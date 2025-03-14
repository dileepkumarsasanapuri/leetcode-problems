class Pair{
    int node;
    int distance;
    public Pair(int node,int distance){
        this.node=node;
        this.distance=distance;

    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y)-> x.distance-y.distance);
    int n=points.length;
    boolean []vis=new boolean[n];
    int mstCost=0;
    int edgesUsed=0;
    pq.add(new Pair(0,0));
    while(!pq.isEmpty() && edgesUsed<n){
        Pair cur=pq.poll();
        int node=cur.node;
        int wt=cur.distance;
        if(vis[node]==true){
            continue;
        }
        vis[node]=true;
        mstCost +=wt;
        edgesUsed++;
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                int dist=Math.abs(points[node][0]-points[i][0])+Math.abs(points[node][1]-points[i][1]);
                pq.add(new Pair(i,dist));
            }
        }
    }
    return mstCost;
    }
}