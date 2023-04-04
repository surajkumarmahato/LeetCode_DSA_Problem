/*
Optimal Partition of String

Given a string s, partition the string into one or more substrings such that the characters in each substring are unique.
That is, no letter appears in a single substring more than once.
Return the minimum number of substrings in such a partition.
Note that each character should belong to exactly one substring in a partition.
*/

class Solution 
{
    public int partitionString(String s) 
    {
        int i = 0, ans = 1, flag = 0;
        while(i < s.length()) 
        {
            int val = s.charAt(i) - 'a';
            if ((flag & (1 << val)) != 0)
            {
                flag = 0;
                ans++;
            }
            flag = flag | (1 << val);
            i++;
        }
        return ans;
    }
}