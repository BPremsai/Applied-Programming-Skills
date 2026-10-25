
import java.util.Stack;
import java.util.Arrays;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean alive = true;

            while (alive && asteroid < 0
                    && !stack.isEmpty()
                    && stack.peek() > 0) {

                if (stack.peek() < -asteroid) {
                    stack.pop();
                } else if (stack.peek() == -asteroid) {
                    stack.pop();
                    alive = false;
                } else {
                    alive = false;
                }
            }

            if (alive) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        System.out.println(Arrays.toString(
            obj.asteroidCollision(new int[]{5, 10, -5})
        ));

        System.out.println(Arrays.toString(
            obj.asteroidCollision(new int[]{8, -8})
        ));

        System.out.println(Arrays.toString(
            obj.asteroidCollision(new int[]{10, 2, -5})
        ));

        System.out.println(Arrays.toString(
            obj.asteroidCollision(new int[]{3, 5, -6, 2, -1, 4})
        ));
    }
}
