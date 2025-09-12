class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int [][][]dp=new int[n][2][k+1];
        return helper(0,1,k,prices,dp);
    }
    int helper(int i,int buy,int cap,int []pr,int [][][]dp){
        if(i==pr.length || cap==0) return 0;
        if(dp[i][buy][cap]!=0) return dp[i][buy][cap];
        int profit=0;
        if(buy==1){
            profit=Math.max(-pr[i]+helper(i+1,0,cap,pr,dp),helper(i+1,1,cap,pr,dp));
        }
        else{
            profit=Math.max(pr[i]+helper(i+1,1,cap-1,pr,dp),helper(i+1,0,cap,pr,dp));
        }
        return dp[i][buy][cap]=profit;
    }
}