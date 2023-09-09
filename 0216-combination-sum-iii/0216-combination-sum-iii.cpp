class Solution {
    vector<vector<int>> res; // Store the final combinations.
    vector<int> arr; // Store the current combination being constructed.

private:
    void backtrack(int k, int n) {
        // If 'n' becomes 0 and 'arr' has exactly 'k' elements, it's a valid combination.
        if (n == 0 && arr.size() == k) {
            res.push_back(arr);
            return;
        }

        // If 'arr' has less than 'k' elements, continue constructing the combination.
        if (arr.size() < k) {
            // Start from the next number, and try all possible numbers from 1 to 9.
            for (int i = arr.empty() ? 1 : arr.back() + 1; i <= 9; i++) {
                // If removing 'i' from 'n' would result in a negative value, break.
                if (n - i < 0) break;
                arr.push_back(i);
                backtrack(k, n - i);
                arr.pop_back();
            }
        }
    }

public:
    vector<vector<int>> combinationSum3(int k, int n) {
        backtrack(k, n);
        return res;
    }
};
