class Solution {
    int n;
    int [][] fruits;
    int [][]dp1;
    int [][]dp2;
    public int maxCollectedFruits(int[][] fruits) {
        this.n=fruits.length;
        this.dp1=new int[n][n];
        this.dp2=new int[n][n];
        this.fruits=fruits;
        for(int []row:dp1) Arrays.fill(row,-1);
        for(int []row:dp2) Arrays.fill(row,-1);
        
        int res=0;
        for(int i=0;i<n;i++){
            res+=fruits[i][i];
        }

        res+=solveTopright(0,n-1);
        res+=solveBottomLeft(n-1,0);

        return res;
    }
    
    int solveTopright(int i,int j){
        if(i==n-1 && j==n-1) return 0;
        if(i>=j) return 0;
        if(dp1[i][j]!=-1) return dp1[i][j];

        int max=0,cur=fruits[i][j];
        if(j-1>=0) max=Math.max(max,cur+solveTopright(i+1,j-1));
        if(i+1<n) max=Math.max(max,cur+solveTopright(i+1,j));
        if(j+1<n) max=Math.max(max,cur+solveTopright(i+1,j+1));
        return dp1[i][j]=max;
    }

    int solveBottomLeft(int i,int j){
        if(i==n-1 && j==n-1) return 0;
        if(i<=j) return 0;
        if(dp2[i][j]!=-1) return dp2[i][j];

        int max=0,cur=fruits[i][j];
        if(i+1<n) max=Math.max(max,cur+solveBottomLeft(i+1,j+1));
        if(j+1<n) max=Math.max(max,cur+solveBottomLeft(i,j+1));
        if(i-1>=0) max=Math.max(max,cur+solveBottomLeft(i-1,j+1));

        return dp2[i][j]=max;
    }

}