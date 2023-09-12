public class DoorInstall implements Runnable {
    private Thread projectRoof;
    private Thread projectDoors;

    public DoorInstall(Thread projectRoof, Thread projectDoors) {
        this.projectDoors=projectDoors;
        this.projectRoof=projectRoof;
    }
    @Override
    public void run() {
        try {
            projectDoors.join();
            projectRoof.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("start installing door");
        try {
            Thread.sleep(1000 * 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end installing door");
    }
}
