public class Electric implements Runnable {
    private Thread projectCommunications;
    private Thread projectRoof;
    public Electric(Thread projectCommunications, Thread projectRoof) {
        this.projectCommunications=projectCommunications;
        this.projectRoof=projectRoof;
    }
    @Override
    public void run() {
        try {
            projectRoof.join();
            projectCommunications.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("start electric");
        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end electric");
    }
}
