class Solution {
    private void backtrack(int idx, List<Integer> curr, List<List<Integer>> res, int[] nums) {
        res.add(new ArrayList<>(curr));

        for(int i = idx; i < nums.length; i++) {
            if(i > idx && nums[i] == nums[i - 1]) continue;
            curr.add(nums[i]);
            backtrack(i + 1, curr, res, nums);
            curr.remove(curr.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, curr, res, nums);
        return res;
    }
}