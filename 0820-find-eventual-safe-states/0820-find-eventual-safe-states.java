class Solution {
    boolean detectCycle(int node, int[] vis, int[][] graph) {
        
        if(vis[node] != -1)
            return vis[node] == 1; // if node is marked unsafe then cycle is found
        
        vis[node] = 1; // marked as unsafe
        for(int it : graph[node])
            if(detectCycle(it, vis, graph))
                return true;
        
        vis[node] = 0; // marked as safe
        return false;
    }
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> res = new ArrayList<>();
        int vis[] = new int[n];
        Arrays.fill(vis, -1);
        
        for(int i = 0; i < n; i++) {
            if(!detectCycle(i, vis, graph)) // safe nodes are those who doesn't form any cycle
                res.add(i);
        }
        
        return res;
    }
}
