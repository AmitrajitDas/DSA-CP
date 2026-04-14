class Solution {
    private void genCombos(int i, int target, List<Integer> curr, List<List<Integer>> res, int[] candidates) {
        if(i == candidates.length) {
            if(target == 0) res.add(new ArrayList<>(curr));
            return;    
        }

        if(candidates[i] <= target) {
            curr.add(candidates[i]);
            genCombos(i, target - candidates[i], curr, res, candidates);
            curr.remove(curr.size() - 1);
        }
        
        genCombos(i + 1, target, curr, res, candidates);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        genCombos(0, target, curr, res, candidates);
        return res;
    }
}