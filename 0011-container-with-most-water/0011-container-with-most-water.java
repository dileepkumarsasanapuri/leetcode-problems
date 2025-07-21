class Solution {
    public int maxArea(int[] height) {
        int max=Integer.MIN_VALUE;
        int l=0,r=height.length-1;
        while(l<r){
            int width=Math.abs(l-r);
            int ht=Math.min(height[l],height[r]);
            max=Math.max(max,ht*width);
            if(height[l]<=height[r]) l++;
            else r--;
        }
        return max;
    }
}