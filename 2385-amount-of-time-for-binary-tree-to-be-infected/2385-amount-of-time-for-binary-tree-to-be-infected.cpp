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
private:
    unordered_map<int, vector<int>> adj;

    void buildGraph(TreeNode* root, int parent) {
        if (root == NULL) return;
        if (parent != -1) {
            adj[parent].push_back(root->val);
            adj[root->val].push_back(parent);
        }
        buildGraph(root->left, root->val);
        buildGraph(root->right, root->val);
    }

public:
    int amountOfTime(TreeNode* root, int start) {
        buildGraph(root, -1);
        queue<int> q;
        unordered_map<int, bool> vis;
        q.push(start);
        vis[start] = true;
        int time = 0;
        while (!q.empty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int node = q.front();
                q.pop();
                for (auto it : adj[node]) {
                    if (!vis[it]) {
                        q.push(it);
                        vis[it] = true;
                    }
                }
            }
            time++;
        }

        return time - 1; // Subtract 1 from time as we need to exclude the initial infected node
    }
};
