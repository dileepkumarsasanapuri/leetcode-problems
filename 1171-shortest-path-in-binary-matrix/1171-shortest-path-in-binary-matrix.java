class Solution {
    class Pair{
        int f,s,t;
        public Pair(int f,int s,int t){
            this.f=f;
            this.s=s;
            this.t=t;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;        
        if(grid[0][0]==1 || grid[m-1][n-1]==1) return -1;
        

        int [][]dist=new int[m][n];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=1;
        q.add(new Pair(1,0,0));
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
             
        while(!q.isEmpty()){
            Pair p=q.poll();
            int r=p.s;
            int c=p.t;
            int dis=p.f;

            if(r==m-1 && c==n-1) return dis;
            for(int d=0;d<8;d++){
                int nr=r+dx[d],nc=c+dy[d];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==0 && dis+1 < dist[nr][nc]){
                    dist[nr][nc]=dis+1;
                    q.add(new Pair(dis+1,nr,nc));
                    }
            }
        }
        return -1;
    }
}