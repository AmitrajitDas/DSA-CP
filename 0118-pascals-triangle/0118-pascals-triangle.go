func genRow(row int) []int {
	ans := 1
	var ansRow []int
	ansRow = append(ansRow, 1)
	for col := 1; col < row; col++ {
		// The value of each element is calculated using the formula:
		// ans = ans * (row - col) / col
		ans = ans * (row - col) / col
		ansRow = append(ansRow, ans)
	}
	return ansRow
}

func generate(numRows int) [][]int {
	var res [][]int
	for i := 1; i <= numRows; i++ {
		// Generate a single row using the genRow function and append it to the res slice
		res = append(res, genRow(i))
	}

	// Return the complete Pascal's Triangle
	return res
}