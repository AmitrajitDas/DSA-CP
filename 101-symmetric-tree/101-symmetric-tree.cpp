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
    bool checkSymmetry(TreeNode* left, TreeNode* right) {
        
         // if both any node is null then we'll return true only if the other one is also null
        if(left == NULL || right == NULL) return left == right; 
        
        // if both mirror nodes doesn't match we return false
        if(left->val != right->val) return false;
        
        // like this we'll check symmetry for all the mirrored nodes 
        return  checkSymmetry(left->left, right->right) 
                && 
                checkSymmetry(left->right, right->left);
    }
    
    bool isSymmetric(TreeNode* root) {
        // we'll check symmetry for both left and right subtree simultaneously
        return root == NULL || checkSymmetry(root->left, root->right);
    }
};