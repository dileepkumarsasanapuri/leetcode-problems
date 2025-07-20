class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int n=nums.length;
      int lt[]=Arrays.copyOfRange(nums,0,n/2);
      int []rt=Arrays.copyOfRange(nums,n/2,n);
      Set<Integer> leftset=Subsum(lt);
      Set<Integer> rightSet=Subsum(rt);
      TreeSet<Integer> ts=new TreeSet<>(rightSet);
      int ans=Math.abs(goal);
      for(int left:leftset){
        int right=goal-left;
        if(ts.contains(right)){
            return 0;
        }
        Integer r1=ts.lower(right);
        Integer r2=ts.higher(right);
        if(r1!=null){
            ans=Math.min(ans,Math.abs(left+r1-goal));
        }
        if(r2!=null){
            ans=Math.min(ans,Math.abs(left+r2-goal));
        }
      }
      return ans;
    }
    Set<Integer> Subsum(int []nums){
        int n=nums.length;
        Set<Integer> subs=new HashSet<>();
        for(int mask=0;mask<(1<<n);mask++){
            int sum=0;
            for(int i=0;i<n;i++){
                if((mask & (1<<i))!=0){
                    sum+=nums[i];
                }
            }
            subs.add(sum);
        }
        return subs;
    }
}