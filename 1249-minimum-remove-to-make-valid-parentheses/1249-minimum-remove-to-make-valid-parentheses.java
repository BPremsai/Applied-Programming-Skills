import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public String minRemoveToMakeValid(String s) {
       
        Deque<Integer> stack = new ArrayDeque<>();
        
        Set<Integer> invalidIndices = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                   
                    stack.pop();
                } else {
                   
                    invalidIndices.add(i);
                }
            }
        }

        while (!stack.isEmpty()) {
            invalidIndices.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!invalidIndices.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}