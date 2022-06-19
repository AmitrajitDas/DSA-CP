class Solution {
public:
    vector<vector<string>> suggestedProducts(vector<string>& products, string searchWord) 
    {
        vector<vector<string>> res;
        sort(products.begin(), products.end()); // sort the list lexicographically
        int low = 0, high = products.size() - 1;
        
        for(int i = 0; i < searchWord.size(); i++)
        {
            char c = searchWord[i];
            // pointer and string size and character macthing condistions
            while(low <= high && (products[low].size() <= i || products[low][i] != c)) 
                low++;
            while(low <= high && (products[high].size() <= i || products[high][i] != c))
                high--;
            
            vector<string> temp;
            int rem = high - low + 1;
            
            for(int j = 0; j < min(rem, 3); j++) // we take the limit as min of 3 and remain window
            {
                temp.push_back(products[low + j]);
            }
            
            res.push_back(temp);
        }
        
        return res;
    }
};