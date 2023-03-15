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
    bool isCompleteTree(TreeNode* root) {
        if(!root) return true;
        queue<TreeNode*> q({root});
        while(q.front()) {
           TreeNode *curr = q.front();
           q.pop();
           q.push(curr->left);
           q.push(curr->right);
        }
        while(!q.empty() && !q.front()) q.pop(); // this ensures null node will be at end  
        return q.empty();
    }
};