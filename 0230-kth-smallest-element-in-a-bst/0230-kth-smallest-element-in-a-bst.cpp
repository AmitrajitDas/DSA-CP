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
    void inOrder(TreeNode *root, vector<int> &arr) {
        if(!root) return;
        
        inOrder(root->left, arr);
        arr.push_back(root->val);
        inOrder(root->right, arr);
    }
public:
    int kthSmallest(TreeNode* root, int k) {
        vector<int> arr; // array to store the node values
        inOrder(root, arr); // as inOrder traversal in a BST yields the nodes in sorted order
        return arr[k - 1];
    }
};