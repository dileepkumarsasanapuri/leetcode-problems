class Solution {
    int getOr(List<Integer> nums){
        int out=0;
        for(int i:nums){
            out=out|i;
        }
        return out;
    }
    public int countMaxOrSubsets(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        int maxor=0;
        for(int mask=0;mask<(1<<n);mask++){
            List<Integer> subset=new ArrayList<>();
            for(int i=0;i<n;i++){
                if((mask & (1<<i))!=0){
                    subset.add(nums[i]);
                }
            }
            int or=getOr(subset);
            maxor=Math.max(maxor,or);
            map.put(or,map.getOrDefault(or,0)+1);
        }
        return map.get(maxor);
    }
}