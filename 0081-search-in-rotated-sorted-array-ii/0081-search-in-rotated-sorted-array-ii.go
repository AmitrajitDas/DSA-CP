func findPivot(nums []int, n int) int {
    start, end := 0, n - 1

    // Find the index of the pivot element using binary search.
    for start < end {
        // Skip duplicates at the beginning of the array.
        for start < end && nums[start] == nums[start + 1] {
            start++
        }
        // Skip duplicates at the end of the array.
        for start < end && nums[end] == nums[end - 1] {
            end--
        }

        mid := start + (end - start) / 2
        if nums[mid] >= nums[end] {
            start = mid + 1
        } else {
            end = mid
        }
    }

    return end
}

func bs(start int, end int, nums []int, target int) bool {
    // Binary search within a specific range [start, end].
    for start <= end {
        mid := start + (end - start) / 2
        if nums[mid] == target {
            return true
        } else if nums[mid] < target {
            start = mid + 1
        } else {
            end = mid - 1
        }
    }
    return false
}

func search(nums []int, target int) bool {
    n := len(nums)
    // Find the index where the array is rotated (the pivot).
    pivot := findPivot(nums, n)

    // Search for the target in the left subarray (before pivot).
    if bs(0, pivot - 1, nums, target) {
        return true
    }

    // Search for the target in the right subarray (after pivot).
    return bs(pivot, n - 1, nums, target)
}
