class ZeroEvenOdd {
    private int n;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }
    private boolean zeroturn=true;
    private boolean eventurn=false;
    private boolean oddturn=false;

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i++){
            if(!zeroturn){
                wait();
            }
            if(i%2==0){
                eventurn=true;
                oddturn=false;
            }
            else{
                oddturn=true;
                eventurn=false;
            }
            printNumber.accept(0);
            zeroturn=false;
            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2;i<=n;i+=2){
            while(!eventurn){
                wait();
            }
            eventurn=false;
            zeroturn=true;
            printNumber.accept(i);
            notifyAll();
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i+=2){
            while(!oddturn){
                wait();
            }
            oddturn=false;
            zeroturn=true;
            printNumber.accept(i);
            notifyAll();
        }
    }
}