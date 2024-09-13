class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        
        // Step 1: Create a prefix XOR array to store XOR from the start to each index
        // Fixed: Initialize the prefixXor array with the same size as arr
        int[] prefixXor = new int[n];  
        
        // Step 2: Initialize the first element of prefixXor to the first element of arr
        prefixXor[0] = arr[0];

        // Step 3: Fill the prefixXor array
        // Each element in prefixXor[i] will store the XOR of arr[0] to arr[i]
        for (int i = 1; i < n; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ arr[i];  // XOR current element with previous prefix XOR
        }

        // Step 4: Prepare to store the results of each query
        int[] res = new int[queries.length];

        // Step 5: Process each query in the queries array
        // For each query, we get the XOR of the subarray from index left to right
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0], right = queries[i][1];

            // Step 6: Calculate the XOR for the range [left, right]
            // If left is 0, simply take prefixXor[right], as we want XOR from the beginning
            // Otherwise, XOR prefixXor[right] with prefixXor[left - 1] to get the range XOR
            res[i] = prefixXor[right] ^ (left == 0 ? 0 : prefixXor[left - 1]);
        }

        // Step 7: Return the results as an array
        return res;
    }
}