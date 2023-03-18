class BrowserHistory {
public:
    stack<string> history; // one to track history
    stack<string> future; // another to store intermediate URLs while backing and restore them again
    BrowserHistory(string homepage) {
        history.push(homepage);
        future = stack<string> ();
    }
    
    void visit(string url) {
        history.push(url);
        future = stack<string> (); // resetting future stack as empty in each new visit
    }
    
    string back(int steps) {
        // storing URLs in future stack while backing to retrieve them again
        while(steps-- && history.size() > 1) {
            future.push(history.top());
            history.pop();
        }

        return history.top(); // history top gives the latest URL
    }
    
    string forward(int steps) {
        // storing future URLs in history stack to restore them again in their original order
        while(steps-- && future.size() > 0) {
            history.push(future.top());
            future.pop();
        }

        return history.top();
    }
};

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory* obj = new BrowserHistory(homepage);
 * obj->visit(url);
 * string param_2 = obj->back(steps);
 * string param_3 = obj->forward(steps);
 */