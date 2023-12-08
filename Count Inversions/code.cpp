// Function to merge two halves of the array and count inversions
int merge(vector<int>& a, int low, int mid, int high) {
    vector<int> temp; // Temporary vector to store merged result
    int count = 0;    // Count of inversions

    int left = low, right = mid + 1;

    // Merge elements from the two halves in sorted order
    while (left <= mid && right <= high) {
        if (a[left] <= a[right]) {
            temp.push_back(a[left++]);
        } else {
            // If an element in the left array is greater than an element
            // in the right array, it means there are inversions.
            // Count the inversions and add the smaller element to temp.
            count += (mid - left + 1);
            temp.push_back(a[right++]);
        }
    }

    // Add remaining elements from the left array, if any
    while (left <= mid) {
        temp.push_back(a[left++]);
    }

    // Add remaining elements from the right array, if any
    while (right <= high) {
        temp.push_back(a[right++]);
    }

    // Copy merged elements back to the original array
    for (int i = low; i <= high; i++) {
        a[i] = temp[i - low];
    }

    // Return the count of inversions in this merge step
    return count;
}

// Function to perform merge sort and count inversions
int mergeSort(vector<int>& a, int low, int high) {
    int count = 0; // Count of inversions

    // Base case: If the array has one or zero elements, it is already sorted
    if (low >= high) {
        return count;
    }

    // Calculate the middle index
    int mid = (low + high) / 2;

    // Recursively sort the left and right halves and count inversions
    count += mergeSort(a, low, mid);
    count += mergeSort(a, mid + 1, high);

    // Merge the two sorted halves and count inversions in the merging step
    count += merge(a, low, mid, high);

    // Return the total count of inversions for the entire array
    return count;
}

// Function to calculate the number of inversions in an array
int numberOfInversions(vector<int>& a, int n) {
    // Call the mergeSort function to perform the sorting and count inversions
    return mergeSort(a, 0, n - 1);
}
