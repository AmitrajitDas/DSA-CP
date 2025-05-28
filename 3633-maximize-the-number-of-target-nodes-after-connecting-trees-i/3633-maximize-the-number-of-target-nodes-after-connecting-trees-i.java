class Solution {
    private List<List<Integer>> buildGraph(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>(n);
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }

    private int countReachableNodes(int currNode, int parentNode, int k, List<List<Integer>> adj) {
        if(k < 0) return 0;
        int count = 1;
        for(int adjNode : adj.get(currNode)) {
            if(adjNode != parentNode) {
                count += countReachableNodes(adjNode, currNode, k - 1, adj);
            }
        }

        return count;
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        List<List<Integer>> adj1 = buildGraph(edges1);
        List<List<Integer>> adj2 = buildGraph(edges2);
        int m = adj2.size(), maxCount2 = 0;
        for(int i = 0; i < m; i++) {
            maxCount2 = Math.max(maxCount2, countReachableNodes(i, -1, k - 1, adj2));
        }

        int n = adj1.size();
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = countReachableNodes(i, -1, k, adj1) + maxCount2;
        }

        return res;
    }
}