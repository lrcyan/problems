/**
* This program determines whether a string represents a valid number or not.
* Input: a string with 1 to 20 characters.
* Output: a boolean value.

class ValidNum {
    public boolean isNumber(String s) {
        s = s.trim();
        if (!containsOnlyValidChars(s)) return false;
        int es = numEs(s);
        if (es > 1) return false;
        int e = eIndex(s);
        if (es == 1) return isNumberNotExp(s.substring(0, e)) && isInteger(s.substring(e +  1, s.length()));
        else return isNumberNotExp(s);
    }
    
    boolean isValidChar(char c) {
        return ((c >= '0' && c <= '9') || c == 'e' || c == '+' || c == '-' || c == '.');
    }
    
    boolean containsOnlyValidChars(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!isValidChar(s.charAt(i))) return false;
        }
        
        return true;
    }
    
    int numEs(String s) {
        int es = 0;
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) == 'e') es++;
        return es;
    }
    
    boolean isNumberNotExp(String s) {
        s = s.trim();
        boolean containsDigit = false;
        int numPoints = 0;
        if (s.length() == 0) return false;
        int i = 0;
        char c = s.charAt(i);
        boolean sign = (c == '+' || c == '-');
        if (sign) {
            i++;
             if (i < s.length() && i >= 0) c = s.charAt(i);
        }
        while (i < s.length()) {
            if (!(c >= '0' && c <= '9') && c != '.') return false;
            if ((c >= '0' && c <= '9')) containsDigit = true;
            if (c == '.') numPoints++;
            if (numPoints > 1) return false;
            i++;
            if (i < s.length() && i >= 0) c = s.charAt(i);
        }
        
        return containsDigit;
        
    }
    
    boolean isInteger(String s) {
        s = s.trim();
        boolean containsDigit = false;
        if (s.length() == 0) return false;
        char c = s.charAt(0);
        if (c != '+' && c != '-' && !(c >= '0' && c <= '9')) return false;
        if (c >= '0' && c <= '9') containsDigit = true;
        
        for (int i = 1; i < s.length(); i++) {
            c = s.charAt(i);
            if (!(c >= '0' && c <= '9')) return false;
            if ((c >= '0' && c <= '9')) containsDigit = true;
        }
        
        return containsDigit;
    }
    
    int eIndex(String s) {
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) == 'e') return i;
        
        return -1;
    }
}
