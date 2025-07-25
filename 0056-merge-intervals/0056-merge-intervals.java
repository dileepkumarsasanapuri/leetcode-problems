class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });

        int [][]res=new int[n][2];
        res[0]=intervals[0];
        int end=0;
        for(int i=1;i<n;i++){
            if(intervals[i][0]<=res[end][1]){
                res[end][1]=Math.max(res[end][1],intervals[i][1]);
            }
            else{
                end++;
                res[end]=intervals[i];
            }
        }
        return Arrays.copyOfRange(res,0,end+1);
    }
}