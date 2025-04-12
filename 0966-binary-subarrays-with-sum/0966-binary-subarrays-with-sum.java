class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        if(goal<0) return 0;
       return helper(nums,goal)-helper(nums,goal-1);
    }
    static int helper(int []nums,int goal){
        if(goal<0) return 0;
        int l=0,r=0,sum=0,cnt=0;
        for( r=0;r<nums.length;r++){
            sum+=nums[r];
            while(sum>goal){
                sum=sum-nums[l];
                l++;
            }
            cnt=cnt+(r-l+1);
        }
        return cnt;
    }
}