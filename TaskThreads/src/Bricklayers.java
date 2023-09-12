public class Bricklayers implements Runnable {

    private Thread projectWall;
    private Thread projectEnd;

    public Bricklayers(Thread projectWall, Thread projectEnd) {
        this.projectWall = projectWall;
        this.projectEnd = projectEnd;
    }


    @Override
    public void run() {
        long n = System.nanoTime();

        try {
            projectWall.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long m = System.nanoTime();
        long s = ((m - n) / 1000000000) - 7;

        try {
            projectEnd.join();
            System.out.println("Bricklayers = " + s);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

