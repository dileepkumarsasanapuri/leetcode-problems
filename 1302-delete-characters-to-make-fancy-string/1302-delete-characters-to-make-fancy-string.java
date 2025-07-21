class Solution {
    public String makeFancyString(String s) {
        StringBuilder str=new StringBuilder();
        for(char ch:s.toCharArray()){
            int l=str.length();
            if(l>=2 && str.charAt(l-1)==ch && str.charAt(l-2)==ch) continue;
            str.append(ch);
        }
        return str.toString();
    }
}