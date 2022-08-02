/**
 * @author Aleksandr Polochkin
 * 02.08.2022
 */

public class Switcher {

    private int counter = 0;
    private volatile boolean isToggleOn = false;

    public void on(String name) {
        if (!isToggleOn) {
            System.out.println("[" + ++counter + "] " + name + " включил тумблер");
            isToggleOn = true;
        }
    }

    public void off(String name) {
        if (isToggleOn) {
            System.out.println("    " + name + " выключила тумблер");
            isToggleOn = false;
        }
    }

}

