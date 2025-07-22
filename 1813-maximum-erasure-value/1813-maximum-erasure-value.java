class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int st=0,end=0,sum=0,res=0;
        while(end<nums.length){
            while(set.contains(nums[end])){
                set.remove(nums[st]);
                sum=sum-nums[st];
                st++;
            }
            set.add(nums[end]);
            sum+=nums[end];
            res=Math.max(res,sum);

            end++;
        }

        return res;
    }
}