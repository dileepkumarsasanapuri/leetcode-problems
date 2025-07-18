class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n=s.length();
        int st=0;
        int cnt=0;
        String res="";
        for(int end=0;end<n;end++){
            if(s.charAt(end)=='1') cnt++;

            while(cnt>k){
                if(s.charAt(st)=='1') cnt--;
                st++;
            }
            while(cnt==k && s.charAt(st)=='0') st++;
            
            if(cnt==k){
                String cur=s.substring(st,end+1);
                if(res.equals("") || cur.length()<res.length() || (cur.length()==res.length() && cur.compareTo(res)<0)){
                    res=cur;
                }
            }
        }
        return res;
    }
}