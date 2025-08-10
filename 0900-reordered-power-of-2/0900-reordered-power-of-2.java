class Solution {
   
    void counter(int n,Map<Integer,Integer> map){
        while(n>0){
            int cur=n%10;
            map.put(cur,map.getOrDefault(cur,0)+1);
            n=n/10;
        }
    }
    public boolean reorderedPowerOf2(int n) {
         Map<Integer,Integer> map=new HashMap<>();
         counter(n,map);

         int limit=(int)Math.pow(10,map.size());
         
         for(int i=0;i<(int)Math.sqrt(limit);i++){
            Map<Integer,Integer> mapp=new HashMap<>();
            counter((int)Math.pow(2,i),mapp);
            if(map.equals(mapp)) return true;
         }
         
        return false;
    }
}