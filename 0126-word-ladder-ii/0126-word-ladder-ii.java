class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return new ArrayList<>(); // End word is not in the word list
        }

        // Step 1: Use BFS to build a graph of all possible neighbors
        Map<String, List<String>> neighbors = new HashMap<>();
        wordSet.add(beginWord); // Ensure the begin word is part of the set
        for (String word : wordSet) {
            neighbors.put(word, new ArrayList<>());
        }
        for (String word : wordSet) {
            for (int i = 0; i < word.length(); i++) {
                char[] charArray = word.toCharArray();
                char original = charArray[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    charArray[i] = c;
                    String newWord = new String(charArray);
                    if (wordSet.contains(newWord) && !newWord.equals(word)) {
                        neighbors.get(word).add(newWord);
                    }
                }
                charArray[i] = original; // Restore original character
            }
        }

        // Step 2: Bidirectional BFS
        Map<String, Integer> distance = new HashMap<>();
        Map<String, List<String>> paths = new HashMap<>();
        for (String word : wordSet) {
            paths.put(word, new ArrayList<>());
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> currentLevelVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                int currentDist = distance.get(word);
                for (String neighbor : neighbors.get(word)) {
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, currentDist + 1);
                        queue.offer(neighbor);
                        currentLevelVisited.add(neighbor);
                    }
                    if (distance.get(neighbor) == currentDist + 1) {
                        paths.get(neighbor).add(word);
                    }
                }
            }
            for (String visited : currentLevelVisited) {
                distance.put(visited, distance.get(visited));
            }
        }

        // Step 3: DFS to reconstruct all paths
        List<List<String>> results = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add(endWord);
        dfs(endWord, beginWord, paths, path, results);

        return results;
    }

    private void dfs(String word, String beginWord, Map<String, List<String>> paths, List<String> path, List<List<String>> results) {
        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp); // Reverse to maintain the order
            results.add(temp);
            return;
        }
        for (String prevWord : paths.get(word)) {
            path.add(prevWord);
            dfs(prevWord, beginWord, paths, path, results);
            path.remove(path.size() - 1); // Backtrack
        }
    }
}
