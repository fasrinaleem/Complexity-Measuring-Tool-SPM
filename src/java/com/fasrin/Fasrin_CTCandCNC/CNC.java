/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fasrin.Fasrin_CTCandCNC;
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
            FileInputStream fileStream = new FileInputStream("C:\\Users\\Fasrin\\Desktop\\Files\\MyException.java");
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
        
        

//Calculating CNC
//Calculating Complexity due to nesting of Control Structures
	
//	public static List<ProgramStatementComplexity> calculateComplexityDueToNestingLevels(ComplexityMeasurements cm) throws IOException , NullPointerException{
//		
//		BufferedReader br= cm.getBr();
//		String statement = null;
//		
//		String nestedControlVariable = null;
//		int leftCurlyBraceCount = 0;
//		int rightCurlyBraceCount = 0;
//		int lineCount = 1;
//		int nestedCount = -1;
//		List<ProgramStatementComplexity> programStatements = new ArrayList<>();
//	    statement = br.readLine();
//		
//		while(statement != null) {
//			
//			//check whether the line contains public or class keywords
//			if(!statement.contains("\"")) {
//				if(statement.contains((" "))){
//					
//					String[] parts = statement.split(" ");
//					
//					if(parts[0].equalsIgnoreCase(Keywords.PUBLIC) || parts[0].equalsIgnoreCase(Keywords.CLASS)) {
//						nestedCount = 0;
//					}
//				}
//			}
//			// check if the line contains for,if,do, while keywords
//			if(statement.contains(" ")) {
//				String[] parts = statement.split(" ");
//				parts[0] = parts[0].trim();
//				
//				if(parts[0].equalsIgnoreCase(Keywords.FOR) || parts[0].equalsIgnoreCase(Keywords.IF) || parts[0].equalsIgnoreCase(Keywords.DO) || parts[0].equalsIgnoreCase(Keywords.WHILE)) {
//					
//					//checking for nested control variable 
//					if(parts[0].equalsIgnoreCase(nestedControlVariable) || nestedControlVariable == null) {
//						nestedCount += 1 ;
//						nestedControlVariable = parts[0];
//						leftCurlyBraceCount += 1;						
//					}
//				}
//			}
//			
//			//check for right curly braces if the nested control variable is not null
//			if(statement.trim().contains("}") && (nestedControlVariable != null)) {
//				rightCurlyBraceCount ++ ;
//				
//				if((rightCurlyBraceCount - leftCurlyBraceCount) == 1) {
//					nestedCount -- ;
//				}
//			}
//			
//			if(nestedCount <= 0) {
//				nestedCount = 0;
//			}
//			System.out.println("Nested count for line no. " + lineCount + ": " + nestedCount);
//			lineCount++;
//			
//			//adding the nesting level count for the given line
//			ProgramStatementComplexity programStatementComplexity = new ProgramStatementComplexity();
//			programStatementComplexity.setLineNumber(lineCount);
//			programStatementComplexity.setNestedLevelCount(nestedCount);
//			
//			programStatements.add(programStatementComplexity);
//		}
//		return programStatements;
//		
//
//	}


        
    }
}
