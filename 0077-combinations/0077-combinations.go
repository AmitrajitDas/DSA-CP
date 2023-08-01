func solve(start, k, n int, temp []int, res *[][]int) {
    // If k becomes 0, it means we have selected k elements for the combination.
    // We create a new slice and copy the elements from temp to it, then add it to the result slice.
    if k == 0 {
        combination := make([]int, len(temp))
        copy(combination, temp)
        *res = append(*res, combination)
        return
    }

    for i := start; i <= n; i++ {
        temp = append(temp, i)
        // We pass a new copy of temp (append([]int{}, temp...)) to avoid modifying the current temp slice
        // in the subsequent recursive calls.
        solve(i+1, k-1, n, append([]int{}, temp...), res)
        // Backtrack by removing the last element from temp before the next iteration.
        temp = temp[:len(temp)-1]
    }
}

func combine(n, k int) [][]int {
    var res [][]int
    var temp []int
    solve(1, k, n, temp, &res)
    return res
}
