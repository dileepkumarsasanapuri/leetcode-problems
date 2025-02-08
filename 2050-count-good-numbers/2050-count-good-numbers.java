class Solution {
    private static final int Mod=1_000_000_007;
    public int countGoodNumbers(long n) {
        long even=(n+1)/2;
        long odd=n/2;
        return (int)(modularExponentiation(5,even,Mod)*modularExponentiation(4,odd,Mod)%Mod);
    }
    private long modularExponentiation(long base,long exp,int mod){
        long result=1;
        while(exp>0){
            if(exp%2==1){
                result=(result*base)%mod;
            }
            base=(base*base)%mod;
            exp=exp/2;
        }
        return result;
    }
}