class MyHashSet {
public:
    
    vector<list<int>> v;
    int size;
    
    MyHashSet() {
        
        int size = 1e6+1;
        v.resize(size);
    }
    
    int hash(int key) {
        return key % size;
    }
    
    list<int> :: iterator search(int key) {
        
        int i = hash(key);
        return find(v[i].begin(), v[i].end(), key);
    }
    
    void add(int key) {
        if(contains(key))
          return;
        int i = hash(key);
        v[i].push_back(key);
    }
    
    void remove(int key) {
        if(!contains(key))
            return;
        int i = hash(key);
        auto it = search(key);
        v[i].erase(it);
    }
    
    bool contains(int key) {
        
        int i = hash(key);
        if(search(key) == v[i].end()) 
            return false;
        return true;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */