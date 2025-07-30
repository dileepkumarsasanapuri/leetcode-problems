class Solution {
    int maxAnd=0,res=0;
    void helper(int []nums,int ind,int cur){
        if(ind==nums.length){
            if(cur==maxAnd) res++;
            return ;
        }
        helper(nums,ind+1,nums[ind]);
        // helper(nums,ind+1,cur);
    }
    public int longestSubarray(int[] nums) {
        maxAnd=Arrays.stream(nums).max().getAsInt();
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