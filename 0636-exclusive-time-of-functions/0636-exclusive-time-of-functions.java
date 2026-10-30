import java.util.List;
import java.util.Stack;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;

        for (String log : logs) {
            String[] parts = log.split(":");
            int functionId = Integer.parseInt(parts[0]);
            String type = parts[1];
            int timestamp = Integer.parseInt(parts[2]);

            if (type.equals("start")) {
                // If another function was running, add the elapsed time to it before switching
                if (!stack.isEmpty()) {
                    res[stack.peek()] += timestamp - prevTime;
                }
                stack.push(functionId);
                prevTime = timestamp;
            } else {
                // Function ends at the *end* of the timestamp, so we add 1
                res[stack.pop()] += timestamp - prevTime + 1;
                prevTime = timestamp + 1;
            }
        }

        return res;
    }
}