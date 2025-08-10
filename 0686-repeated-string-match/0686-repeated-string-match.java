class Solution {
    public int repeatedStringMatch(String a, String b) {
        int cnt=1;
        String cur=a;
        while(a.length()<b.length()){
            a=a+cur;
            cnt++;
            if(a.contains(b)) return cnt;
        }
         a=a+cur;
         cnt++;
         if(a.contains(b)) return cnt;
         return -1;
    }
}