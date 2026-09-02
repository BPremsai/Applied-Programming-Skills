import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            // Collision condition: Current asteroid moves LEFT (< 0) 
            // and the top of the stack moves RIGHT (> 0)
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                int top = stack.peek();

                if (top < -asteroid) {
                    // Right-moving top asteroid is smaller and explodes
                    stack.pop();
                } else if (top == -asteroid) {
                    // Both asteroids are of equal size and both explode
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                    // Right-moving top asteroid is larger, current left-moving asteroid explodes
                    destroyed = true;
                    break;
                }
            }

            // If the current asteroid survived all collisions, push it onto the stack
            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        // Reconstruct result array from stack (preserving left-to-right order)
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}