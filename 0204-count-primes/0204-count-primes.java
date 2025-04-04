class Solution {
    public int countPrimes(int n) {
        if(n==1) return 0;
        int []prime=new int[n];
        Arrays.fill(prime,1);
        for(int i=2;i<Math.sqrt(n);i++){
            if(prime[i]==1){
                for(int j=i*i;j<n;j=j+i){
                    prime[j]=0;
                }
            }
        }
        int cnt=0;
        for(int i=2;i<n;i++){
            if(prime[i]==1) cnt++;
        }
        return cnt;
    }
}