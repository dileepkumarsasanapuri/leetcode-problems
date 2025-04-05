class Solution {
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