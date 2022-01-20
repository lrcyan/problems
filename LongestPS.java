class LongestPS {
    public String longestPalindrome(String s) {//babad
        char[] sArr = s.toCharArray();//babad
        int n = sArr.length;//5
        
        int start = 0;
        int end = 0;
        int len = 0;
        int longestLen = 1;//3
        int longestStart = 0;
        
        for (int mid = 1; mid < n - 1; mid++) {//1
            start = mid - 1;//0
            end = mid + 1;//2
            len = 1;//1
            
            while (start >= 0 && end < n) {//0>=0 and 2<5, -1<0 so break
                if (sArr[start] != sArr[end]) {//b==b
                    break;
                }
                
                len += 2;//3
                start--;//-1
                end++;//4
            }
            
            if (len > longestLen) {//3>1
                longestLen = len;//
                longestStart = start + 1;//0
            }
        }
        
        for (int mid = 0; mid < n - 1; mid++) {
            start = mid;
            end = mid + 1;
            len = 0;
            
            while (start >= 0 && end < n) {
                if (sArr[start] != sArr[end]) {
                    break;
                }
                
                len += 2;
                start--;
                end++;
            }
            
            if (len > longestLen) {
                longestLen = len;
                longestStart = start + 1;
            }
        }
        
        return s.substring(longestStart, longestStart + longestLen);
    }
}
