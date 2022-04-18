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
public:
    
    int dfs(TreeNode* root, int& diameter) {
        
        if(root == NULL) return 0;
        
        int lh = dfs(root->left, diameter);
        int rh = dfs(root->right, diameter);
        
        diameter = max(lh+rh, diameter);
        
        return 1 + max(lh, rh);
    }
    
    int diameterOfBinaryTree(TreeNode* root) {
        
        int diameter = 0;
        dfs(root, diameter);
        return diameter;
    }
};