class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int []freq=new int[256];
        int l=0,r=0,cnt=0,minlen=Integer.MAX_VALUE,sInd=-1;

        for(int i=0;i<t.length();i++){
            freq[t.charAt(i)]++;
        }

        while(r<s.length()){
            char ch=s.charAt(r);
            if(freq[ch]>0) 
               cnt=cnt+1;
            freq[ch]--;
            while(cnt==t.length()){
                if(r-l+1 < minlen){
                    minlen=r-l+1;
                    sInd=l;
                }
                freq[s.charAt(l)]++;
                if(freq[s.charAt(l)] >0){
                    cnt=cnt-1;
                }
                l++;
            }
            r=r+1;
        }
        return sInd==-1?"":s.substring(sInd,sInd+minlen);
    }
}