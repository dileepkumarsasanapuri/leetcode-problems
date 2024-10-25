class Solution {
    static void merge(int []nums,int low,int mid,int high){
        ArrayList<Integer> temp=new ArrayList<>();
        int left=low,right=mid+1;
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                temp.add(nums[left]);
                left++;
            }
            else{
                temp.add(nums[right]);
                right++;
            }
        }
        while(left<=mid){
            temp.add(nums[left]);
            left++;

        }
        while(right<=high){
            temp.add(nums[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            nums[i]=temp.get(i-low);
        }
    }
    static void mergesort(int []nums,int low,int high){
        if(low>=high) return;
        int mid=(low+high)/2;
        
        mergesort(nums,low,mid);
        mergesort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }
    public void sortColors(int[] nums) {
        mergesort(nums,0,nums.length-1);
    }
}