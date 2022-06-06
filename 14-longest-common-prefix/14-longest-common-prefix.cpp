class Solution
{
public:
    string longestCommonPrefix(vector<string> &strs)
    {

        string prefix = strs[0];
        int n = strs.size();

        for (int i = 1; i < n; i++)
        {
            if (strs[i] == prefix)
                continue;
            else
            {

                string temp = "";
                for (int j = 0; j < strs[i].length() && j < prefix.length(); j++)
                {
                    if (strs[i][j] == prefix[j])
                        temp += strs[i][j];
                    else
                        break;
                }

                prefix = temp;
            }
        }
        
        return prefix;
    }
};