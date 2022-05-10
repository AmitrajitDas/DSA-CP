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
    
    TreeNode* solve(vector<int>& preorder, int preStart, int preEnd, vector<int>& inorder, int inStart,                           int inEnd, unordered_map<int, int> &map) {
        
        if(preStart > preEnd || inStart > inEnd) return NULL;
        
        TreeNode* root = new TreeNode(preorder[preStart]);
        int inRoot = map[root->val];
        int numsLeft = inRoot - inStart;
        
        root->left = solve(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, map);
        root->right = solve(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, map);
        
        return root;
    }
    
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        unordered_map<int, int> map;
        
        for(int i = 0; i < inorder.size(); i++) map[inorder[i]] = i;
        
        TreeNode* root = solve(preorder, 0, preorder.size() - 1, inorder, 0 , inorder.size() - 1, map);
        
        return root;
    }
};