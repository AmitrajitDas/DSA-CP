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
    int maxLevelSum(TreeNode* root) {
        if(!root) return 0;
        queue<TreeNode*> q;
        q.push(root);
        int maxLvl = 1, maxSum = INT_MIN, lvl = 1;
        while(!q.empty()) {
            int lvlSum = 0, lvlSize = q.size();;
            for (int i = 0; i < lvlSize; i++) {
                TreeNode* node = q.front();
                q.pop();
                
                lvlSum += node->val;

                if(lvlSum)
                if(node->left) q.push(node->left);
                if(node->right) q.push(node->right);
            } 

            if(lvlSum > maxSum) {
                maxSum = lvlSum;
                maxLvl = lvl;
            }

            lvl++;
        }

        return maxLvl;
    }
};