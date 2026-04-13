class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> nums = new ArrayList<>();
        StringBuilder res = new StringBuilder();

        for(int i = 1; i < n; i++) {
            fact *= i;
            nums.add(i);
        }
        nums.add(n);
        k = k - 1;
        
        while(true) {
            res.append(nums.get(k / fact));
            nums.remove(k / fact);
            if(nums.size() == 0) {
                break;
            }
            k = k % fact;
            fact = fact / nums.size();
        }

        return res.toString();
    }
}