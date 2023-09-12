public class FloorFinish implements Runnable {
    private Thread projectWallAndCeiling;
    public FloorFinish(Thread projectWallAndCeiling) {
        this.projectWallAndCeiling=projectWallAndCeiling;
    }
    @Override
    public void run() {
        try {
            projectWallAndCeiling.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("start floor finish");
        try {
            Thread.sleep(1000 * 7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end floor finish");
    }
}
