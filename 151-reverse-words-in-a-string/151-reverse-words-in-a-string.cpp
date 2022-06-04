// With no extra space //

class Solution {
public:
    
    void reverseWord(string &s, int i, int j){
        while(i<j){
          char t=s[i];
          s[i++]=s[j];
          s[j--]=t;
        } 
    }
    
    string reverseWords(string s) {
        
        int i = 0, j = 0, n = s.size();
        string res = "";
        int wordCount = 0;
        
        while(i < n) {
            while(i < n && s[i] == ' ') i++; // skip spaces
            if(i >= n) break;
            if(wordCount > 0) s[j++] = ' ';
            int low = j;
            while(i < n && s[i] != ' ') s[j++] = s[i++]; // reverse word in place
            reverseWord(s, low, j - 1);
            wordCount++;
        }
        
        s.resize(j);                           // resize result string
        reverseWord(s, 0, j - 1);              // reverse whole string
        return s;
    }
};

// With extra space //

// class Solution {
// public:
//     string reverseWords(string s) {
        
//         int i = 0, n = s.size();
//         string res = "";
        
//         while(i < n) {
//             while(i < n && s[i] == ' ') i++; // skip spaces
//             if(i >= n) break;
//             int j = i + 1; // j will start immediately after i
//             while( j < n && s[j] != ' ') j++; // skip non-spaces
//             string str = s.substr(i, j - i);
//             if(res.size() == 0) res = str;
//             else res = str + " " + res;
//             i = j + 1;
//         }
        
//         return res;
//     }
// };