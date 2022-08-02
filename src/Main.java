/**
 * @author Aleksandr Polochkin
 * 29.07.2022
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Switcher switcher = new Switcher();

        Thread human = new Thread(new Human(switcher), "человек");
        Thread toy = new Thread(new Toy(switcher), "мохнатая рука");

        human.start();
        toy.start();

        human.join();
        toy.interrupt();

        System.out.println("И так пока не сядут батарейки");
    }
}
