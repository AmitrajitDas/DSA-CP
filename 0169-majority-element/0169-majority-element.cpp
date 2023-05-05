// TC: O(N), SC: O(1)

class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int n = nums.size();
        int count = 0;
        int el;

        //applying the moore's voting algo
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                count = 1;
                el = nums[i];
            }
            else if (el == nums[i]) count++;
            else count--;
        }

        /* Only applicable if majority elemen'ts existence is not fixed
        //checking if the stored element
        // is the majority element:
        int count1 = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] == el) count1++;
        }

        if (count1 > (n / 2)) return el; */

        return el;
    }
};