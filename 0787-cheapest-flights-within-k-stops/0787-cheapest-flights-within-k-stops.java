class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        // prices[i] = cheapest cost to reach city i from src
        // start with infinity (unreachable) for all cities
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0; // cost to reach src is 0

        // k stops = k+1 flights, so run k+1 rounds
        // each round allows one more flight/edge
        for (int i = 0; i < k + 1; i++) {

            // snapshot of prices from PREVIOUS round
            // ensures we only extend paths by exactly 1 edge per round
            // without this, multiple edges could chain in a single round
            int[] temp = Arrays.copyOf(prices, n);

            for (int[] flight : flights) {
                int u = flight[0], v = flight[1], wt = flight[2];

                // only relax if city u is reachable in previous round
                // and going through u gives a cheaper path to v
                if (prices[u] != Integer.MAX_VALUE && prices[u] + wt < temp[v]) {
                    temp[v] = prices[u] + wt;
                }
            }

            // update prices to this round's results
            // next round will use these as the "previous round" snapshot
            prices = temp;
        }

        // if dst is still unreachable, return -1
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}