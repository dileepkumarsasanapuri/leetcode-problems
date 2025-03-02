import java.util.Stack;

class MyQueue {
    Stack<Integer> Q;

    public MyQueue() {
        Q = new Stack<>();
    }

    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        while (!Q.isEmpty()) {
            temp.push(Q.pop());
        }
        Q.push(x);
        while (!temp.isEmpty()) {
            Q.push(temp.pop());
        }
    }

    public int pop() {
        return Q.isEmpty() ? -1 : Q.pop();
    }

    public int peek() {
        return Q.isEmpty() ? -1 : Q.peek();
    }

    public boolean empty() {
        return Q.isEmpty();
    }
}
