class Solution {
public:
    
    bool isMatching(char a, char b)
    {
        return ((a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']'));
    }
    
    bool isValid(string s) {
        
        stack<char> st;
        
        for(auto c : s) 
        {
            if(c =='(' or c =='{' or c =='[') st.push(c);
            else 
            {
                if(st.empty() or !isMatching(st.top(), c)) return false;
                
                st.pop();
            }
        }
        return st.empty();  
    
    }
};