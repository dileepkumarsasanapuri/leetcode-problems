class Solution {
    public double soupServings(int n) {
        if(n>4800) return 1.0;
        double [][]dp=new double[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(n,n,dp);
    }

    double fun(int a,int b,double [][]dp){
        if(a<=0 && b>0) return 1.0;
        if((a==0 && b==0) ||( a<=0 && b<=0)) return 0.5;
        if(a>0 && b<=0) return 0.0;
        if(dp[a][b]!=-1) return dp[a][b];
        double x=0.25*fun(a-100,b,dp);
        double y=0.25*fun(a-75,b-25,dp);
        double z=0.25*fun(a-50,b-50,dp);
        double w=0.25*fun(a-25,b-75,dp);
        return dp[a][b]=w+x+y+z;
    }
}