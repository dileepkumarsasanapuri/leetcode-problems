class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();
        int st=0,end=0;
        long sum=0,max=0;
        while(end<nums.length){
            while(set.contains(nums[end]) || set.size()>=k){
                set.remove(nums[st]);
                sum-=nums[st];
                st++;
            }

            set.add(nums[end]);
            sum+=nums[end];
            if(set.size()==k) max=Math.max(max,sum);
            end++;
        }
        return max;
    }
}