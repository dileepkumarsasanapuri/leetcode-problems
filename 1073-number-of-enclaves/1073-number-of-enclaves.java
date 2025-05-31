class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int [][]vis=new int[m][n];
        int []drow={-1,0,1,0};
        int []dcol={0,1,0,-1};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || i==m-1 || j==0 || j==n-1){
                    if(grid[i][j]==1){
                        dfs(i,j,vis,drow,dcol,grid);
                    }
                }
            }
        }
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]!=1){
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(int r,int c,int [][]vis,int []drow,int []dcol,int [][]grid){
        vis[r][c]=1;
        for(int i=0;i<4;i++){
            int nr=r+drow[i];
            int nc=c+dcol[i];
            if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc]==1 && vis[nr][nc]!=1){
                dfs(nr,nc,vis,drow,dcol,grid);
            }
        }
    }
}