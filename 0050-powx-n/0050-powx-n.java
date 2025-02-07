class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        double result=1;
        if(n<0){
            n=-n;
            x=1/x;
            result=x*myPow(x,n-1);
        }
        else if(n%2==0){
            result=myPow(x*x,n/2);
        }
        else{
            result=x*myPow(x,n-1);
        }
        return result;
    }
}