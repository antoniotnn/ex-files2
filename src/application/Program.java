package application	;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        System.out.print("Enter a file path: ");
        String filePath = sc.nextLine();

        File sourceFile = new File(filePath);
        String targetFile = sourceFile.getParent() + "endoideiMasDeuCerto.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {

            String line = br.readLine();
            while (line != null) {
                List<String> fields = allMatches(line);

                for (int i = 0; i < fields.size(); i++) {
                    int j = i;
                    String filtered = list.stream().filter(x -> x.equals(fields.get(j))).findFirst().orElse(null);

                    if (filtered == null) {
                        list.add(fields.get(j));
                    }

                }
                line = br.readLine();
            }

        }

        catch (IOException e) {
            System.out.println("Error Reading File: " + e.getMessage());
        }

        List<String> fields2 = new ArrayList<>();

        for (String s : list) {
            System.out.print("Entre com o "+s.substring(1, s.length()-1)+": ");
            String item=sc.nextLine();
            fields2.add(item);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter (targetFile));
             BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {
            String line = br.readLine();
            while (line != null) {
                for(int i = 0; i < list.size(); i++){
                    line = line.replace(list.get(i), fields2.get(i));
                }

                bw.write(line+"\n");
                line = br.readLine();
            }
        }
        catch (IOException e) {
            System.out.println("Error Writing File: "+ e.getMessage());
        }

        sc.close();
    }

    static List<String> allMatches(String line) {

        List<String> allMatches = new ArrayList<>();
        Matcher m = Pattern.compile("\\{[a-zA-Z]*\\}").matcher(line);
        while (m.find()) {
            allMatches.add(m.group());
        }

        return allMatches;
    }

}
