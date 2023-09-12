public class Plasterers implements Runnable {

    private Thread projectFlat;
    private Thread projectEnd;


    public Plasterers(Thread projectFlat, Thread projectEnd) {
        this.projectFlat = projectFlat;
        this.projectEnd = projectEnd;
    }


    @Override
    public void run() {
        long n = System.nanoTime();

        try {
            projectFlat.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long m = System.nanoTime();
        long s = ((m - n) / 1000000000) - 7;

        try {
            projectEnd.join();
            System.out.println("Plasterers = " + s);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
