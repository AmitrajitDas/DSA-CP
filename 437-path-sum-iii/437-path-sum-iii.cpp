/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),  qright(right) {}
 * };
 */
class Solution {
private:
    void pathSum(TreeNode* root, long long sum, int &count, int targetSum) {
        if (!root) return;
        
        if(root->val + sum == targetSum) count++;
        
        pathSum(root->left, sum + root->val, count, targetSum);
        pathSum(root->right, sum + root->val, count, targetSum);
    }
    
	void preorder(TreeNode* root, int &count, int targetSum) {
		if (!root) return;
        
        pathSum(root, 0, count, targetSum);
        
        preorder(root->left, count, targetSum);
        preorder(root->right, count, targetSum);
		
	}

public:
	int pathSum(TreeNode* root, int targetSum) {
		int count = 0;
		preorder(root, count, targetSum);
		return count;
	}
};