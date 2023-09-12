public class DoorFabrication implements Runnable {
    private Thread projectThread;

    public DoorFabrication(Thread projectThread) {
        this.projectThread=projectThread;
    }

    @Override
    public void run() {
        try {
            projectThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("start door fabrication");
        try {
            Thread.sleep(1000 * 7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end doors fabrication");
    }
}
