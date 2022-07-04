class Solution {
public:
    int candy(vector<int>& ratings) {
        
        int n = ratings.size();
        vector<int> L2R(n);
        vector<int> R2L(n);
        vector<int> res(n);
        
        for(int i = 0; i < n; i++) // allocating 1 candy to each child
            L2R[i] = R2L[i] = 1;
        
        for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i - 1]) 
                L2R[i] =  L2R[i - 1] + 1;
        }
        
        for(int i = n - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) 
                R2L[i] =  R2L[i + 1] + 1;
        }
        
        for(int i = 0; i < n; i++) {
            res[i] = max(L2R[i], R2L[i]); 
        }
        
        return accumulate(res.begin(), res.end(), 0);
    }
};