class Solution {
private:
    void reverse(vector<int>& nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
public:
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        k %= n; // handling out of bound exception when k > n
        reverse(nums, 0, n - 1); // reversing the whole array
        reverse(nums, 0, k - 1); // reversing that array upto kth index
        reverse(nums, k, n - 1); // reversing that array from kth + 1 index upto the end
    }
};