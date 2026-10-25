
import java.util.Stack;
import java.util.Arrays;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;

        for (int value : pushed) {
            stack.push(value);

            while (!stack.isEmpty()
                    && j < popped.length
                    && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return j == popped.length;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] pushed1 = {1, 2, 3, 4, 5};
        int[] popped1 = {4, 5, 3, 2, 1};

        int[] pushed2 = {1, 2, 3, 4, 5};
        int[] popped2 = {4, 3, 5, 1, 2};

        System.out.println(
            obj.validateStackSequences(pushed1, popped1)
        );

        System.out.println(
            obj.validateStackSequences(pushed2, popped2)
        );
    }
}
