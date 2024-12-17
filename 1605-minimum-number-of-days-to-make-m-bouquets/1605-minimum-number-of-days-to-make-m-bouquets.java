class Solution {
    static int[] min_max(int []arr){
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(int i:arr){
            max=Math.max(max,i);
            min=Math.min(min,i);
        }
        return new int[]{min,max};

    }
    static boolean isPossible(int []arr,int day,int m,int k){
        int cnt=0,boquets=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=day) cnt++;
            else{
                boquets += cnt/k;
                cnt=0;
            }
        }
        boquets += (cnt/k);
        if(boquets >= m) return true;
        else return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        long val=(long)m*k;
        if(bloomDay.length < val) return -1;
        int[]minmax=min_max(bloomDay);
        int low=minmax[0],high=minmax[1];
        while(low<=high){
            int mid=(low+high)/2;
            if(isPossible(bloomDay,mid,m,k)==true)
             high=mid-1;
            else
            low=mid+1;
        }
        return low;
    }
}