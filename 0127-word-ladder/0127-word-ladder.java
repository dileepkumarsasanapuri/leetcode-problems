class Pair{
    String str;
    int steps;
    public Pair(String str,int steps){
        this.str=str;
        this.steps=steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Set<String> st=new HashSet<>();
        int length=wordList.size();
        for(String sr:wordList){
            st.add(sr);
        }
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word=q.peek().str;
            int steps=q.peek().steps;
            q.remove();
            if(word.equals(endWord)) return steps;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char []arr=word.toCharArray();
                    arr[i]=ch;
                    String rp=new String(arr);
                    if(st.contains(rp)){
                        st.remove(rp);
                        q.add(new Pair(rp,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}