class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> res = new ArrayList<>();
        if(intervals.length == 0) return res.toArray(new int[0][]);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] temp = intervals[0];
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int[] it : intervals) {
            if(it[0] <= temp[1]) temp[1] = Math.max(temp[1], it[1]);
            else {
                res.add(temp);
                temp = it;
            }
        }
        
        res.add(temp);
        return res.toArray(new int[0][]);
    }
}