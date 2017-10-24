package Task3_Heroes;

public class Hobbit extends Character {

    public Hobbit() {
        this.setPower(0);
        this.setHitPoints(3);
    }

    private static void toCry(){
        System.out.println("Aaaaaaaaa!!! Don't kick me");
    }

    @Override
    void kick(Character character) {
        Hobbit.toCry();
    }
}
