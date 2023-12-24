class SeatManager {
    private int lastSeat;  // Represents the last seat number that was reserved
    private PriorityQueue<Integer> pq; // A priority queue to efficiently manage available seats
    
    public SeatManager(int n) {
        this.lastSeat = 0;
        this.pq = new PriorityQueue<>();
    }
    
    public int reserve() {
        // If the priority queue is empty, increment the last seat and return it
        if (pq.isEmpty()) return ++lastSeat;
        // Otherwise, return the smallest available seat by polling from the priority queue
        else return pq.poll();
    }
    
    public void unreserve(int seatNumber) {
        // If the unreserved seat is the last reserved seat, decrement the lastSeat counter
        if (seatNumber == lastSeat) --lastSeat;
        // Otherwise, add the unreserved seat back to the priority queue
        else pq.offer(seatNumber);
    }
}
/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */