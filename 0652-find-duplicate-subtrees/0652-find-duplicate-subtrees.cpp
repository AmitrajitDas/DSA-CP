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
    string serialize(TreeNode* node, unordered_map<string, vector<TreeNode*>> &mp) {
        if(node == NULL) return "";
        // this serialization structure keeps root at middle and left-right on the other sides
        // this will determine our duplicates subtrees as they will be same for them 
        string serializedStr = "(" + serialize(node->left, mp) + to_string(node->val) + serialize(node->right, mp) + ")";
        mp[serializedStr].push_back(node); // mapping serialized string with its root node
        return serializedStr;
    }
public:
    vector<TreeNode*> findDuplicateSubtrees(TreeNode* root) {
        unordered_map<string, vector<TreeNode*>> mp;
        vector<TreeNode*> dups;
        serialize(root, mp);
        for(auto it = mp.begin(); it != mp.end(); it++) {
            if(it->second.size() > 1) dups.push_back(it->second[0]);
        }

        return dups;
    }
};

