package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a file path: ");
		String filePath=sc.nextLine();
		
		File sourceFile = new File(filePath);
		
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {
			
			String line = br.readLine();
			while (line!=null) {
				returnMarkers(line);
				
				
				
				
			}
			
		}
		

		sc.close();
	}
	
	List<String> returnMarkers(String line) {
		String[] markers=line.split("{[a-zA-Z]}");
		
		
		for (int i=0;i<field.length;i++) {
			String[] field=line.split("{");
			if (field[i].indexOf('{') {
				
			}
			String validField=field[i]+
		}
		
		
		
		
	// String[] ops = str.split("\\s*[a-zA-Z]+\\s*");	
		
	}

}
