class Solution {
    public int nthUglyNumber(int n) {
        // TreeSet to maintain sorted order and uniqueness
        TreeSet<Long> uglyNumbers = new TreeSet<>();
        uglyNumbers.add(1L);  // Start with the first ugly number

        long ugly = 1;  // This will hold the nth ugly number

        // Generate n ugly numbers
        for (int i = 0; i < n; i++) {
            // Remove the smallest element (the next ugly number)
            ugly = uglyNumbers.pollFirst();

            // Generate new ugly numbers and add them to the set
            uglyNumbers.add(ugly * 2);
            uglyNumbers.add(ugly * 3);
            uglyNumbers.add(ugly * 5);
        }

        // The last removed element is the nth ugly number
        return (int) ugly;
    }
}