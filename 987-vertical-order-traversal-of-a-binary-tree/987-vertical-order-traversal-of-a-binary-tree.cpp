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
    vector<vector<int>> verticalTraversal(TreeNode* root) {
        map<int, map<int, multiset<int>>> nodes;
        queue<pair<TreeNode*, pair<int, int>>> q;
        q.push({root, {0, 0}});
        while(!q.empty()) {
            auto p = q.front();
            TreeNode* node = p.first;
            int v = p.second.first, l =  p.second.second;
            q.pop();
            nodes[v][l].insert(node->val);
            if(node->left)
                q.push({node->left, {v - 1,  l + 1}});
            if(node->right)
                q.push({node->right, {v + 1, l + 1}});
        }
        
        vector<vector<int>> res;
        for(auto node : nodes) {
            vector<int> col;
            for(auto n : node.second)
                col.insert(col.end(), n.second.begin(), n.second.end());
            res.push_back(col);
        }
        
        return res;
    }
};