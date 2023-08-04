func solve(opened, closed, n int, current string, res *[]string) {
    // If we have placed the desired number of open and close parentheses
    if opened == n && closed == n {
        *res = append(*res, current) // Add the current combination to the result
        return
    }
    
    // If we can still place an open parenthesis
    if opened < n {
        solve(opened+1, closed, n, current+"(", res) // Place an open parenthesis
    }

    // If we can still place a close parenthesis (but only if it matches an open one)
    if closed < opened {
        solve(opened, closed+1, n, current+")", res) // Place a close parenthesis
    }
}

func generateParenthesis(n int) []string {
    var res []string
    solve(0, 0, n, "", &res) // Start with no parentheses placed
    return res
}
