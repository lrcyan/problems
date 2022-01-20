import java.util.HashMap;

class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;
        
        HashMap<Character, Integer> letterCount = new HashMap<Character, Integer>();
        int l = 0;
        int r = 0;
        int longest = 1;
        
        while (r < n) {
            char tmp = s.charAt(r);
            if (!letterCount.containsKey(tmp)) letterCount.put(tmp, 0);
            letterCount.put(tmp, letterCount.get(tmp) + 1);
            //System.out.println(letterCount.get(s.charAt(r)));
            while (letterCount.get(tmp) > 1) {
                letterCount.put(s.charAt(l), letterCount.get(s.charAt(l)) - 1);
                l++;
            }
            if (r-l+1 > longest) longest = r-l+1;
            r++;
        }
        
        return longest;
    }
}
