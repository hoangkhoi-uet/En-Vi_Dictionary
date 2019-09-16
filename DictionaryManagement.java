import java.sql.SQLOutput;
import java.util.Scanner;

public class DictionaryManagement {
    public void insertFromCommandline(){
        System.out.println("Enter number of word you want to insert: ");
        Scanner input = new Scanner(System.in);                 //Initialize input of class Scanner
        String w_Target, w_Explain;

        int numberOfWords = input.nextInt();                    //Insert number words
        input.nextLine();
        for(int i = 0; i < numberOfWords; i ++) {
            Word word = new Word();                             //Initialize
            //Insert new word
            System.out.println("Word " + (i+1) +":");
            w_Target = input.nextLine();
            word.setWord_Taget(w_Target);
            //Insert mean of word
            System.out.println("Explain");
            w_Explain = input.nextLine();
            word.setWord_Explain(w_Explain);

            Word newWord = new Word(w_Target, w_Explain);
            Dictionary.dictionary.add(newWord);
        }
    }
}
