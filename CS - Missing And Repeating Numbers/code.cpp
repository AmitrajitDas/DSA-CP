vector<int> findMissingRepeatingNumbers(std::vector<int>& a) {
    int n = a.size();
    int xr = 0;

    // Step 1: Calculate the XOR of all elements in the array and XOR with expected values.
    for (int i = 0; i < n; i++) {
        xr ^= a[i];         // XOR of all elements in 'a'
        xr ^= (i + 1);      // XOR with expected values from 1 to n
    }

    // Step 2: Find the rightmost set bit (the bit that differs between the missing and repeated numbers).
    int num = (xr & ~(xr - 1)); 

    int zero = 0, one = 0;
    for (int i = 0; i < n; i++) {
        // Step 3: Separate numbers into two groups based on the rightmost set bit.
        if ((a[i] & num) != 0)
            one ^= a[i];     // XOR of numbers with that bit set
        else
            zero ^= a[i];    // XOR of numbers with that bit not set
    }

    for (int i = 1; i <= n; i++) {
        // XOR expected values into two groups similarly.
        if ((i & num) != 0)
            one ^= i;         // XOR of expected values with that bit set
        else
            zero ^= i;        // XOR of expected values with that bit not set
    }

    int count = 0;
    for (int i = 0; i < n; i++) {
        // Step 4: Count occurrences of the 'zero' value in the input array.
        if (a[i] == zero) count++;
    }

    // Step 5: Determine if 'zero' or 'one' should be the repeated and missing numbers.
    if (count == 2) return {zero, one}; // If count is 2, 'zero' is the missing, and 'one' is repeated.
    return {one, zero}; // Otherwise, 'one' is the missing, and 'zero' is repeated.
}
