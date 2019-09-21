/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary_swing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Dell
 */
public class Dictionary {

    private final String fileReader = "dictionaries.txt";
    static ArrayList<Word> dictionary = new ArrayList<Word>();                  //Initialize dictionary by arraylist   
    
    /**
     * Insert from file
     */
    
    public void insertFromFile() {
        BufferedReader br = null;
        try {
            FileReader fr = new FileReader(fileReader);
            br = new BufferedReader(fr);
            String contentLine = br.readLine();                                     //First  
            
            while (contentLine != null) {                
                String taget = contentLine.substring(0, contentLine.indexOf("\t"));
                String explain = contentLine.substring(contentLine.indexOf("\t") + 1);

                Word w = new Word(taget, explain);                                  //New word
                Dictionary.dictionary.add(w);
                contentLine = br.readLine();
            }
            br.close();                                                             //Close file
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            System.out.println("Error " + ex);
        } catch (IOException ex) {
           System.out.println("Error " + ex);
        }
                         
        /*class sortWord implements Comparator<Word> {                            //Compare unicode

            @Override
            public int compare(Word word1, Word word2) {
                return word1.getWord_target().compareTo(word2.getWord_target());
            }
        }
        Collections.sort(Dictionary.dictionary, new sortWord());                //Sort*/
    }

    /**
     * Export to file
     */
    
    public void dictionaryExportToFile() {
        
        class sortWord implements Comparator<Word> {                            //Compare unicode

            @Override
            public int compare(Word word1, Word word2) {
                return word1.getWord_target().compareTo(word2.getWord_target());
            }
        }
        Collections.sort(Dictionary.dictionary, new sortWord());                //Sort
        
        BufferedWriter bw = null;
        try {
            FileWriter fw = new FileWriter(fileReader);
            bw = new BufferedWriter(fw);
            for (Word ele : Dictionary.dictionary) {
                bw.write(ele.getWord_target() + "\t" + ele.getWord_explain());
                bw.newLine();
            }
            bw.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            System.out.println("Error " + ex);
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }
    }
}
