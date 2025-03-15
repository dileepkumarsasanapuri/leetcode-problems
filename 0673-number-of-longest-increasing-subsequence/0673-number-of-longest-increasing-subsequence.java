class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int []dp=new int[n];
        int []cnt=new int[n];
        int maxLen=1,result=0;
        for(int i=0;i<n;i++){
            dp[i]=1;
            cnt[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    cnt[i]=cnt[j];
                }
                else if(nums[j]<nums[i] && dp[j]+1==dp[i]){
                    cnt[i]+=cnt[j];
                }
            }
            maxLen=Math.max(maxLen,dp[i]);
        }
        for(int i=0;i<n;i++){
            if(dp[i]==maxLen) result+=cnt[i];
        }
        return result;
    }
}