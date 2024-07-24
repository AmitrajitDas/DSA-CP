class Solution {
    private int translateInteger(int num, int[] mapping) {
        if(num == 0) {
            return mapping[0];
        }
        int res = 0, mult = 1;

        while(num > 0) {
            int rem = num % 10;
            num /= 10;
            res += mapping[rem] * mult;
            mult *= 10;
        }

        return res;
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int num : nums) {
            if(!mp.containsKey(num)) {
                mp.put(num, translateInteger(num, mapping));
            }
        }

        Integer[] numsBoxed = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsBoxed, (a, b) -> mp.get(a) - mp.get(b));

        for(int i = 0; i < nums.length; i++) {
            nums[i] = numsBoxed[i];
        }

        return nums;
    }
}