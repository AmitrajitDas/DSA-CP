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
    int widthOfBinaryTree(TreeNode* root) {
        if(!root) return 0;
        int res = INT_MIN;
        queue<pair<TreeNode*, int>> q;
        q.push({root, 0});
        while(!q.empty()) {
            int size = q.size();
            int minIdx = q.front().second;
            int first, last;
            for(int i = 0; i < size; i++) {
                TreeNode *node = q.front().first;
                int currIdx = q.front().second - minIdx;
                q.pop();
                
                if(i == 0) first = currIdx;
                if(i == size - 1) last = currIdx;
                if(node->left) q.push({node->left, (long long)currIdx*2+1});
                if(node->right) q.push({node->right, (long long)currIdx*2+2});
            }
            
            res = max(res, last-first+1);
        }
        
        return res;
    }
};