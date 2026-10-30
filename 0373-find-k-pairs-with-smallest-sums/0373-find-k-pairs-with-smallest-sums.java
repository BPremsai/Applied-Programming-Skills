import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        // Min-heap stores int array: {nums1[i], nums2[j], index_j}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        // Initialize the heap with pairs from nums1 and the first element of nums2
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{nums1[i], nums2[0], 0});
        }

        // Extract the smallest pairs up to k times
        while (k > 0 && !minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int u = curr[0];
            int v = curr[1];
            int idx2 = curr[2];

            List<Integer> pair = new ArrayList<>();
            pair.add(u);
            pair.add(v);
            result.add(pair);

            // If there is a next element in nums2 for the current nums1[i], push it to the heap
            if (idx2 + 1 < nums2.length) {
                minHeap.offer(new int[]{u, nums2[idx2 + 1], idx2 + 1});
            }

            k--;
        }

        return result;
    }
}