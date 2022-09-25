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
    int dfs(TreeNode* root, int val, int &len) {
        if(!root) return 0;
        
        int left = dfs(root->left, root->val, len);
        int right = dfs(root->right, root->val, len);
        
        len = max(left + right, len);
        if(root->val == val) return max(left, right) + 1;
        return 0;
    }
    
public:
    int longestUnivaluePath(TreeNode* root) {
        if(!root) return 0;
        int len = 0;
        dfs(root, root->val, len);
        return len;
    }
};