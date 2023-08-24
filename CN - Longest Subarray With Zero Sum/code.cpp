int getLongestZeroSumSubarrayLength(vector<int> &arr){
    unordered_map<int, int> mp;
    int sum = 0, count = 0;

    for(int i = 0; i < arr.size(); i++) {
        sum += arr[i];  // Update the current sum by adding the current element
        
        if(sum == 0) {
            count++;  // If the current sum is zero, increment the count
        } else {
            if(mp.find(sum) != mp.end()) {
                // If the current sum was encountered before, update the count
                count = max(count, i - mp[sum]);
            } else {
                mp[sum] = i;  // Otherwise, store the index of the current sum
            }
        }
    }

    return count;  // Return the maximum count of zero-sum subarray
}
