class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length, m = worker.length;

        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new int[]{difficulty[i], profit[i]});
        }

        Arrays.sort(worker);
        Collections.sort(pairs, (a, b) -> a[0] - b[0]);

        int j = 0, totalProfit = 0, maxProfit = 0;

        for (int i = 0; i < m; i++) {
            while (j < n && worker[i] >= pairs.get(j)[0]) {
                maxProfit = Math.max(maxProfit, pairs.get(j++)[1]);
            }
            totalProfit += maxProfit;
        }

        return totalProfit;
    }
}