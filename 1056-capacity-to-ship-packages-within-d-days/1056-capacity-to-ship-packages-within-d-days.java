class Solution {
    boolean canBeshipped(int []wt,int cap,int d){
        int cur=0,used=1;
        for(int i:wt){
            if(cur+i>cap){
                used++;
                cur=0;
            }
                cur+=i;
            
        }
        return used<=d;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low=0,high=0,cap=0;
        for(int i:weights){
            high+=i;
            low=Math.max(i,low);
        }
        while(low<=high){
            int mid=(low+high)/2;
            if(canBeshipped(weights,mid,days)){
                cap=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return cap;
    }
}