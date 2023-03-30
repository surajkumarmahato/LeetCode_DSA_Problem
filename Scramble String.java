/*
Scramble String
We can scramble a string s to get a string t using the following algorithm:
If the length of the string is 1, stop.
If the length of the string is > 1, do the following:
Split the string into two non-empty substrings at a random index, i.e., if the string is s, divide it to x and y where s = x + y.
Randomly decide to swap the two substrings or to keep them in the same order. i.e., after this step, s may become s = x + y or s = y + x.
Apply step 1 recursively on each of the two substrings x and y.
Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise, return false.
*/
class Solution 
{
    public boolean isScramble(String s1, String s2) 
    {
        if (s1.equals(s2)) 
        {
            return true;
        }
        if (!Arrays.equals(s1.chars().sorted().toArray(), s2.chars().sorted().toArray())) {
            return false;
        }
        
        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n+1];
        
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                dp[i][j][1] = (s1.charAt(i) == s2.charAt(j));
            }
        }
        
        for (int length = 2; length <= n; length++) 
        {
            for (int i = 0; i <= n-length; i++) 
            {
                for (int j = 0; j <= n-length; j++) 
                {
                    for (int k = 1; k < length; k++) 
                    {
                        if ((dp[i][j][k] && dp[i+k][j+k][length-k]) || (dp[i][j+length-k][k] && dp[i+k][j][length-k])) 
                        {
                            dp[i][j][length] = true;
                            break;
                        }
                    }
                }
            }
        }
        
        return dp[0][0][n];
    }
}