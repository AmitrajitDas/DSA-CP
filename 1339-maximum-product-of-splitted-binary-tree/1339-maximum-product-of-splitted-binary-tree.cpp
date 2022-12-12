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
long long int res = 0, totalSum = 0, MOD = 1e9 + 7;
private:
    int find(TreeNode *root) {
        if(!root) return 0;
        long long int sum = find(root->left) + find(root->right) + root->val; // sum of a subtree
        res = max((totalSum - sum) * sum, res); // max product
        return sum;
    }
public:
    int maxProduct(TreeNode* root) {
        totalSum = find(root); // finding the totalSum of the nodes
        find(root);
        return res % MOD;
    }
};