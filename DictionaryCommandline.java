public class DictionaryCommandline {

    //Function show list word

    public void showAllWords(){
        if(Dictionary.dictionary.size() == 0) System.out.println("Khong co du lieu");
        else {
            System.out.println("Danh sach cac tu: ");

            for (int i = 0; i < Dictionary.dictionary.size(); i++){
                String w_target = (Dictionary.dictionary).get(i).getWord_target();              //Get target
                String w_explain = (Dictionary.dictionary).get(i).getWord_explain();            //Get explain
                System.out.printf("%-15s %s %n", w_target, w_explain);
            }
        }
    }


    //Function ver basic

    public void dictionaryBasic(){
        DictionaryManagement dictionaryManagement = new DictionaryManagement();             //Initialize
        dictionaryManagement.insertFromCommandline();                                       //Words are inserted into list by keyboard
        showAllWords();                                                                     //Show list
    }


    //Function ver advanced

    public void dictionaryAdvanced(){
        DictionaryManagement dictionaryManagement = new DictionaryManagement();             //Initialize
        dictionaryManagement.insertFromFile();                                              //Words are inserted into list by file
        showAllWords();
        dictionaryManagement.dictionaryLookup();                                            //Look up word
    }

}
