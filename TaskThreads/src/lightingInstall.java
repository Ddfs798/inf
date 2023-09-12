public class lightingInstall implements Runnable {
    private Thread projectWallAndCeiling;
    public lightingInstall(Thread projectWallAndCeiling) {
        this.projectWallAndCeiling = projectWallAndCeiling;
    }

    @Override
    public void run() {
        try {
            projectWallAndCeiling.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("start installation of lighting fixtures");
        try {
            Thread.sleep(1000 * 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end installation of lighting fixtures");
    }
}
