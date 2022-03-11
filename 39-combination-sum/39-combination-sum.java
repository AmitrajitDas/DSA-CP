class Solution {
    
    public void findCombo(int idx, int target, int[] candidates, List<List<Integer>> ans, List<Integer> ds)
    {
        if(idx == candidates.length)
        {
            if(target == 0)
                ans.add(new  ArrayList<>(ds));
            
            return;
        }
        
        // take
        if(candidates[idx] <= target)
        {
            ds.add(candidates[idx]);
            findCombo(idx, target - candidates[idx], candidates, ans, ds);
            ds.remove(ds.size() - 1);
        }
        
        // not take
        findCombo(idx + 1, target, candidates, ans, ds);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans = new  ArrayList<>();
        List<Integer> ds = new  ArrayList<>();
        findCombo(0, target, candidates, ans, ds);
        return ans;
    }
}