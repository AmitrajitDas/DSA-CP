class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int i = 0; i < k + 1; i++) {
            int[] temp = Arrays.copyOf(prices, n);
            for (int[] flight : flights) {          // int[] not int
                int u = flight[0], v = flight[1], wt = flight[2];
                if (prices[u] != Integer.MAX_VALUE && prices[u] + wt < temp[v]) {
                    temp[v] = prices[u] + wt;
                }
            }
            prices = temp;                          // inside for loop
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}