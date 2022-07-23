class Solution {
public:
    
    bool isValid(int row, int col, char ch, vector<vector<char>>& board) {
        for(int i = 0; i < 9; i++) {
            if(board[row][i] == ch || board[i][col] == ch || board[3 * (row/3) + i/3][3 * (col/3) + i%3] == ch) {
                return false;
            }
        }
        
        return true;
    }
    
    bool backtrack(vector<vector<char>>& board) {
        
        for(int i = 0; i < board.size(); i++) {
            for(int j = 0; j < board[i].size(); j++) {
                if(board[i][j] == '.') {
                    for(char k = '1'; k <= '9'; k++) {
                        if(isValid(i, j, k, board)) {
                            board[i][j] = k;
                            if(backtrack(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    
                    return false;
                }
            }
        }
        
        return true;
    }
    
    void solveSudoku(vector<vector<char>>& board) {
        backtrack(board);    
    }
};