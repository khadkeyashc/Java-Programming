import java.io.*;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Prompt user for file name
            System.out.print("Enter the file name to read: ");
            String fileName = scanner.nextLine();
            
            // Create FileReader and BufferedReader
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            System.out.println("File content:");
            String line;
            
            // Read and print each line from the file
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            
            // Close resources
            bufferedReader.close();
            fileReader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. Please ensure the file exists.");
        } catch (IOException e) {
            System.out.println("Error: An I/O error occurred while reading the file.");
        } finally {
            scanner.close();
            System.out.println("Program has ended.");
        }
    }
}
