
class RecentCounter {
    private int[] requests;
    private int front;
    private int rear;

    public RecentCounter() {
        requests = new int[10001];
        front = 0;
        rear = 0;
    }

    public int ping(int t) {
        requests[rear++] = t;

        // Remove requests older than t - 3000
        while (front < rear && requests[front] < t - 3000) {
            front++;
        }

        // Number of requests in the valid time range
        return rear - front;
    }
}
