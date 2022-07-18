//{ Driver Code Starts
#include<bits/stdc++.h> 
using namespace std; 

// } Driver Code Ends
class Solution
{
public:

    void backtrack(int ind, int sum, int size, vector<int> &arr, vector<int> &res) {
        
        if(ind == size) {
            res.push_back(sum);
            return;
        }
        
        sum += arr[ind];
        backtrack(ind + 1, sum, size, arr, res);
        sum -= arr[ind];
        backtrack(ind + 1, sum, size, arr, res);
    }

    vector<int> subsetSums(vector<int> arr, int N) {
        vector<int> res;
        int sum = 0;
        backtrack(0, sum, N, arr, res);
        return res;
    }
};

//{ Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int N;
        cin>>N;
        vector<int> arr(N);
        for(int i = 0 ; i < N ; i++){
            cin >> arr[i];
        }
        Solution ob;
        vector<int> ans = ob.subsetSums(arr,N);
        sort(ans.begin(),ans.end());
        for(auto sum : ans){
            cout<< sum<<" ";
        }
        cout<<endl;
    }
    return 0;
}
// } Driver Code Ends
