class Solution {
    boolean subsetsum(int []arr,int target){
        int n=arr.length;
        boolean [][]dp=new boolean[n][target+1];
        for(int i=0;i<n;i++) dp[i][0]=true;
        if(arr[0]<=target) dp[0][arr[0]]=true;

        for(int i=1;i<n;i++){
            for(int j=1;j<=target;j++){
                boolean nottake=dp[i-1][j];
                boolean take=false;
                if(arr[i]<=j) take=dp[i-1][j-arr[i]];
                dp[i][j]=take|| nottake;
            }
        }
        return dp[n-1][target];
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums) sum+=i;
        if(sum%2==1) return false;
        else return subsetsum(nums,sum/2);
    }
}