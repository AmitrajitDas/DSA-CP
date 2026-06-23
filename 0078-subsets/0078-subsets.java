class Solution {
    private void backtrack(int start, List<Integer> curr, int[] nums, List<List<Integer>> res) {
        // snapshot current subset at every node (not just leaves)
        res.add(new ArrayList<>(curr));

        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);              // choose
            backtrack(i + 1, curr, nums, res);  // explore (i+1 to avoid re-picking same element)
            curr.remove(curr.size() - 1);   // unchoose
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, new ArrayList<>(), nums, res);
        return res;
    }
}