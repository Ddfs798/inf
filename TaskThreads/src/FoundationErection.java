public class FoundationErection implements Runnable {
    private Thread projectThread;

    public FoundationErection(Thread projectThread) {
        this.projectThread = projectThread;
    }

    @Override
    public void run() {
        try {
            projectThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("start foundation erection");
        try {
            Thread.sleep(1000 * 14);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end foundation erection");
    }
}
