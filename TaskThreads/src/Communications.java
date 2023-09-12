public class Communications implements Runnable {
    private Thread projectFundament;

    public Communications(Thread projectFundament) {
        this.projectFundament=projectFundament;
    }

    @Override
    public void run() {
        try {
            projectFundament.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("start communications");
        try {
            Thread.sleep(1000 * 4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end communications");
    }
}
