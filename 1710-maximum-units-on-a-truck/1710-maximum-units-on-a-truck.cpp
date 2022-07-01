static bool comparator(const pair<int, int> &a, const pair<int, int> &b) {
    return a.second > b.second;
}

class Solution {
public:
    int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) {
        
        vector<pair<int, int>> boxPairs;
        for(int i = 0; i < boxTypes.size(); i++) {
            boxPairs.push_back({boxTypes[i][0], boxTypes[i][1]});
        }
        
        sort(boxPairs.begin(), boxPairs.end(), comparator);
        
        int limit = truckSize;
        int res = 0;
        
        for(int i = 0; i < boxPairs.size() && limit > 0; i++) {
            if(limit > boxPairs[i].first) {
                res += boxPairs[i].first * boxPairs[i].second;
            } else {
                res += limit * boxPairs[i].second;
            }
            
            limit -= boxPairs[i].first;
        }
        
        return res;
    }
};