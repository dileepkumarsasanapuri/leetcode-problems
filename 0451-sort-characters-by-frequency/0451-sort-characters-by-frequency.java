class Solution {
    public String frequencySort(String s) {
       StringBuilder str=new StringBuilder();
       HashMap<Character,Integer> hm=new HashMap<>();
       for(char ch:s.toCharArray()){
        hm.put(ch,hm.getOrDefault(ch,0)+1);
       }
       List<Character> lst=new ArrayList(hm.keySet());
       lst.sort((ob1,ob2) -> hm.get(ob2)-hm.get(ob1));
       for(char ch:lst){
        for(int i=0;i<hm.get(ch);i++){
                str.append(ch);
        }
       }
       return str.toString();
    }

}