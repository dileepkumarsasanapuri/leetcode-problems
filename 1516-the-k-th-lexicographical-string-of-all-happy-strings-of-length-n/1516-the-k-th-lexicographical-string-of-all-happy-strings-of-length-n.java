class Solution {
    public String getHappyString(int n, int k) {
        char[]str={'a','b','c'};
        List<String> ans=new ArrayList<>();
        getStrings(str,ans,n,new StringBuilder());
        return ans.size()<k?"":ans.get(k-1);
    }
    public void getStrings(char [] str,List<String> ans,int n,StringBuilder curr){
        if(curr.length()==n){
            ans.add(curr.toString());
            return;
        }
        
        for(char c:str){
            if(curr.length()>0 && (curr.charAt(curr.length()-1)==c))  continue;
           curr.append(c);
           getStrings(str,ans,n,curr);
           curr.deleteCharAt(curr.length()-1);
        }
    }
}