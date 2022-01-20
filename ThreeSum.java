import java.util.*;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<List<Integer>>();
        int OFFSET = 100001; 
        
        int[] freq = new int[200003];
        HashSet<Integer> vals = new HashSet<Integer>();
        
        //Count frequencies of each value:
        for (int num : nums) {
            freq[num + OFFSET]++;
            vals.add(num);
        }
        
        //Add only distinct values to nums[]:
        nums = new int[vals.size()];
        Iterator iter = vals.iterator();
        int v = 0;
        while (iter.hasNext()) {
            nums[v] = (int)iter.next();
            v++;
        }
        Arrays.sort(nums);
        
        //Iterate through pairs of values:
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];

            if (freq[a  + OFFSET] >= 3 && a == 0) {//add identical triplet
                List<Integer> trip = new ArrayList<Integer>();
                trip.add(a); trip.add(a); trip.add(a);
                triplets.add(trip);
            }
                
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                //Add triplets with 2 distinct values
                if (freq[a + OFFSET] >= 2 && a + a + b == 0) {//add that one 
                    List<Integer> trip = new ArrayList<Integer>();
                    trip.add(a); trip.add(a); trip.add(b);
                    triplets.add(trip);
                }
                if (freq[b + OFFSET] >= 2 && a + b + b == 0) {//add that one 
                    List<Integer> trip = new ArrayList<Integer>();
                    trip.add(a); trip.add(b); trip.add(b);
                    triplets.add(trip);
                }
                
                //Add triplet with 3 distinct values
                if (vals.contains(0-a-b) && 0-a-b > b) {
                    //add that one
                    List<Integer> trip = new ArrayList<Integer>();
                    trip.add(a); trip.add(b); trip.add(0-a-b);
                    triplets.add(trip);
                }
            }
        }
        
        return triplets;
    }
}
