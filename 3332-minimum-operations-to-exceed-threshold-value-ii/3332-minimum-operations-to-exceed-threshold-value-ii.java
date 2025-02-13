class Solution {
    public int minOperations(int[] nums, int k) {
         PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i:nums){
            pq.add((long)i);
        }
        int ops=0;
        while(pq.size()>1 && pq.peek()<k){
            
            long a= pq.poll();
            long b = pq.poll();
            long sum=b+(2*a);
            pq.add(sum);
            ops++;
            
        }
        return ops;
    }
}