class Solution {
public:
	vector<int> findOriginalArray(vector<int>& changed) {

		int n = changed.size();
		if (n % 2 == 1) return vector<int>(); // array should be even length otherwise it won't contain all the doubled values

		unordered_map<int, int> mp;
		vector<int> res;
		sort(changed.begin(), changed.end());

		for (auto it : changed) mp[it]++; // storing frequency in the hashmap

		for (int i = 0; i < n; i++) {
			if (mp[changed[i]] == 0) continue;
			if (mp[changed[i] * 2] == 0) return vector<int>(); // if double of a num is not found then return empty arr
			res.push_back(changed[i]);
			mp[changed[i]]--;
			mp[changed[i] * 2]--; // removing already calculated nums from map
		}

		return res;
	}
};