class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
  } 
  static int helper(int []nums,int k){
    int l=0,sum=0,cnt=0;
    for(int r=0;r<nums.length;r++){
        sum=sum+nums[r]%2;
        while(sum>k){
            sum=sum-nums[l]%2;
            l++;
        }
        cnt=cnt+(r-l+1);
    }
    return cnt;
  }
}