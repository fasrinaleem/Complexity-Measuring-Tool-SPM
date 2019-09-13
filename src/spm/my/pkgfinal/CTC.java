/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fasrin_CTCandCNC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Fasrin
 */
public class CTC {
    
    	int complexity = 0;
        int ifCount = 0;
        int catchCount = 0;
        int forCount = 0;
        int whileCount = 0;
        int doWhileCount = 0;
        int caseCount = 0;
	int totalcomplexity = 0;
        
        private static File file;
	private static final List<String> invalidVariablesList = new ArrayList<>();
	private static final List<String> ifValidVariablesList = new ArrayList<>();
	private static final List<String> forValidVariablesList = new ArrayList<>();
	private static final List<String> whileValidVariablesList = new ArrayList<>();
	private static final List<String> doWhileValidVariablesList = new ArrayList<>();
	private static final List<String> catchValidVariablesList = new ArrayList<>();
	private static final List<String> switchValidVariablesList = new ArrayList<>();

	private static String[] ifCatchKeywords = {"if","catch"}; // find the if and catch keywords
	private static String[] forWhileKeywords = {"for","do"};// find the for , do-while keywords
        private static String[] whileKeywords = {"while"}; // find the while keywords
	private static String[] operatorKeywords = {"&&","and","||","&","|"}; //find the these operations  keywords
	private static String[] caseKeywords = {"case"}; ////find the case(switch = N number of case)  keywords
	
	private static final List<String> ifCatchKeywordsList = Arrays.asList(ifCatchKeywords);
	private static final List<String> forWhileKeywordsList = Arrays.asList(forWhileKeywords);
        private static final List<String> whileKeywordsList = Arrays.asList(whileKeywords);
	private static final List<String> operatorKeywordsList = Arrays.asList(operatorKeywords);
	private static final List<String> caseKeywordsList = Arrays.asList(caseKeywords);
    
	public CTC() {
		this.file = new File("C:\\Users\\Fasrin\\Desktop\\Year 03 Semester 02\\SPM\\Group\\Sprint 02\\Measuring_Complexity_Size\\src\\MyException.java");
	}

	public boolean isNumeric(String strNum) {
		try {
			if (Double.isNaN(Double.parseDouble(strNum)))
				return false;

		} catch (NumberFormatException | NullPointerException nfe) {
			return false;
		}
		return true;
	}

	public void readFileItem() {

		int lineCount = 0;
		int count = 0;

        int lineComplexity = 0;
		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {

				lineCount += 1;
				String line = scanner.nextLine();

				System.out.println("------------------------------------");
				System.out.println("Line No : " + lineCount);

				Scanner scanner2 = new Scanner(line);

				while (scanner2.hasNext()) {
					String word = scanner2.next();

					if ( word.contains("if")) {
						if (isNumeric(word)) {
							ifValidVariablesList.add(word);
                                                        complexity = complexity + 1;
                                                        ifCount = ifCount + 1;
                                                        lineComplexity = lineComplexity+1;
						} else if (ifCatchKeywordsList.contains(word)) {
							ifValidVariablesList.add(word);
                                                         complexity = complexity + 1;
                                                        ifCount = ifCount + 1;
                                                        lineComplexity = lineComplexity+1;
						}
					}  
					if ( word.contains("for")) {
						if (isNumeric(word)) {
							forValidVariablesList.add(word);
                                                         complexity = complexity + 2;
                                                         forCount = forCount + 1;
                                                        lineComplexity = lineComplexity+2;
						} else if (forWhileKeywordsList.contains(word)) {
							forValidVariablesList.add(word);
                                                         complexity = complexity + 2;
                                                         forCount = forCount + 1;
                                                        lineComplexity = lineComplexity+2;
						}
					}
					if ( word.contains("while")) {
						if (isNumeric(word)) {
							whileValidVariablesList.add(word);
                                                         complexity = complexity + 2;
                                                         whileCount = whileCount + 1;
                                                        lineComplexity = lineComplexity+2;
						} else if (whileKeywordsList.contains("while")) {
							whileValidVariablesList.add(word);
                                                         complexity = complexity + 2;
                                                         whileCount = whileCount + 1;
                                                        lineComplexity = lineComplexity+2;
						}
					}
					if ( word.contains("do")) {
						if (isNumeric(word)) {
							doWhileValidVariablesList.add(word);
                                                         complexity = complexity + 2;
                                                         doWhileCount = doWhileCount + 1;
                                                        lineComplexity = lineComplexity+2;
						} else if (forWhileKeywordsList.contains("do")) {
							doWhileValidVariablesList.add(word);
                                                         complexity = complexity + 2;
                                                         doWhileCount = doWhileCount + 1;
                                                        lineComplexity = lineComplexity+2;
						}
					}
                                        if ( word.contains("catch")) {
						if (isNumeric(word)) {
							catchValidVariablesList.add(word);
                                                         complexity = complexity + 1;
                                                         catchCount = catchCount + 1;
                                                        lineComplexity = lineComplexity+1;
						} else if (ifCatchKeywordsList.contains("catch")) {
							catchValidVariablesList.add(word);
                                                         complexity = complexity + 1;
                                                         catchCount = catchCount + 1;
                                                        lineComplexity = lineComplexity+1;
						}
					} 
                                        if ( word.contains("case")) {
						if (isNumeric(word)) {
							switchValidVariablesList.add(word);
                                                         complexity = complexity + caseCount;
                                                         caseCount = caseCount + 1;
                                                        lineComplexity = lineComplexity+1;
						} else if (caseKeywordsList.contains("case")) {
							switchValidVariablesList.add(word);
                                                         complexity = complexity + caseCount;
                                                         caseCount = caseCount + 1;
                                                        lineComplexity = lineComplexity+1;
						}
					} 
				}

				System.out.println("Token : " + ifValidVariablesList + catchValidVariablesList + forValidVariablesList + whileValidVariablesList + doWhileValidVariablesList);
				System.out.println("IF Complexity : " + ifValidVariablesList.size());
                                System.out.println("TRY CATCH Complexity : " + catchValidVariablesList.size());
                                System.out.println("FOR Complexity : " + forValidVariablesList.size());
                                System.out.println("WHILE Complexity : " + whileValidVariablesList.size());
                                System.out.println("DO Complexity : " + doWhileValidVariablesList.size());
                                System.out.println("SWITCH CASE Complexity : " + switchValidVariablesList.size());
                                System.out.println(" ");
                                System.out.println("Line Number "+lineCount+" Complexity : " +lineComplexity );
                                
				ifValidVariablesList.clear();
                                catchValidVariablesList.clear();
                                forValidVariablesList.clear();
                                whileValidVariablesList.clear();
                                doWhileValidVariablesList.clear();
                                switchValidVariablesList.clear();
        lineComplexity = 0;
			}
                        totalcomplexity = totalcomplexity+complexity;
                        
        lineComplexity = 0;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
                
                            
                      System.out.println("");   
                      System.out.println("");   
                      System.out.println("-----------------------------------------------");     
                      System.out.println("");
                      System.out.println("Total IF Statements (weight 1)            -   " + ifCount);
                      System.out.println("Total TRY CATCH Statements (weight 1)     -   " + catchCount);
                      System.out.println("Total FOR Statements (weight 2)           -   " + forCount);
                      System.out.println("Total WHILE Statements (weight 2)         -   " + whileCount);
                      System.out.println("Total DO Statements (weight 2)            -   " + doWhileCount);
                      System.out.println("Total SWITCH CASE Statements (weight n)   -   " + caseCount);
                      System.out.println("");  
                      System.out.println("TOTAL SIZE COMPLEXITY (CTC VALUE)         -   " + totalcomplexity);
                      System.out.println("");  
                      System.out.println("-----------------------------------------------"); 
                                
	}

	public static void main(String[] args) {
		CTC complexity = new CTC();
		complexity.readFileItem();
	}

    
}
