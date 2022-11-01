//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int minimumMultiplications(vector<int>& arr, int start, int end) {
        vector<int> dist(100000, 1e9);
        dist[start] = 0;
        queue<pair<int, int>> q;
        q.push({0, start});
        int mod = 100000;
        while(!q.empty()) {
            auto it = q.front();
            q.pop();
            int steps = it.first, node = it.second;
            
            for(int itr : arr) {
                int newNode = (itr * node) % mod;
                if(steps + 1 < dist[newNode]) {
                    dist[newNode] = steps + 1;
                    if(newNode == end) return steps + 1;
                    q.push({steps + 1, newNode});
                }
            }
        }
        
        return -1;
    }
};


//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<int> arr(n);
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        int start, end;
        cin >> start >> end;
        Solution obj;
        cout << obj.minimumMultiplications(arr, start, end) << endl;
    }
}

// } Driver Code Ends