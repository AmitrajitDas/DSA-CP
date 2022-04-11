// { Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
#define N 105
using namespace std;
void printArray(vector<int> arr, int size)
{
for (int i=0; i < size; i++)
	cout << arr[i] << " ";
}


 // } Driver Code Ends
//User function Template for C++

struct Triplet {
    int val, aPos, vPos;
    Triplet(int _val, int _aPos, int _vPos) {
        val = _val;
        aPos = _aPos;
        vPos = _vPos;
    }
};

struct comparator {
    bool operator () (Triplet const& a, Triplet const& b) {
        return a.val > b.val;
    }
};

class Solution
{
    public:
    //Function to merge k sorted arrays.
    vector<int> mergeKArrays(vector<vector<int>> arr, int K)
    {
        priority_queue<Triplet, vector<Triplet>, comparator> pq;
        vector<int> res;
        
        for(int i = 0; i  < arr.size(); i++) {
            Triplet t(arr[i][0], i, 0);
            pq.push(t);
        }
        
        while(!pq.empty()) {
            Triplet temp = pq.top();
            pq.pop();
            res.push_back(temp.val);
            int apos = temp.aPos, vpos = temp.vPos;
            if(vpos + 1 < arr[apos].size()) {
                Triplet t(arr[apos][vpos+1], apos, vpos + 1);
                pq.push(t);
            }
        }
        
        return res;
    }
};

// { Driver Code Starts.

int main()
{
	int t;
	cin>>t;
	while(t--){
	    int k;
	    cin>>k;
	    vector<vector<int>> arr(k, vector<int> (k, 0));
	    for(int i=0; i<k; i++){
	        for(int j=0; j<k; j++)
	        {
	            cin>>arr[i][j];
	        }
	    }
	    Solution obj;
    	vector<int> output = obj.mergeKArrays(arr, k);
    	printArray(output, k*k);
    	cout<<endl;
    }
	return 0;
}





  // } Driver Code Ends