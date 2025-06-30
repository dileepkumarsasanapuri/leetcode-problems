class Solution {
    public int findLHS(int[] nums) {
        int winSt=0,len=0;
        Arrays.sort(nums);
        for(int winEnd=1;winEnd<nums.length;winEnd++){
            while(nums[winEnd]-nums[winSt]>1){
                winSt++;
            }
            if(nums[winEnd]-nums[winSt]==1){
                len=Math.max(len,winEnd-winSt+1);
            }
        }
        return len;
    }
}