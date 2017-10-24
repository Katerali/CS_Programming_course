package Task3_Heroes;

public abstract class Character {

    private int power;
    private int hitPoints;

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }


    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }


    void kick(Character character){

    }

    boolean isAlive(){
        return (hitPoints > 0);
    }



}
