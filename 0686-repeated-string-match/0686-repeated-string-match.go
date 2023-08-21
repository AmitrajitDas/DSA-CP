func repeatedStringMatch(a string, b string) int {
	// We add +2 to allow for potential offset and rounding up of division
	for i := 1; i <= len(b) / len(a) + 2; i++ {
		// Repeat string 'a' 'i' times and check if it contains string 'b'
		if strings.Contains(strings.Repeat(a, i), b) {
			// If 'b' is found in the repeated string, return the value of 'i'
			// This indicates how many times 'a' needs to be repeated to contain 'b'
			return i
		}
	}
	// If 'b' is not found in any repeated string of 'a', return -1
	return -1
}