class ZigzagConversion {
    public String convert(String s, int numRows) {//ab, 1
        StringBuilder b = new StringBuilder("");//""
        int len = s.length();//2
        if (len <= numRows || numRows == 1) return s;//2>1; no return
    
        //First row:
        int jump = numRows*2-2;//0
        for (int i = 0; i < len; i += jump) {
            b.append(s.charAt(i));
        }
        //Middle numRows-2 rows:
        for (int row = 1; row < numRows - 1; row++) {
            int i = row;
            int jump1 = jump - row - row;
            int jump2 = jump - jump1;
            
            while (i < len) {
                b.append(s.charAt(i));
                i += jump1;
                if (i >= len) break;
                b.append(s.charAt(i));
                i += jump2;
            }
        }
        //Last row:
        for (int i = numRows-1; i < len; i += jump) {
            b.append(s.charAt(i));
        }
        
        return b.toString();
    }
}
