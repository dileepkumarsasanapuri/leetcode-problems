class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int []>(){
            public int compare(int []a,int []b){
              return  a[1]-b[1];
            }
        });
        int cnt=0,end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<end) {
                cnt++;
            }
            else{
                end=intervals[i][1];
            }
        }
        return cnt;
    }
}