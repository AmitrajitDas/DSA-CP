class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double p = succProb[i];
            adj.get(u).add(new double[]{v, p});
            adj.get(v).add(new double[]{u, p});
        }

        // Max-heap: highest probability first
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        double[] dist = new double[n];

        dist[start_node] = 1.0;
        pq.offer(new double[]{1.0, start_node});

        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            double currProb = curr[0];
            int currNode = (int) curr[1];

            for (double[] edge : adj.get(currNode)) {
                int adjNode = (int) edge[0];
                double wt = edge[1];
                if (currProb * wt > dist[adjNode]) {
                    dist[adjNode] = currProb * wt;
                    pq.offer(new double[]{dist[adjNode], adjNode});
                }
            }
        }

        return dist[end_node];
    }
}