/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
private:
    bool isPalindrome(unordered_map<int, int> &map) {
        int odd = 0;
        
        for(auto it : map) {
            if(it.second % 2) odd++;
            if(odd > 1) return false; // odd-palindromes always has odd numbers of count 1
        }
        
        return true;
    }
    
    void dfs(TreeNode* root, unordered_map<int, int> &map, int &res) {
        if(!root) return;
        map[root->val]++;
        
        if(!root->left && !root->right) {
            if(isPalindrome(map)) res++;
        }
        
        dfs(root->left, map, res);
        dfs(root->right, map, res);
        map[root->val]--; // backtrack to remove path trace
    }

public:
    int pseudoPalindromicPaths (TreeNode* root) {
        unordered_map<int, int> map;
        int res = 0;
        dfs(root, map, res);
        return res;
    }
};