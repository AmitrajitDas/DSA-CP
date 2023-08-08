func search(nums []int, target int) int {
    n := len(nums)
    if n == 0 {
        return -1
    }

    start, end := 0, n-1

    for start <= end {
        mid := start + (end - start) / 2

        if nums[mid] == target {
            return mid
        } else if nums[start] <= nums[mid] {
            // If left half is sorted
            if target >= nums[start] && target < nums[mid] {
                end = mid - 1 // Search in the left half
            } else {
                start = mid + 1 // Search in the right half
            }
        } else if nums[mid] <= nums[end] {
            // If right half is sorted
            if target > nums[mid] && target <= nums[end] {
                start = mid + 1 // Search in the right half
            } else {
                end = mid - 1 // Search in the left half
            }
        }
    }

    return -1
}
