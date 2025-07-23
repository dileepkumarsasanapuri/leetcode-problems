class Solution {
    public int maximumGain(String s, int x, int y) {
        StringBuilder sb=new StringBuilder(s);
        if(x<y){
            return helper(sb,y,"ba")+helper(sb,x,"ab");
        }
        return helper(sb,x,"ab")+helper(sb,y,"ba");
    }

    int helper(StringBuilder sb,int x,String s){
        Stack<Character> st=new Stack<>();
        int ans=0;
        for( char ch:sb.toString().toCharArray()){
            if(!st.isEmpty() && st.peek()==s.charAt(0) && ch==s.charAt(1) ){
                ans+=x;
                st.pop();
            }
            else{
                st.push(ch);
            }
        }

        sb.delete(0,sb.length());
        while(!st.isEmpty()){
            sb.insert(0,st.pop());
        }
        return ans;
    }

}
