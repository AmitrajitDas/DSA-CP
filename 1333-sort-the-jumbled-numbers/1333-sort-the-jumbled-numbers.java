class Solution {
    // Method to translate a number based on the given mapping
    private int translateInteger(int num, int[] mapping) {
        if(num == 0) {
            return mapping[0]; // Special case when num is 0
        }
        int res = 0, mult = 1;

        // Translate the number by mapping each digit
        while(num > 0) {
            int rem = num % 10; // Get the last digit
            num /= 10; // Remove the last digit from num
            res += mapping[rem] * mult; // Map the digit and add to the result
            mult *= 10; // Increase the multiplier by 10 for the next digit
        }

        return res;
    }

    // Method to sort the array based on the translated values
    public int[] sortJumbled(int[] mapping, int[] nums) {
        // Map to store the translated values for each number in nums
        Map<Integer, Integer> mp = new HashMap<>();

        // Translate each number and store it in the map
        for(int num : nums) {
            if(!mp.containsKey(num)) {
                mp.put(num, translateInteger(num, mapping)); // Only translate if not already done
            }
        }

        // Convert nums to Integer array for sorting
        Integer[] numsBoxed = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        // Sort nums based on their translated values
        Arrays.sort(numsBoxed, (a, b) -> mp.get(a) - mp.get(b));

        // Convert sorted Integer array back to int array
        for(int i = 0; i < nums.length; i++) {
            nums[i] = numsBoxed[i];
        }

        return nums; // Return the sorted array
    }
};