/**
 * @author Aleksandr Polochkin
 * 29.07.2022
 */

public class Main implements Runnable{

    volatile static boolean isSwitchOn;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {

            if (Main.isSwitchOn) {
                System.out.println("    " + Thread.currentThread().getName() + " выключила тумблер");
                Main.isSwitchOn = false;
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread human = new Thread(new Human(), "человек");
        Thread box = new Thread(new Main(), "шкатулка");

        human.start();
        box.start();

        human.join();
        box.interrupt();

        System.out.println("The End");
    }
}
