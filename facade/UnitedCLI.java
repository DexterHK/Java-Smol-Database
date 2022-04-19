package StudentenVerwaltung.facade;

import java.io.IOException;
import java.util.Scanner;

import StudentenVerwaltung.Domain.ExamsManager;

public class UnitedCLI {
	public void printcommands()
	{
		
		System.out.println("CMD:"

		+ "\nTo print all users use the command ('print-all')"
		+ "\nTo print a user use the command ('print' matknr)"
		+ "\nTo quit use the command: ('quit')");
		
	}
	public void unitedCommand() throws IOException
	{
		CLI cli = new CLI();
		printcommands();
		ExamsManager em = new ExamsManager();
		boolean quit = false;
		Scanner scanner = new Scanner(System.in);
	    String input;
	    final int INDEX_PARAMTER = 1;
	    final int INDEX_COMMAND = 0;
	    do {
	    	System.out.print(">");
	        input = scanner.nextLine();
	        String[] command = input.split(" ");
	        String[] paramter = new String[0];
	       if(command.length > INDEX_PARAMTER) {
	    	   paramter  = command[INDEX_PARAMTER].split(";");
	       }
	switch (command[INDEX_COMMAND]) {
	case "print-all":
		cli.print();
		em.printAll();
			break;
	case "print":
		try {
		cli.printOne(Integer.parseInt(paramter[0]));
		em.printuser(Integer.parseInt(paramter[0]));
		}
		catch (NumberFormatException  | ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid parameter");
			break;
			}
		break;
	case "quit":
		quit = true;
		System.out.println("Quitting... to main menu");
		break;
	case "info":
		printcommands();
	default:
		System.out.println("Invalid command!");
		System.out.println("Type 'info' for more :)");
		break;
	        }


	} while (!quit);
	
		
		
		
		
		
		
		
	}
	
	
}
