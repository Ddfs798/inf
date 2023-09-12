
public class ProjectJob implements Runnable {

    @Override
    public void run() {
        System.out.println("start project");
        try {
            Thread.sleep(1000 * 7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
