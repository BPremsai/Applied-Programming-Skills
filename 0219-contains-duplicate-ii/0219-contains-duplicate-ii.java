import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            // If the element is already in the set, a duplicate exists within distance k
            if (set.contains(nums[i])) {
                return true;
            }
            
            // Add current element to the set
            set.add(nums[i]);
            
            // Maintain a sliding window of size k
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        
        return false;
    }
}