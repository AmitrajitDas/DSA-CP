class Solution {
public:
    struct compare{
    public:
        bool operator()(vector<int> &a, vector<int> &b) {
            return b[1] > a[1];
        }
    };
    
    int minRefuelStops(int target, int startFuel, vector<vector<int>>& stations) {
        int n = stations.size();
        priority_queue<vector<int>, vector<vector<int>>, compare> pq;
        
        int i = 0, refills = 0, distance = startFuel;
        
        while(distance < target) {
            while(i < n && distance >= stations[i][0]) {
                pq.push(stations[i]);
                i++;
            }
            
            if(pq.empty()) return -1; // if pq gets empty it means we can't reach the target
            distance += pq.top()[1];
            pq.pop();
            refills++;
        }
        
        return refills;
    }
}; 