class Tasks{
    int user,task,pr;
    public Tasks(int user,int task,int pr){
        this.user=user;
        this.task=task;
        this.pr=pr;
    }
}
class TaskManager {

    Map<Integer,Tasks> map;
    TreeMap<Integer,PriorityQueue<Integer>> prmap;
    public TaskManager(List<List<Integer>> tasks) {
        map=new HashMap<>();
        prmap=new TreeMap<>();
        for(List<Integer> t:tasks){
            int u=t.get(0),ts=t.get(1),p=t.get(2);
            Tasks cur=new Tasks(u,ts,p);
            add(u,ts,p);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Tasks cur=new Tasks(userId,taskId,priority);
        map.put(taskId,cur);
        prmap.putIfAbsent(priority,new PriorityQueue<>(Collections.reverseOrder()));
        prmap.get(priority).add(taskId);

    }
    
    public void edit(int taskId, int newPriority) {
        Tasks cur=map.get(taskId);
        map.put(taskId,new Tasks(cur.user,taskId,newPriority));
        int p=cur.pr;
        prmap.get(p).remove(taskId);

        if(prmap.get(p).isEmpty()) prmap.remove(p);

        prmap.putIfAbsent(newPriority,new PriorityQueue<>(Collections.reverseOrder()));
        prmap.get(newPriority).add(taskId);
    }
    
    public void rmv(int taskId) {
        int p=map.get(taskId).pr;
        map.remove(taskId);
        prmap.get(p).remove(taskId);
        if(prmap.get(p).isEmpty()) prmap.remove(p);
    }
    
    public int execTop() {
        if(prmap.isEmpty()) return -1;
        int key=prmap.lastKey();
        int taskId=prmap.get(key).poll();
        if(prmap.get(key).isEmpty()) prmap.remove(key);
        int userId=map.get(taskId).user;
        map.remove(taskId);
        return userId;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */