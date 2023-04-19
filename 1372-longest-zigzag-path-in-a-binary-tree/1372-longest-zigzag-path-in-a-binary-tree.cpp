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
    int maxPath = 0;
private:
    /* Here left = 0 means the path is coming from right side
    and right = 0 signifies the path is coming from left
    */
    void dfs(TreeNode* root, int left, int right) {
        if(!root) return;
        maxPath = max({maxPath, left, right});
        dfs(root->left, right + 1, 0);
        dfs(root->right, 0, left + 1);
    }
public:
    int longestZigZag(TreeNode* root) {
        dfs(root, 0, 0);
        return maxPath;
    }
};