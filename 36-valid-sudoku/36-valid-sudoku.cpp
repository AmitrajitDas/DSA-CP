class Solution {
	bool isValidRow(vector<vector<char>>& board, int row) {
		unordered_set<char> s;
		for (int col = 0; col < board.size(); col++) {
			if (s.find(board[row][col]) != s.end()) {
				return false;
			}

			if (board[row][col] != '.') {
				s.insert(board[row][col]);
			}
		}
		return true;
	}

	bool isValidCol(vector<vector<char>>& board, int col) {
		unordered_set<char> s;
		for (int row = 0; row < board.size(); row++) {
			if (s.find(board[row][col]) != s.end()) {
				return false;
			}

			if (board[row][col] != '.') {
				s.insert(board[row][col]);
			}
		}
		return true;
	}

	bool isValidCell(vector<vector<char>>& board, int startRow, int endRow, int startCol, int endCol) {
		unordered_set<char> s;
		for (int row = startRow; row <= endRow; row++) {
			for (int col = startCol; col <= endCol; col++) {
				if (s.find(board[row][col]) != s.end()) {
					return false;
				}

				if (board[row][col] != '.') {
					s.insert(board[row][col]);
				}
			}
		}
		return true;
	}
public:
	bool isValidSudoku(vector<vector<char>>& board) {
		bool match = true;
		int adder = sqrt(board.size());
		for (int i = 0; i < board.size(); i++) {
			match = match && isValidRow(board, i) && isValidCol(board, i);
			if (i % adder == 0) {
				for (int j = 0; j < board.size(); j += adder) {
					match = match && isValidCell(board, i, i + adder - 1, j, j + adder - 1);
				}
			}
		}

		return match;
	}
};