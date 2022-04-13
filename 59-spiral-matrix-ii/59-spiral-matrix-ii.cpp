class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        
        vector<vector<int>>v(n,vector<int>(n));
        int r1 = 0, r2 = n-1;
        int c1 = 0, c2 = n-1;
        int val = 0;
        
         while(r1<=r2 && c1<=c2){
             
            for(int i=c1;i<=c2;i++)//left to right move,row is fixed
                v[r1][i] = ++val;
       
            for(int i=r1+1;i<=r2;i++) //top to bootom move ,colomn is fixed
                v[i][c2] = ++val;
       
            for(int i=c2-1;i>=c1;i--) // right to left move,row is fixed
                v[r2][i] = ++val;
        
            for(int i=r2-1;i>r1;i--) // bottom to up move ,colomn is fixed
                v[i][c1] = ++val;
        
             r1++;
             c1++;
             r2--;
             c2--;
    }
        
        return v;
        
    }
};