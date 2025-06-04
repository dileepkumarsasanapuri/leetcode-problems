class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int []indegree=new int[numCourses];
        for(int []prereq:prerequisites){
            int cur=prereq[0];
            int pre=prereq[1];
            adj.get(pre).add(cur);
            indegree[cur]++;
        }
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.add(i);
        }
        int []topo=new int[numCourses];
        int i=0;
        while(!q.isEmpty()){
            int node =q.poll();
            topo[i++]=node;
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        if(i ==numCourses) return topo;
        else return new int[]{};
    }
}