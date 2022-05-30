#include <bits/stdc++.h>

using namespace std;

class Solution{
public:
    int *findTwoElement(int *arr, int n) {
        
        int xorVar = arr[0];
        
        int *res = new int[2];
        
        int x, y;
        
        for(int i = 1; i < n; i++) xorVar ^= arr[i];
        
        for(int i = 1; i <= n; i++) xorVar ^= i;

        int rmsBit = xorVar & ~(xorVar - 1);
        
        for(int i = 0; i < n; i++) {
            if(arr[i] & rmsBit) x ^= arr[i]; // belongs to 1st set
            else y ^= arr[i]; // belongs to 2nd set
        }
        
        for(int i = 1; i <= n; i++) {
            if(i & rmsBit) x ^= i; // belongs to 1st set
            else y ^= i; // belongs to 2nd set
        }
        
        res[0] = x;
        res[1] = y;
        
        return res;
    }
};


int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int a[n];
        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }
        Solution ob;
        auto ans = ob.findTwoElement(a, n);
        cout << ans[0] << " " << ans[1] << "\n";
    }
    return 0;
}
