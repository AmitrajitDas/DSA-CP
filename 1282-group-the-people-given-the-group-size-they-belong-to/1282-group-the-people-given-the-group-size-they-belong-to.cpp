class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        int n = groupSizes.size();
        unordered_map<int, vector<int>> mp; // Create a map to store groups.
        vector<vector<int>> res;

        for (int i = 0; i < n; i++) {
            int len = groupSizes[i]; // Get the group size for the current person.
            mp[len].push_back(i); // Add the person to their corresponding group.

            if (mp[len].size() == len) {
                // If the group is full (size equals the group size), add it to the result.
                res.push_back(mp[len]);
                mp[len].clear(); // Clear the group for the next set of people.
            }
        }

        return res;
    }
};
