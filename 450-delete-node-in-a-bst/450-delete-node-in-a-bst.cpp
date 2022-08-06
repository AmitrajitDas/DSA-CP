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
    
    TreeNode* getLastRight(TreeNode* root) {
        if(!root->right) return root;
        return getLastRight(root->right);
    }
    
    TreeNode* attachNode(TreeNode* root) {
        if(!root->left) return root->right;
        else if(!root->right) return root->left;
        
        TreeNode* rightChild = root->right;
        TreeNode* lastRight = getLastRight(root->left);
        lastRight->right = rightChild;
        return root->left;
    }
    
    TreeNode* deleteNode(TreeNode* root, int key) {
        if(root == NULL) return NULL;
        if(root->val == key) return attachNode(root);
        TreeNode* curr = root;
        
        while(curr) {
            if(key < curr->val) {
                if(curr->left && curr->left->val == key) {
                    curr->left = attachNode(curr->left);
                } else curr = curr->left;
                
            } else {
                if(curr->right && curr->right->val == key) {
                    curr->right = attachNode(curr->right);
                } else curr = curr->right;
            }
        }
        
        return root;
    }
};