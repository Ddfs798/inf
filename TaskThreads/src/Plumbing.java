public class Plumbing implements Runnable {
    private Thread projectCommunications;
    private Thread projectElectric;
    private Thread projectWallAndCeiling;
    public Plumbing(Thread projectCommunications, Thread projectElectric, Thread projectWallAndCeiling) {

        this.projectCommunications =projectCommunications;
        this.projectElectric = projectElectric;
        this.projectWallAndCeiling = projectWallAndCeiling;
    }
    @Override
    public void run() {
        try {
            projectWallAndCeiling.join();
            projectCommunications.join();
            projectElectric.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("start plumbing");
        try {
            Thread.sleep(1000 * 2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end plumbing");
    }
}
