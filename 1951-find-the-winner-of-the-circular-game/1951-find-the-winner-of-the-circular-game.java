class Solution {
    private int findWinnerIdx(int n, int k) {
        if (n == 1) {
            return 0;
        }

        int idx = findWinnerIdx(n - 1, k);
        idx = (idx + k) % n; // to find the original index in the original array

        return idx;
    }

    public int findTheWinner(int n, int k) {
        int resultIdx = findWinnerIdx(n, k);
        return resultIdx + 1;
    }
}