class Solution {
public:
    int getWinner(vector<int>& arr, int k) {
        int n = arr.size();
        int maxEle = *max_element(begin(arr), end(arr));
        if(k >= n) return maxEle; // rotates so maxEle will come atleast once on index 0
        int streak = 0, currWinner = arr[0];
        for(int i = 1; i < n; i++) {
            if(arr[i] > currWinner) {
                currWinner = arr[i];
                streak = 1;
            } else streak++;
            if(streak == k || currWinner == maxEle) return currWinner;
        }
        return currWinner;
    }
};