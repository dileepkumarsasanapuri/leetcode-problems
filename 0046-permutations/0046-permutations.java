class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        boolean []freq=new boolean[nums.length];
        helper(nums,freq,res, new ArrayList<>());
        return res;
    }
    public void helper(int []nums,boolean []freq,List<List<Integer>> res,ArrayList<Integer> ds){
        if(ds.size()==nums.length){
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                freq[i]=true;
                ds.add(nums[i]);
                helper(nums,freq,res,ds);
                ds.remove(ds.size()-1);
                freq[i]=false;
            }
        }
    }
}