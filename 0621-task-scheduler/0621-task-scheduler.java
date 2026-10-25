
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        // Count the frequency of each task
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Find the maximum frequency
        int maxFreq = 0;
        for (int count : freq) {
            maxFreq = Math.max(maxFreq, count);
        }

        // Count tasks having the maximum frequency
        int maxCount = 0;
        for (int count : freq) {
            if (count == maxFreq) {
                maxCount++;
            }
        }

        // Calculate the minimum intervals
        int intervals = (maxFreq - 1) * (n + 1) + maxCount;

        return Math.max(tasks.length, intervals);
    }
}
