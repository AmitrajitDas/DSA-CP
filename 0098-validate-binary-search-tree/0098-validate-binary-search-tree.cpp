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
    bool dfs(TreeNode* root, long mini, long maxi) {
        // If the current node is null, it is a valid subtree
        if (!root) {
            return true;
        }

        // Check if the current node's value is within the valid range (mini, maxi)
        if (root->val <= mini || root->val >= maxi) {
            return false;
        }

        // Recursively check the left and right subtrees
        // Update the range for the left subtree to (mini, root->val)
        // Update the range for the right subtree to (root->val, maxi)
        return dfs(root->left, mini, root->val) && dfs(root->right, root->val, maxi);
    }

public:
    bool isValidBST(TreeNode* root) {
        // Start the DFS with an initial valid range for values in the tree
        return dfs(root, LONG_MIN, LONG_MAX);
    }
};