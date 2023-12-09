// Function to find the floor of x in a sorted array a of size n
int getFloor(vector<int> &a, int n, int x) {
    int low = 0, high = n - 1, res = -1;

    // Binary search to find the largest element smaller than or equal to x
    while (low <= high) {
        int mid = low + (high - low) / 2;

        // If the middle element is less than or equal to x, update the result and search in the right half
        if (a[mid] <= x) {
            res = a[mid];
            low = mid + 1;
        } else {
            // If the middle element is greater than x, search in the left half
            high = mid - 1;
        }
    }

    // Return the floor value
    return res;
}

// Function to find the ceil of x in a sorted array a of size n
int getCeil(vector<int> &a, int n, int x) {
    int low = 0, high = n - 1, res = -1;

    // Binary search to find the smallest element greater than or equal to x
    while (low <= high) {
        int mid = low + (high - low) / 2;

        // If the middle element is greater than or equal to x, update the result and search in the left half
        if (a[mid] >= x) {
            res = a[mid];
            high = mid - 1;
        } else {
            // If the middle element is less than x, search in the right half
            low = mid + 1;
        }
    }

    // Return the ceil value
    return res;
}

// Function to get both the floor and ceil of x in a sorted array a of size n
pair<int, int> getFloorAndCeil(vector<int> &a, int n, int x) {
    // Find the floor and ceil using the previously defined functions
    int floor = getFloor(a, n, x);
    int ceil = getCeil(a, n, x);

    // Return a pair containing the floor and ceil values
    return make_pair(floor, ceil);
}
