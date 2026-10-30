import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        // Push -1 as a base for the first valid substring calculation
        stack.push(-1);
        int maxLength = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop(); // Pop the matching '(' or the base index
                
                if (stack.isEmpty()) {
                    // If stack is empty, current ')' is a mismatch, set new base
                    stack.push(i);
                } else {
                    // Calculate valid length from the new top of the stack
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        
        return maxLength;
    }
}