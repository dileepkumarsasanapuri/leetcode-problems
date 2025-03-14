class Solution {
    private long fuelCost=0;
    public long minimumFuelCost(int[][] roads, int seats) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=roads.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int []road:roads){
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }
        dfs(0,-1,adj,seats);
        return fuelCost;

    }
    public int dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,int seats){
        int representatives=1;
        for(int neighbour:adj.get(node)){
            if(neighbour==parent) continue;
            int subtreeRep=dfs(neighbour,node,adj,seats);
            fuelCost +=Math.ceil((double)subtreeRep/seats);
            representatives+=subtreeRep;
        }
        return representatives;
    }
}