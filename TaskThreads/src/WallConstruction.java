public class WallConstruction implements Runnable {

    private Thread projectFundament;

    public WallConstruction(Thread projectFundament) {
        this.projectFundament = projectFundament;
    }
    @Override
    public void run() {
        try {
            projectFundament.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("start wall construction");
        try {
            Thread.sleep(1000 * 14);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end wall construction");
    }
}
