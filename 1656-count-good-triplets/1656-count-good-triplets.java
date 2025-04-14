class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int good = 0;
        
        for (int i = 0; i < n - 2; i++) {
            for (int k = i + 2; k < n; k++) {
                if (Math.abs(arr[k] - arr[i]) > c) continue;
                for (int j = i + 1; j < k; j++) {
                    if (Math.abs(arr[i] - arr[j]) <= a &&
                        Math.abs(arr[j] - arr[k]) <= b) {
                        good++;
                    }
                }
            }
        }
        return good;
    }
}