class MedianFinder {
public:
    MedianFinder() {
        
    }
    
    priority_queue<double> small; // max-heap
    priority_queue<double, vector<double>, greater<double>> large; // min-heap
    
    void addNum(int num) {
        small.push(num); // all nums will be inserted to small heap until it has a size difference of > 2 with large heap
        
        // every num in small should be <= every num in large
        if(small.size() && large.size() && (small.top() > large.top())) {
            large.push(small.top());
            small.pop();
        }
        
        // uneven size
        if(small.size() > large.size() + 1) {
            large.push(small.top());
            small.pop();
        }
        
        if(large.size() > small.size() + 1) {
            small.push(large.top());
            large.pop();
        }
    }
    
    double findMedian() {
        if(small.size() > large.size()) return small.top(); // if small is greater then max of small will be the median
        if(large.size() > small.size()) return large.top(); // else min of large
        else return (small.top() + large.top())/2; // if they're even sized
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */