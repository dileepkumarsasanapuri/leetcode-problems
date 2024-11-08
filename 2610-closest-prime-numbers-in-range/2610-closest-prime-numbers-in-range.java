class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right+1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for(int i=2;i*i<=right;i++){
            if(isPrime[i]==true) for(int j=i*i;j<=right;j+=i) isPrime[j] = false;
        }
        int res[] = new int[2];
        List<Integer> primes = new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(isPrime[i]==true) primes.add(i);
        }
        int size = primes.size();
        if(size<=1) return new int[]{-1,-1};
        int minDiff = Integer.MAX_VALUE;
        for(int i=0;i<size-1;i++){
            int first = primes.get(i), second = primes.get(i+1);
            if(second-first<minDiff){
                res[0] = first; res[1] = second; minDiff = second-first;
            }
        }
        return res;
    }
}