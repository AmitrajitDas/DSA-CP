func maxArea(height []int) int {
    i, j := 0, len(height) - 1;
    maxArea := 0;

    for i < j {
        minHeight := min(height[i], height[j]);
        width := j - i;
        maxArea = max(maxArea, minHeight * width);
        if height[i] < height[j] {
            i++;
        } else {
            j--;
        }
    }

    return maxArea;
}