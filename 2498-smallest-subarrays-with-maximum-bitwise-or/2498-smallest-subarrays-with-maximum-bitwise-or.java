class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n=nums.length;
        int []res=new int[n];
        int last[]=new int[32];
        Arrays.fill(last,-1);
        for(int i=n-1;i>=0;i--){
            for(int b=0;b<32;b++){
                if((nums[i] & (1<<b))!=0) last[b]=i;
            }
            int far=i;
            for(int b:last){
                if(b!=-1){
                    far=Math.max(far,b);
                }
            }
            res[i]=far-i+1;
        }
        return res;
    }
}