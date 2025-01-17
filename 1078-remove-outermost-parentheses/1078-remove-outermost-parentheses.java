class Solution {
    public String removeOuterParentheses(String s) {
        int counter=0;
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                if(counter!=0){
                    ans.append(ch);
                }
                counter++;
            }
            else {
                counter--;
                if(counter!=0){
                    ans.append(ch);
                }
                
            }
        }
        return ans.toString();
    }
}