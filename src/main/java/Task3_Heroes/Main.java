package Task3_Heroes;

public class Main {
    public static void main(String[] args) {
        GameManager game = new GameManager();
        CharacterFactory newCharacter = new CharacterFactory();
        Character character1 = newCharacter.createCharacter();
        Character character2 = newCharacter.createCharacter();
        game.fight(character1, character2);
    }
}
