class Solution {
public:
    typedef pair<int, char> P;
    
    string reorganizeString(string s) {
        int n = s.length();
        unordered_map<char, int> freq;  // To store character frequencies
        priority_queue<P, vector<P>, less<P>> pq;  // Max-heap for frequency and character pairs
        string res = "";  // To store the reorganized string
        
        // Calculate character frequencies
        for (char ch : s) {
            freq[ch]++;
            // If frequency of a character exceeds the threshold, reorganization is not possible
            if (freq[ch] > (n + 1) / 2) return res;
        }

        // Populate the priority queue with frequency and character pairs
        for (const auto &entry : freq) pq.push({entry.second, entry.first});

        // Reorganize the string
        while (pq.size() >= 2) {
            P p1 = pq.top();
            pq.pop();
            P p2 = pq.top();
            pq.pop();

            // Add characters to the result string
            res += p1.second;
            res += p2.second;

            // Decrement frequencies and push back to the priority queue if needed
            if (--p1.first > 0) {
                pq.push(p1);
            }
            if (--p2.first > 0) {
                pq.push(p2);
            }
        }

        // If there's only one character left in the priority queue, add it to the result
        if (!pq.empty()) {
            res += pq.top().second;
        }

        return res;
    }
};

// class Solution {
// public:
//     typedef pair<int, char> P;

//     string reorganizeString(string s) {
//         int n = s.length();
//         map<char, int> freq;  // To store character frequencies
        
//         char charMaxFreq;  // To store the character with maximum frequency
//         int maxFreq = 0;   // To store the maximum frequency found

//         // Calculate character frequencies and find the character with maximum frequency
//         for (char ch : s) {
//             freq[ch]++;
//             if (freq[ch] > maxFreq) {
//                 maxFreq = freq[ch];
//                 charMaxFreq = ch;
//             }
//             // If frequency of a character exceeds the threshold, reorganization is not possible
//             if (freq[ch] > (n + 1) / 2) {
//                 return "";
//             }
//         }

//         int i = 0;
//         string res = s;
//         // Reorganize the string with the character of maximum frequency
//         while (freq[charMaxFreq] > 0) {
//             res[i] = charMaxFreq;
//             i += 2;
//             freq[charMaxFreq]--;
//         }

//         // Reorganize the rest of the string with other characters
//         for (char ch = 'a'; ch <= 'z'; ch++) {
//             while (freq[ch] > 0) {
//                 if (i >= n) {
//                     i = 1;
//                 }
//                 res[i] = ch;
//                 i += 2;
//                 freq[ch]--;
//             }
//         }

//         return res;
//     }
// };
