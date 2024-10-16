class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // PriorityQueue to store the counts of available characters, with the character with the highest count first.
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);

        // Add character counts to the priority queue, if they are greater than 0.
        if(a > 0) pq.offer(new int[]{a, 'a'});  // Store {count, 'a'}
        if(b > 0) pq.offer(new int[]{b, 'b'});  // Store {count, 'b'}
        if(c > 0) pq.offer(new int[]{c, 'c'});  // Store {count, 'c'}

        // StringBuilder to construct the final longest diverse string.
        StringBuilder sb = new StringBuilder();

        // Continue building the string while there are still characters left to use.
        while(!pq.isEmpty()) {
            // Poll the character with the highest remaining count.
            int[] first = pq.poll();
            
            // Check if the last two characters in the result are the same as the current character.
            // If the last two characters are the same, we cannot use the same character again (to avoid three consecutive same characters).
            if(sb.length() >= 2 && first[1] == sb.charAt(sb.length() - 1) && first[1] == sb.charAt(sb.length() - 2)) {
                // If the next highest character doesn't exist, we can't form a valid diverse string anymore.
                if(pq.isEmpty()) break;

                // Poll the second highest count character since we cannot use the `first` character here.
                int[] second = pq.poll();
                
                // Append the second highest character to the result.
                sb.append((char)(second[1]));
                
                // Decrease the count of the second character.
                second[0]--;
                
                // If there are still more instances of the second character left, put it back in the priority queue.
                if(second[0] > 0) pq.offer(second);

                // Put the first character back in the priority queue because we couldn't use it in this step.
                pq.offer(first);
            } else {
                // If the last two characters are not the same as the `first` character, we can use it.
                sb.append((char)(first[1]));
                
                // Decrease the count of the first character.
                first[0]--;
                
                // If there are still more instances of the first character left, put it back in the priority queue.
                if(first[0] > 0) pq.offer(first);
            }
        }
        
        // Return the longest diverse string.
        return sb.toString();
    }
}