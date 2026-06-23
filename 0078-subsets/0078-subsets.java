class Solution {
    private void backtrack(int start, List<Integer> curr, int[] nums, List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));

        for(int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums, res);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(0, curr, nums, res);
        return res;
    }
}