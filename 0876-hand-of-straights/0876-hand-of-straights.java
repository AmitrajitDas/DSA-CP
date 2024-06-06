class Solution {
    private boolean findConsecutive(int i, int[] hand, int groupSize, int n) {
        int next = hand[i] + 1;
        hand[i++] = -1;
        int count = 1;

        while(i < n && count < groupSize) {
            if(hand[i] == next) {
                next = hand[i] + 1;
                hand[i] = -1;
                count++;
            }
            i++;
        }

        if(count == groupSize) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        for(int i = 0; i < n; i++) {
            if(hand[i] >= 0) {
                if(!findConsecutive(i, hand, groupSize, n)) {
                    return false;
                }
            }
        }

        return true;
    }
}