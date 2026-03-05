func subsets(nums []int) [][]int {
    n := len(nums) 
    subsetCount := 1 << n
    var res [][]int

    for i := 0; i < subsetCount; i++ {
        var ds []int;
        for j := 0; j < n; j++ {
            if(i & (1 << j) != 0) {
                ds = append(ds, nums[j])
            }
        }
        res = append(res, ds);
    }

    return res;
}