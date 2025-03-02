class MyStack {
    Queue<Integer> mainStack;

    public MyStack() {
        mainStack=new LinkedList<>();
    }
    
    public void push(int x) {
        mainStack.add(x);
        for(int i=0;i<mainStack.size()-1;i++){
            mainStack.add(mainStack.remove());
        }
    }
    
    public int pop() {
        return mainStack.remove();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public boolean empty() {
        if(mainStack.size()==0) return true;
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */