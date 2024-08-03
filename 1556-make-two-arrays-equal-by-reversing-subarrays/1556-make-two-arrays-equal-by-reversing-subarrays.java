class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] cnt1 = new int[1001];
        int[] cnt2 = new int[1001];
        for (int num : target) {
            cnt1[num]++;
        }
        for (int num : arr) {
            cnt2[num]++;
        }
        return Arrays.equals(cnt1, cnt2);
    }
}