class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> path=new ArrayList<>();
        func(0,s,path,res);
        return res;
    }
    void func(int ind,String str,List<String> path,List<List<String>> res){
        if(ind==str.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=ind;i<str.length();++i){
            if(isPalin(str,ind,i)){
                path.add(str.substring(ind,i+1));
                func(i+1,str,path,res);
                path.remove(path.size()-1);
            }
        }
    }
    boolean isPalin(String s,int st,int end){
        while(st<=end){
            if(s.charAt(st++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}