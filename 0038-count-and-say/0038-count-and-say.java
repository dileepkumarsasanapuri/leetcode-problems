class Solution {
    public String countAndSay(int n) {
        String res="1";
        for(int i=1;i<n;i++){
            StringBuilder temp=new StringBuilder();
            int cnt=1;
            for(int j=1;j<res.length();j++){
                if(res.charAt(j)==res.charAt(j-1)) cnt++;
                else{
                    temp.append(cnt).append(res.charAt(j-1));
                    cnt=1;
                }
            }
            temp.append(cnt).append(res.charAt(res.length()-1));
            res=temp.toString();
        }
        return res;
    }
}