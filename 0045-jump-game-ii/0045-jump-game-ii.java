class Solution {
    public int jump(int[] nums) {
        int l=0,r=0,jumps=0;
        while(r<nums.length-1){
            int far=0;
            for(int i=l;i<=r;i++){
                far=(far>i+nums[i])? far:i+nums[i];
            }
            l=r+1;
            r=far;
            jumps++;
        }
        return jumps;
    }
}