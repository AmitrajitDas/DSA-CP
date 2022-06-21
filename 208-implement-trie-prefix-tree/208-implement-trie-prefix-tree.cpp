struct Node {
    Node* child[26];
    bool flag = false;
    
    bool containsKey(char ch) {
        return child[ch - 'a'] != NULL;
    }
    
    void put(char ch, Node *node) {
        child[ch - 'a'] = node;
    }
    
    Node* get(char ch) {
        return child[ch - 'a'];
    }
    
    void setEnd() {
        flag = true;
    }
    
    bool isEnd() {
        return flag;
    }
};

class Trie {
private : Node *root;
public:
    Trie() {
        root = new Node();
    }
    
    void insert(string word) {
        Node *curr = root;
        for(char ch : word) {
            if(!curr->containsKey(ch))
               curr->put(ch, new Node());
            
            curr = curr->get(ch); // move to reference trie
        }
        
        curr->setEnd();
    }
    
    bool search(string word) {
        Node *curr = root;
        for(char ch : word) {
            if(!curr->containsKey(ch)) return false;
            curr = curr->get(ch);
        }
        
        return curr->isEnd();
    }
    
    bool startsWith(string prefix) {
        Node *curr = root;
        for(char ch : prefix) {
            if(!curr->containsKey(ch)) return false;
            curr = curr->get(ch);
        }
        
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */