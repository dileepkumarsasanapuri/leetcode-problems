class Solution {
    class Pair{
        int f;int s;
        public Pair(int f,int s){
            this.f=f;
            this.s=s;
        }
    }
    class Tuple{
        int f;int s;int t;
        public Tuple(int f,int s,int t){
            this.f=f;
            this.s=s;
            this.t=t;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj=new ArrayList<>();
       
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []flight:flights){
            adj.get(flight[0]).add(new Pair(flight[1],flight[2]));
        }
        int []dist=new int[n];
        
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        Queue<Tuple> q=new LinkedList<>();
        q.add(new Tuple(0,src,0));
        while(!q.isEmpty()){
            Tuple tp=q.poll();
            int stops=tp.f;
            int node=tp.s;
            int dis=tp.t;
            if(stops>k) continue;
            for(Pair pr:adj.get(node)){
                int nei=pr.f;
                int wt=pr.s;
                if(dis+wt<dist[nei] && stops<=k){
                    dist[nei]=dis+wt;
                    q.add(new Tuple(stops+1,nei,dis+wt));
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE) return -1;
        else return dist[dst];
    }
}