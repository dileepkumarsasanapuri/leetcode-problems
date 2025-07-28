class Solution {
    public boolean wordPattern(String pattern, String s) {
     char []pat=pattern.toCharArray();
     String []st=s.split(" ");
     if(pat.length!=st.length) return false;
     Map<Character,String> map=new HashMap<>();
    
     for(int i=0;i<pat.length;i++){
        char cur=pat[i];
        String trr=st[i];
        if(map.containsKey(cur)){
            if(!map.get(cur).equals(trr)) return false;
        }
        else if(map.containsValue(trr)) return false;
        map.put(cur,trr);
     }
     return true;
    }
}