class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int cur=image[sr][sc];
        int [][]res=image;
        int []drow={-1,0,1,0};
        int []dcol={0,-1,0,1};
        dfs(image,res,sr,sc,drow,dcol,color,cur);
        return  res;
    }
    public void dfs(int [][]img,int [][]res,int sr,int sc,int []drow,int []dcol,int color,int cur){
        res[sr][sc]=color;
        int m=img.length;
        int n=img[0].length;
        for(int i=0;i<4;i++){
            int nr=sr+drow[i];
            int nc=sc+dcol[i];
            if(nr>=0 && nr<m && nc>=0 && nc<n && img[nr][nc]==cur && img[nr][nc]!=color){
                dfs(img,res,nr,nc,drow,dcol,color,cur);
            }
        }
    }
}