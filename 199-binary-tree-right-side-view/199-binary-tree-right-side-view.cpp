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
    
    void recur(TreeNode* root, int level, vector<int> &ds) {
        if(root == NULL)
            return;
        
        // if level is same as ds container size then we can say that its the first time we are                          ecountering this node
        
        if(level == ds.size()) 
            ds.push_back(root->val);
        
        recur(root->right, level+1, ds);
        recur(root->left, level+1, ds);
    }
    
    vector<int> rightSideView(TreeNode* root) {
        vector<int> ds;
        if(root == NULL) return ds;
        ds.push_back(root->val);
        recur(root, 0, ds);
        return ds;
    }
};