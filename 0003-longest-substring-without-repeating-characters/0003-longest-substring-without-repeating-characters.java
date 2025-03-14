class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int maxLen=0;
        int left=0;
        for(int right=0;right<s.length();right++){
            char cur=s.charAt(right);
            if(map.containsKey(cur)){
                left=Math.max(left,map.get(cur)+1);
            }
            map.put(cur,right);
            maxLen=Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
}