/*
Number of Closed Islands

Given a 2D grid consists of 0s (land) and 1s (water). 
An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
Return the number of closed islands.
*/

class Solution 
{
    public int closedIsland(int[][] grid) 
    {
     int rows = grid.length, cols = grid[0].length, count = 0;
        
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < cols; j++) 
            {
                if (grid[i][j] == 0 && dfs(grid,i, j)) 
                {
                    count++;
                }
            }
        }
        
        return count;
    }
    public boolean dfs(int[][] grid,int i, int j) 
    {
        int rows = grid.length, cols = grid[0].length;
        if (i < 0 || j < 0 || i >= rows || j >= cols)
         {
            return false;
        }
        if (grid[i][j] == 1) 
        {
            return true;
        }
        grid[i][j] = 1;
        boolean left = dfs(grid,i, j-1), right = dfs(grid,i, j+1);
        boolean up = dfs(grid,i-1, j), down = dfs(grid,i+1, j);
        return left && right && up && down;
    }
}
