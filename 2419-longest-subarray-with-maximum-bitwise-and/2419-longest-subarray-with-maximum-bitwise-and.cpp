class Solution {
public:
	int longestSubarray(vector<int>& nums) {
		int maxi = INT_MIN;
		for (auto it : nums) maxi = max(it, maxi);

		int count = 0, length = 0;
		for (auto it : nums) {
			if (it == maxi) count++;
			else {
				length = max(count, length);
				count = 0;
			}
		}

		length = max(count, length);
		return length;
	}
};