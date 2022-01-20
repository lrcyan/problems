class StringtoInteger {
    public int myAtoi(String s) {//"0"
        s = s.trim();//"0"
        if (s.length() == 0) return 0;
        char first = s.charAt(0);//'0'
        int sign = 1;//1
        if (first=='-') {//no
            sign = -1;
            s = s.substring(1, s.length());
        } else if (first=='+') {//no
            s = s.substring(1, s.length());
        }
        
        int firstNonDigit = s.length();//1
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                firstNonDigit = i;
                break;
            }
        }
        
        s = s.substring(0, firstNonDigit);//0,1->"0"
        
        //Now we have a string of just digits to convert into an integer.
        int firstNonZero = 0;//0
        while (firstNonZero < s.length() && s.charAt(firstNonZero) == '0') firstNonZero++;//0, yes&&yes->1, no->break
        
        s = s.substring(firstNonZero, s.length());//1,1->""
        
        //Only look at 10 digits because if there are more it will overflow.
        if (s.length() > 10) return (sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE);//no
        
        //We have a number with 10 or fewer digits. Convert it to a long, then see whether it overflows int.
        
        long ans = 0;//0
        for (int i = 0; i < s.length(); i++) {//never run
            ans *= 10;
            ans += (int)(s.charAt(i) - '0');
        }
        
        ans *= sign;//0*1==0
        if (ans > (long)Integer.MAX_VALUE) return Integer.MAX_VALUE;//no
        if (ans < (long)Integer.MIN_VALUE) return Integer.MIN_VALUE;//no
        
        return (int)ans;//0
    }
}
