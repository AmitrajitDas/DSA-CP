class Solution {
    private int generateInt(int idx, int res, String s, int sign) {
        // Base case: end of string
        if(idx >= s.length()) return res;
        
        // Digit check: stop if not a digit
        if(!Character.isDigit(s.charAt(idx))) return res;
        
        int currDigit = s.charAt(idx) - '0';
        
        // Overflow check BEFORE updating res
        if (res > (Integer.MAX_VALUE - currDigit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        
        res = res * 10 + currDigit;
        return generateInt(idx + 1, res, s, sign);
    }

    public int myAtoi(String s) {
        // Trim leading whitespace
        s = s.trim();
        if(s.isEmpty()) return 0;
        
        // Check for sign
        int sign = 1;
        int startIdx = 0;
        if(s.charAt(0) == '-') {
            sign = -1;
            startIdx = 1;
        } else if(s.charAt(0) == '+') {
            startIdx = 1;
        }
        
        int result = generateInt(startIdx, 0, s, sign);
        return sign * result;
    }
}