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
    
    TreeNode* buildTree(map<int, int> &inMap, vector<int>& preorder, int preStart, int preEnd, vector<int>& inorder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) return NULL;
        
        TreeNode* root = new TreeNode(preorder[preStart]);
        int inRoot = inMap[root->val];
        int numsLeft = inRoot - inStart;
        
        root->left = buildTree(inMap, preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1);
        root->right = buildTree(inMap, preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd);
        
        return root;
    }
    
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        map<int, int> inMap;
        
        for(int i = 0; i < inorder.size(); i++) inMap[inorder[i]] = i; // hashing inorder array
        
        TreeNode* root = buildTree(inMap, preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1);
        
        return root;
    }
};
