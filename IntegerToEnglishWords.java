import java.util.StringJoiner;

class IntegerToEnglishWords {
    String[] ones = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"", "", "", "", "", "", "", "", "", "", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"Zero", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        
        String ones = shortToWords(num % 1000);
        num /= 1000;
        String thousands = shortToWords(num % 1000);
        num /= 1000;
        String millions = shortToWords(num % 1000);
        num /= 1000;
        String billions = shortToWords(num);
        
        StringJoiner ret = new StringJoiner(" ");
        
        if (!billions.equals("zero")) {
            ret.add(billions);
            ret.add("Billion");
        }
        
        if (!millions.equals("zero")) {
            ret.add(millions);
            ret.add("Million");
        }
        
        if (!thousands.equals("zero")) {
            ret.add(thousands);
            ret.add("Thousand");
        }
        
        if (!ones.equals("zero")) {
            ret.add(ones);
        }
        
        return ret.toString();
    }
    
    public String shortToWords(int num) {
        if (num == 0) return "zero";
        
        String ret = "";
        if (num / 100 > 0) ret = ones[num / 100] + " Hundred";
        num %= 100;
        if (num / 10 > 1) ret = ret + (ret.length() == 0 ? "" : " ") + tens[num / 10];
        if (num / 10 == 1) {
            ret = ret + (ret.length() == 0 ? "" : " ") + teens[num];
        } else {
            if (num % 10 > 0) ret = ret + (ret.length() == 0 ? "" : " ") + ones[num % 10];
        }
        
        return ret;
    }
}
