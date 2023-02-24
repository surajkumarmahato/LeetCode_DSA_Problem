/*
Maximum Difference Between Increasing Elements
Given a 0-indexed integer array nums of size n, find the maximum difference between nums[i] and nums[j] (i.e., nums[j] - nums[i]), such that 0 <= i < j < n and nums[i] < nums[j].

Return the maximum difference. If no such i and j exists, return -1.
*/

class Solution 
{
    public int maximumDifference(int[] nums) 
    {
        int min = nums[0];
        int result = -1;
        for (int i = 1; i<nums.length; i++)
        {
            if (nums[i] > min)
                result = Math.max(result, nums[i] - min);
            else
                min = Math.min(min, nums[i]);
        }
        return result;
    }
}