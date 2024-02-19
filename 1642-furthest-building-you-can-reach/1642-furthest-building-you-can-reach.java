class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff > 0) { // If the next building is taller than the current one
                pq.add(diff); // Add the height difference to the priority queue
                if (pq.size() > ladders) { // If there are more height differences than available ladders
                    bricks -= pq.poll(); // Use a ladder by removing the smallest height difference from the priority queue
                    if (bricks < 0) { // If not enough bricks to bridge the remaining gaps
                        return i; // Return the index of the current building (furthest reachable building)
                    }
                }
            }
        }

        return n - 1; // If all buildings can be reached, return the index of the last building
    }
}