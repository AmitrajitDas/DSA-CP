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
    void dfs(TreeNode* root, int val, int currDepth, int depth) {   
        if(!root) return;
        
        if(currDepth < depth - 1) {
            dfs(root->left, val, currDepth++, depth);
            dfs(root->right, val, currDepth++, depth);
        } else {
            TreeNode *tmp = root->left;
            root->left = new TreeNode(val);
            root->left->left = tmp;
            tmp = root->right;
            root->right = new TreeNode(val);
            root->right->right = tmp;
        }
    }
        
public:
    TreeNode* addOneRow(TreeNode* root, int val, int depth) {
        if (depth == 1) {
            TreeNode *newroot = new TreeNode(val);
            newroot->left = root;
            return newroot;
        }
        
        queue<TreeNode*> q;
        q.push(root);
        int currDepth = 0;
        
        while(!q.empty()) {
            
            currDepth++;
            int n = q.size(); 
            while(n--) {
                TreeNode *currNode = q.front();
                q.pop();
                
                if(currDepth != depth - 1) {
                    if(currNode->left) q.push(currNode->left);
                    if(currNode->right) q.push(currNode->right);
                } else {
                    TreeNode* newNode = new TreeNode(val);
                    newNode->left = currNode->left;
                    currNode->left = newNode;
                    TreeNode* newNode2 = new TreeNode(val);
                    newNode2->right = currNode->right;
                    currNode->right = newNode2;
                }
            } 
        }
        
        return root;
    }
};