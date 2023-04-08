/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
    unordered_map<Node*, Node*> mp;
   private:
    void dfs(Node* node, Node* cloneNode) {
        for (Node* n : node->neighbors) {
            if (mp.find(n) == mp.end()) {
                Node* clone = new Node(n->val);  // cloned adjacent nodes
                mp[n] = clone;
                cloneNode->neighbors.push_back(clone);
                dfs(n, clone);
            } else
                cloneNode->neighbors.push_back(mp[n]);
        }
    }

   public:
    Node* cloneGraph(Node* node) {
        if(!node) return NULL;
        Node* cloneNode = new Node(node->val);  // cloned root node
        mp.clear();
        mp[node] = cloneNode;
        dfs(node, cloneNode);  // cloning neighbors recursively
        return cloneNode;
    }
};