class Solution {
  public:
    void backtrack(int col, vector<string> &board, vector <vector<string>> &res, vector <int> &leftrow,                    vector<int> &upperDiagonal, vector <int> &lowerDiagonal, int n) {
      if (col == n) {
        res.push_back(board);
        return;
      }
      for (int row = 0; row < n; row++) {
        if (leftrow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[n - 1 + col - row] == 0) {
          board[row][col] = 'Q';
          leftrow[row] = 1;
          lowerDiagonal[row + col] = 1;
          upperDiagonal[n - 1 + col - row] = 1;
          backtrack(col + 1, board, res, leftrow, upperDiagonal, lowerDiagonal, n);
          board[row][col] = '.';
          leftrow[row] = 0;
          lowerDiagonal[row + col] = 0;
          upperDiagonal[n - 1 + col - row] = 0;
        }
      }
    }

  public:
    vector <vector<string>> solveNQueens(int n) {
      vector<vector<string>> res;
      vector<string> board(n);
      string s(n, '.');
      for (int i = 0; i < n; i++) board[i] = s;
      vector<int> leftrow(n, 0), upperDiagonal(2 * n - 1, 0), lowerDiagonal(2 * n - 1, 0);
      backtrack(0, board, res, leftrow, upperDiagonal, lowerDiagonal, n);
      return res;
    }
};