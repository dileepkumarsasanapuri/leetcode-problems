class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n=nums.length;
        int []ans=new int[n];
        int []or=nums.clone();
        for(int i=0;i<n;i++){
            int x=nums[i];
            ans[i]=1;
            for(int j=i-1;j>=0;j--){
                if((or[j]|x)==or[j])  break;
            or[j]=or[j]|x;
            ans[j]=i-j+1;
            }
        }
            return ans;
    }

}