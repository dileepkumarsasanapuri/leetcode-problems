class Node{
  int r,c,dist;
  public Node(int r,int c,int dist){
    this.r=r;
    this.c=c;
    this.dist=dist;
  }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int res[][]=new int[m][n];
        int [][]vis=new int[m][n];
        Queue<Node> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new Node(i,j,0));
                    vis[i][j]=1;
                }
                else {
                    vis[i][j]=0;
                }
            }
        }
        int []drow={-1,0,1,0};
        int []dcol={0,-1,0,1};
        while(!q.isEmpty()){
           int r=q.peek().r;
           int c=q.peek().c;
           int dist=q.peek().dist;
           q.poll();
           res[r][c]=dist;
           for(int i=0;i<4;i++){
             int nr=r+drow[i];
             int nc=c+dcol[i];
             if(nr>=0 && nr<m && nc>=0 && nc<n && vis[nr][nc]==0){
                q.add(new Node(nr,nc,dist+1));
                vis[nr][nc]=1;
             }
           }
        }
        return res;
    }
}