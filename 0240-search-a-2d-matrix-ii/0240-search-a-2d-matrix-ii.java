class Solution {
    // static boolean binarysearch(int []arr,int target){
    //     int low=0,high=arr.length-1;
    //     while(low<=high){
    //         int mid=(low+high)/2;
    //         if(arr[mid]==target) 
    //            return true;
    //         else if(arr[mid]<target)
    //            low=mid+1;
    //         else 
    //            high=mid-1;
    //     }
    //     return false;
    // }
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     for(int i=0;i<matrix.length;i++){
    //         if(binarysearch(matrix[i],target)){
    //             return true;
    //         }
    //     }
    //     return false;
    // }


    
     public boolean searchMatrix(int[][] matrix, int target){
        int row=0,col=matrix[0].length-1;
        while(row<matrix.length && col>=0){
            if(matrix[row][col]==target)
               return true;
            else if(matrix[row][col]<target)
               row++;
            else 
               col--;
        }
        return false;
     }
}