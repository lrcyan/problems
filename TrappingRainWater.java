/**
* This program computes how much water can be trapped by an elevation map.
* Input:  n non-negative integers representing an elevation map where the width of each bar is 1.
* Output: how much water it can trap after raining.
*/

class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        
        int water = 0;
        int match;
        int level = height[0];
        int curr = 0; 
        
        while (curr < height.length - 1) {
            level = (height[curr] > level ? height[curr] : level);
            match = match(height, curr, level);
            level = (height[match] < level ? height[match] : level);
            while (curr < match) {
                water += (level - height[curr + 1] > 0 ? level - height[curr + 1] : 0);
                curr++;
            }
        }
        
        return water;
    }
    
    int match(int[] height, int curr, int level) {
        int max = curr + 1;
        
        for (int i = curr + 1; i < height.length; i++) {
            if (height[i] >= level) return i;
            
            if (height[i] > height[max]) max = i;
        }
        
        return max;
    }
}
