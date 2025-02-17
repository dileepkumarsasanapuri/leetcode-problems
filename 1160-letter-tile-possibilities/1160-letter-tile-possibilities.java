class Solution {
    public int numTilePossibilities(String tiles) {
        int []freq=new int[26];
        for(char c:tiles.toCharArray()){
            freq[c-'A']++;
        }
        return dfs(freq);
    }
    private int dfs(int []freq){
        int cnt=0;
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                cnt++;
                freq[i]--;
                cnt+=dfs(freq);
                freq[i]++;
            }
        }
        return cnt;
    }
}