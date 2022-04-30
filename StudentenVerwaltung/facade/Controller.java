package StudentenVerwaltung.facade;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


import StudentenVerwaltung.Domain.Database;
import StudentenVerwaltung.Presistance.ReadFile;
import StudentenVerwaltung.UI.CLI;
import StudentenVerwaltung.UI.UnitedCLI;

public class Controller {
	public void controller() throws IOException, ClassNotFoundException {
	Database databaseObj = new Database();
	CLI cli = new CLI();
	ReadFile rf = new ReadFile();
	
	boolean quit = false;
	Scanner input = new Scanner(System.in);
	while(!quit) {
	System.out.println("Main Menu:");
	System.out.println("Do you have an existing CSV file or do you want to create a new database?");
	System.out.println("Enter no/na to create a new database and yes/y to read an existing CSV file");
	System.out.println("EXTRA Try mainmenu to go to print all the files");
	System.out.println("To quit enter ('quit'): ");
	System.out.print(">");
	String userInput = input.nextLine();
	
	if(userInput.equals("yes") || userInput.equals("Yes") 
			|| userInput.equals("y") || userInput.equals("Y")
			|| userInput.equals("YES"))
		{

		
		System.out.println("Where is your file located at (global)? "
				+ "(the database should be a csv file): ");
		System.out.print(">");
		//Adding input2 for collision
		Scanner input2 = new Scanner(System.in);
		String fileLocation = input2.nextLine();
		try {
			rf.readFile(fileLocation);
		}
		catch(FileNotFoundException | ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Invalid File name");
			continue;
		}
		
		}
	else if(userInput.equals("quit") || userInput.equals("Quit") 
			|| userInput.equals("QUIT"))
	{
		quit = true;
	}
	else if(userInput.equals("mainmenu") || userInput.equals("MAINMENU") 
			|| userInput.equals("Mainmenu"))
	{
		UnitedCLI uc = new UnitedCLI();
		uc.unitedCommand();
	}
	else 
	{
		System.out.println("Entering CMD...");
		cli.command();
	}

	}
	}
	}
	


