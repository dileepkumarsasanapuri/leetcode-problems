class Solution {
    public int lengthOfLongestSubstring(String s) {
       Set<Character> set=new HashSet<>();
       int st=0,end=0,res=0;
       char[]arr=s.toCharArray();
       while(end<arr.length){
        while(set.contains(arr[end])){
            set.remove(arr[st]);
            st++;
        }

        set.add(arr[end]);
        res=Math.max(res,set.size());
        end++;
       } 
       return res;
    }
}