package Task3_Heroes;

public class Main {
    public static void main(String[] args) {
        GameManager game = new GameManager();
        CharacterFactory factory = new CharacterFactory();
        Character character1 = factory.createCharacter();
        CharacterFactory factory2 = new CharacterFactory();
        Character character2 = factory2.createCharacter();
        if (character1.getClass() != character2.getClass()){
            game.fight(character1, character2);
        }
        else {
            main(args);
        }

    }
}
