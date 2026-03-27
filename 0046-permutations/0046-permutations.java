class Solution {
    private void backtrack(List<Integer> curr, boolean[] used, List<List<Integer>> res, int[] nums) {
        if(curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
        }
        for(int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
            used[i] = true;
            curr.add(nums[i]);
            backtrack(curr, used, res, nums);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(curr, used, res, nums);
        return res;
    }
}