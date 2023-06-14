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
    int diff = INT_MAX;
    TreeNode *prev = NULL;
    int getMinimumDifference(TreeNode *root) {
        if (root->left) getMinimumDifference(root->left);
        // if we find at least a node before, we update diff
        if (prev) diff = min(diff, abs(prev->val - root->val));
        prev = root;
        if (root->right) getMinimumDifference(root->right);
        return diff;
    }
};