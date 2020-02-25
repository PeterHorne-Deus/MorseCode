/*
 * Peter Horne-Deus
 * This program proforms a simple morse code encryption for one word
 * MorseCode.java
 * Feburary 24, 2020
 */
package morsecode;

import javax.swing.*;
import java.io.*;

/**
 *
 * @author Peter
 */
public class MorseCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Varibles for input
        String input;
        char character;
        //Variables for scanning external file
        int num;
        boolean match = false;
        int n = 1;
        //Variables for output
        String output = "";
        String junk;
        
        //Input Popup
        input = JOptionPane.showInputDialog("Enter a word that you would like to "
                + "put into morse code\n(No Puncuation Please)");
        
        try{
            //Setting up file information
            File dataFile = new File("letters.txt");
            FileReader in = new FileReader(dataFile);
            BufferedReader readFile = new BufferedReader(in) ;
            
            //Setting input to lower case
            input = input.toLowerCase();
            
            //Setting a mark for the bufferedreader to reset to
            readFile.mark(1);
            
            for(int i = 0; i < input.length();i++){
                //Getting the characters of each letter in the string 
                character = input.charAt(i);
                //Casting the characters to integers
                num = (int)character;
                
                //Setting the line value to search for based on ascii values
                if(num >= 97 && num <= 123){
                    num = num - 96;
                }
                else{
                    num = num - 21;
                }
                
                //Searching for determined line value
                do{
                    //Setting the correct output based on the line value needed
                    if(n == num){
                    output = output + " " +readFile.readLine(); 
                    //Reseting to do all over again for the next character
                    readFile.reset(); 
                    match = true;  
                    }
                    //Setting all inputed lines to a usless string to no be used
                    else{
                        junk = readFile.readLine();
                        n++;
                    }
                }while(match == false);
                //Reseting for another round of testing
                n = 1;
                match = false;
            }
            //Giving a final output
            JOptionPane.showMessageDialog(null, "The Morse Code is: \n" + output);
        }
        catch (IOException e) {
            System.out.println("Problem reading file.");
            System.err.println("IOException: " + e.getMessage());
    	}
    }
    
}
