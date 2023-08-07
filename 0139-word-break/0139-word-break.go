// Function to check if a given string is in the word dictionary
func dictContains(str string, wordDict []string) bool {
    for _, word := range wordDict {
        if word == str {
            return true
        }
    }
    return false
}

func solve(idx int, s string, dp *[]int, wordDict []string) bool {
    // Base case: if we have reached the end of the string, return true
    if idx == len(s) {
        (*dp)[idx] = 1
        return true
    }
    // If the result for the current index is already computed, return it
    if (*dp)[idx] != -1 {
        return (*dp)[idx] == 1
    }

    // Try all possible splits and recursively check if the split is valid
    for endIdx := idx + 1; endIdx <= len(s); endIdx++ {
        split := s[idx:endIdx]
        if dictContains(split, wordDict) && solve(endIdx, s, dp, wordDict) {
            (*dp)[idx] = 1
            return true
        }
    }

    // If no valid split is found, mark the result as false
    (*dp)[idx] = 0
    return false
}

func wordBreak(s string, wordDict []string) bool {
    dp := make([]int, len(s)+1)
    for i := range dp {
        dp[i] = -1
    }
    return solve(0, s, &dp, wordDict)
}
