public class BatteryInstall implements Runnable {

    private Thread windowInstall;
    private Thread doorsInstall;
    private Thread communications;

    public BatteryInstall(Thread windowInstall, Thread doorInstall, Thread communications) {
        this.communications = communications;
        this.doorsInstall = doorInstall;
        this.windowInstall = windowInstall;
    }


    @Override
    public void run() {
        try {
            communications.join();
            doorsInstall.join();
            windowInstall.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("start installing battery");
        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end installing battery");
    }
}