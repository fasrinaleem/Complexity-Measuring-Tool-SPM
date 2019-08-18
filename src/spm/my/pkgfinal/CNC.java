/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fasrin_CTCandCNC;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fasrin
 */
public class CNC {
    
    public static void main(String[] args) throws IOException{
        try{
            FileInputStream fileStream = new FileInputStream("C:\\Users\\Fasrin\\Documents\\NetBeansProjects\\SPM - My Final\\src\\Fasrin_CTCandCNC\\MyException.java");
            DataInputStream in = new DataInputStream(fileStream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String stringLine;
            int countFor = 0;
            int countIf = 0;
            int weightForIf = 1;
            int f = 0;
            
            int i = 0;
            int f1 = 0;
            int f2 = 0;
            int Sum = 0;
            int lineWeight = 0;
            
            int lineNo = 0;
            
            while((stringLine = br.readLine()) != null){
                lineWeight = 0;
                lineNo++;                
                if(stringLine.contains("for")){
                    countFor++;
                    Sum = Sum+countFor;
                    lineWeight = lineWeight+countFor;
                }
                if(stringLine.contains("if")){
                    countIf++;
                    Sum = Sum+countIf;
                    lineWeight = lineWeight+countIf;
                }  
                
            System.out.println("Line No : " +lineNo+ " Weight : " +lineWeight);
            }  
            
            System.out.println("=========List==========");
            System.out.println("Total counts of FOR statements : " +countFor);
            System.out.println("Total counts of IF statements : " +countIf);
            System.out.println("Total SUM of weight: "+Sum);
            
            in.close();
            // TODO code application logic here
            }catch (FileNotFoundException ex) {
            Logger.getLogger(CNC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
