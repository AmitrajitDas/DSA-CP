class Solution {
    public int integerReplacement(int n) {
        long num = n; //overflow avoid to safe
        int steps = 0;
        
        while(num != 1) {
            if ((num & 1) == 0) {
                num >>= 1; //even number
            } else {
               //odd number
                if (num == 3 || (num & 3) == 1) {
                    num--;
                } else {
                    num++; 
                }
            }
                steps++;
        }

        return steps;
    }
}