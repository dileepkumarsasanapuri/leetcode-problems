class FooBar {
    private int n;
    int state = 0;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized(this){
                while(state!=0){
                    wait();
                }
                printFoo.run();
                state=1;
                notifyAll();
            }
        	
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized(this){
                while(state!=1){
                    wait();
                }
                printBar.run();
                state=0;
                notifyAll();
            }
        }
    }
}