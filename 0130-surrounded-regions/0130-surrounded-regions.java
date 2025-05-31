class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int [][]vis=new int[m][n];
        int []drow={-1,0,1,0};
        int []dcol={0,-1,0,1};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || i==m-1 ||j==0 || j==n-1){
                    if(board[i][j]=='O'){
                        dfs(i,j,vis,drow,dcol,board);
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && vis[i][j]!=1){
                    board[i][j]='X';
                }
            }
        }
    }
    public void dfs(int r,int c,int [][]vis,int []drow,int []dcol,char [][]board){
        vis[r][c]=1;
        for(int i=0;i<4;i++){
            int nr=r+drow[i];
            int nc=c+dcol[i];
            if(nr>=0  && nc>=0 && nr<vis.length && nc<vis[0].length && board[nr][nc]=='O' && vis[nr][nc]!=1){
                dfs(nr,nc,vis,drow,dcol,board);
            }
        }

    }
}