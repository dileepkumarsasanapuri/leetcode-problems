class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int []> pq=new PriorityQueue<>((a,b)-> a[0]-b[0]);
        for(int i=0;i<nums.length;i++){
            pq.offer(new int[]{nums[i],i});
            if(pq.size()>k)  pq.poll();
        }
        int [][]ind=pq.toArray(new int[0][0]);
        Arrays.sort(ind,(a,b)->a[1]-b[1]);
        int []res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=nums[ind[i][1]];
        }
        return res;
    }
}