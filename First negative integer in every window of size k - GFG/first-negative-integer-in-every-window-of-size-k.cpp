// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

vector<long long> printFirstNegativeInteger(long long int arr[],
                                             long long int n, long long int k);

// Driver program to test above functions
int main() {
    long long int t, i;
    cin >> t;
    while (t--) {
        long long int n;
        cin >> n;
        long long int arr[n];
        for (i = 0; i < n; i++) {
            cin >> arr[i];
        }
        long long int k;
        cin >> k;

        vector<long long> ans = printFirstNegativeInteger(arr, n, k);
        for (auto it : ans) cout << it << " ";
        cout << endl;
    }
    return 0;
}
// } Driver Code Ends


vector<long long> printFirstNegativeInteger(long long int A[], long long int N, long long int K) {
    
    vector<long long> res;
    list<long long> list;
    long long i = 0, j = 0;
    
    while(j < N) {
        if(A[j] < 0) list.push_back(A[j]); // storing the negs
        if(j - i + 1 < K) j++;
        else if(j - i + 1 == K) {
            if(list.size() == 0) res.push_back(0); // if neg list is empty we add 0 in result
            else {
                res.push_back(list.front()); // we push the front neg from the list to result
                if(A[i] == list.front()) list.pop_front(); // if front neg matches start of window then we pop it from list
            }
            i++;
            j++;
        }
    }
    
    return res;
 }