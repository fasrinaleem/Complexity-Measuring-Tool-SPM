/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spm.my.pkgfinal;

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
public class CTCandCNC {
        private static File file;
	private static final List<String> invalidVariablesList = new ArrayList<>();
	private static final List<String> ifValidVariablesList = new ArrayList<>();
	private static final List<String> catchValidVariablesList = new ArrayList<>();
	private static final List<String> forValidVariablesList = new ArrayList<>();
	private static final List<String> whileValidVariablesList = new ArrayList<>();
	private static final List<String> doWhileValidVariablesList = new ArrayList<>();

	private static String[] ifCatchKeywords = {"if","catch"}; // find the if and catch keywords
	private static String[] forWhileKeywords = {"for","while","do-while"};// find the for ,while and do-while keywords
	private static String[] operatorKeywords = {"&&","and","||","&","|"}; //find the these operations  keywords
	private static String[] caseKeywords = {"case"}; ////find the case(switch = N number of case)  keywords
	
	private static final List<String> ifCatchKeywordsList = Arrays.asList(ifCatchKeywords);
	private static final List<String> forWhileKeywordsList = Arrays.asList(forWhileKeywords);
	private static final List<String> operatorKeywordsList = Arrays.asList(operatorKeywords);
	private static final List<String> caseKeywordsList = Arrays.asList(caseKeywords);
    
	public CTCandCNC() {
		this.file = new File("C:\\Users\\Fasrin\\Documents\\NetBeansProjects\\SPM - My Final\\src\\spm\\my\\pkgfinal\\MyException.java");
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
						} else if (ifCatchKeywordsList.contains(word)) {
							ifValidVariablesList.add(word);
						} else if (forWhileKeywordsList.contains(word)) {
							ifValidVariablesList.add(word);
						} else if (operatorKeywordsList.contains(word)) {
							ifValidVariablesList.add(word);
						} else if (caseKeywordsList.contains(word)) {
							ifValidVariablesList.add(word);
						} else if (invalidVariablesList.contains(word)) {
							ifValidVariablesList.remove(word);
						} else {
							ifValidVariablesList.add(word);
						}
					}
					if ( word.contains("catch")) {
						if (isNumeric(word)) {
							catchValidVariablesList.add(word);
						} else if (ifCatchKeywordsList.contains(word)) {
							catchValidVariablesList.add(word);
						} else if (forWhileKeywordsList.contains(word)) {
							catchValidVariablesList.add(word);
						} else if (operatorKeywordsList.contains(word)) {
							catchValidVariablesList.add(word);
						} else if (caseKeywordsList.contains(word)) {
							catchValidVariablesList.add(word);
						} else if (invalidVariablesList.contains(word)) {
							catchValidVariablesList.remove(word);
						} else {
							catchValidVariablesList.add(word);
						}
					}   
					if ( word.contains("for")) {
						if (isNumeric(word)) {
							forValidVariablesList.add(word);
						} else if (ifCatchKeywordsList.contains(word)) {
							forValidVariablesList.add(word);
						} else if (forWhileKeywordsList.contains(word)) {
							forValidVariablesList.add(word);
						} else if (operatorKeywordsList.contains(word)) {
							forValidVariablesList.add(word);
						} else if (caseKeywordsList.contains(word)) {
							forValidVariablesList.add(word);
						} else if (invalidVariablesList.contains(word)) {
							forValidVariablesList.remove(word);
						} else {
							forValidVariablesList.add(word);
						}
					}
					if ( word.contains("while")) {
						if (isNumeric(word)) {
							whileValidVariablesList.add(word);
						} else if (ifCatchKeywordsList.contains(word)) {
							whileValidVariablesList.add(word);
						} else if (forWhileKeywordsList.contains(word)) {
							whileValidVariablesList.add(word);
						} else if (operatorKeywordsList.contains(word)) {
							whileValidVariablesList.add(word);
						} else if (caseKeywordsList.contains(word)) {
							whileValidVariablesList.add(word);
						} else if (invalidVariablesList.contains(word)) {
							whileValidVariablesList.remove(word);
						} else {
							whileValidVariablesList.add(word);
						}
					}
					if ( word.contains("do-while")) {
						if (isNumeric(word)) {
							doWhileValidVariablesList.add(word);
						} else if (ifCatchKeywordsList.contains(word)) {
							doWhileValidVariablesList.add(word);
						} else if (forWhileKeywordsList.contains(word)) {
							doWhileValidVariablesList.add(word);
						} else if (operatorKeywordsList.contains(word)) {
							doWhileValidVariablesList.add(word);
						} else if (caseKeywordsList.contains(word)) {
							doWhileValidVariablesList.add(word);
						} else if (invalidVariablesList.contains(word)) {
							doWhileValidVariablesList.remove(word);
						} else {
							doWhileValidVariablesList.add(word);
						}
					} 
				}

				System.out.println("Token : " + ifValidVariablesList + catchValidVariablesList + forValidVariablesList + whileValidVariablesList + doWhileValidVariablesList);
				System.out.println("IF Complexity : " + ifValidVariablesList.size());
                                System.out.println("CATCH Complexity : " + catchValidVariablesList.size());
                                System.out.println("FOR Complexity : " + forValidVariablesList.size());
                                System.out.println("WHILE Complexity : " + whileValidVariablesList.size());
                                System.out.println("DO-WHILE Complexity : " + doWhileValidVariablesList.size());
                                
                                
//                                String[] itemsArray = new String[ifValidVariablesList.size()];
//                                itemsArray = ifValidVariablesList.toArray(itemsArray);
//                                
//                                System.out.println(itemsArray);
//                                    
//                                List<Integer> numbers = Arrays.asList("ifValidVariablesList");
//                                Integer[] integers = numbers.toArray(new Integer[numbers.size()]);                                


				ifValidVariablesList.clear();
                                catchValidVariablesList.clear();
                                forValidVariablesList.clear();
                                whileValidVariablesList.clear();
                                doWhileValidVariablesList.clear();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		CTCandCNC complexity = new CTCandCNC();
		complexity.readFileItem();
	}

    
}
