class Solution {
    public long subArrayRanges(int[] nums) {
        int []nse=findNSE(nums);
        int []pse=findPSE(nums);
        int []nge=findNGE(nums);
        int []pge=findPGE(nums);

        long minSum=0l,maxSum=0l;
        for(int i=0;i<nums.length;i++){
            minSum+=(i-pse[i])*1l*(nse[i]-i)*nums[i];
            maxSum+=(i-pge[i])*1l*(nge[i]-i)*nums[i];
        }
        return maxSum-minSum;
    }

    public int [] findNSE(int []arr){
        int []nse=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nse[i]=st.isEmpty()?arr.length:st.peek();
            st.push(i);
        }
        return nse;
     }
    public int []findPSE(int[]arr){
          int n=arr.length;
          Stack<Integer> st=new Stack<>();
          int []pse=new int[n];
          for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i])
               st.pop();
            pse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
          }
          return pse;
    } 
      public int [] findNGE(int []arr){
        int []nse=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            nse[i]=st.isEmpty()?arr.length:st.peek();
            st.push(i);
        }
        return nse;
     }
    public int []findPGE(int[]arr){
          int n=arr.length;
          Stack<Integer> st=new Stack<>();
          int []pse=new int[n];
          for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i])
               st.pop();
            pse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
          }
          return pse;
    } 
}