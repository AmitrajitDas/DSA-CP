class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int slow = nums[0], fast = nums[0];

        // Move 'slow' one step and 'fast' two steps at a time until they meet in a cycle.
        slow = nums[slow];  // Move 'slow' one step.
        fast = nums[nums[fast]];  // Move 'fast' two steps.

        // Continue moving the pointers until they meet at the start of the cycle.
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // Reset 'slow' to the beginning and move both 'slow' and 'fast' one step at a time
        // until they meet at the entrance of the cycle, which is the duplicate element.
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        // Return the duplicate element found at the entrance of the cycle.
        return fast;
    }
};
