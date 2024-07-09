class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double totalWaitTime = 0;
        int currTime = 0;

        for (int[] customer : customers) {
            int arrivalTime = customer[0];
            int cookTime = customer[1];
            if (currTime < arrivalTime) {
                currTime = arrivalTime;
            }
            int waitTime = currTime + cookTime - arrivalTime;
            totalWaitTime += waitTime;
            currTime += cookTime;
        }

        return totalWaitTime / n;
    }
}