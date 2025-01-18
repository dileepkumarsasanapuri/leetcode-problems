class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        if(s.isEmpty()) return 0;
        int sign=1,index=0;
        if(s.charAt(0)=='-'){
            sign=-1;
            index++;
        }
        else if(s.charAt(0)=='+') index++;

        long result=0;
        while(index<s.length() && Character.isDigit(s.charAt(index))){
            result=result*10+(s.charAt(index)-'0');
            if(sign*result<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if(sign*result>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            index++;
        }
        return (int)(sign*result);
    }
}