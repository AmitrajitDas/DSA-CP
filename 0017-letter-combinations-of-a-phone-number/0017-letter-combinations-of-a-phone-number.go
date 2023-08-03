func solve(idx int, temp *string, digits string, letterMap map[byte]string, res *[]string) {
    // Base case: when we have processed all digits
    if idx == len(digits) {
        // Create a new string and copy the characters from temp
        combo := make([]byte, len(*temp))
        copy(combo, *temp)
        *res = append(*res, string(combo))
        return
    }
    // Get the letters corresponding to the current digit
    letters := letterMap[digits[idx]]
    for i := 0; i < len(letters); i++ {
        // Add the current letter to the temp string
        *temp += string(letters[i])
        solve(idx + 1, temp, digits, letterMap, res)
        // Remove the last letter to backtrack
        *temp = (*temp)[:len(*temp) - 1]
    }
}

func letterCombinations(digits string) []string {
    var res []string
    temp := ""
    if digits == "" {
        return res
    }
    letterMap := make(map[byte]string)
    letterMap['2'] = "abc"
    letterMap['3'] = "def"
    letterMap['4'] = "ghi"
    letterMap['5'] = "jkl"
    letterMap['6'] = "mno"
    letterMap['7'] = "pqrs"
    letterMap['8'] = "tuv"
    letterMap['9'] = "wxyz"
    solve(0, &temp, digits, letterMap, &res)
    return res
}
