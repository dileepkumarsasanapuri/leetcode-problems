class Solution {
    class Pair{
        int dis;int r;int c;
        public Pair(int dis,int r,int c){
            this.dis=dis;
            this.r=r;
            this.c=c;
        }
    }
    public int minimumEffortPath(int[][] ht) {
        int m=ht.length;
        int n=ht[0].length;
        int [][]dist=new int[m][n];
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y)->x.dis-y.dis);
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0]=0;
        pq.add(new Pair(0,0,0));
        int []dr={0,-1,0,1};
        int []dc={1,0,-1,0};
        while(pq.size()!=0){
            Pair pr=pq.poll();
            int diff=pr.dis,r=pr.r,c=pr.c;
            if(r==m-1 && c==n-1) return diff;
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    int newEffort=Math.max(diff,Math.abs(ht[r][c]-ht[nr][nc]));
                    if(newEffort < dist[nr][nc]){
                        dist[nr][nc]=newEffort;
                        pq.add(new Pair(newEffort,nr,nc));

                    }
                }
            }
           
        }
         return 0;
    }
}