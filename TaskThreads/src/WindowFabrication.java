public class WindowFabrication implements Runnable {
    private Thread projectThread;

    public WindowFabrication(Thread projectThread) {
        this.projectThread = projectThread;
    }

    @Override
    public void run() {
        try {
            projectThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("start window fabrication");
        try {
            Thread.sleep(1000 * 7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end window fabrication");
    }
}


