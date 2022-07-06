class Solution {
public:
    int minMovesToMakePalindrome(string s) {
        
        int low = 0, high = s.size() - 1, mid = s.size()/2;
        
        int count = 0;
        int center = -1;
        
        while(low < high) {
            
            if(s[low] == s[high]) {
                low++;
                high--;
                continue;
            } 
            
            int k;
            for(k = low + 1; k < high; k++) {
                if(s[k] == s[high]) break;
            }
            
            if(k == high) {
                center = high;
                high--;
                continue;
            }
            
            for(int j = k; j > low; j--) {
                swap(s[j], s[j - 1]);
                count++;
            }
            
            low++;
            high--;
        }
        
        if(center != -1) {
            count += center - mid;
        }
        
        return count;
    }
};