class Solution {
    public double myPow(double x, int exp) {
        if(exp==0) return 1;
        double result=1;
        long n=exp;
        if(n<0){
            x=1/x;
            n=-n;
        }
        while(n>0){
            if(n%2==1){
                result=result*x;
                n=n-1;
            }
            else{
                x=x*x;
                n=n/2;
            }
        }
        return result;
}
}