/*
Number of Zero-Filled Subarrays
Given an integer array nums, return the number of subarrays filled with 0.
A subarray is a contiguous non-empty sequence of elements within an array.
*/
class Solution 
{
    public long zeroFilledSubarray(int[] nums) 
    {
        long cnt = 0, zeroSubarraysEndingAtCurrentIndex = 0;
        for (int n : nums) 
        {
            if (n == 0) 
            {
                cnt += ++zeroSubarraysEndingAtCurrentIndex;
            }
            else 
            {
                zeroSubarraysEndingAtCurrentIndex = 0;
            }
        }
        return cnt;
    }
}