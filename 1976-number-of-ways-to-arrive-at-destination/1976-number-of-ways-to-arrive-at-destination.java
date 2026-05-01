class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1000000007;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0L, 0L});

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0L;

        int[] ways = new int[n];
        ways[0] = 1;

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long currT = curr[0];
            int currN = (int) curr[1];
            
            if(currT > dist[currN]) continue;

            for (int[] next : adj.get(currN)) {
                int nxtN = next[0], nxtT = next[1];
                if (currT + nxtT < dist[nxtN]) {
                    dist[nxtN] = currT + nxtT;
                    ways[nxtN] = ways[currN];
                    pq.offer(new long[]{currT + nxtT, nxtN});
                } else if(currT + nxtT == dist[nxtN]) {
                    ways[nxtN] = (ways[currN] + ways[nxtN]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}