import java.util.Scanner;

public class Main {
    public static void main(String []args){
        DictionaryCommandline test = new DictionaryCommandline();                       //Initialize

        Scanner input = new Scanner(System.in);
        System.out.println("0. Phiên bản Basic\n1. Phiên bản Advanced");
        System.out.print("Nhập số chọn phiên bản: ");
        int chooseVersion = input.nextInt();

        /**
         * Choose version
         */
        switch (chooseVersion) {
            case 0 : {                                                              //Basic
                test.dictionaryBasic();                                             //Call to function
                break;
            }
            case 1 : {                                                              //Advanced
                test.dictionaryAdvanced();                                          //Call to function
                break;
            }
            default:
                System.out.println("KHÔNG HỢP LỆ!");
        }

    }
}
