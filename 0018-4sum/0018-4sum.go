func fourSum(nums []int, target int) [][]int {
    n := len(nums)
    sort.Ints(nums)
    var res [][]int

    for i := 0; i < n-3; i++ {
        // Skip duplicate elements for the first number
        if i > 0 && nums[i] == nums[i-1] {
            continue
        }
        for j := i + 1; j < n-2; j++ {
            // Skip duplicate elements for the second number
            if j > i+1 && nums[j] == nums[j-1] {
                continue
            }
            k, l := j+1, n-1
            for k < l {
                sum := nums[i] + nums[j] + nums[k] + nums[l]
                if sum < target {
                    k++
                } else if sum > target {
                    l--
                } else {
                    // Found a valid quadruplet, add it to the result
                    res = append(res, []int{nums[i], nums[j], nums[k], nums[l]})
                    k++
                    l--
                    // Skip duplicate elements for the third number
                    for k < l && nums[k] == nums[k-1] {
                        k++
                    }
                    // Skip duplicate elements for the fourth number
                    for k < l && nums[l] == nums[l+1] {
                        l--
                    }
                }
            }
        }
    }

    return res
}
