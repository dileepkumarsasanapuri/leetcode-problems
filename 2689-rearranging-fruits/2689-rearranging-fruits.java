class Solution {
    public long minCost(int[] basket1, int[] basket2) {
       Map<Integer,Integer> count=new HashMap<>();
       int n=basket1.length;
       for(int num:basket1) count.put(num,count.getOrDefault(num,0)+1);
       for(int num:basket2) count.put(num,count.getOrDefault(num,0)-1);

       for(int val:count.values()){
        if(val%2!=0) return -1;
       }

       List<Integer> excess1=new ArrayList<>();
       List<Integer> excess2=new ArrayList<>();
       int globalMin=Integer.MAX_VALUE;
       for(int num:basket1) globalMin=Math.min(globalMin,num);
       for(int num:basket2) globalMin=Math.min(globalMin,num);

       for(Map.Entry<Integer,Integer> e: count.entrySet()){
        int fruit=e.getKey();
        int diff=e.getValue();

        if(diff>0){
            for(int i=0;i<diff/2;i++){
                excess1.add(fruit);
            }
        }
        else if(diff<0){
            for(int i=0;i<(-diff)/2;i++){
                excess2.add(fruit);
            }
        }
       }

       Collections.sort(excess1);
       Collections.sort(excess2,Collections.reverseOrder());
      
      long cost=0;
      for(int i=0;i<excess1.size();i++){
        int a=excess1.get(i);
        int b=excess2.get(i);

        cost+=Math.min(Math.min(a,b),2*globalMin);
      }
      return cost;
    }
}