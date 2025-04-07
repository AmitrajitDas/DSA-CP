class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = (int)1e9 + 7;

        // Build an adjacency list: node -> list of [time, neighbor]
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        // Since the roads are bidirectional, add both directions
        for (int[] road : roads) {
            int src = road[0], dest = road[1], time = road[2];
            adj.get(src).add(new int[]{time, dest});
            adj.get(dest).add(new int[]{time, src});
        }

        // Priority queue to get the node with the shortest time so far (Dijkstra's)
        // Each element in PQ is [totalTimeSoFar, node]
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0L, 0L}); // Start from node 0 with time 0

        // Array to store the shortest time to reach each node
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE); // Initialize all distances as infinity
        dist[0] = 0L;

        // Array to store the number of ways to reach each node with the shortest time
        int[] ways = new int[n];
        ways[0] = 1;

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long timeSoFar = curr[0];
            int node = (int) curr[1];

            // If we have already found a better way to this node, skip
            if (timeSoFar > dist[node]) continue;

            // Explore all neighbors
            for (int[] nei : adj.get(node)) {
                int wt = nei[0], neighbor = nei[1];
                long totalTime = timeSoFar + wt;

                // If this path to neighbor is shorter, update distance and ways
                if (totalTime < dist[neighbor]) {
                    dist[neighbor] = totalTime;
                    ways[neighbor] = ways[node];
                    pq.offer(new long[]{totalTime, neighbor});
                }
                // If this path is equally short, accumulate the number of ways
                else if (totalTime == dist[neighbor]) {
                    ways[neighbor] = (ways[neighbor] + ways[node]) % mod;
                }
            }
        }

        // Return the number of ways to reach the last node (n-1)
        return ways[n - 1];
    }
}
