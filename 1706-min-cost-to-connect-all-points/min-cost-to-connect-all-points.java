class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]); 
        // Each entry: [cost, pointIndex]

        int totalCost = 0;
        int pointsConnected = 0;

        minHeap.offer(new int[]{0, 0}); // Start with 0 cost to point 0

        while (pointsConnected < n) {
            int[] current = minHeap.poll();
            int cost = current[0], currPoint = current[1];

            if (visited[currPoint]) continue;

            visited[currPoint] = true;
            totalCost += cost;
            pointsConnected++;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int distance = Math.abs(points[currPoint][0] - points[i][0]) +
                                   Math.abs(points[currPoint][1] - points[i][1]);
                    minHeap.offer(new int[]{distance, i});
                }
            }
        }

        return totalCost;
    }
}
