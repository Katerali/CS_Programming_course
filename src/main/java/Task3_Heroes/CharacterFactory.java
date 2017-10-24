package Task3_Heroes;

import java.util.Random;

public class CharacterFactory {

    public Character createCharacter(){
        Random c = new Random();
        int randNum = c.nextInt(4);

        Character newCharacter = null;

        if (randNum == 0){
            newCharacter = new Hobbit();
        }
        if (randNum == 1){
            newCharacter = new Elf();
        }
        if (randNum == 2){
            newCharacter = new King();
        }
        if (randNum == 3){
            newCharacter = new Knight();
        }
        return newCharacter;
    }

}
