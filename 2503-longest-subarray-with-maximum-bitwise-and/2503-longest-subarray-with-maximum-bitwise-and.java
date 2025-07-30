class Solution {
    public int longestSubarray(int[] nums) {
      int  maxAnd=0;
      for(int i:nums){
        maxAnd=Math.max(maxAnd,i);
      }
        int res=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==maxAnd){
                int cnt=0;
                while(i<nums.length && nums[i]==maxAnd){
                    cnt++;
                    i++;
                }
                res=Math.max(res,cnt);
            }
           
        }
        return res;
    }
}