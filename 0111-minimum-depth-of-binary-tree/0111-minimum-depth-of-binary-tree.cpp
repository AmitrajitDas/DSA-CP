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
    int minDepth(TreeNode* root) {
        if (root == NULL) return 0;
        queue<TreeNode*> q;
        q.push(root);
        int depth = 0;
        while (!q.empty()) {
            depth++;
            int k = q.size();
            for (int i = 0; i < k; i++) {
                TreeNode* currNode = q.front();
                if (currNode->left) q.push(currNode->left);
                if (currNode->right) q.push(currNode->right);
                q.pop();
                if (!currNode->left && !currNode->right) return depth;
            }
        }
        return -1;
    }
};