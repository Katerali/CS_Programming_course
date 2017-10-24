package Task3_Heroes;

import java.util.Random;

public class King extends Character {

    Random pow = new Random();
    int kingPower = pow.nextInt(15-5 + 1);

    Random hp = new Random();
    int kingHitPoints = hp.nextInt(15-5 + 1);

    public King() {
        this.setPower(kingPower);
        this.setHitPoints(kingHitPoints);
    }

    void kick(Character character){
        int opponentLives = character.getHitPoints();

        character.setHitPoints(opponentLives - this.getPower());
    }
}
