class Solution
{
public:
    struct TrieNode
    {
        vector<TrieNode *> child{vector<TrieNode *>(26, nullptr)};
        ;
        string *word{};
    };
    void insert(TrieNode *root, string &word)
    {
        for (char ch : word)
        {
            if (root->child[ch - 'a'] == nullptr)
                root->child[ch - 'a'] = new TrieNode();
            root = root->child[ch - 'a'];
        }
        root->word = &word;
    }
    void dfs(TrieNode *root, int limit, vector<string> &result)
    {
        if (root == nullptr)
            return;
        if (result.size() == limit)
            return;
        if (root->word != nullptr)
            result.push_back(*root->word);
        for (int i = 0; i < 26; ++i)
            dfs(root->child[i], limit, result);
    }
    vector<string> getWords(TrieNode *root, int limit)
    {
        vector<string> result;
        dfs(root, limit, result);
        return result;
    }

    vector<vector<string>> suggestedProducts(vector<string> &products, string searchWord)
    {
        TrieNode *root = new TrieNode();
        for (string &product : products)
            insert(root, product);

        vector<vector<string>> ans;
        TrieNode *curr = root;
        for (char &ch : searchWord)
        {
            if (curr != nullptr && curr->child[ch - 'a'] != nullptr)
            {
                curr = curr->child[ch - 'a'];
                ans.push_back(getWords(curr, 3));
            }
            else
            {
                curr = nullptr;
                ans.emplace_back();
            }
        }
        return ans;
    }
};

// class Solution {
// public:
//     vector<vector<string>> suggestedProducts(vector<string>& products, string searchWord) 
//     {
//         vector<vector<string>> res;
//         sort(products.begin(), products.end()); // sort the list lexicographically
//         int low = 0, high = products.size() - 1;
        
//         for(int i = 0; i < searchWord.size(); i++)
//         {
//             char c = searchWord[i];
//             // pointer and string size and character macthing condistions
//             while(low <= high && (products[low].size() <= i || products[low][i] != c)) 
//                 low++;
//             while(low <= high && (products[high].size() <= i || products[high][i] != c))
//                 high--;
            
//             vector<string> temp;
//             int rem = high - low + 1;
            
//             for(int j = 0; j < min(rem, 3); j++) // we take the limit as min of 3 and remain window
//             {
//                 temp.push_back(products[low + j]);
//             }
            
//             res.push_back(temp);
//         }
        
//         return res;
//     }
// };