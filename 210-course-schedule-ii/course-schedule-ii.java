class Solution {
    int orderIdx;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses]; 
        int[] order = new int[numCourses];
        orderIdx = numCourses - 1;

        LinkedList<Integer>[] g = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) g[i] = new LinkedList<Integer>();
        for (int[] edge : prerequisites) {
            g[edge[1]].add(edge[0]);
        }


        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, g, visited, recStack, order)) {
                return new int[0]; 
            }
        }
        return order;
    }
    
    public boolean hasCycle(int source, LinkedList<Integer>[] g, boolean[] visited, boolean[] recStack, int[] order) {
        if (recStack[source]) {
            return true; // Cycle detected
        }
        if (visited[source]) {
            return false; // Already processed, no cycle
        }
        visited[source] = true;
        recStack[source] = true;
        for (int adj : g[source]) {
            if (hasCycle(adj, g, visited, recStack, order)) {
                return true; // Cycle detected
            }
        }
        // Departing from current node
        order[orderIdx--] = source;
        recStack[source] = false; // Remove from recursion stack
        return false; // No cycle detected
    }
}