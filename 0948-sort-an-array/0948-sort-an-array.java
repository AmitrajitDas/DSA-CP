class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> res = new ArrayList<>();

        for(int num : nums) {
            pq.add(num);
        }

        while(!pq.isEmpty()) {
            int num = pq.poll();
            res.add(num);
        }

        Integer[] sortedArray = res.toArray(new Integer[0]);
        return Arrays.stream(sortedArray).mapToInt(Integer::intValue).toArray();
    }
}