//// O(N) ////

class Solution {
public:
    int totalMoney(int n) {
        int res = 0;
        int weeks = n / 7;  // No. of full weeks
        // first week  1 2 3 4 5 6 7 (sum is 28 i.e. 7*(i+3) if i=1)
        // second week  2 3 4 5 6 7 8 (sum is 35 i.e. 7*(i+3) if i=2)

        for(int i = 1; i <= weeks; i++) res += 7 * (i + 3);
        
        //Calculating remaining days
        for(int i = 7 * weeks; i < n; i++) res += ++weeks;
        return res;
    }
};

//// O(1) ////

// class Solution {
// public:
//     int totalMoney(int n) {
//         int week_count = n / 7;
//         int remaining_days = n % 7;
        
//         int total = ((week_count * (week_count - 1)) / 2) * 7; // Contribution from complete weeks
//         total += week_count * 28; // Contribution from complete weeks (additional on Mondays)
//         total += ((remaining_days * (remaining_days + 1)) / 2) + (week_count * remaining_days); // Contribution from remaining days
        
//         return total;
//     }
// };