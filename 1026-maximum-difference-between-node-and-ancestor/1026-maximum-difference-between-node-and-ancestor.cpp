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
    int dfs(TreeNode *root, int mini, int maxi) {
        if(!root) return maxi - mini;
        mini = min(root->val, mini);
        maxi = max(root->val, maxi);
        return max(dfs(root->left, mini, maxi), dfs(root->right, mini, maxi)); 
    }
public:
    int maxAncestorDiff(TreeNode* root) {
        return dfs(root, INT_MAX, INT_MIN);
    }
};