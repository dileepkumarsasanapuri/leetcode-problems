class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        generate(nums,result,0,subset );
        return result;
    }
    public void generate(int []nums,List<List<Integer>> res,int index,List<Integer> subset){
        if(index==nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        generate(nums,res,index+1,subset);
        subset.remove(subset.size()-1);
        generate(nums,res,index+1,subset);
    }
}