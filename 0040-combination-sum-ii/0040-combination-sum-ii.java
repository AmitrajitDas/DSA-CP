class Solution {
    private void findCombination(int ind, int target, int[] arr, List<List<Integer>> ans, List<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1])
                continue; // Skip duplicates
            if (arr[i] > target)
                break; // No point in continuing if arr[i] exceeds target
            ds.add(arr[i]);
            findCombination(i + 1, target - arr[i], arr, ans, ds);
            ds.remove(ds.size() - 1); // Backtrack
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // Sort to handle duplicates and early stopping
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        findCombination(0, target, candidates, ans, ds);
        return ans;
    }
}