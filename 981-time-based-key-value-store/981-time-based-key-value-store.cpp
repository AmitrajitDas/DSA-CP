class TimeMap {
public:
	TimeMap() {
		
	}

    unordered_map<string, vector<pair<string, int>>> map;
	void set(string key, string value, int timestamp) {
		map[key].push_back({value, timestamp});
	}

	string get(string key, int timestamp) {
		auto it = upper_bound(begin(map[key]), end(map[key]), pair<string, int>("", timestamp),
		[](const pair<string, int> &a, const pair<string, int> &b) {
			return a.second < b.second;
		});

		return it == map[key].begin() ? "" : prev(it)->first;
	}
};

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap* obj = new TimeMap();
 * obj->set(key,value,timestamp);
 * string param_2 = obj->get(key,timestamp);
 */