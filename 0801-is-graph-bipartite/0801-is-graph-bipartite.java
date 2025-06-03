class Solution {
    public boolean isBipartite(int[][] graph) {
       int v=graph.length;
       int []color=new int[v];
       for(int i=0;i<v;i++) color[i]=-1;
       for(int i=0;i<v;i++){
        if(color[i]==-1){
            if(dfs(i,0,color,graph)==false) return false;
        }
       }
       return true;
    }
    private boolean dfs(int node,int col,int []color,int [][]graph){
        color[node]=col;
        for(int i:graph[node]){
                if(color[i]==-1){
                    if(dfs(i,1-col,color,graph)==false)
                      return false;
                }
                else if(color[i]==col) return false;
            }
        return true;
    }
}