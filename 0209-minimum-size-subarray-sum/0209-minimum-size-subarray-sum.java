class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0,len=Integer.MAX_VALUE,sum=0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            while(sum>=target){
                len=Math.min(len,r-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return len==Integer.MAX_VALUE?0:len;
    }
}