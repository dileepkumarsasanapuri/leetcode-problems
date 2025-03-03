class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1) return x;
        int st=1,end=x;
        while(st<=end){
            int mid=st+(end-st)/2;
            long temp=(long)mid*mid;
            if(temp>(long)x){
                end=mid-1;
            }
            else if(temp==(long)x) return mid;
            else{
                st=mid+1;
            }
        }
        return Math.round(end);
         }
}