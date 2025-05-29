class Solution {
    public void dfs(int x,boolean []vis,int [][]grid){
        vis[x]=true;
        for(int i=0;i<vis.length;i++){
            if(grid[x][i]==1 && vis[i]==false){
                dfs(i,vis,grid);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
      int ans=0;
      boolean []vis=new boolean[isConnected.length];
      for(int i=0;i<isConnected.length;i++){
        if(vis[i]==false){
            ans++;
            dfs(i,vis,isConnected);
        }
      }
      return ans;
    }
}