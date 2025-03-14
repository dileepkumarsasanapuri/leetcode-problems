class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if(digits.length()==0) return res;
        String [] mapping={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtrack(res,mapping,digits,0,new StringBuilder());
        return res;
    }
    public void backtrack(List<String> res,String []mapping,String digits,int index,StringBuilder curr){
        if(index==digits.length()){
            res.add(curr.toString());
            return;
        }
        String letters=mapping[digits.charAt(index)-'0'];
        for(char letter:letters.toCharArray()){
            curr.append(letter);
            backtrack(res,mapping,digits,index+1,curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}