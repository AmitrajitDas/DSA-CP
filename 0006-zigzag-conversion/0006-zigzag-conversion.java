class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length()) {
            return s;
        }

        List<Character>[] rowBucket = new ArrayList[numRows];
        for(int i = 0; i < numRows; i++) {
            rowBucket[i] = new ArrayList<>();
        }

        int idx = 0, diff = 1;
        for(char ch : s.toCharArray()) {
            rowBucket[idx].add(ch);
            if(idx == 0) {
                diff = 1;
            } else if(idx == numRows - 1) {
                diff = -1;
            }
            idx += diff;
        }

        StringBuilder res = new StringBuilder();
        for(List<Character> row : rowBucket) {
            for(char ch : row) {
                res.append(ch);
            }
        }

        return res.toString();
    }
}