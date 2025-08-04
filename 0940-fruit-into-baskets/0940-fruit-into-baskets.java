class Solution {
    public int totalFruit(int[] fruits) {
        int res=0;
        int st=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int end=0;end<fruits.length;end++){
            map.put(fruits[end],map.getOrDefault(fruits[end],0)+1);
            while(map.size()>=3){
                map.put(fruits[st],map.get(fruits[st])-1);
                if(map.get(fruits[st])==0) map.remove(fruits[st]);
                st++;
            }
 
            res=Math.max(res,end-st+1);
        }
        return res;
    }
}