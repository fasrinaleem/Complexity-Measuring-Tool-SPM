package com.fasrin.inheritance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.StringTokenizer;

public class Inheritance {

	String fileLocation;
	String words, words2;
	String line = null;

	String[] extendsCheck = { "extends" };
	String[] implementsCheck = { "implements" };
	String[] commaCheck = { "," };

	int complexity = 2;
	int totalcomplexity = 0;
	int x = 0;

	// constructor
	Inheritance(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public void CheckInheritance() {

		LineNumberReader lineNumberReader = null;

		try {

			FileReader filereader = new FileReader(fileLocation);
			BufferedReader bufferedreader = new BufferedReader(filereader);
			line = bufferedreader.readLine();
			lineNumberReader = new LineNumberReader(new FileReader(fileLocation));
			lineNumberReader.setLineNumber(0);

			// Read all lines and every read increase the line number by 1
			while (line != null && (line = lineNumberReader.readLine()) != null) {


				StringTokenizer stringToken = new StringTokenizer(line);

				while (stringToken.hasMoreTokens()) {

					words = stringToken.nextToken();

					for (int i = 0; i < extendsCheck.length; i++) {
						if (extendsCheck[i].equals("//")) {
							break;
						} else {
							if (extendsCheck[i].equals(words)) {
								complexity = complexity + 1;
							} else if (implementsCheck[i].equals(words)) {

								String line2 = line;
								complexity = complexity + 1;
								StringTokenizer stringToken2 = new StringTokenizer(line2);

								while (stringToken2.hasMoreTokens()) {
									words2 = stringToken2.nextToken();

									for (int x = 0; x < commaCheck.length; x++) {
										if (commaCheck[x].equals("{")) {
											break;
										} else {
											if (commaCheck[x].equals(words2)) {
												complexity = complexity + 1;
												System.out.println(complexity);
											}
										}

									}

								}
							}
						}
					}

				}

				line = bufferedreader.readLine();

				System.out.println(
						"Line " + lineNumberReader.getLineNumber() + " complexity due to inheritance:" + complexity);
				x = x + complexity;

			}

			totalcomplexity = totalcomplexity + x;
			System.out.println("Total inheritance: " + totalcomplexity);

			bufferedreader.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Close the LineNumberReader
			try {
				if (lineNumberReader != null) {
					lineNumberReader.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
