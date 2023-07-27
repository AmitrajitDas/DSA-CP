func majorityElement(nums []int) []int {
    if len(nums) <= 1 {
        return nums
    }
    limit := len(nums) / 3
    mp := make(map[int]int)
    var res []int
    for _, num := range nums {
        mp[num]++
    }
    for num, count := range mp {
        if count > limit {
            // If the count is greater than the limit, add the element to the result slice
            res = append(res, num)
        }
    }
    return res
}
