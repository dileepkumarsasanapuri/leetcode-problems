class Solution {
    public String shortestPalindrome(String s) {
        String rev=new StringBuilder(s).reverse().toString();
        String newStr=s+"#"+rev;
        // LPS 
        int n=newStr.length();
        int []lps=new int[n];
        int j=0;
        for(int i=1;i<n;i++){
            while(j>0 && newStr.charAt(i)!=newStr.charAt(j)){
                j=lps[j-1];
            }
            if(newStr.charAt(i)==newStr.charAt(j)){
                j++;
            }
            lps[i]=j;
        }

        int palinPref=lps[n-1];
        String suffix=rev.substring(0,rev.length()-palinPref);
        return suffix+s;
    }
}