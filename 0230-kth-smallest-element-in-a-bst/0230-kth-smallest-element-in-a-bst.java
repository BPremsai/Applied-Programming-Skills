/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current subtree
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            // Process the current node
            curr = stack.pop();
            k--;
            
            // If k reaches 0, we found our kth smallest element
            if (k == 0) {
                return curr.val;
            }
            
            // Move to the right subtree
            curr = curr.right;
        }
        
        return -1; // Unreachable given the problem constraints (1 <= k <= n)
    }
}