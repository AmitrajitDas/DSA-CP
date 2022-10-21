class Solution
{
public:
    const string key[13] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    const int val[13] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    string intToRoman(int nums)
    {
        string res = "";
        int i = 0;
        while(nums) {
            while (nums >= val[i]) {
                
                // adding the keys to the result until num gets lesser than the current value
                res += key[i];
                nums -= val[i]; 
            }
            i++;
        }
                
        return res;
    }
};