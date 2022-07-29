import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * @author Aleksandr Polochkin
 * 29.07.2022
 */

public class Human implements Runnable {

    private final int NUMBER_OF_SWITCHES = 10;
    private final int MIN_SWITCHING_TIME = 1000;
    private final int MAX_SWITCHING_TIME = 1000 * 3;
    private long switchingTime;
    private String threadName;

    @Override
    public void run() {

        threadName = Thread.currentThread().getName();

        for (int i = 0; i < NUMBER_OF_SWITCHES; i++) {

            switchingTime = new Random().nextInt(MAX_SWITCHING_TIME - MIN_SWITCHING_TIME) + MIN_SWITCHING_TIME;

            try {
                sleep(switchingTime);
            } catch (InterruptedException e) {
                break;
            }

            if (!Main.isSwitchOn) {

                System.out.println("[" + (i + 1) + "] " + threadName + " включил тумблер");
                Main.isSwitchOn = true;

            }
        }
    }
}
