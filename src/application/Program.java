package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<>();
		
		System.out.print("Enter a file path: ");
		String filePath=sc.nextLine();
		
		File sourceFile = new File(filePath);
		
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {
			
			String line = br.readLine();
			while (line!=null) {
				String[] fields=returnMarkers(line);
				
				for (int i=0;i<fields.length;i++) {
						list.add(fields[i]);	/*List<Piece> opponentPieces = piecesOnTheBoard
						.stream()
						.filter(x -> ((ChessPiece) x).getColor() == opponent(color))
						.collect(Collectors.toList());*/
			
				}
				
				for (String fieldLine : list) {
					for (int i=0;i<fields.length;i++) {
						
					}
					List<String> filtered = list.stream().filter(x-> x!= fields.length ).collect(Collectors.toList());
				}
				//<List>String filtered = list.stream().filter(x-> ).collect(Collectors.toList());
				
				
				br.readLine();
				
				
			}
			
		}
		
		catch {
			
		}
		sc.close();
	}

	static String[] returnMarkers(String line) {
		String[] markers = line.split("{[a-zA-Z]}");

		return markers;
		// String[] ops = str.split("\\s*[a-zA-Z]+\\s*");

	}

}
