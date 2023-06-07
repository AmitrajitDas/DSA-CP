class Solution {
public:
    int minFlips(int a, int b, int c) {
        int res = ((a | b) ^ c); // flips
        // if both bits are 1 in a and b then a & b
        int res1 = a & b;
        int res2 = res & res1; // yields extra counting bit
        // __builtin_popcount returns count of set bits
        return __builtin_popcount(res) + __builtin_popcount(res2);
    }
};