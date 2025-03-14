class Solution {
    private int gcd(int a,int b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }
    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        int gcdVal=numsDivide[0];
        for(int n:numsDivide){
            gcdVal=gcd(gcdVal,n);
        }
        for(int i=0;i<nums.length;i++){
            if(gcdVal%nums[i]==0){
                return i;
            }
        }
        return -1;
    }
}