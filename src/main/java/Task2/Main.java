package Task2;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GuessGame game = new GuessGame();
        int maxNumber = Integer.parseInt(JOptionPane.showInputDialog("Welcome!\nChoose max number!"));
        while (true){
            game.play(maxNumber);
            String decision = JOptionPane.showInputDialog("Do you want to continue? (yes/no)");
            if (decision.equals("no")){
                break;
            }
        }

        game.printBestScore();
    }
}
