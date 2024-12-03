class Pair<K, V> {
    public K first;
    public V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Initialize the queue for BFS
        Queue<Pair<String, Integer>> q = new LinkedList<>();

        // Convert wordList to a set for faster lookups
        Set<String> st = new HashSet<>(wordList);

        // If the endWord is not in the word list, there's no valid transformation
        if (!st.contains(endWord)) {
            return 0;
        }

        // Push the starting word with step count 1 into the queue
        q.offer(new Pair<>(beginWord, 1));
        st.remove(beginWord); // Mark the start word as visited by removing it from the set

        // BFS loop
        while (!q.isEmpty()) {
            // Get the current word and the step count
            Pair<String, Integer> pair = q.poll();
            String word = pair.first;
            int steps = pair.second;

            // If the current word is the endWord, return the step count
            if (word.equals(endWord)) {
                return steps;
            }

            // Explore all possible transformations of the current word
            char[] wordArray = word.toCharArray(); // Convert string to char array for modification
            for (int i = 0; i < wordArray.length; i++) {
                char original = wordArray[i]; // Save the original character

                // Try replacing the character with every other lowercase letter
                for (char c = 'a'; c <= 'z'; c++) {
                    wordArray[i] = c;
                    String newWord = new String(wordArray); // Form the new word

                    // If the new word is in the set, it's a valid transformation
                    if (st.contains(newWord)) {
                        q.offer(new Pair<>(newWord, steps + 1)); // Add it to the queue
                        st.remove(newWord); // Mark as visited
                    }
                }

                // Restore the original character
                wordArray[i] = original;
            }
        }

        // If we exhaust the queue without finding the endWord, return 0
        return 0;
    }
}
