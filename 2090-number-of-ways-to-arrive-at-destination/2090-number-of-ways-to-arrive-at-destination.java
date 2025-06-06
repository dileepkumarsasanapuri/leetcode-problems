class Solution {
    class Pair{
        int f;long s;
        Pair(int f,long s){
            this.f=f;
            this.s=s;
        }
    }
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int []road:roads){
            adj.get(road[0]).add(new Pair(road[1],road[2]));
            adj.get(road[1]).add(new Pair(road[0],road[2]));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->Long.compare(x.s,y.s));
        long []dist=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        int []ways=new int[n];
        Arrays.fill(ways,0);
        dist[0]=0;
        ways[0]=1;
        int mod=(int)(1e9+7);
        pq.add(new Pair(0,0L));
        while(pq.size()!=0){
            Pair pr=pq.poll();
            int node=pr.f;
            long dis=pr.s;
            if(dis>dist[node]) continue;
            for(Pair pp:adj.get(node)){
                int nei=pp.f;
                long wt=pp.s;
                if(dis+wt<dist[nei]){
                    dist[nei]=dis+wt;
                    pq.add(new Pair(nei,dist[nei]));
                    ways[nei]=ways[node];
                }
                else if(dis+wt==dist[nei]){
                    ways[nei]=(ways[nei]+ways[node])%mod;
                }
            }
        }
        return ways[n-1]%mod;
    }
}