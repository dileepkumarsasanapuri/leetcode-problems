class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int cnt=0;
        int []vis=new int[baskets.length];
        
        Arrays.fill(vis,-1);
        for(int i=0;i<fruits.length;i++){
            boolean flag=false;
            for(int j=0;j<baskets.length;j++){
                if(baskets[j]>=fruits[i] && vis[j]==-1){
                    vis[j]=1;
                    flag=true;
                    break;
                }
            }
            if(flag==false) cnt++;
         }
         return cnt;
    }
    
}