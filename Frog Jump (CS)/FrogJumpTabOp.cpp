// tabulation and space optimized

int frogJump(int n, vector<int> &heights)
{
    int prev = 0, prev2 = 0;
    
    for(int i = 1; i < n; i++) {
        int jumpone = prev + abs(heights[i] - heights[i-1]);
        int jumptwo = INT_MAX;
        if(i > 1)
        	jumptwo = prev2 + abs(heights[i] - heights[i-2]);
        int curr = min(jumpone, jumptwo);
        prev2 = prev;
        prev = curr;
    }
    
    return prev;
}

    
    
