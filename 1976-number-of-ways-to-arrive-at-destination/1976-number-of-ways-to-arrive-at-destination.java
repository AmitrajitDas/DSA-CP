class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1000000007;

        // Build adjacency list: adj.get(u) gives list of {neighbor, travelTime}
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate adjacency list (undirected graph)
        for (int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        // Min-heap ordered by travel time (index 0), so we always process
        // the currently shortest known path first — core of Dijkstra's
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0L, 0L}); // {time, node} — start at node 0 with time 0

        // dist[i] = shortest time found so far to reach node i
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE); // unknown = infinity
        dist[0] = 0L;

        // ways[i] = number of shortest paths to reach node i (mod MOD)
        int[] ways = new int[n];
        ways[0] = 1; // exactly one way to be at the start

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long currT = curr[0];
            int currN = (int) curr[1];

            // Skip if we've already found a shorter path to currN
            // (stale entry in the heap)
            if (currT > dist[currN]) continue;

            for (int[] next : adj.get(currN)) {
                int nxtN = next[0], nxtT = next[1];

                // Case 1: Found a strictly shorter path to nxtN
                // — update distance and reset its ways count to currN's ways
                if (currT + nxtT < dist[nxtN]) {
                    dist[nxtN] = currT + nxtT;
                    ways[nxtN] = ways[currN];
                    pq.offer(new long[]{currT + nxtT, nxtN});
                }

                // Case 2: Found another path with equal shortest distance
                // — accumulate the ways (all paths through currN are also valid)
                else if (currT + nxtT == dist[nxtN]) {
                    ways[nxtN] = (ways[currN] + ways[nxtN]) % MOD;
                }

                // Case 3: currT + nxtT > dist[nxtN] — longer path, ignore
            }
        }

        // Return number of shortest paths from node 0 to node n-1
        return ways[n - 1];
    }
}