class Solution {
    int robbery(int []nums,int st,int end){
        int []dp=new int[end+1];
        dp[st]=nums[st];
        for(int i=st+1;i<=end;i++){
            int take=nums[i];
            if(i>1) take+=dp[i-2];
            int notake=dp[i-1];
            dp[i]=Math.max(take,notake);
        }
        return dp[end];
    }
    public int rob(int[] nums) {
     int n=nums.length;
     if(n==1) return nums[0]; 
     return Math.max(robbery(nums,0,nums.length-2),robbery(nums,1,nums.length-1));
    }
}