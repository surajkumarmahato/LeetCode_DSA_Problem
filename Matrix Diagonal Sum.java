/*
Matrix Diagonal Sum
Given a square matrix mat, return the sum of the matrix diagonals.
*/

class Solution 
{
    public int diagonalSum(int[][] mat) 
    {
        int sum=0;
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(i==j || i+j==mat.length-1)
                {
                    sum=sum+mat[i][j];
                }
            }
        }
        return sum;
    }
}