class Solution {
    int cherries(int [][]grid,int r,int c,int [][][]dp){
        for(int i1=0;i1<c;i1++){
            for(int i2=0;i2<c;i2++){
                if(i1==i2) dp[r-1][i1][i2]=grid[r-1][i1];
                else dp[r-1][i1][i2]=grid[r-1][i1]+grid[r-1][i2];
            }
        }
        for(int i=r-2;i>=0;i--){
            for(int j1=0;j1<c;j1++){
                for(int j2=0;j2<c;j2++){
                     int maxi=0;
                    for(int dj1=-1;dj1<=1;dj1++){
                        for(int dj2=-1;dj2<=1;dj2++){
                            int val=0;
                            if(j1==j2) val=grid[i][j1];
                            else val=grid[i][j1]+grid[i][j2];
                            if(j1+dj1>=0 && j1+dj1<c && j2+dj2>=0 && j2+dj2<c)
                               val+=dp[i+1][j1+dj1][j2+dj2]; 
                            else 
                               val=Integer.MIN_VALUE;
                            maxi=Math.max(maxi,val);
                        }
                    }
                    dp[i][j1][j2]=maxi;
                }
            }
        }
        return dp[0][0][c-1];
    }
    public int cherryPickup(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int [][][]dp=new int[m][n][n];
        return cherries(grid,m,n,dp);
    }
}