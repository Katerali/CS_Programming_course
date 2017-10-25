package Task3_Heroes;

public class GameManager {

    void fight(Character c1, Character c2) {
        while (true) {
            c1.kick(c2);
            Class cls1 = c1.getClass();
            Class cls2 = c2.getClass();
            System.out.println(cls1.getSimpleName() + " has kicked " + cls2.getSimpleName());
            System.out.println("Now " + cls1.getSimpleName() + " has " + c1.getPower() + " power and " + c1.getHitPoints() + " lives");
            System.out.println("Now " + cls2.getSimpleName() + " has " + c2.getPower() + " power and " + c2.getHitPoints() + " lives");

            if (!c1.isAlive()) {
                System.out.println(cls1.getSimpleName() + " is dead.\nGame over");
                break;
            }
            if (!c2.isAlive()) {
                System.out.println(cls2.getSimpleName() + " is dead\nGame over");
                break;
            }
            c2.kick(c1);
            System.out.println(cls2.getSimpleName() + " has kicked " + cls1.getSimpleName());
            System.out.println("Now " + cls1.getSimpleName() + " has " + c1.getPower() + " power and " + c1.getHitPoints() + " lives");
            System.out.println("Now " + cls2.getSimpleName() + " has " + c2.getPower() + " power and " + c2.getHitPoints() + " lives");

            if (!c1.isAlive()) {
                System.out.println(cls1.getSimpleName() + "is dead.\nGame over");
                break;
            }
            if (!c2.isAlive()) {
                System.out.println(cls2.getSimpleName() + "is dead\nGame over");
                break;

            }

        }

    }
}
