class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] visited = new int[n]; // Track included points
        int[] minCost = new int[n]; // Min cost to connect each point
        Arrays.fill(minCost, Integer.MAX_VALUE);

        int current = 0;
        minCost[0] = 0;
        int totalCost = 0;

        while (current >= 0) {
            visited[current] = 1;
            int next = -1;
            int minDistance = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (visited[i] == 1) continue;

                int cost = Math.abs(points[current][0] - points[i][0]) + Math.abs(points[current][1] - points[i][1]);
                minCost[i] = Math.min(minCost[i], cost);

                if (minCost[i] < minDistance) {
                    minDistance = minCost[i];
                    next = i;
                }
            }

            totalCost += (minDistance == Integer.MAX_VALUE) ? 0 : minDistance;
            current = next;
        }

        return totalCost;
    }
}
