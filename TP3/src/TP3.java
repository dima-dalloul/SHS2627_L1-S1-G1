import com.sun.source.doctree.EscapeTree;

import java.util.Scanner;

public class TP3 {

    public static void main(String[] args){
        int nbLetters = 7,  score = 0;
        Scanner s = new Scanner(System.in);
        String answerFromUser, lettersToGuess = "";

        // Get a random set of letters
        for(int i =0; i < 7; i++){
            lettersToGuess += (char) ('A' + Math.random()*26);
        }
        // Ask the user to remember
        System.out.println("Try to memorise this sequence " + lettersToGuess);

        // Wait 3 seconds
        try{
            Thread.sleep(3000);
        } catch(Exception e){}

        // "Clear"the screnn
        for(int i = 0; i < 50; i++)
            System.out.println();

        System.out.println("So ? Let's see if you remember the 7 letters !");
        answerFromUser = s.nextLine();
        for(int i  = 0; i < 7; i++){
            if(lettersToGuess.charAt(i) == answerFromUser.charAt(i))
                score++;
        }

        System.out.println("Your score is " + score + "/7");
    }
}
