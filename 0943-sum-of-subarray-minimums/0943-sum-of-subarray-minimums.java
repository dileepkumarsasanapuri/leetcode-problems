class Solution {
public int sumSubarrayMins(int[] arr) {
    int[] nse = findNSE(arr);
    int[] pse = findPSE(arr);
    long total = 0;
    final int mod = 1_000_000_007;

    for (int i = 0; i < arr.length; i++) {
        int left = i - pse[i];
        int right = nse[i] - i;
        long contrib = ((long) left * right % mod) * arr[i] % mod;
        total = (total + contrib) % mod;
    }

    return (int) total;
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
}