import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryCommandline {
    DictionaryManagement dictionaryManagement = new DictionaryManagement();             //Initialize
    Scanner input = new Scanner(System.in);                                 //Initialize class Scanner

    /**
     * Basic dictionary
     */

    public void dictionaryBasic() {
        dictionaryManagement.insertFromCommandline();                        //Words are inserted into list by keyboard
        showAllWords();
        dictionaryManagement.dictionaryLookup();                                            //Look up word
        dictionaryManagement.editAnyWord();                                                 //Edit any word
        dictionaryManagement.deleteAnyWord();                                               //Delete any word
        dictionarySearcher();
        showAllWords();
        dictionaryExportToFile();                                                           //Show list
    }


    /**
     * Advanced dictionay
     */

    public void dictionaryAdvanced() {
        dictionaryManagement.insertFromFile();                                   //Words are inserted into list by file
        System.out.println("0. Exit\n1. Show all Words\n2. Edit word\n3. Delete Word\n4. Searcher\n5. Look up\n6. Add new word");
        int chooseFunction = input.nextInt();

        switch (chooseFunction) {
            case 0: {
                System.out.println("Chương trình kết thúc.");
                break;
            }
            case 1: {
                showAllWords();
                break;
            }
            case 2: {
                dictionaryManagement.editAnyWord();                                                 //Edit any word
                dictionaryExportToFile();
                break;
            }
            case 3: {
                dictionaryManagement.deleteAnyWord();                                               //Delete any word
                dictionaryExportToFile();
                break;
            }
            case 4: {
                dictionarySearcher();
                break;
            }
            case 5: {
                dictionaryManagement.dictionaryLookup();                                            //Look up word
                break;
            }
            case 6: {
                dictionaryManagement.addWord();
                dictionaryExportToFile();
                break;
            }
            default:
                System.out.println("KHÔNG HỢP LỆ!!!");
        }

    }


    /**
     * Show list words
     */

    public void showAllWords() {
        if (Dictionary.dictionary.size() == 0) System.out.println("Không có dữ liệu trong file!!!");
        else {
            System.out.println("\n---Danh sách gồm " + Dictionary.dictionary. size() + " từ---");

            for (int i = 0; i < Dictionary.dictionary.size(); i++) {
                String w_target  = (Dictionary.dictionary).get(i). getWord_target();             //Get target
                String w_explain = (Dictionary.dictionary).get(i). getWord_explain();            //Get explain
                System.out.printf("%-15s %s %n", w_target, w_explain);
            }
        }
    }


    /**
     * Look up all words by start char or string
     */

    public void dictionarySearcher() {
        System.out.println("\n---Chức năng tìm kiếm bằng nhóm kí tự đầu tiên---");
        System.out.print("Nhập nhóm kí tự bắt đầu: ");
        String stringGroup = input.nextLine();                                          //Insert
        boolean checkExist = false;                                                     //Check word exist
        System.out.println("Các từ bắt đầu bằng " + stringGroup);

        for (Word w : Dictionary.dictionary) {
            if (w.getWord_target().indexOf(stringGroup) == 0) {
                System.out.printf("%-15s %s %n", w.getWord_target(), w.getWord_explain());      //Print word found
                checkExist = true;
            }
        }

        if (!checkExist)
            System.out.println("KHÔNG TÌM THẤY!");                           //If list has no word start at stringGroup
    }

    /**
     * Export current dictionary to new file txt
     */

    public void dictionaryExportToFile() {
        BufferedWriter bw = null;

        try{
            FileWriter fw = new FileWriter(dictionaryManagement.fileReader);
            bw = new BufferedWriter(fw);                                //Initialize br of class Buffered Writer

            for (Word w : Dictionary.dictionary) {                      //Run first to last
                bw.write(w.getWord_target() + "\t" + w.getWord_explain());  //If word found
                bw.newLine();
            }

            bw.close();                                                     //Close file
        }catch (IOException e){                                             //Catch Exception
            e.printStackTrace();
        }
        System.out.println("\nGHI RA FILE THÀNH CÔNG!");                   //File write success

    }
}
