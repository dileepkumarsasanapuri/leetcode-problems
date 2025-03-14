class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        int []indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] pre:prerequisites){
            int course=pre[0];
            int prereq=pre[1];
            adj.get(prereq).add(course);
            indegree[course]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int []order=new int[numCourses];
        int index=0;
        while(!q.isEmpty()){
            int cur=q.poll();
            order[index++]=cur;
            for(int neighbour:adj.get(cur)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    q.add(neighbour);
                }
            }
        }
        if(index==numCourses) return order;
        else return new int[]{};
    }
}