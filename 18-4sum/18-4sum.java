class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        
        
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (num == null || num.length == 0)
            return res;
        
        int n = num.length;
    
        Arrays.sort(num); 
    
        for (int i = 0; i < n - 1; i++) {
        
            int target_3 = target - num[i];
        
            for (int j = i + 1; j < n; j++) {
            
                int target_2 = target_3 - num[j];
            
                int front = j + 1;
                int back = n - 1;
            
                while(front < back) {
                
                    int two_sum = num[front] + num[back];
                
                    if (two_sum < target_2) front++;
                
                    else if (two_sum > target_2) back--;
                
                    else {
                    
                        List<Integer> quad = new ArrayList<>(); 
                        quad.add(num[i]);
                        quad.add(num[j]);
                        quad.add(num[front]);
                        quad.add(num[back]);
                        res.add(quad);
                    
                        // Processing the duplicates of number 3
                        while (front < back && num[front] == quad.get(2)) ++front;
                    
                        // Processing the duplicates of number 4
                        while (front < back && num[back] == quad.get(3)) --back;
                
                    }
                }
                
                // Processing the duplicates of number 2
                while(j + 1 < n && num[j + 1] == num[j]) ++j;
            }
        
            // Processing the duplicates of number 1
            while (i + 1 < n && num[i + 1] == num[i]) ++i;
        
        }
        
    
        return res;
        
    }
}
        
        
//         Arrays.sort(nums);
        
//         int n = nums.length;
        
//         LinkedList<List<Integer>> list = new LinkedList<>();
        
//         for(int i = 0; i < n - 1; i++)
//         {
//             for(int j = i + 1; j < n; j++)
//             {
//                 int low = j + 1, high = n - 1;
//                 int sum = 0;
                
//                 if(i > 0 && nums[j] == nums[j - 1]) continue; // no duplicates
                
//                 while(low < high)
//                 {
//                     sum = nums[i] + nums[j] + nums[low] + nums[high];
                    
//                     if(sum < target)
//                     {
//                         while(low < high && nums[low] == nums[low + 1]) low++;
//                         low++;
//                     }
                    
//                     if(sum > target)
//                     {
//                         while(low < high && nums[high] == nums[high - 1]) high--;
//                         high--;
//                     }
                    
//                     if(sum == target)
//                     {
//                         list.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
//                         while(low < high && nums[low] == nums[low + 1]) low++;
//                         low++;
//                         while(low < high && nums[high] == nums[high - 1]) high--;
//                         high--;
//                     }
//                 }
//             }
//         }
        
//         return list;
        
//   }
// }