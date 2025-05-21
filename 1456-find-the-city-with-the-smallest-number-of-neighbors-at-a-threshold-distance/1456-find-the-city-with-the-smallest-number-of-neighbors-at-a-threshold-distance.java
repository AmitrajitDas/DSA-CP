class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Initialize distance matrix with maximum values
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        // Fill the distance matrix with the direct edge weights
        for(int[] it : edges) {
            dist[it[0]][it[1]] = it[2]; // The weight of the edge from it[0] to it[1]
            dist[it[1]][it[0]] = it[2]; // Undirected graph, so add the reverse edge too
        }
        
        // Set distance from each city to itself as 0
        for(int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }
        
        // Floyd-Warshall algorithm to find shortest paths between all pairs of cities
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    // Only update if both paths (i->k and k->j) exist
                    // This avoids integer overflow when adding large values
                    if(dist[i][k] != Integer.MAX_VALUE && 
                       dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        
        // Find the city with the fewest neighbors within threshold distance
        int resCity = -1;       // Result city
        int cityCount = n;      // Initialize with maximum possible count
        
        for(int city = 0; city < n; city++) {
            int count = 0;      // Counter for cities within threshold
            
            // Count reachable cities within threshold distance
            for(int adjCity = 0; adjCity < n; adjCity++) {
                if(city != adjCity && dist[city][adjCity] <= distanceThreshold) {
                    count++;
                }
            }
            
            // Update result if this city has fewer or equal reachable cities
            // If equal, prefer the city with the larger number (as per problem requirement)
            if(count <= cityCount) {
                cityCount = count;
                resCity = city;
            }
        }
        
        return resCity;
    }
}