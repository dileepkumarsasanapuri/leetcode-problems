class Solution {
    int [] seg;
    void buildTree(int []arr,int node,int l,int r){
        if(l==r){
            seg[node]=arr[l];
            return;
        }
        else{
            int mid=(l+r)/2;
            buildTree(arr,2*node+1,l,mid);
            buildTree(arr,2*node+2,mid+1,r);
            seg[node]=Math.max(seg[2*node+1],seg[2*node+2]);
        }
    }
    
    int query(int node,int st,int end,int fruit){
        if(seg[node]<fruit) return -1;
        if(st==end){
            seg[node]=-1;
            return st;
        }

        int mid=(st+end)/2;
        int pos=-1;
        if(seg[2*node+1]>=fruit){
            pos=query(2*node+1,st,mid,fruit);
        }
        else{
            pos=query(2*node+2,mid+1,end,fruit);
        }

        seg[node]=Math.max(seg[2*node+1],seg[2*node+2]);
        return pos;
    }
    

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n=fruits.length;
        seg=new int[4*n];
        buildTree(baskets,0,0,n-1);
        int ans=0;
        for(int i=0;i<n;i++){
            int pos=query(0,0,n-1,fruits[i]);
            if(pos==-1) ans++;
        }
        return ans;
    }
}