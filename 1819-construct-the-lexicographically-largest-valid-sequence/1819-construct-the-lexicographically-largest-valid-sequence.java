class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res=new int[2*n-1];
        
        boolean hs[]=new boolean[n+1];
        helper(res,0,hs,n);
        return res;
    }
    public boolean helper(int []res,int index,boolean[] hs,int n){
        while(index<res.length && res[index]!=0) index++;
        if(index==res.length){
            return true;
        }
        for(int i=n;i>0;i--){
            if(hs[i])
             continue;
            if(i>1 && (index+i>=res.length || res[i+index]!=0))
             continue;
            
            res[index]=i;
           if(i>1) res[index+i]=i;
           hs[i]=true;
            if(helper(res,index+1,hs,n))
              return true;
            
            res[index]=0;
            if (i>1){
                res[index+i]=0;
            }
            hs[i]=false;
        }
        return false;
    }
}