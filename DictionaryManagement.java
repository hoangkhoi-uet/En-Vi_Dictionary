import java.io.*;
import java.util.Scanner;

public class DictionaryManagement {
    public final String fileReader = "dictionaries.txt";               //Link to file reader txt
    private Scanner input = new Scanner(System.in);                     //Initialize input of class Scanner

    /**
     * Insert word by keyboard
     */

    public void insertFromCommandline(){
        System.out.print("Nhập số lượng từ cần insert: ");              //Print
        int numberOfWords = input.nextInt();                            //Insert number words
        input.nextLine();

        for(int i = 0; i < numberOfWords; i ++) {
            Word newWord = new Word();                                  //Initialize new word
            System.out.print("Từ " + (i+1) + ": ");
            newWord.setWord_target(input.nextLine());                   //Set target for new word

            System.out.print("Dịch nghĩa " + (i+1) + ": ");
            newWord.setWord_explain(input.nextLine());                  //Set explain for new word

            Dictionary.dictionary.add(newWord);                         //Add new word to dictionary
        }

        System.out.println("NHẬP THÀNH CÔNG!");
    }


    /**
     * Insert word from file
     */

    public void insertFromFile(){
        BufferedReader br = null;
        try {
            FileReader fr = new FileReader(fileReader);
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
            br.close();                                                     //Close file
        } catch (IOException e){                                            //Catch Exception
            e.printStackTrace();
        }
        System.out.println("\n---ĐỌC TỪ FILE THÀNH CÔNG!");                 //File read success
    }


    /**
     * Look up word in dictionary
     */

    public void dictionaryLookup(){
        System.out.println("\n---Chức năng tìm kiếm từ---");
        System.out.print("Nhập từ cần tìm kiếm: ");
        String wordLookup = input.nextLine();                               //Word need looking up

        for(Word w: Dictionary.dictionary){
            if(wordLookup.equals(w.getWord_target())){                      //If word has been found
                System.out.println("Từ đang tìm: " + wordLookup);
                System.out.println("Dịch nghĩa: "+ w.getWord_explain());
                return;
            }
        }

        System.out.println("KHÔNG TÌM THẤY!");
    }


    /**
     * Edit word by new word
     */

    public void editAnyWord() {
        System.out.println("\n---Chức năng sửa từ---");
        System.out.print("Nhập từ bạn muốn sửa: ");
        String needEditing = input.nextLine();                                          //Insert word need editing

        for (int i = 0; i < Dictionary.dictionary.size(); i ++) {
            if(Dictionary.dictionary.get(i).getWord_target(). equals(needEditing)) {     //If find word
                System.out.println("Đã tìm thấy!");
                System.out.print("Nhập từ mới: ");
                String new_target = input.nextLine();                                   //Insert target

                System.out.print("Nhập dịch nghĩa: ");
                String new_explain = input.nextLine();                                  //Insert explain
                Dictionary.dictionary.set(i, new Word(new_target, new_explain));        //Replace by new word

                System.out.println("SỬA THÀNH CÔNG!");
                return;
            }
        }
        System.out.println("KHÔNG TÌM THẤY!");                                          //If cannot find
    }


    /**
     * Delete word
     */

    public void deleteAnyWord() {
        System.out.println("\n---Chức năng xóa từ---");
        System.out.print("Nhập từ bạn muốn xóa: ");
        String needDeleting = input.nextLine();                                          //Insert word need deleting

        for (int i = 0; i < Dictionary.dictionary.size(); i ++) {
            if (Dictionary.dictionary.get(i).getWord_target(). equals(needDeleting)) {     //If find word
                System.out.println("Đã tìm thấy!");
                Dictionary.dictionary.remove(i);                                           //Remove from dictionary
                System.out.println("XÓA THÀNH CÔNG!");
                return;
            }
        }
        System.out.println("KHÔNG TÌM THẤY!");                                             //If cannot find
    }

    public void addWord() {
        System.out.println("\n---Chức năng thêm từ---");
        System.out.print("Nhập từ bạn muốn thêm: ");
        String newWord = input.nextLine();
        System.out.print("Nhập nghĩa: ");
        String mean = input.nextLine();

        Dictionary.dictionary.add(new Word(newWord, mean));
        System.out.println("Thêm thành công!");
    }


}
