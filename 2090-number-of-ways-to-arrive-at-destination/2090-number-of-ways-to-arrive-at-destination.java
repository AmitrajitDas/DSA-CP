class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = (int)1e9 + 7;

        // Adjacency list: node -> list of [time, neighbor]
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        // Build undirected graph
        for (int[] road : roads) {
            int src = road[0], dest = road[1], time = road[2];
            adj.get(src).add(new int[]{time, dest});
            adj.get(dest).add(new int[]{time, src});
        }

        // Priority queue: [totalTimeSoFar, node]
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0L, 0L}); // Start from node 0 with time 0

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0L;

        int[] ways = new int[n];
        ways[0] = 1;

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long timeSoFar = curr[0];
            int node = (int) curr[1];

            if (timeSoFar > dist[node]) continue;

            for (int[] nei : adj.get(node)) {
                int wt = nei[0], neighbor = nei[1];
                long totalTime = timeSoFar + wt;

                if (totalTime < dist[neighbor]) {
                    dist[neighbor] = totalTime;
                    ways[neighbor] = ways[node];
                    pq.offer(new long[]{totalTime, neighbor});
                } else if (totalTime == dist[neighbor]) {
                    ways[neighbor] = (ways[neighbor] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1];
    }
}
