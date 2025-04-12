class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,maxf=0,maxlen=0,r=0;
        int []hash=new int[26];
        while(r<s.length()){
            char cur=s.charAt(r);
            hash[cur-'A']++;
            maxf=Math.max(maxf,hash[cur-'A']);
            while((r-l+1-maxf)>k){
                hash[s.charAt(l)-'A']--;
                maxf=0;
                for(int i:hash){
                    maxf=Math.max(maxf,i);
                }
                l=l+1;
            }
            if((r-l+1-maxf)<=k){
                maxlen=Math.max(maxlen,r-l+1);
            }
            r++;
        }
        return maxlen;
    }
}