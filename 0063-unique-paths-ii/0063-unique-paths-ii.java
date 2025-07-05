class Solution {
    int paths(int [][]dp,int i,int j,int m,int n,int [][]arr){
        if(i>=m || j>=n) return 0;
        if(i>=0 && j>=0 && arr[i][j]==1) return 0;
        if(i==m-1 && j==n-1) return 1; 
        if(dp[i][j]!=0) return dp[i][j];
        dp[i][j]=paths(dp,i+1,j,m,n,arr)+paths(dp,i,j+1,m,n,arr);
        return dp[i][j];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        int [][]dp=new int[m][n];
        return paths(dp,0,0,m,n,obstacleGrid);
    }
}