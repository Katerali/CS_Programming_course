package Task3_Heroes;

public class GameManager {

    void fight(Character c1, Character c2) {
        while (c1.isAlive() & c2.isAlive()) {
            c1.kick(c2);
            System.out.println(c1.toString() + " has kicked " + c2.toString());
            System.out.println("Now " + c1.toString() + " has " + c1.getPower() + " power and " + c1.getHitPoints() + " lives");
            System.out.println("Now " + c2.toString() + " has " + c2.getPower() + " power and " + c2.getHitPoints() + " lives");
        }
        if (!c1.isAlive()) {
            System.out.println(c1.toString() + "is dead.\nGame over");
        }
        if (!c2.isAlive()) {
            System.out.println(c2.toString() + "is dead\nGame over");
        }
    }
}