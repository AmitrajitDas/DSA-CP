class Solution {
public:
    // Define a structure to store information about each creator
    struct video {
        long sum = 0;          // total views for the creator
        string smallestId;     // lexicographically smallest id for the creator
        int maxViews;          // maximum views among all videos of the creator
    };

    vector<vector<string>> mostPopularCreator(vector<string>& creators, vector<string>& ids, vector<int>& views) {
        
        unordered_map<string, video> mp; // Create an unordered_map to store information about each creator
        long count = 0; // Variable to keep track of the overall maximum total views

        for (int i = 0; i < creators.size(); i++) {
            string currCreator = creators[i];
            // Check if the creator is already in the map
            if (mp.find(currCreator) != mp.end()) {
                // Update total views for the creator
                mp[currCreator].sum += views[i];
                // Update maximum views and smallest id if necessary
                if (mp[currCreator].maxViews < views[i] || (mp[currCreator].maxViews == views[i] && ids[i] < mp[currCreator].smallestId)) {
                    mp[currCreator].maxViews = views[i];
                    mp[currCreator].smallestId = ids[i];
                }
            } else {
                // If the creator is not in the map, initialize its entry
                mp[currCreator] = {views[i], ids[i], views[i]};
            }

            // Update the overall maximum total views
            count = max(count, mp[currCreator].sum);
        }

        // Create a vector to store the result
        vector<vector<string>> res;

        // Iterate through the map to find creators with the highest total views
        for (auto &it : mp) {
            if (it.second.sum == count) {
                // Add the creator and its most popular video to the result
                res.push_back({ it.first, it.second.smallestId });
            }
        }

        // Return the final result
        return res;
    }
};
