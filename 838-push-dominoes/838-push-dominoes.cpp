class Solution {
public:
	string pushDominoes(string dominoes) {
		queue<pair<char, int>> q;
		int n = dominoes.size();

		for (int i = 0; i < n; i++) {
			if (dominoes[i] != '.') q.push({dominoes[i], i});
		}

		while (!q.empty()) {
			char dom = q.front().first;
			int idx = q.front().second;
			q.pop();

			if (dom == 'L') {
				if (idx > 0 && dominoes[idx - 1] == '.') {
					dominoes[idx - 1] = 'L';
					q.push({dom, idx - 1});
				}
			} else {
				if (idx + 1 < n && dominoes[idx + 1] == '.') {
					if (idx + 2 < n && dominoes[idx + 2] == 'L') {
						q.pop();
					} else {
						dominoes[idx + 1] = 'R';
						q.push({dom, idx + 1});
					}

				}
			}
		}

		return dominoes;
	}
};