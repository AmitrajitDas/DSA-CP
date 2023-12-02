class Solution {
public:
    int MOD = 1e9 + 7;
    int numberOfWays(string corridor) {
        int n = corridor.size();
        
        // If there's only one seat or no seat, return 0 ways
        if (n == 1 || corridor.find('S') == string::npos) return 0;

        // Vector to store the positions of seats ('S') in the corridor
        vector<int> seatArr;
        for (int i = 0; i < n; i++) {
            if (corridor[i] == 'S') {
                seatArr.push_back(i);
            }
        }

        // If the number of seats is odd or there are no seats, return 0 ways
        if (seatArr.size() % 2 != 0 || seatArr.size() == 0) return 0;

        // Initialize variables to keep track of previous end index and result
        int end_idx_prev = seatArr[1];
        long long res = 1;

        // Loop through seat positions, calculating the number of ways
        for (int i = 2; i < seatArr.size(); i += 2) {
            // Calculate the length between two consecutive seat positions
            int len = seatArr[i] - end_idx_prev;
            res = (res * len) % MOD;
            // Update the previous end index to the next seat's end index
            end_idx_prev = seatArr[i + 1];
        }
        return res;
    }
};
