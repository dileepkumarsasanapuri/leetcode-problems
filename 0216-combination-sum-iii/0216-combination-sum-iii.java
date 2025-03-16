class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        getComb(1,k,n,res,new ArrayList<>());
        return res;
    }
    public void getComb(int ind,int k,int target,List<List<Integer>> res,List<Integer> ds){
        if(k==0 && target==0){
            res.add(new ArrayList<>(ds));
            return;
        }
        if(k==0 || target<0) return;
        for(int i=ind;i<=9;i++){
            ds.add(i);
            getComb(i+1,k-1,target-i,res,ds);
            ds.remove(ds.size()-1);
            // getComb(i+1,k,target,res,ds);
        }
    }
}