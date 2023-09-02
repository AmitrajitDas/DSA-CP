class Solution {
public:
    vector<int> countBits(int n) {
        vector<int> res(n + 1, 0);
        // Loop from 1 to n to calculate the number of set bits (1s) in each number
        for (int i = 1; i <= n; i++) {
            // If 'i' is odd, set the number of set bits in 'i' to 1 more than in 'i/2'
            if (i % 2 != 0) res[i] = res[i / 2] + 1; 
            // If 'i' is even, set the number of set bits in 'i' to be the same as in 'i/2'
            else res[i] = res[i / 2]; 
        }
        return res;
    }
};


// class Solution {
// public:
//     vector<int> countBits(int n) {
//     std::vector<int> res(n + 1, 0);
//     for (int i = 1; i <= n; ++i) {
//         res[i] = res[i >> 1] + (i & 1);
//     }
//     return res;
// }
// };