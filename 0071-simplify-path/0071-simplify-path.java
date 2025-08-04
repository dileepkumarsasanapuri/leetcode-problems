class Solution {
    public String simplifyPath(String path) {
        String []arr=path.split("/");
        Stack<String> st=new Stack<>();
        for(String cur:arr){
            if(cur.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else if(!cur.equals("") && !cur.equals(".")){
                st.push(cur);
            }
        }
        return "/"+String.join("/",st);
    }
}