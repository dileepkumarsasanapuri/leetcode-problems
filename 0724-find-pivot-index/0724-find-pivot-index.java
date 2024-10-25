
class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int leftsum=0;int totalsum=0;
        for(int i:nums){
            totalsum +=i;
        }
        for(int i=0;i<n;i++){
            leftsum +=nums[i];
            if(totalsum==leftsum) return i;
            totalsum -=nums[i];
        }
        return -1;
    }
}