/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spm.my.pkgfinal;

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
            FileInputStream fileStream = new FileInputStream("C:\\Users\\Fasrin\\Documents\\NetBeansProjects\\SPM - My Final\\src\\spm\\my\\pkgfinal\\MyException.java");
            DataInputStream in = new DataInputStream(fileStream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String stringLine;
            int countFor = 0;
            int countIf = 0;
            int weightForIf = 1;
            int f = 0;
            int Sum2 = 0;
            
            int i = 0;
            int f1 = 0;
            int f2 = 0;
            int Sum = 0;
            
            int lineNo = 0;
            
            while((stringLine = br.readLine()) != null){
                
                lineNo++;                
                if(stringLine.contains("for")){
                    f1++;
                    countFor++;
                    Sum = Sum+f1;
                }
                if(stringLine.contains("if")){
                    f2++;
                    countIf++;
                    Sum = Sum+f2;
                }  

                if(stringLine.contains("if")){
                    f++;
                    Sum2 = Sum2+weightForIf;
                    if(f>=1){
                        weightForIf++;
                        Sum2 = Sum2+weightForIf;
                    }
                    weightForIf = 1;
                }
                
            }  
            
            System.out.println("=========List==========");
            System.out.println("Total counts of FOR statements : " +countFor);
            System.out.println("Total counts of IF statements : " +countIf);
            System.out.println("Total Sum of weight: "+Sum);
            System.out.println("Total Sum2 of weight: "+Sum2);
            
            in.close();
            // TODO code application logic here
            }catch (FileNotFoundException ex) {
            Logger.getLogger(CNC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
