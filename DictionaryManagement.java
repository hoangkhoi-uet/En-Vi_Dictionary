import java.io.*;
import java.util.Scanner;

public class DictionaryManagement {

    //Insert from command line

    public void insertFromCommandline(){
        System.out.println("Nhap so luong tu: ");                       //Print
        Scanner input = new Scanner(System.in);                         //Initialize input of class Scanner

        int numberOfWords = input.nextInt();                            //Insert number words
        input.nextLine();

        for(int i = 0; i < numberOfWords; i ++) {
            Word newWord = new Word();                                  //Initialize new word
            System.out.println("Tu " + (i+1) + ":");
            newWord.setWord_target(input.nextLine());                   //Set target for new word

            System.out.println("Dich nghia " + (i+1) + ":");
            newWord.setWord_explain(input.nextLine());                  //Set explain for new word

            Dictionary.dictionary.add(newWord);                         //Add new word to dictionary
        }
    }


    //Insert from file

    public void insertFromFile(){
        BufferedReader br = null;
        try {
            FileReader fr = new FileReader("C:\\Users\\Dell\\Desktop\\OOP\\Dictionary_Long-Khoi\\dictionaries.txt");
            br = new BufferedReader(fr);                                    //Initialize br of class Buffered Reader

            String contentLine = br.readLine();                             //First insert
            while (contentLine != null) {
                if(contentLine.indexOf("\t") == -1){                        //If line has no tab"\t"
                    contentLine = br.readLine();
                    continue;
                }

                Word newWord = new Word(contentLine);                       //Add new word by content line
                (Dictionary.dictionary).add(newWord);
                contentLine = br.readLine();                                //Read other line
            }
        }catch (IOException e){                                             //Catch Exception
            e.printStackTrace();
        }finally{
            try{
                br.close();                                                 //close file
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }


    //Dictionary Look Up

    public void dictionaryLookup(){
        Scanner input = new Scanner(System.in);                             //Initialize class scanner
        System.out.print("\nNhap tu can tim kiem: ");
        String wordLookup = input.nextLine();                               //Word need looking up

        for(Word w: Dictionary.dictionary){
            if(wordLookup.equals(w.getWord_target())){                      //If word has been found
                System.out.println("Tu can tim: " + wordLookup);
                System.out.println("Dich nghia: "+ w.getWord_explain());
                return;
            }
        }

        System.out.println("Khong tim thay!");                              //If cannot find
    }
}
