public class Satnechs implements Runnable {

    private Thread projectPlumbing;
    private Thread projectEnd;


    public Satnechs(Thread projectPlumbing, Thread projectEnd) {
        this.projectPlumbing = projectPlumbing;
        this.projectEnd = projectEnd;
    }


    @Override
    public void run() {
        long n = System.nanoTime();

        try {
            projectPlumbing.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long m = System.nanoTime();
        long s = ((m - n) / 1000000000) - 7;

        try {
            projectEnd.join();
            System.out.println("Satnechs = " + s);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
