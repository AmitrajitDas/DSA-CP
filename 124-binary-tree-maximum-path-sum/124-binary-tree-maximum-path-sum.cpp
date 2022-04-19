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
    
    int maxPath(TreeNode* root, int &maxSum) {
        
        if(root == NULL) return 0;
        
        // max is used to return only +ve values from the noes ie -ve nodes will be stored as 0 
        int leftSum = max(0, maxPath(root->left, maxSum));
        int rightSum = max(0, maxPath(root->right, maxSum));
        
        maxSum = max(maxSum, (root->val + leftSum + rightSum));
        
        return root->val + max(leftSum, rightSum);
    }
    
    int maxPathSum(TreeNode* root) {
        
        int maxSum = INT_MIN;
        maxPath(root, maxSum);
        return maxSum;
    }
};