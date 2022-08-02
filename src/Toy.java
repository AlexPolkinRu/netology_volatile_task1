/**
 * @author Aleksandr Polochkin
 * 02.08.2022
 */

public class Toy implements Runnable{

    private String threadName;
    private Switcher switcher;

    public Toy (Switcher switcher) {
        this.switcher = switcher;
    }

    @Override
    public void run() {

        threadName = Thread.currentThread().getName();

        while (!Thread.currentThread().isInterrupted()) {

            switcher.off(threadName);

        }
    }

}
