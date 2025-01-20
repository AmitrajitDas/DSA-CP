class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = arr.length, rows = mat.length, cols = mat[0].length;
        Map<Integer, Integer> mp = new HashMap<>();
        int minIdx = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            mp.put(arr[i], i);
        }

        for(int row = 0; row < rows; row++) {
            int lastIdx = Integer.MIN_VALUE;
            for(int col = 0; col < cols; col++) {
                int val = mat[row][col];
                int idx = mp.get(val);
                lastIdx = Math.max(lastIdx, idx);
            }
            minIdx = Math.min(minIdx, lastIdx);
        }

        for(int col = 0; col < cols; col++) {
            int lastIdx = Integer.MIN_VALUE;
            for(int row = 0; row < rows; row++) {
                int val = mat[row][col];
                int idx = mp.get(val);
                lastIdx = Math.max(lastIdx, idx);
            }
            minIdx = Math.min(minIdx, lastIdx);
        }

        return minIdx;
    }
}