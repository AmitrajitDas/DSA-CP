class Solution {
	unordered_map<string, int> mp;
	vector<vector<string>> res;
	string b;
private:
	void dfs(string word, vector<string> &seq) {
		if (word == b) {
			reverse(seq.begin(), seq.end());
			res.push_back(seq);
			reverse(seq.begin(), seq.end()); // to prevent changing the original sequence otherwise wrong element will be popped back
			return;
		}


		int steps = mp[word];
		int size = word.size();
		for (int i = 0; i < size; i++) {
			char original = word[i];
			for (char c = 'a'; c <= 'z'; c++) {
				word[i] = c;
				if (mp.find(word) != mp.end() && mp[word] == steps - 1) {
					seq.push_back(word);
					dfs(word, seq);
					seq.pop_back();
				}
			}
			word[i] = original;
		}
	}
public:
	vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
		int n = wordList.size();
		unordered_set<string> st(wordList.begin(), wordList.end());
		queue<string> q;
		q.push(beginWord);
		mp[beginWord] = 1;
		st.erase(beginWord);
		int size = beginWord.size();
		b = beginWord;

		while (!q.empty()) {
			string word = q.front();
			q.pop();

			int steps = mp[word];

			if (word == endWord) break;

			for (int i = 0; i < size; i++) {
				char original = word[i];
				for (char c = 'a'; c <= 'z'; c++) {
					word[i] = c;
					if (st.count(word)) {
						q.push(word);
						st.erase(word);
						mp[word] = steps + 1;
					}
				}
				word[i] = original;
			}
		}

		if (mp.find(endWord) != mp.end()) {
			vector<string> seq;
			seq.push_back(endWord);
			dfs(endWord, seq);
		}

		return res;
	}
};