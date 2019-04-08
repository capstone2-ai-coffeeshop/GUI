package files;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Formatter;

public class FR {
	
	public static void main(String[] args) throws Exception {
		//Scanner read = new Scanner(System.in);
//		FileReader file = new FileReader("D:/4_Projects/FilesCreate/newFile.txt");
//		BufferedReader reader = new BufferedReader(file);
//		
//		String text = "";
//		String line = reader.readLine();
//		while (line != null) {
//			text += line;
//			line = reader.readLine();
//		}
//		
//		reader.close();
//		System.out.println(text);
		
		Formatter formatter = new Formatter();
		//String formatter123 = formatter.format("%2f %-20s $%.2f%n", "123", "123", "1").toString();
		//System.out.println(formatter123);
		System.out.printf("%-15s %-20s $%20sn",  1342341.0, "Chân gà xả ớt", 123.0);
		System.out.printf("\n%-5s %-20s $%.2f%n",  1.0, "123ágvadv", 1.0);
		System.out.printf("\n%-10s %-20s $%.2f%n",  1.0, "123svsv", 1223233.0);
		System.out.printf("\n%-15s %-20s $%.2f%n",  1.0, "123s", 12144547753.0);
	}
}
