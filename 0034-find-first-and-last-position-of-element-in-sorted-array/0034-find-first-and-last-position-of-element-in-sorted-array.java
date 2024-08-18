class Solution {
    private int findFirst(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int idx = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] >= x) {
                high = mid - 1;
                if(arr[mid] == x) {
                    idx = mid;
                }
            } else {
                low = mid + 1;
            }
        }

        return idx;
    }

    private int findLast(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int idx = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] <= x) {
                low = mid + 1;
                if(arr[mid] == x) {
                    idx = mid;
                }
            } else {
                high = mid - 1;
            }
        }

        return idx;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];

        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);

        return res;
    }
}