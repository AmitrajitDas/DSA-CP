int unboundedKnapsack(int n, int W, vector<int>& val,vector<int>& wt) {
    
    vector<int> cur(W+1,0);
    
    //Base Condition
    
    for(int i=wt[0]; i<=W; i++){
        cur[i] = ((int)i/wt[0]) * val[0];
    }
    
    for(int ind =1; ind<n; ind++){
        for(int cap=0; cap<=W; cap++){
            
            int notTaken = cur[cap];
            
            int taken = -1e9;
            if(wt[ind] <= cap)
                taken = val[ind] + cur[cap - wt[ind]];
                
            cur[cap] = max(notTaken, taken);
        }
    }
    
    return cur[W];

}
