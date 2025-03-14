class Solution {
    public int trap(int[] height) {
        if(height==null || height.length<3) return 0;
        int left=0,right=height.length-1,lMax=0,rMax=0,totalWater=0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>=lMax){
                    lMax=height[left];
                }
                else{
                    totalWater+=lMax-height[left];
                }
                left++;
            }
            else{
                if(height[right]>=rMax){
                    rMax=height[right];
                }
                else{
                    totalWater += rMax-height[right];
                }
                right--;
            }
        }
        return totalWater;
    }
}