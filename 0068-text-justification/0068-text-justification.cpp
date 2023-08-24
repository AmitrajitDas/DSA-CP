class Solution {
public:
    // Function to construct the final justified line for a given range of words
    string getFinalWord(int i, int j, int eachWordSpace, int extraSpace, vector<string>& words, int maxWidth) {
        string s;
        
        // Concatenate words and spaces based on eachWordSpace and extraSpace
        for (int k = i; k < j; k++) {
            s += words[k];
            
            // Add spaces between words (eachWordSpace)
            if (k == j - 1) continue;  // Skip for the last word
            for (int space = 1; space <= eachWordSpace; space++) s += " ";
            
            // Distribute extra spaces
            if (extraSpace > 0) {
                s += " ";
                extraSpace--;
            }
        }
        
        // Pad the line with spaces to reach maxWidth
        while (s.length() < maxWidth) s += " ";
        return s;
    }
    
    // Function to justify the given list of words within maxWidth
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        vector<string> res;  // Resultant vector of justified lines
        int n = words.size();  // Number of words in the input
        int i = 0;  // Pointer to the current word
        
        while (i < n) {
            int lettersCount = words[i].length();  // Count of letters in the current word
            int j = i + 1;  // Pointer to the next word to be included
            int spaceSlots = 0;  // Count of slots between words
            
            // Calculate how many words can fit within maxWidth
            while (j < n && spaceSlots + lettersCount + words[j].length() + 1 <= maxWidth) {
                lettersCount += words[j].length();
                spaceSlots += 1;
                j++;
            }
            
            int remainingSlots = maxWidth - lettersCount;  // Remaining slots for spaces
            
            int eachWordSpace = spaceSlots == 0 ? 0 : remainingSlots / spaceSlots;  // Calculate spaces per slot
            int extraSpace = spaceSlots == 0 ? 0 : remainingSlots % spaceSlots;  // Calculate extra spaces
            
            // If this is the last line, adjust spacing
            if (j == n) {
                eachWordSpace = 1;
                extraSpace = 0;
            }
            
            // Construct the justified line and add it to the result
            res.push_back(getFinalWord(i, j, eachWordSpace, extraSpace, words, maxWidth));
            
            // Move the pointer to the next unprocessed word
            i = j;
        }
        
        return res; 
    }
};
