class Solution
{
public:
    bool areNumbersAscending(string s)
    {
        int prev = 0, curr = 0;
        for (auto ch : s)
        {
            if (isdigit(ch))
                curr = curr * 10 + (ch - '0');
            else if (curr != 0)
            {
                if (prev >= curr)
                    return false;
                prev = curr;
                curr = 0;
            }
        }
        return curr == 0 || prev < curr;
    }
};