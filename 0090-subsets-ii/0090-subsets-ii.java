class Solution {
    private void backtrack(int start, List<Integer> curr, int[] nums, List<List<Integer>> res) {
        // capture snapshot at every node, not just leaves — this gives us all subset sizes
        res.add(new ArrayList<>(curr));

        for (int i = start; i < nums.length; i++) {
            // skip duplicate values at the same recursive level to avoid duplicate subsets
            // i > start ensures we don't skip the first valid pick at this level
            if (i > start && nums[i] == nums[i - 1]) continue;

            curr.add(nums[i]);                       // choose
            backtrack(i + 1, curr, nums, res);       // explore (i+1: each element used at most once)
            curr.remove(curr.size() - 1);            // unchoose (restore state for next iteration)
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  // sorting groups duplicates together, making skip condition possible
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, new ArrayList<>(), nums, res);
        return res;
    }
}