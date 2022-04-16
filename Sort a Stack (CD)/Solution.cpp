void insert(stack<int> &st, int x) {
	if(st.empty() || x > st.top())
		st.push(x);
	else {
		int a = st.top();
		st.pop();
		insert(st, x);
		st.push(a);
	}
}
void sortStack(stack<int> &st) {
	if(!st.empty()) {
		int x = st.top();
		st.pop();
		sortStack(st);
		insert(st, x);
	}
}
