import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = prices.clone(); 
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int prevIndex = stack.pop();
                result[prevIndex] = prices[prevIndex] - prices[i];
            }
            stack.push(i);
        }

        return result;
    }
}