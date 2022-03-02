class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       
        Arrays.sort(nums);
        
        List<List<Integer>> res = new LinkedList<>(); 
        
        if(nums.length < 3) return res; // if array size < 3 then no triplet will be formed
        
        // 1st element should be -ve otherwise no -ve numbers will be there  to make the sum 0
        
        if(nums[0] > 0) return res; 
        
        // fixing a target value and getting other two by two pointer
        
        for(int i = 0; i < nums.length; i++)
        {
            int target = nums[i]; 
            
            if(target > 0) break; // if target is +ve break the loop
            
            int low = i + 1, high = nums.length - 1;
            int sum = 0;
            
            if(i > 0 && nums[i] == nums[i - 1]) continue; // no duplicates
            
            while(low < high)
            {
                sum = nums[i] + nums[low] + nums[high];
                
                // f sum is -ve, means, we need more +ve numbers to make it 0 increament low (low++)     
                
                if(sum < 0) low++; 
                
                //If sum is +ve, means, we need more -ve numbers to make it 0, decreament high (high--).      
                if(sum > 0) high--;                                       
                
                if(sum == 0)
                {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    
                    // to avoid duplicate triplets, we have to navigate to last occurences of num[low]                          and num[high] respectively. Update the low and high with last occurences of low and high.
                    
                    int last_low_occ = nums[low], last_high_occ = nums[high];
                    
                    while(low < high && nums[low] == last_low_occ) low++;
                    while(low < high && nums[high] == last_high_occ) high--;
                }
            }
        }
        
        
        return res;
    
    }
}