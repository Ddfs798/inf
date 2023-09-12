
public class Сarpenters implements Runnable {

    private Thread projectDoorsInstall;
    private Thread projectEnd;


    public Сarpenters(Thread projectDoorsInstall, Thread projectEnd) {
        this.projectDoorsInstall = projectDoorsInstall;
        this.projectEnd = projectEnd;
    }


    @Override
    public void run() {
        long n = System.nanoTime();

        try {
            projectDoorsInstall.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long m = System.nanoTime();
        long s = ((m - n) / 1000000000) - 7;

        try {
            projectEnd.join();
            System.out.println("Сarpenters = " + s);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


