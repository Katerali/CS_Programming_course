package Task3_Heroes;

public class Elf extends Character {

    public Elf() {
        this.setPower(10);
        this.setHitPoints(10);
    }

    @Override
    void kick(Character character) {
        int opponentPower = character.getPower();

        if (this.getPower() > opponentPower){
            character.setHitPoints(0);
        }
        if (this.getPower() <= opponentPower){
            character.setPower(opponentPower - 1);
        }
    }
}
