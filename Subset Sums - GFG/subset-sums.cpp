// { Driver Code Starts
#include<bits/stdc++.h> 
using namespace std; 

 // } Driver Code Ends
class Solution
{
public:

    void genSubsets(int idx, int sum, vector<int> &arr, int N, vector<int> &res) {
        
        if(idx == N) {
            res.push_back(sum);
            return;
        }
        
        //pick element
        genSubsets(idx + 1, sum + arr[idx], arr, N, res);
        
        //leave element
        genSubsets(idx + 1, sum, arr, N, res);
    }

    vector<int> subsetSums(vector<int> arr, int N) {
        vector<int> res;
        genSubsets(0, 0, arr, N, res);
        sort(res.begin(), res.end());
        return res;
    }
};

// { Driver Code Starts.
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
}  // } Driver Code Ends