public class Solution {
    public int firstUniqChar(String s) {
        // Array to store counts of each character 'a' through 'z'
        int[] count = new int[26];
        
        // Step 1: Count frequencies of each character
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        // Step 2: Find the first character with a frequency of 1
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        // Return -1 if no unique character is found
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test cases
        System.out.println(sol.firstUniqChar("leetcode"));     // Output: 0
        System.out.println(sol.firstUniqChar("loveleetcode")); // Output: 2
        System.out.println(sol.firstUniqChar("aabb"));         // Output: -1
    }
}
