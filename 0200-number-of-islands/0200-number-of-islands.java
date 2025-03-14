class Pair{
    int row,col;
    public Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length,n=grid[0].length;
        int cnt=0;
        boolean [][]vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    bfs(i,j,m,n,vis,grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public void bfs(int i,int j,int m,int n,boolean [][]vis,char [][]grid){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(i,j));
        vis[i][j]=true;
        while(!q.isEmpty()){
            Pair cur=q.poll();
            int r=cur.row;
            int c=cur.col;
            if(r>0 && grid[r-1][c]=='1' && !vis[r-1][c]){
                vis[r-1][c]=true;
                q.add(new Pair(r-1,c));
            }
            if(r<m-1 && grid[r+1][c]=='1' && !vis[r+1][c] ){
                vis[r+1][c]=true;
                q.add(new Pair(r+1,c));
            }
            if(c>0 && grid[r][c-1]=='1' && !vis[r][c-1]){
                vis[r][c-1]=true;
                q.add(new Pair(r,c-1));
            }
            if(c<n-1 && grid[r][c+1]=='1' && !vis[r][c+1]){
                vis[r][c+1]=true;
                q.add(new Pair(r,c+1));
            }
        }
    }
}