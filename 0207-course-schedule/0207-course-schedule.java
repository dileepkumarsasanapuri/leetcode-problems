class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        int indegree[]=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int []prereq:prerequisites){
            int course=prereq[0];
            int pre=prereq[1];
            adj.get(pre).add(course);
            indegree[course]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int cnt=0;
        while(!q.isEmpty()){
            int cur=q.poll();
            cnt++;
            for(int neighbour:adj.get(cur)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    q.add(neighbour);
                }
            }
        }
        return cnt==numCourses;
    }
}