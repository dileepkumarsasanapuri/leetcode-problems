class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int []res=new int[nums.length-k+1];
        Deque<Integer> dq=new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            if(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
           while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
            dq.pollLast();
           } 
           dq.add(i);
           if(i>=k-1){
            res[i-k+1]=nums[dq.peekFirst()];
           }
        }
        return res;
    }
}