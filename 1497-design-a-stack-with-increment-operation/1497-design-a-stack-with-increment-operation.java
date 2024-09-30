class CustomStack {
    int top = -1;
    int[] st;
    public CustomStack(int maxSize) {
        st = new int[maxSize];
    }
    
    public void push(int x) {
        if(top < st.length - 1) {
            top++;
            st[top] = x;
        }
    }
    
    public int pop() {
        if(top != -1) {
            return st[top--];
        }

        return -1;
    }
    
    public void increment(int k, int val) {
        for(int i = 0; i < Math.min(k, top + 1); i++) {
            st[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */