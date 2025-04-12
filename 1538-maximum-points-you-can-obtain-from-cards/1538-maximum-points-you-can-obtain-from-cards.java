class Solution {
    public int maxScore(int[] cardPoints, int k) {
       int   maxSum=0,lsum =0,rsum=0;
       for(int i=0;i<k;i++){
        lsum+=cardPoints[i];
       }
       maxSum=lsum;
       int r=cardPoints.length-1;
       for(int i=k-1;i>=0;i--){
        lsum=lsum-cardPoints[i];
        rsum=rsum+cardPoints[r];
        r--;
        maxSum=Math.max(lsum+rsum,maxSum);
       }
       return maxSum;
    }
}