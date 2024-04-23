class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Collections.singletonList(0);
        
        int indegree[] = new int[n];
        Map<Integer, List<Integer>> map = new HashMap();
        for(int[] edge: edges) {
            indegree[edge[0]]++;
            indegree[edge[1]]++;
            map.putIfAbsent(edge[0], new ArrayList());
            map.putIfAbsent(edge[1], new ArrayList());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList();
        for(int i=0; i< indegree.length; i++) {
            if(indegree[i] == 1) {
                queue.add(i);
            }
        }

        while(n > 2) {
            int size = queue.size();
            n -= size;
            for(int i=0; i < size; i++) {
                int poll = queue.poll();
                for(int adj: map.get(poll)) {
                    if(--indegree[adj] == 1) {
                        queue.add(adj);
                    }
                }
            }
        }

        List<Integer> list = new ArrayList();
        list.addAll(queue);
        return list;
    }
}