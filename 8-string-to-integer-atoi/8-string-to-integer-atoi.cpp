class Solution
{
public:
    int myAtoi(string s)
    {
        long long int res = 0;
        int sign = 1;
        int i = 0;

        while (s[i] == ' ')
            i++;
        
        // if '-' is found then we make the sign -ve
        if (s[i] == '-' || s[i] == '+') sign = s[i++] == '-' ? -1 : 1; 

        while (s[i] - '0' >= 0 && s[i] - '0' <= 9) // only check if character is digit
        {
            res = res * 10 + (s[i++] - '0');
            if (res * sign >= INT_MAX) // if result is greater than inf we return inf
                return INT_MAX;
            if (res * sign <= INT_MIN) // if result is less than -inf we return -inf
                return INT_MIN;
        }

        return res * sign; // sign is multuplied to get the actual result
    }
};