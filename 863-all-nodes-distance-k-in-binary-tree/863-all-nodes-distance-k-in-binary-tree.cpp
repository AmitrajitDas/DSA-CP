/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    
    void setParent(TreeNode* root, unordered_map<TreeNode*, TreeNode*> &parent) {
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()) {
            TreeNode* curr = q.front();
            q.pop();
            
            if(curr->left) {
                q.push(curr->left);
                parent[curr->left] = curr;
            }
            
            if(curr->right) {
                q.push(curr->right);
                parent[curr->right] = curr;
            }
        }
    }
    
    vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
        unordered_map<TreeNode*, TreeNode*> parent;
        unordered_map<TreeNode*, bool> vis;
        vector<int> res;
        setParent(root, parent);
        queue<TreeNode*> q;
        q.push(target);
        vis[target] = true;
        int dis = 0;
        while(!q.empty()) {
            int size = q.size();
            if(dis++ == k) break;
            for(int i = 0; i < size; i++) {
                TreeNode *curr = q.front();
                q.pop();
                
                if(curr->left && !vis[curr->left]) {
                    q.push(curr->left);
                    vis[parent[curr->left]] = true;
                }
                
                if(curr->right && !vis[curr->right]) {
                    q.push(curr->right);
                    vis[parent[curr->right]] = true;
                }
                
                if(parent[curr] && !vis[parent[curr]]) {
                    q.push(parent[curr]);
                    vis[parent[curr]] = true;
                }
            }
        }
        
        while(!q.empty()) {
            TreeNode *tmp = q.front();
            q.pop();
            res.push_back(tmp->val);
        }
        
        return res;
    }
};