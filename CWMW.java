class CWMW {
    public int maxArea(int[] height) {
        int max = 0;
        
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int next = (j - i) * (height[i] < height[j] ? height[i] : height[j]);
                
                if (next > max) max = next;
            }
        }
        
        return max;
    }
}
