class Solution {
    public int[] replaceElements(int[] arr) {
        int n=arr.length;
        if(n==1) return new int[]{-1};
        int result[]=new int[n];
        result[n-1]=-1;
        for(int i=n-2;i>=0;i--){
            if(arr[i+1]>result[i+1]) result[i]=arr[i+1];
            else result[i]=result[i+1];
        }
        return result; 
    }
}