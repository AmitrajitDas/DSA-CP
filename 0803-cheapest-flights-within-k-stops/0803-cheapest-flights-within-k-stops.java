class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build adjacency list to represent the flight graph
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        
        // Populate adjacency list with flight information
        for (int[] flight : flights) {
            int source = flight[0];
            int destination = flight[1];
            int price = flight[2];
            adj.get(source).add(new int[]{destination, price});
        }
        
        // Priority queue to always process the cheapest path first
        // Format: [price, city, stops]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // Track visited states to avoid processing worse paths
        // Key format: "city,stops", Value: minimum price to reach this state
        Map<String, Integer> vis = new HashMap<>();
        
        // Start from source with 0 price and 0 stops
        minHeap.offer(new int[]{0, src, 0}); // {price, city, stops}
        
        while (!minHeap.isEmpty()) {
            int[] node = minHeap.poll();
            int price = node[0], city = node[1], stops = node[2];
            
            // Create key for current state
            String key = city + "," + stops;
            
            // Skip if:
            // 1. We've seen this city with same/fewer stops at cheaper price, OR
            // 2. We've exceeded the allowed number of stops
            if ((vis.containsKey(key) && vis.get(key) <= price) || stops > k + 1) {
                continue;
            }
            
            // Mark this state as visited with current price
            vis.put(key, price);
            
            // If we've reached destination, return the price
            if (city == dst) {
                return price;
            }
            
            // Explore all neighboring cities
            for (int[] neighbor : adj.get(city)) {
                int nextCity = neighbor[0], flightPrice = neighbor[1];
                // Add to priority queue with updated price and stops
                minHeap.offer(new int[]{price + flightPrice, nextCity, stops + 1});
            }
        }
        
        // If we can't reach the destination within k stops, return -1
        return -1;  // Fixed: Return -1 instead of 0
    }
}