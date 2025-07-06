class Solution {
    int minPath(int [][]matrix,int [][]dp,int n){
        for(int i=0;i<n;i++){
            dp[n-1][i]=matrix[n-1][i];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int d=Integer.MAX_VALUE,l=Integer.MAX_VALUE,r=Integer.MAX_VALUE;
                d=dp[i+1][j];
                if(j<n-1) r=dp[i+1][j+1];
                if(j>0) l=dp[i+1][j-1]; 
                dp[i][j]=matrix[i][j]+Math.min(d,Math.min(l,r));
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(dp[0][i],min);
        }
        return min;
    }
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int [][]dp=new int[n][n];
        return minPath(matrix,dp,n);
    }
}