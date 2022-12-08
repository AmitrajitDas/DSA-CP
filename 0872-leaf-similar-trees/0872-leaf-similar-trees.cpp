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
    void dfs(TreeNode *root, vector<int> &arr) {
        if(!root) return;
        if(!root->left && !root->right) arr.push_back(root->val);
        dfs(root->left, arr);
        dfs(root->right, arr);
    }
public:
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        vector<int> arr1;
        vector<int> arr2;
        dfs(root1, arr1);
        dfs(root2, arr2);

        return arr1 == arr2;
    }
};