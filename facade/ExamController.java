package StudentenVerwaltung.facade;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import StudentenVerwaltung.Domain.Database;
import StudentenVerwaltung.Domain.ExamsManager;


public class ExamController {
		public void controller() throws IOException, ClassNotFoundException {
		Database databaseObj = new Database();
		ExamCLI cli = new ExamCLI();
		ExamsManager em = new ExamsManager();
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
			
			System.out.println("Where is your file located at (global)? "
					+ "(the database should be a csv file): ");
			System.out.print(">");
			//Adding input2 for collision
			Scanner input2 = new Scanner(System.in);
			String fileLocation = input2.nextLine();
			try {
				em.readFile(fileLocation);
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
		else 
		{
			System.out.println("Entering CMD...");
			cli.mainMenu();
		}

		}
		}
		}
		




