class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
      return helper(nums,k)-helper(nums,k-1);
    }
    public int helper(int []nums,int k){
        int l=0;int cnt=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int r=0;r<nums.length;r++){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
         
            while(map.size()>k){
                int ln=nums[l];
               map.put(ln,map.get(ln)-1);
               if(map.get(ln)==0)
                map.remove(ln);
               l++; 
            }
           cnt+=(r-l+1);
        }
        return cnt;
    }
}