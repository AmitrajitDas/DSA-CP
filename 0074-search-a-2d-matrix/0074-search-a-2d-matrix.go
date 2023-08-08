func searchMatrix(matrix [][]int, target int) bool {
    n, m := len(matrix), len(matrix[0])
    start, end := 0, n * m-1

    for start <= end {
        mid := start + (end - start) / 2
        row, col := mid / m, mid % m    // Calculate the row and column indices

        if matrix[row][col] > target {
            end = mid - 1 // Adjust the end index for the left half
        } else if matrix[row][col] < target {
            start = mid + 1 // Adjust the start index for the right half
        } else {
            return true // Found the target value in the matrix
        }
    }

    return false
}
