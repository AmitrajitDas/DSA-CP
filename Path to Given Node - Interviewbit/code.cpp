/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

bool getPath(TreeNode *root, vector<int> &ds, int node) {

    if(!root) return false;
    ds.push_back(root->val);
    if(root->val == node) return true;
    if(getPath(root->left, ds, node) || getPath(root->right, ds, node)) return true;
    ds.pop_back();
    return false;

}

vector<int> Solution::solve(TreeNode* A, int B) {
    vector<int> ds;
    if(A == NULL) return ds;
    getPath(A, ds, B);
    return ds;
}
