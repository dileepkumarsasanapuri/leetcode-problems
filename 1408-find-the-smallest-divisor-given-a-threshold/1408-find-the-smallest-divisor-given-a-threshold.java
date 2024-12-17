class Solution {
    static int sumofDivisors(int []arr,int div){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum +=Math.ceil((double)arr[i]/(double)div);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=0;
        for(int i:nums){
            high=Math.max(high,i);
        }
        while(low<=high){
            int mid=(low+high)/2;
            if(sumofDivisors(nums,mid)<=threshold)
               high=mid-1;
            else 
               low=mid+1;
        }
        return low;
    }
}