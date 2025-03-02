class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='{' || c=='[' || c=='('){
                st.push(c);
            }
            else {
               switch(c){
                case ')':
                   if(st.isEmpty() || st.peek()!='(') return false;
                   else st.pop();
                   break;
                case ']':
                   if(st.isEmpty() || st.peek()!='[') return false;
                   else st.pop();
                   break;
                case '}':
                   if(st.isEmpty() || st.peek()!='{') return false;
                   else st.pop();
                    break;
               }
            }
        }
        return st.isEmpty();
    }
}