func validPartition(nums []int) bool {
    n := len(nums)
    dp := make([]bool, n+1)

    dp[n] = true // Base case: An empty subarray is always valid

    for i := n - 1; i >= 0; i-- {
        // rule 1
        if i < n-1 && nums[i] == nums[i+1] && dp[i+2] {
            dp[i] = true
        } else if i < n-2 && nums[i] == nums[i+1] && nums[i+1] == nums[i+2] && dp[i+3] {
            // rule 2
            dp[i] = true
        } else if i < n-2 && nums[i+2]-nums[i+1] == 1 && nums[i+1]-nums[i] == 1 && dp[i+3] {
            // rule 3
            dp[i] = true
        }
    }

    return dp[0]
}

// func solve(idx int, nums []int, dp *map[int]bool) bool {
//     if idx >= len(nums) {
//         (*dp)[idx] = true
//         return true
//     }

//     val, exists := (*dp)[idx]
//     if exists {
//         return val
//     }

//     if idx < len(nums)-1 && nums[idx] == nums[idx+1] {
//         if solve(idx+2, nums, dp) {
//             (*dp)[idx] = true
//             return true
//         }
//     }

//     if idx < len(nums)-2 && nums[idx] == nums[idx+1] && nums[idx+1] == nums[idx+2] {
//         if solve(idx+3, nums, dp) {
//             (*dp)[idx] = true
//             return true
//         }
//     }

//     if idx < len(nums)-2 && nums[idx+2]-nums[idx+1] == 1 && nums[idx+1]-nums[idx] == 1 {
//         if solve(idx+3, nums, dp) {
//             (*dp)[idx] = true
//             return true
//         }
//     }

//     (*dp)[idx] = false
//     return false
// }

// func validPartition(nums []int) bool {
//     dp := make(map[int]bool)
//     return solve(0, nums, &dp)
// }
