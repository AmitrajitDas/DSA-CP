import java.util.*;

class Solution {
    int N;

    class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        // Find operation with path compression
        int findUPar(int node) {
            if (node == parent[node])
                return node;
            return parent[node] = findUPar(parent[node]);
        }

        // Union operation with rank optimization
        boolean unionByRank(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);

            if (ulp_u == ulp_v)
                return false;

            if (rank[ulp_u] > rank[ulp_v]) {
                parent[ulp_v] = ulp_u;
            } else if (rank[ulp_u] < rank[ulp_v]) {
                parent[ulp_u] = ulp_v;
            } else {
                parent[ulp_u] = ulp_v;
                rank[ulp_v]++;
            }
            return true;
        }
    }

    // Kruskal's algorithm
    int kruskal(List<int[]> edges, int skipEdge, int forceEdge) {
        int sum = 0;
        UnionFind uf = new UnionFind(N);

        // Include a forced edge if provided
        if (forceEdge != -1) {
            uf.unionByRank(edges.get(forceEdge)[0], edges.get(forceEdge)[1]);
            sum += edges.get(forceEdge)[2];
        }

        // Construct the MST
        for (int i = 0; i < edges.size(); i++) {
            if (i == skipEdge)
                continue;

            int u = edges.get(i)[0];
            int v = edges.get(i)[1];
            int wt = edges.get(i)[2];

            int parentU = uf.findUPar(u);
            int parentV = uf.findUPar(v);

            if (parentU != parentV) {
                uf.unionByRank(u, v);
                sum += wt;
            }
        }

        // Check if the MST is valid or not
        for (int i = 0; i < N; i++) {
            if (uf.findUPar(i) != uf.findUPar(0))
                return Integer.MAX_VALUE;
        }

        return sum;
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        N = n;

        // Prepare edgeList and add original index
        List<int[]> edgeList = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = Arrays.copyOf(edges[i], 4);
            edge[3] = i;
            edgeList.add(edge);
        }

        // Sort edges based on their weights
        edgeList.sort(Comparator.comparingInt(a -> a[2]));

        // Calculate MST weight
        int mstWeight = kruskal(edgeList, -1, -1);

        // Find critical and pseudo-critical edges
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();

        for (int i = 0; i < edgeList.size(); i++) {
            if (kruskal(edgeList, i, -1) > mstWeight) {
                critical.add(edgeList.get(i)[3]);
            } else if (kruskal(edgeList, -1, i) == mstWeight) {
                pseudoCritical.add(edgeList.get(i)[3]);
            }
        }

        // Prepare the result and return
        List<List<Integer>> result = new ArrayList<>();
        result.add(critical);
        result.add(pseudoCritical);

        return result;
    }
}
