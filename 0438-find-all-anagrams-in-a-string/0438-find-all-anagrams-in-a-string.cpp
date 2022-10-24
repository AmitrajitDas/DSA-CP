class Solution {
public:
	vector<int> findAnagrams(string s, string p) {
		unordered_map<char, int> freq;
		for (char it : p) freq[it]++;
		vector<int> res;
		int i = 0, j = 0, k = p.size(), count = freq.size();

		while (j < s.size()) {
			if (freq.find(s[j]) != freq.end()) {
				freq[s[j]]--;
				if (freq[s[j]] == 0) count--; // decreasing count to know which chars are processed which lies in map
			}
			if (j - i + 1 < k) j++;
			else if (j - i + 1 == k) {
				if (count == 0) res.push_back(i); // if count becomes 0 it means all the occurences were found
				if (freq.find(s[i]) != freq.end()) {
					freq[s[i]]++;
					if (freq[s[i]] == 1) count++; // before we slide the window we need to restore the prev count
				}
                
                i++; j++;
			}

		}

		return res;
	}
};