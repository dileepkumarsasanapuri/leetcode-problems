class H2O {
    private Semaphore Hsem;
    private Semaphore Osem;
    public H2O() {
        Hsem=new Semaphore(2);
        Osem=new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		
        Hsem.acquire();
        releaseHydrogen.run();
        Osem.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        
            Osem.acquire(2);
        	releaseOxygen.run();
            Hsem.release(2);
    }
}