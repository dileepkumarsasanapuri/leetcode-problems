class Solution {
    public int longestSubarray(int[] nums) {
      int  maxAnd=Arrays.stream(nums).max().getAsInt();
        int res=1,cnt=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==maxAnd){
                if(nums[i]==nums[i+1]){
                    cnt++;
                }else{
                    cnt=1;
                }
            }
            res=Math.max(res,cnt);
        }
        return res;
    }
}