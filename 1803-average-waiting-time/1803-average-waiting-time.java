class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        int timeTillNow = customers[0][0] + customers[0][1];
        double totalTime = timeTillNow - customers[0][0];

        for(int i = 1; i < n; i++) {
            if(customers[i][0] < timeTillNow) {
                timeTillNow += customers[i][1];
            } else {
                timeTillNow = customers[i][0] + customers[i][1];
            }
            System.out.println(timeTillNow);
            totalTime += (timeTillNow - customers[i][0]); 
            System.out.println(totalTime);   
        }

        return totalTime / n;
    }
}