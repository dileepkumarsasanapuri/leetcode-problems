class Solution {
    int result=0;
    public int punishmentNumber(int n) {
        for(int i=1;i<=n;i++){
            int prod=i*i;
            String str=String.valueOf(prod);
            if(canPartition(str,i,0,0)){
                result+=prod;
            }
            
        }
        return result;
    }
    public boolean canPartition(String str,int target,int index,int currentsum){
        if(index==str.length()){
            return currentsum==target;
        }
        int num=0;
        for(int i=index;i<str.length();i++){
            num=num*10+(str.charAt(i)-'0');
            if(canPartition(str,target,i+1,currentsum+num)){
                return true;
            }
        }
        return false;
    }
}