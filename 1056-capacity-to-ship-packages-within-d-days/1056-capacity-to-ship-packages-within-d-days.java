class Solution {
    static int daysReq(int []arr,int cap){
        int days=1,load=0;
        for(int i=0;i<arr.length;i++){
            if(load+arr[i] > cap){
                days=days+1;
                load=arr[i];
            }
            else load +=arr[i];
        }
        return days;

    }
    public int shipWithinDays(int[] weights, int days) {
        int low=0,sum=0;
        for(int i:weights){
            sum+=i;
            low=Math.max(low,i);
        }
        int high=sum;
        while(low<=high){
            int mid=(low+high)/2;
            if(daysReq(weights,mid)<=days){
                high=mid-1;
            }
            else low=mid+1;
        }
        return low;
    }
}