class Solution {
     private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    private void helper(int[] nums, int ind, List<List<Integer>> res) {
        if(ind == nums.length) {
            ArrayList<Integer> t = new ArrayList<>();
            for(int num: nums) t.add(num);
            res.add(t);
            return;
        }
        for(int i=ind;i<nums.length;i++) {
            swap(nums, i, ind);
            helper(nums, ind+1, res);
            swap(nums, i, ind);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, res);
        return res;
    }
}
    // public List<List<Integer>> permute(int[] nums) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     boolean freq[]=new boolean[nums.length];
    //     getpermutations(nums,freq,res,new ArrayList<>());
    //     return res;
    // }
    // static void getpermutations(int []arr,boolean []freq,List<List<Integer>> ans,ArrayList<Integer> ds){
    //     if(ds.size()==arr.length){
    //         ans.add(new ArrayList<>(ds));
    //         return;
    //     }
    //     for(int i=0;i<arr.length;i++){
    //         if(!freq[i]){
    //             freq[i]=true;
    //             ds.add(arr[i]);
    //             getpermutations(arr,freq,ans,ds);
    //             ds.remove(ds.size()-1);
    //             freq[i]=false;
    //         }

    //     }
    // }



