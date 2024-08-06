class Solution {
    public int minimumPushes(String word) {
        // Create a frequency array for 26 letters of the alphabet
        int[] freq = new int[26];
        for (char ch : word.toCharArray()) {
            // Increment the frequency of each character in the word
            freq[ch - 'a']++;
        }

        // Create an array to store frequencies for sorting
        Integer[] sortedFreq = new Integer[26];
        for (int i = 0; i < 26; i++) {
            sortedFreq[i] = freq[i];
        }

        /* Sort the frequencies in descending order
        it allows us to assign the most frequent letters to the most accessible key positions
        */
        Arrays.sort(sortedFreq, Collections.reverseOrder());

        int totalPresses = 0;
        for (int i = 0; i < 26; i++) {
            if (sortedFreq[i] == 0) break;
            /* i / 8 + 1 determines the number of presses required for the current letter
            The first 8 letters (indices 0-7) require 1 press
            the next 8 (indices 8-15) require 2 presses & so on
            */
            totalPresses += (i / 8 + 1) * sortedFreq[i];
        }
        
        return totalPresses;
    }
}
