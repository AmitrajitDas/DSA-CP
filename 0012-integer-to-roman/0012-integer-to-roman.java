class Solution {
    public String intToRoman(int num) {
        String[] key = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        int i = 0;
        StringBuilder res = new StringBuilder();

        while(num > 0) {
            while(num >= val[i]) {
                res.append(key[i]);
                num -= val[i];
            }
            i++;
        }

        return res.toString();
    }
}