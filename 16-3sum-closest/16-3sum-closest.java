class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        List<List<Integer>> list = new LinkedList<>();
        
        Arrays.sort(nums);
        
        int n = nums.length;
        
        if(n < 3) return -1; // if array size < 3 then no triplet will be formed
        
        int minSum = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        
        int sum = nums[0] + nums[1] + nums[nums.length - 1];
        int closestSum = sum;
        
        for(int i = 0; i < n - 1; i++)
        {            
            int low = i + 1, high = n - 1;
            
            if(i > 0 && nums[i] == nums[i - 1]) continue; // no duplicates
            
            while(low < high)
            {
                sum = nums[i] + nums[low] + nums[high];
                     
                if(sum < target)
                {
                    while(low < high && nums[low] == nums[low + 1]){
                        
                        low++;
                    }
                    
                    low++;
                }
                
                if(sum > target)
                {
                    while(low < high && nums[high] == nums[high - 1]){
                        
                        high--;
                    }
                    
                     high--;
                }
                
                if(sum == target) return sum;
                
                //update the closest sum if needed
                
                if(Math.abs(target - sum) < Math.abs(target - closestSum)) closestSum = sum;
            }
        }
        
        return closestSum;
        
    }
}