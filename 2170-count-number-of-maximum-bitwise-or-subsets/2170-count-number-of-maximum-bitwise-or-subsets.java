class Solution {
    int maxOr=0,cnt=0;
    public int countMaxOrSubsets(int[] nums) {
       for(int i:nums){
        maxOr|=i;
       }

       backtrack(nums,0,0);
       return cnt;
    }
    void backtrack(int []nums,int ind,int cur){
        if(ind==nums.length){
            if(cur==maxOr){
                cnt++;
            }
            return;
        }

        backtrack(nums,ind+1,cur|nums[ind]);
        backtrack(nums,ind+1,cur);
    }
}