class MyHashSet {
public:
    vector<list<int>> hset;
    int size;
    MyHashSet() {
        int size = 1e6 + 1;
        hset.resize(size);
    }

    int hash(int key) {
        return key % size; // mod for chaining values for a particular key
    }

    list<int> :: iterator search(int idx, int key) { // returns an iterator which points to the key
        return find(hset[idx].begin(), hset[idx].end(), key);
    }
    
    void add(int key) {
        if(contains(key)) return;
        int i = hash(key);
        hset[i].push_back(key);
    }
    
    void remove(int key) {
        if(!contains(key)) return;
        int i = hash(key);
        auto it = search(i, key);
        hset[i].erase(it);
    }
    
    bool contains(int key) {
        int i = hash(key);
        if(search(i, key) == hset[i].end()) return false; // if iterator is going out of bounds then it's not found
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