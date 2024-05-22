class Solution {
    // Helper method to check if a substring of 's' from 'start' to 'end' is a palindrome
    private boolean isPalindrome(int start, int end, String s) {
        while (start <= end) {
            // If characters at the current positions are not equal, it's not a palindrome
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        // If all characters matched, it's a palindrome
        return true;
    }

    // Helper method to generate all possible palindromic partitions
    private void generatePalindrome(int idx, String s, List<String> ds, List<List<String>> res) {
        // Base case: if the current index has reached the end of the string, add the current partition to the result
        if (idx == s.length()) {
            res.add(new ArrayList<>(ds)); // Create a new list to avoid modifying the original
            return;
        }

        // Iterate over the substring starting from the current index
        for (int i = idx; i < s.length(); i++) {
            // Check if the substring from 'idx' to 'i' is a palindrome
            if (isPalindrome(idx, i, s)) {
                // If it is, add it to the current partition
                ds.add(s.substring(idx, i + 1));
                // Recur for the remaining substring
                generatePalindrome(i + 1, s, ds, res);
                // Backtrack: remove the last added substring to explore other partitions
                ds.remove(ds.size() - 1);
            }
        }
    }

    // Main method to get all palindromic partitions of the input string 's'
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>(); // List to store all partitions
        List<String> ds = new ArrayList<>(); // List to store the current partition
        generatePalindrome(0, s, ds, res); // Start generating partitions from index 0
        return res; // Return the result list containing all palindromic partitions
    }
}