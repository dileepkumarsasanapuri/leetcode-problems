class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxlen=0;
        int numflipped=0;
        int windowstart=0;
        for(int windowend=0;windowend < nums.length;windowend++){
            if(nums[windowend]==0){
                numflipped++;
            }
            while(numflipped>k){
                if(nums[windowstart]==0) {
                    numflipped--;
                }
                windowstart++;
            }
            maxlen=Math.max(maxlen,windowend-windowstart+1);
        }
        return maxlen;
    }
}