class Solution {
    public boolean isAnagram(String s, String t) {
     int[] check = new int[26];
       for(char c:s.toCharArray()){
        check[c-'a']++;
       }
       for(char ch:t.toCharArray()){
        check[ch-'a']--;
       }
       for(int i:check){
        if(i!=0) return false;
       }
       return true;
    }
}