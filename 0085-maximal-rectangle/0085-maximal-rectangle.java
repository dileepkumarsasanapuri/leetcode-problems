class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length,m=matrix[0].length;
        int [][]pSum=new int[n][m];
        int maxArea=0;
        for(int j=0;j<m;j++){
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=matrix[i][j]-'0';
                if(matrix[i][j]=='0'){
                    sum=0;
                }
                pSum[i][j]=sum;
            }
        }
        for(int i=0;i<n;i++){
            maxArea=Math.max(maxArea,largestRectangleArea(pSum[i]));
        }
        return maxArea;
    }
     public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<=n;i++){
            int curht=(i==n)?0:heights[i];
            while(!st.isEmpty() && heights[st.peek()]>curht){
                int ht=heights[st.pop()];
                int width=st.isEmpty()?i:i-st.peek()-1;
                maxArea=Math.max(maxArea,ht*width);
            }
            st.push(i);
            
        }
        return maxArea;
    }
}