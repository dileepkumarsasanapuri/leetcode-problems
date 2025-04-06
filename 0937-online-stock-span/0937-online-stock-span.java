class Pair{
    int val,ind;
    public Pair(int val,int ind){
        this.val=val;
        this.ind=ind;
    }
}
class StockSpanner {
    Stack<Pair> st;
    int cnt;
    public StockSpanner() {
        st=new Stack<>();
        cnt=-1;
    }
    
    public int next(int price) {
        cnt=cnt+1;
        while(!st.isEmpty() && st.peek().val<=price){
            st.pop();
        }
        int res=cnt-(st.isEmpty()?-1:st.peek().ind);
        st.push(new Pair(price,cnt));
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */