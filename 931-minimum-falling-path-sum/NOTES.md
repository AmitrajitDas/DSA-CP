Starting from last row the matrix arr[n-1][j] where we'll check for every j.
Traversal - upLeft, upRight, up & taking min of them.
Base case - if we reach the 1st row then we'll return arr[0][j]
If col < 0 or col >= m we won't consider that subproblem