class Solution {
    public int calculate(String s) {
        Stack<Integer>stack = new Stack<>();
        int num=0,res=0,sign=1;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+(c-'0');
            }
            else if(c=='+'){
                res=res+(sign*num);
                num=0;
                sign=1;
            }
            else if(c=='-'){
                res=res+(sign*num);
                num=0;
                sign=-1;
            }
            else if(c=='('){
                stack.push(res);
                stack.push(sign);
                num=0;
                res=0;
                sign=1;
            }
            else if(c==')'){
                res=res+(sign*num);
                num=0;
                int prevSign=stack.pop();
                int prevRes=stack.pop();
                res=prevRes+prevSign*res;
            }
        }
        res=res+sign*num;
        return res;
    }
}