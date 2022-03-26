package StudentenVerwaltung;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;




public class Main {
	
	public static void main(String[] arg) throws IOException {
	Database databaseObj = new Database();
	ReadCSV readObj = new ReadCSV();
	boolean quit = false;
	Scanner input = new Scanner(System.in);
	while(!quit) {
	System.out.println("Main Menu:");
	System.out.println("Do you have an existing CSV file or do you want to create a new database?");
	System.out.println("Enter yes/y to create a new database and no/na to read an existing CSV file");
	System.out.println("To quit enter ('quit'): ");
	System.out.print(">");
	String userInput = input.nextLine();
	
	if(userInput.equals("yes") || userInput.equals("Yes") 
			|| userInput.equals("y") || userInput.equals("Y"))
		{
		System.out.println("Entering CMD...");
		databaseObj.dex();
		}
	else if(userInput.equals("quit") || userInput.equals("Quit") 
			|| userInput.equals("QUIT"))
	{
		quit = true;
	}
	else 
	{
		System.out.println("Where is your file located at (global)? "
				+ "(the database should be a csv file): ");
		System.out.print(">");
		String fileLocation = input.nextLine();
		readObj.readFile(fileLocation);
	}

	
	}
	}
}
