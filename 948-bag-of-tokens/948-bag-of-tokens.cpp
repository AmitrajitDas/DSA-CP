class Solution {
public:
    int bagOfTokensScore(vector<int>& tokens, int power) {
        sort(tokens.begin(), tokens.end());
        int start = 0, end = tokens.size() - 1;
        int score = 0, maxScore = 0;
        
        while(start <= end) {
            if(power >= tokens[start]) {
                power -= tokens[start++];
                score++;
            } else if(score > 0) {
                power += tokens[end--];
                score--;
                
            } else break;
            
            maxScore = max(score, maxScore);
        }
        
        return maxScore;
    }
};