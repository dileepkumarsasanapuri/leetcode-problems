class Solution {
    static int paintersAlloc(int []arr,int work){
        int pntrs=1,paintwork=0;
        for(int i=0;i<arr.length;i++){
            if(paintwork+arr[i] <=work){
                paintwork+=arr[i];
            }
            else{
                pntrs++;
                paintwork=arr[i];
            }
        }
        return pntrs;
    }
    public int splitArray(int[] nums, int k) {
         int low=0,sum=0;
        for(int i:nums){
            low=Math.max(low, i);
            sum +=i;
        }
        int high=sum;
        while(low<=high){
            int mid=(low+high)/2;
            int cntPainters=paintersAlloc(nums,mid);
            if(cntPainters > k){
                low=mid+1;
            }
            else 
                high=mid-1;
        }
        return low;
    }
}