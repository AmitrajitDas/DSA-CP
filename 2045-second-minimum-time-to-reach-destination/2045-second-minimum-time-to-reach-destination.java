class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // dist1[i] = min time, dist2[i] = second min time
        int[] dist1 = new int[n + 1];
        int[] dist2 = new int[n + 1];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist1[1] = 0;

        // BFS queue stores [node, currTime]
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0], currTime = curr[1];

            // Calculate departure time (wait if red light)
            int departure = currTime;
            if ((departure % (2 * change)) >= change) {
                departure = (departure / (2 * change) + 1) * (2 * change);
            }
            int nextTime = departure + time;

            for (int neighbor : adj.get(node)) {
                if (nextTime < dist1[neighbor]) {
                    dist2[neighbor] = dist1[neighbor];
                    dist1[neighbor] = nextTime;
                    queue.offer(new int[]{neighbor, nextTime});
                } else if (nextTime > dist1[neighbor] && nextTime < dist2[neighbor]) {
                    dist2[neighbor] = nextTime;
                    queue.offer(new int[]{neighbor, nextTime});
                }

                // Early exit
                if (dist2[n] != Integer.MAX_VALUE) return dist2[n];
            }
        }

        return dist2[n];
    }
}