class Solution {
    public String frequencySort(String s) {
        // Create a HashMap to store the frequency of each character
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Create a PriorityQueue to sort characters based on their frequency
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        // Build the sorted string by appending characters from the PriorityQueue
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> ele = pq.poll();
            // Append the character 'ele.getKey()' 'ele.getValue()' times
            for (int i = 0; i < ele.getValue(); i++) {
                sb.append(ele.getKey());
            }
        }

        // Return the final sorted string
        return sb.toString();
    }
}