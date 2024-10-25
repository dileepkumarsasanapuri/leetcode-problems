class Solution {
    public void rotate(int []nums , int k){
        int n=nums.length;
        k=k%n;
        int []temp=new int[n];
         for(int i=0;i<n;i++){
            temp[i]=nums[(i+n-k)%n];
         }
         for(int i=0;i<n;i++){
            nums[i]=temp[i];
         }
    }
    // public void rotate(int[] nums, int k) {
    //     int n=nums.length;
    //     while(k>0){
    //         int temp=nums[n-1];
    //         for(int i=0;i<n-1;i++){
    //            nums[n-i-1]=nums[n-i-2];
    //         }
    //         nums[0]=temp;
    //       k--;
    //     }
    // }

    // public void rotate(int []nums,int k){
    //     int n=nums.length;
    //     k=k%n;
    //     reverse(nums,0,n-1);
    //     reverse(nums,0,k-1);
    //     reverse(nums,k,n-1);
    // }
    // public void reverse(int [] nums,int start,int end){
    //     while(start<end){
    //         int temp=nums[start];
    //         nums[start]=nums[end];
    //         nums[end]=temp;
    //         start++;
    //         end--;
    //     }
    // }
}