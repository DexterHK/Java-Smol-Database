package StudentenVerwaltung;

import java.io.IOException;
import java.util.*;




public class Main {
	//This main function is supposed to be the function which creates every Object and more.
	public static void main(String[] arg) throws IOException {
	Database databaseObj = new Database();
	ReadCSV readObj = new ReadCSV();
	boolean quit = false;
	Scanner input = new Scanner(System.in);
	while(!quit) {
	System.out.println("Main Menu:");
	System.out.println("Do you have an existing CSV file or do you want to create a new database?");
	System.out.println("Enter no/na to create a new database and yes/y to read an existing CSV file");
	System.out.println("To quit enter ('quit'): ");
	System.out.print(">");
	String userInput = input.nextLine();
	
	if(userInput.equals("yes") || userInput.equals("Yes") 
			|| userInput.equals("y") || userInput.equals("Y")
			|| userInput.equals("YES"))
		{
		System.out.println("Type a number please"
				+ "\n(1)Do you want to addusers to the database through a file?"
				+ "\n(2)Update existing users through a file?"
				+ "\n(3)Delete existing usesrs through a file?"
				+ "\n(4)Retrieve existing users through a file?");
		System.out.print(">");
		int command = input.nextInt();
		System.out.println("Where is your file located at (global)? "
				+ "(the database should be a csv file): ");
		System.out.print(">");
		//Adding input2 for collision
		Scanner input2 = new Scanner(System.in);
		String fileLocation = input2.nextLine();
		
		readObj.readFile(fileLocation,command);

		}
	else if(userInput.equals("quit") || userInput.equals("Quit") 
			|| userInput.equals("QUIT"))
	{
		quit = true;
	}
	else 
	{
		System.out.println("Entering CMD...");
		databaseObj.command();
	}

	
	}
	}
}
