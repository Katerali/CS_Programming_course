package Task3_Heroes;

import java.util.Random;

public class Knight extends Character {
    Random pow = new Random();
    int knightPower = pow.nextInt(12-2 + 1);

    Random hp = new Random();
    int knightHitPoints = hp.nextInt(12-2 + 1);

    public Knight() {
        this.setPower(knightPower);
        this.setHitPoints(knightHitPoints);
    }

    void kick(Character character){
        int opponentLives = character.getHitPoints();

        character.setHitPoints(opponentLives - this.getPower());
    }
}
