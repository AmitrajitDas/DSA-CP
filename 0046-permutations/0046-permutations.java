class Solution {
    // Explores all possible permutations by choosing unused elements one at a time
    private void backtrack(List<Integer> curr, boolean[] used, List<List<Integer>> res, int[] nums) {
        // Base case: current permutation is complete
        if(curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            // Skip already used elements
            if(used[i]) continue;

            // Choose: mark element as used and add to current permutation
            used[i] = true;
            curr.add(nums[i]);

            // Explore: recurse with updated state
            backtrack(curr, used, res, nums);

            // Unchoose: backtrack by removing element and marking as unused
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] used = new boolean[nums.length]; // defaults to false
        backtrack(curr, used, res, nums);
        return res;
    }
}