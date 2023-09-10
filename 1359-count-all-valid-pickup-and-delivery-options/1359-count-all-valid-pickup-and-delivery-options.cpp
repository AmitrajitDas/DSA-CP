class Solution {
    typedef long long ll;
    int MOD = 1e9 + 7;

public:
    int countOrders(int n) {
        if (n == 1) return n; // If n is 1, there is only one order possible.

        ll res = 1;

        for (int i = 2; i <= n; i++) {
            int spaces = (i - 1) * 2 + 1; // Calculate the number of spaces in the order.
            int currPoss = spaces * (spaces + 1) / 2; // Calculate the current number of possibilities.
            res *= currPoss; // Multiply the result by the current possibilities.
            res %= MOD;
        }

        return res;
    }
};
