/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package measuring_complexity_size;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jahrin
 */
public class Measuring_Complexity_Size {

    String fileLocation;
    String words;
    String line = null;

    List<String> arr = new ArrayList<>();
    int complexity = 0;
    int totalcomplexity = 0;

    String[] arithmetic = {"+", "-", "*", "/", "%", "++", "--"};
    String[] relation = {"==", "!=", ">", "<", ">=", "<="};
    String[] logical = {"&&", "||", "!"};
    String[] bitwise = {"|", "^", "~", "<<", ">>", ">>>", "<<<"};
    String[] misc = {",", "->", ".", "::"};
    String[] assignment = {"+=", "-=", "*=", "/=", "=", ">>>=", "|=", "&=", "%=", "<<=", ">>=", "^="};
    String[] keywords = {"void", "double", "int", "float", "String",
        "printf", "println", "cout", "cin", "if", "for", "while", "do while", "switch", "case", "long"};
    String[] manipulators = {"endl", "\n"};

    String[] invalidStringVariables = {"public", "static", "else", "try", "return", "private", "class"};
    String[] constValueTwoVariables = {"&", "throw", "throws", "new", "delete"};

    public void MeasureSize() {

        try {

            Pattern pattern = Pattern.compile("\"([^\"]*)\"");

            fileLocation = "C:\\Users\\jahrin\\Desktop\\MyException.java";

            FileReader filereader = new FileReader(fileLocation);
            BufferedReader bufferedreader = new BufferedReader(filereader);
            line = bufferedreader.readLine();
            Matcher m = pattern.matcher(line);

            while (line != null) {
                complexity = 0;

                if (m.find()) {
                    complexity++; //complexity of text inside a pair of double quotes
                }
                // --------------
                line = line.replaceAll("\\{", " ");
                line = line.replaceAll("\\}", " ");
                line = line.replaceAll("\\(", " ");
                line = line.replaceAll("\\)", " ");
                line = line.replaceAll(";", " ");
                line = line.replaceAll("\"", " ");
                line = line.replaceAll("\\[", " ");
                line = line.replaceAll("\\]", " ");

//                if (line.contains("class")) {
//                    break;
//                }
//                
                StringTokenizer stringToken = new StringTokenizer(line);

                while (stringToken.hasMoreTokens()) {
                    words = stringToken.nextToken();

                    // Arithmetic operators
                    for (int i = 0; i < arithmetic.length; i++) {
                        if (arithmetic[i].equals("//")) {
                            break;
                        } else {
                            if (arithmetic[i].equals(words)) {
                                arr.add(words);
                                complexity++;
                            }
                        }
                    }

                    // Relation operators
                    for (int i = 0; i < relation.length; i++) {
                        if (relation[i].equals("//")) {
                            break;
                        } else {
                            if (relation[i].equals(words)) {
                                arr.add(words);
                                complexity = complexity + 1;
                            }
                        }
                    }

                    // logical operators
                    for (int i = 0; i < logical.length; i++) {
                        if (logical[i].equals("//")) {
                            break;
                        } else {
                            if (logical[i].equals(words)) {
                                arr.add(words);
                                complexity = complexity + 1;
                            }
                        }
                    }

                    // bitwise operators
                    for (int i = 0; i < bitwise.length; i++) {
                        if (bitwise[i].equals("//")) {
                            break;
                        } else {
                            if (bitwise[i].equals(words)) {
                                arr.add(words);
                                complexity = complexity + 1;
                            }
                        }
                    }

                    // misc operators
                    for (int i = 0; i < misc.length; i++) {
                        if (misc[i].equals("//")) {
                            break;
                        } else {
                            if (misc[i].equals(words)) {
                                arr.add(words);
                                complexity = complexity + 1;
                            }
                        }
                    }

                    // assignment operators
                    for (int i = 0; i < assignment.length; i++) {
                        if (assignment[i].equals("//")) {
                            break;
                        } else {
                            if (assignment[i].equals(words)) {
                                arr.add(words);
                                complexity = complexity + 1;
                            }
                        }
                    }

                    // keywords operators
                    for (int i = 0; i < keywords.length; i++) {
                        if (keywords[i].equals("//")) {
                            break;
                        } else {
                            if (keywords[i].equals(words)) {
                                arr.add(words);
                                complexity = complexity + 1;
                            }
                        }
                    }

                    // manipulators operators
                    for (int i = 0; i < manipulators.length; i++) {
                        if (manipulators[i].equals("//")) {
                            break;
                        } else {
                            if (manipulators[i].equals(words)) {
                                arr.add(words);
                                complexity = complexity + 1;
                            }
                        }
                    }

                    // invalidStringVariables operators
                    for (int i = 0; i < invalidStringVariables.length; i++) {
                        if (invalidStringVariables[i].equals("//")) {
                            break;
                        } else {
                            if (invalidStringVariables[i].equals(words)) {
                                arr.add(words);
                                complexity = complexity + 1;
                            }
                        }
                    }

                    // constValueTwoVariables operators
                    for (int i = 0; i < constValueTwoVariables.length; i++) {
                        if (constValueTwoVariables[i].equals("//")) {
                            break;
                        } else {
                            if (constValueTwoVariables[i].equals(words)) {
                                arr.add(words);
                                complexity = complexity + 1;
                            }
                        }
                    }

                    if (!arr.contains(words)) {
                        if (words.equals("//")) {
                            break;
                        } else {
                            System.out.println(words);
                            complexity = complexity + 1;
                        }
                    }

                }

                totalcomplexity = totalcomplexity + complexity;
                System.out.println("Line Complexity is: " + complexity);
                line = bufferedreader.readLine();

                //-----------------
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total Size Complexity is: " + totalcomplexity);

    }

}
