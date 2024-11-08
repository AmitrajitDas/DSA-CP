class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length, subsets = 1 << n;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < subsets; i++) {
            List<Integer> ds = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                // Check if the j-th bit in i is set, meaning nums[j] should be included in this subset
                if ((i & (1 << j)) != 0) {
                    ds.add(nums[j]);
                }
            }
            res.add(ds);
        }

        return res;
    }
}