class Solution {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> ans=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                map.put(nums[i][j],map.getOrDefault(nums[i][j],0)+1);
            }
        }
        for(int key:map.keySet()){
            if(map.get(key)==nums.length){
                ans.add(key);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}