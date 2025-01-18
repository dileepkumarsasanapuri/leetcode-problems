class Solution {
    public int maxDepth(String s) {
        int count=0,max_num=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                count++;
                if(count>max_num) max_num=count;
            }
            if(ch==')'){
                count--;
            }
        }
        return max_num;
    }
}