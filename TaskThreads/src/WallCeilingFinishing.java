public class WallCeilingFinishing implements Runnable {
    private Thread projectWindowsInstall;
    private Thread projectDoorsInstall;
    private Thread projectElectric;

    public WallCeilingFinishing(Thread projectWindowsInstall, Thread projectDoorsInstall, Thread projectElectric) {
        this.projectDoorsInstall = projectDoorsInstall;
        this.projectElectric = projectElectric;
        this.projectWindowsInstall = projectWindowsInstall;
    }

    @Override
    public void run() {
        try {
            projectDoorsInstall.join();
            projectElectric.join();
            projectWindowsInstall.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("start wall and ceiling finishing");
        try {
            Thread.sleep(1000 * 7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end wall and ceiling finishing");
    }
}
