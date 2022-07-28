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
    
    void genPath(TreeNode* root, vector<int> &ds, vector<vector<int>> &res, int targetSum) {
        if(root == NULL) return;
        ds.push_back(root->val);
        if(root->val == targetSum && root->left == NULL && root->right == NULL) {
            res.push_back(ds);
        }
        
        genPath(root->left, ds, res, targetSum - root->val);
        genPath(root->right, ds, res, targetSum - root->val);
        ds.pop_back();
    }
    
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> res;
        vector<int> ds;
        genPath(root, ds, res, targetSum);
        return res;
    }
};