class Solution {
    // Function to count the frequency of each character in a string
    private int[] count(String str) {
        int[] freq = new int[26];
        // Loop through each character in the string
        for (char c : str.toCharArray()) {
            freq[c - 'a']++; // Increment the count for the corresponding character
        }
        return freq; // Return the frequency array
    }

    // Function to find the intersection of two frequency arrays
    private int[] intersection(int[] a, int[] b) {
        int[] arr = new int[26];
        // Loop through each character index
        for (int i = 0; i < 26; i++) {
            // Take the minimum count for each character from both arrays
            arr[i] = Math.min(a[i], b[i]);
        }
        return arr; // Return the intersection frequency array
    }

    public List<String> commonChars(String[] words) {
        // Initialize the frequency array with the first word
        int[] pre = count(words[0]);

        // Compute the intersection of frequencies with subsequent words
        for (int i = 1; i < words.length; i++) {
            pre = intersection(pre, count(words[i]));
        }

        List<String> res = new ArrayList<>();
        // Collect the common characters based on the intersection array
        for (int i = 0; i < 26; i++) {
            if (pre[i] > 0) {
                char ch = (char) ('a' + i); // Convert the index back to a character
                String str = String.valueOf(ch); // Convert the character to a string
                // Add the character to the result list the number of times it appears
                while (pre[i] > 0) {
                    res.add(str);
                    pre[i]--;
                }
            }
        }

        return res; // Return the list of common characters
    }
}
