public class RoofErection implements Runnable {
    private Thread projectWalls;
    public RoofErection(Thread projectWalls) {
        this.projectWalls = projectWalls;
    }
    @Override
    public void run() {
        try {
            projectWalls.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("start roof");
        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end roof");
    }

}
