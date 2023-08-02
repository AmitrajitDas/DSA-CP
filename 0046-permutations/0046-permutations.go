func swap(a *int, b *int) {
    temp := *a
    *a = *b
    *b = temp
}

func solve(idx int, nums []int, res *[][]int) {
    if idx == len(nums)-1 {
        // Create a new slice and copy elements from nums
        permutation := make([]int, len(nums))
        copy(permutation, nums)
        *res = append(*res, permutation)
        return
    }

    for i := idx; i < len(nums); i++ {
        swap(&nums[idx], &nums[i])
        solve(idx+1, nums, res)
        swap(&nums[i], &nums[idx]) // Backtrack by swapping again
    }
}

func permute(nums []int) [][]int {
    var res [][]int
    solve(0, nums, &res)
    return res
}
