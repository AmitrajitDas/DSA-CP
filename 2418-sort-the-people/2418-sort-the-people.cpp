class Solution {
private:
	static bool comp(pair<string, int> &a, pair<string, int> &b) {
		return a.second > b.second;
	}

public:
	vector<string> sortPeople(vector<string>& names, vector<int>& heights) {
		vector<pair<string, int>> arr;
		vector<string> res;

		for (int i = 0; i < names.size(); i++) {
			arr.push_back({names[i], heights[i]});
		}

		sort(arr.begin(), arr.end(), comp);

		for (auto it : arr) {
			res.push_back(it.first);
		}

		return res;
	}
};