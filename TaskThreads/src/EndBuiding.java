public class EndBuiding implements Runnable {

    private Thread projectFlat;
    private Thread projectPlumbing;
    private Thread projectLightingInstall;

    public EndBuiding(Thread projectFlat,  Thread projectPlumbing, Thread projectLightingInstall) {
        this.projectFlat = projectFlat;
        this.projectPlumbing = projectPlumbing;
        this.projectLightingInstall = projectLightingInstall;
    }


    @Override
    public void run() {
        long n = System.nanoTime();
        try {
            projectFlat.join();
            projectLightingInstall.join();
            projectPlumbing.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long m = System.nanoTime();
        System.out.println("end the building");
        System.out.println(" ");
        System.out.println("Total Running Time " +(m - n) / 1000000000);
        System.out.println(" ");
    }
}