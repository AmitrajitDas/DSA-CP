// O(nlogn)

class Solution {
public:
    vector<int> sortByBits(vector<int>& arr) {
        auto lambda = [&](int &a, int &b) {
            int count_a = __builtin_popcount(a);
            int count_b = __builtin_popcount(b);
            if(count_a == count_b) return a < b;
            return count_a < count_b;
        };
        sort(arr.begin(), arr.end(), lambda);
        return arr;
    }
};

// O(nlogn) * log2(num)

// class Solution {
// private:
//     int countOneBits(int num) {
//         int count = 0;
//         while(num) {
//             count += (num & 1);
//             num >>= 1;
//         }
//         return count;
//     }
// public:
//     vector<int> sortByBits(vector<int>& arr) {
//         auto lambda = [&](int &a, int &b) {
//             int count_a = countOneBits(a);
//             int count_b = countOneBits(b);
//             if(count_a == count_b) return a < b;
//             return count_a < count_b;
//         };
//         sort(arr.begin(), arr.end(), lambda);
//         return arr;
//     }
// };