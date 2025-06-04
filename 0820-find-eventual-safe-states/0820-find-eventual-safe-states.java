class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v=graph.length;
        int[]indegree=new int[v];
        List<List<Integer>> adjR=new ArrayList<>();
        for(int i=0;i<v;i++){
            adjR.add(new ArrayList<>());
        }
        for(int i=0;i<v;i++){
            for(int it:graph[i]){
                adjR.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> safe=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            safe.add(node);
            for(int it:adjR.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        Collections.sort(safe);
        return safe;
    }
}