class Solution {
    
    public void findCombo(int idx, int target, int[] arr, List<List<Integer>> ans, List<Integer> ds)
    {
        if(target == 0)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }
            
        for(int i = idx; i < arr.length; i++)
        {
            if(arr[i] > target)
                break;
            
            if(i > idx && arr[i] == arr[i-1])
                continue;
            
            ds.add(arr[i]);
            findCombo(i + 1, target - arr[i], arr, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(candidates);
        findCombo(0, target, candidates, ans, ds);
        return ans;
    }
}