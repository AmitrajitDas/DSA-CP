class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {
        
        sort(people.begin(), people.end());
        int i = 0, j  = people.size() - 1;
        int sum = 0, count = 0;
        
        while(i <= j)
        {
            sum = people[i] + people[j];
            
            if(sum <= limit)
            {
                count++;
                i++;
                j--;
            } else {
                
                count++;
                j--;
            }
        }
        
        return count;
    }
};