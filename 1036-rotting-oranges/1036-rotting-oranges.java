class Pair{
    int row,col,time;
    public Pair(int row,int col,int time){
        this.row=row;this.col=col;this.time=time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int [][]vis=new int[m][n];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }
            }
        }
        int res=0;
        int delR[] ={-1,0,+1,0};
        int delC[] ={0,+1,0,-1};
        while(!q.isEmpty()){
            Pair p=q.poll();
            int r=p.row;
            int c=p.col;
            int t=p.time;
            res=Math.max(res,t);
            for(int i=0;i<4;i++){
                int nrow=r+delR[i];
                int ncol=c+delC[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]!=2 && grid[nrow][ncol]==1){
                    q.add(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol]=2;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]!=2 && grid[i][j]==1){
                    return -1;
                }
            }
        }
        return res;
    }
}