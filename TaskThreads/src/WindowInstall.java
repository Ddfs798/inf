public class WindowInstall implements Runnable {
    private Thread projectRoof;
    private Thread projectWindow;
    public WindowInstall(Thread projectRoof, Thread projectWindow) {
        this.projectWindow = projectWindow;
        this.projectRoof = projectRoof;
    }

    @Override
    public void run() {
        try {
            projectWindow.join();
            projectRoof.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("start installing windows");
        try {
            Thread.sleep(1000 * 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end installing windows");
    }

}
