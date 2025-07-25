class Solution {
    public int maxSum(int[] nums) {
       int max=Integer.MIN_VALUE;
       int sum=0;
       Set<Integer> set=new HashSet<>();
       for(int i:nums){
        if(!set.contains(i)){
            if(i>=0){
                sum+=i;
            }
            else{
                max=Math.max(max,i);
            }
        }
         set.add(i);
       }
       if(sum==0 && !set.contains(0)) return max;
       return sum;
    }
}