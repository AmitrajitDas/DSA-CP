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
   private:
    void dfs(Node* node, Node* cloneNode, vector<Node*>& vis) {
        vis[node->val] =
            cloneNode;  // marking early because this will only happen in
                        // forward exploration of sub problems
        for (Node* n : node->neighbors) {
            if (vis[n->val] == NULL) {
                Node* clone = new Node(n->val);  // cloned adjacent nodes
                cloneNode->neighbors.push_back(clone);
                dfs(n, clone, vis);
            } else
                cloneNode->neighbors.push_back(vis[n->val]);
        }
    }

   public:
    Node* cloneGraph(Node* node) {
        if (!node) return NULL;
        Node* cloneNode = new Node(node->val);  // cloned root node
        vector<Node*> vis(101, NULL);
        vis[node->val] = cloneNode;
        dfs(node, cloneNode, vis);  // cloning neighbors recursively
        return cloneNode;
    }
};