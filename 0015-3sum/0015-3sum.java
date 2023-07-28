public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // Skip duplicate elements to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            else {
                // Set pointers for the second and third elements of the triplet
                int j = i + 1, k = n - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    // If the sum is negative, move the second pointer to the right
                    if (sum < 0) j++;
                    // If the sum is positive, move the third pointer to the left
                    else if (sum > 0) k--;
                    // If the sum is zero, we found a triplet
                    else {
                        // Create a list to store the triplet
                        List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                        res.add(temp);
                        // Move the pointers to the next unique elements
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j - 1]) j++;
                        while (j < k && nums[k] == nums[k + 1]) k--;
                    }
                }
            }
        }
        return res;
    }
}