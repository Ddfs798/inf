public class Electricians implements Runnable {

    private Thread projectLightingInstall;
    private Thread projectEnd;


    public Electricians(Thread projectLightingInstall, Thread projectEnd) {
        this.projectLightingInstall = projectLightingInstall;
        this.projectEnd = projectEnd;
    }


    @Override
    public void run() {
        long n = System.nanoTime();

        try {
            projectLightingInstall.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long m = System.nanoTime();
        long s = ((m - n) / 1000000000) - 7;

        try {
            projectEnd.join();
            System.out.println("Electricians= " + s);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
