func minimizeMax(nums []int, p int) int {
    n := len(nums)
    sort.Ints(nums)  // Sort the input array in ascending order
    start, end := 0, nums[n - 1] - nums[0]  // Initialize the search range on answers (BS on answers)
    var res int

    for start <= end {
        mid := start + (end - start) / 2
        count := 0  // Initialize the count of removed elements
        i := 0
        for i < n - 1{
            if nums[i + 1] - nums[i] <= mid {
                count++  // Remove a pair of elements
                i += 2
            } else {
                i++
            }
        }
        if count >= p {
            res = mid
            end = mid - 1  // Decrease the maximum difference
        } else {
            start = mid + 1  // Increase the maximum difference
        }
    }

    return res
}
