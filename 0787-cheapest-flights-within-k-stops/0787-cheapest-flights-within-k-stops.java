class Pair<K, V> {
    private final K key;
    private final V value;
    
    // Constructor to initialize key-value pair
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    // Getter method for retrieving the key
    public K getKey() {
        return key;
    }
    
    // Getter method for retrieving the value
    public V getValue() {
        return value;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         // Creating an adjacency list for representing graph
        List<Pair<Integer, Integer>>[] adj = new ArrayList[n];
         
        // Initializing each element of the adjacency list
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
         
        // Populating the adjacency list from flights data
        for (int[] flight : flights) {
            adj[flight[0]].add(new Pair<>(flight[1], flight[2]));
        }

        // Initializing distance array to store shortest distances
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

         // Using Queue for BFS traversal
         /* We are not using priority queue because the first element in the pair ie stops will always be increasing,
         so using PQ will yield extra logarithmic overhead, so we're skipping it
         */
         Queue<Pair<Integer, Pair<Integer, Integer>>> q = new ArrayDeque<>();
         q.offer(new Pair<>(0, new Pair<>(src, 0)));

        // BFS traversal
        while (!q.isEmpty()) {
            Pair<Integer, Pair<Integer, Integer>> ele = q.poll();
            int stops = ele.getKey(), node = ele.getValue().getKey(), distance = ele.getValue().getValue();
            
            if(stops > k) break;

             // Exploring neighbors of the current node
            for (Pair<Integer, Integer> itr : adj[node]) {
                int adjNode = itr.getKey(), edgeWt = itr.getValue();
                // Updating distance if a shorter path is found
                if (distance + edgeWt < dist[adjNode] && stops <= k) {
                    dist[adjNode] = distance + edgeWt;
                    // Adding the neighbor to the queue for further exploration
                    q.offer(new Pair<>(stops + 1, new Pair<>(adjNode, dist[adjNode])));
                }
            }
        }

         // Returning the shortest distance to the destination or -1 if unreachable
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}