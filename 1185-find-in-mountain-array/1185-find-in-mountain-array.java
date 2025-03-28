/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n=mountainArr.length();
        int peak=findPeak(mountainArr,n);
        int index=binarySearch(mountainArr,target,0,peak,true);
        if(index!=-1) return index;
        return binarySearch(mountainArr,target,peak+1,n-1,false);

    }
    private int findPeak(MountainArray mountArr,int n){
        int left=0,right=n-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(mountArr.get(mid)<mountArr.get(mid+1)){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        return left;
    }
    private int binarySearch(MountainArray mountArr,int target,int left,int right,boolean ascending){
        while(left<=right){
            int mid=left+(right-left)/2;
            int midval=mountArr.get(mid);
            if(midval==target) return mid;
            if(ascending){
                if(midval < target) left=mid+1;
                else right=mid-1;
            }
            else{
                if(midval > target) left=mid+1;
                else right=mid-1;
            }
        }
        return -1;
    }
}