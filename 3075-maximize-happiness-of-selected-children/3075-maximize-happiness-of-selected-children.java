class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long sum = 0;
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int x : happiness) {
            pq.add(x);
        }

        while(k > 0) {
            int hap = pq.poll();
            /* we don't need to manually decrease each number by 1 everytime,
            rather we can maintain a decrement counter & substract it from current 
            happiness
            */
            sum += (long)(Math.max(hap - count, 0));
            count++;
            k--;
        }

        return sum;
    }
}