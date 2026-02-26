class Solution {
    public int numSteps(String s) {
        int n = s.length(), carry = 0, steps = 0;

        for(int i = n - 1; i > 0; i--) {
            if(Character.getNumericValue(s.charAt(i)) + carry == 0) {
                carry = 0;
                steps++;
            } else if(Character.getNumericValue(s.charAt(i)) + carry == 2) {
                carry = 1;
                steps++;
            } else {
                carry = 1;
                steps += 2;
            }
        }

        if(carry == 1) steps++;

        return steps;
    }
}