class Solution {
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        
    
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        

        long n = Math.abs((long) dividend);
        long q = Math.abs((long) divisor);
        long ans = 0;

        while (n >= q) {
            long temp = q, multiple = 1;
            while (n >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            ans += multiple;
            n -= temp;
        }
        ans = isNegative ? -ans : ans;
        return (int) Math.min(Math.max(Integer.MIN_VALUE, ans), Integer.MAX_VALUE);
    }
}