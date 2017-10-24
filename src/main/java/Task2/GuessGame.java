package Task2;

import javax.swing.*;
import java.util.Random;

public class GuessGame {
    private int scoreBest = 0;

    public void play(int max){

        Random n = new Random();
        int num = n.nextInt(max);

        int i = 0;
        do {
            i++;
            int guessed = Integer.parseInt(JOptionPane.showInputDialog("Guess the number from 0 to " + max + "!"));
            if (guessed < num){
                JOptionPane.showMessageDialog(null,"too small");
            }
            else if (guessed > num){
                JOptionPane.showMessageDialog(null,"too big");
            }
            else if (guessed == num){
                JOptionPane.showMessageDialog(null,"You've guessed!!");
                break;
            }
        } while (true);

        int scoreGame = max/i;
        if (scoreGame > this.scoreBest) {
            this.scoreBest = scoreGame;
        }
    }

    public void printBestScore(){
        JOptionPane.showMessageDialog(null, "Best score is " + this.scoreBest);

    }
}
