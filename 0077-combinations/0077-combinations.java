class Solution {
    private void backtrack(int idx, int n, int k, List<Integer> curr, List<List<Integer>> res) {
        if(k == 0) {
            res.add(new ArrayList<>(curr));
            return;
        } 

        for(int i = idx; i <= n; i++) {
            curr.add(i);
            backtrack(i + 1, n, k - 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(1, n, k, curr, res);
        return res;
    }
}