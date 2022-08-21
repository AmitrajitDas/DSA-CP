class Solution
{
public:
    string longestCommonPrefix(vector<string> &strs)
    {

        string prefix = strs[0];
        int n = strs.size();
        if(n == 0) return "";

        for (int i = 1; i < n; i++)
        {
            if (strs[i] == prefix) // if any string matches with prefix then we don't evaluate
                continue;
            else
            {
                string temp = "";
                for (int j = 0; j < strs[i].length() && j < prefix.length(); j++)
                {
                    // we check how much of the curr string is matching with prefix
                    if (strs[i][j] == prefix[j])
                        temp += strs[i][j];
                    else
                        break;
                }
                prefix = temp; // updated prefix
            }
        }
        
        return prefix;
    }
};
