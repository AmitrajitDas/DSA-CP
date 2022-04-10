class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        vector<int> res;
        int n = arr.size();
        
        for(int i = 0; i < k; i++)
            pq.push({arr[i], abs(arr[i] - x)});
        
        for(int i = k; i < n; i++) {
            if(abs(arr[i] - x) < pq.top().second) {
                pq.pop();
                pq.push({arr[i], abs(arr[i] - x)});
            }
        }
        
        while(!pq.empty()) {
            int temp = pq.top().first;
            pq.pop();
            res.push_back(temp);
        }
        
        sort(res.begin(), res.end());
        
        return res;
    }
};