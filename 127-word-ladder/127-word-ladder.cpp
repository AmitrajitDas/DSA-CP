class Solution {
public:
	int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
		int n = wordList.size();
		unordered_set<string> st(wordList.begin(), wordList.end());
		queue<pair<string, int>> q;
		q.push({beginWord, 1});
		st.erase(beginWord);

		while (!q.empty()) {
			string word = q.front().first;
			int steps = q.front().second;
			q.pop();

			if (word == endWord) return steps;

			for (int i = 0; i < word.size(); i++) {
				char original = word[i];
				for (char c = 'a'; c <= 'z'; c++) {
					word[i] = c;
					auto it = st.find(word);
					if (it != st.end()) {
						q.push({word, steps + 1});
						st.erase(it);
					}
				}

				word[i] = original;
			}
		}

		return 0;
	}
};