package StudentenVerwaltung.UI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


import StudentenVerwaltung.Domain.Database;
import StudentenVerwaltung.Domain.ExamsManager;
import StudentenVerwaltung.Presistance.WriteFile;
import StudentenVerwaltung.facade.ExamController;

public class CLI {
	private Database database;
	public CLI()
	{
		database = new Database();
	}
	public void adduser(String lastname, String firstName)
	{
		boolean output = database.adduser(lastname, firstName);
		if(!output)
		{
			System.out.println("Invalid input!");
		} 
		else {
			System.out.println("successfully added the user:");
		}
	}
	public void adduser(String lastname, String firstName,int numberOfSemesters)
	{
		boolean output = database.adduser(lastname, firstName,numberOfSemesters);
		if(!output)
		{
			System.out.println("Invalid input!");
		} 
		else {
			System.out.println("successfully added the user:");
		}
	}
	public void delete(int matknr)
	{
		boolean output = database.delete(matknr);
	if(!output) {
		System.out.println("Invalid input");
		System.out.println("User: " + matknr + " not found!");
		System.out.println("All users:");
		print();
	}
	else
	{
		System.out.println("deleted!");
	}
		
	}
	public void retrieve(int matknr)
	{
		boolean output = database.retrieve(matknr);
	if(!output)
	{
		System.out.println("Inavlid matriculation number!");
		System.out.println("This user does either not exist at all or is already in database and was not delete");
		System.out.println("This is all deleted users:");
		printDeleted();
	}
	else
	{
		System.out.println("Retrieved!");
	}
	}
	public void	save(String fileLocation) throws IOException
	{
		
		WriteFile wf = new WriteFile();
		boolean output = wf.save(fileLocation);
		if(!output)
		{
			System.out.println("Invalid file location");
		}
	}
	public void saveDeleted(String fileLocation) throws IOException
	{
		WriteFile rf = new WriteFile();
		boolean output = rf.saveDeleted(fileLocation);
		if(!output)
		{
			System.out.println("Invalid file location");
		}
	}
	public void print()
	{
		database.print();
	}
	public void printDeleted()
	{
		database.printDeleted();
	}
	public void printOne(int matknr)
	{
		database.printOne(matknr);
	}
	public void update(String lastname, String firstName, int matknr,int numberOfSemesters)
	{
		boolean output = database.update(lastname, firstName, matknr,numberOfSemesters);
	
		if(!output)
		{
			
			System.out.println("Invalid Input");
			System.out.println("User: " + matknr + " not found!");
			System.out.println("All users:");
			print();
		}
		else
		{
			System.out.println("successfully updated!");
		}
	}
	public void update(String lastname, String firstName, int matknr)
	{
		boolean output = database.update(lastname, firstName, matknr);
	
		if(!output)
		{
			
			System.out.println("Invalid Input");
			System.out.println("User: " + matknr + " not found!");
			System.out.println("All users:");
			print();
		}
		else
		{
			System.out.println("successfully updated!");
		}
	}
	
	//This function should be printed out before the user-input pops up and if the user requests it.
	//Example: the command info should pop up this for more information.
	public void printcommands()
	{
		
		System.out.println("CMD:"
		+ "\nThis are the following commands to use:"
		+ "\nTo create a user use the command: ('create' lastname;firstname;numberOfSemesters)"
		+ "\nTo retrieve a user use the command: ('retrieve';matriculation number')"
		+ "\nTo update a user use the command: ('update';name;firstname;matriculation number;numberOfSemesters)"
		+ "\nTo delete a user use the command: ('delete';matriculation number)"
		+ "\nTo print all users use the command ('print-all')"
		+ "\nTo print a user use the command ('print' matknr)"
		+ "\nTo save the file use the command ('save') Note:the database should be a csv file: "
		+ "\nTo save the deleted-database use the command ('save-deleted') Note:the database should be a csv file: "
		+ "\nTo log in the exams main menu ('exam')"
		+ "\nTo see more type ('info')"
		+ "\nTo quit use the command: ('quit')");
		
	}
	//Here is where all the methods are going to be used
	public void command() throws IOException, ClassNotFoundException
	{
		printcommands();
		GUI gui = new GUI();
		gui.show();
		ExamController ec = new ExamController();
		boolean quit = false;
		Scanner scanner = new Scanner(System.in);
	    String input;
	    String fileLocation;
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
	case "create":
		if(paramter.length == 3)
			{
			try {
			adduser(paramter[0],paramter[1],Integer.parseInt(paramter[2]));
			}
			catch (NumberFormatException  | ArrayIndexOutOfBoundsException e){
				System.out.println("Invalid parameter");
				break;
				}
			break;
			}
		try {
		adduser(paramter[0],paramter[1]);
		}
		catch (NumberFormatException  | ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid parameter");
			break;
			}
		break;
	case "retrieve":
		try {
		retrieve(Integer.parseInt(paramter[0]));
		}
		catch (NumberFormatException  | ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid parameter");
			break;
			}
		break;
	case "update":
		if(paramter.length == 3)
		{
			try {
			update(paramter[0],paramter[1],Integer.parseInt(paramter[2]));
			}
			catch (NumberFormatException  | ArrayIndexOutOfBoundsException e){
				System.out.println("Invalid parameter");
				break;
				}
			break;
		}
		try {
		update(paramter[0],paramter[1],Integer.parseInt(paramter[2]),Integer.parseInt(paramter[3]));
		}
		catch (NumberFormatException  | ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid parameter");
			break;
			}
		break;
	case "delete":
		try {
		delete(Integer.parseInt(paramter[0]));
		}
		catch (NumberFormatException  | ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid parameter");
			break;
			}
		break;
	case "print-all":
			print();
			break;
	case "print":
		try {
		printOne(Integer.parseInt(paramter[0]));
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
	case "save":
		System.out.println("Where do you want me to save your file, sir?");
		System.out.print(">");
		fileLocation = scanner.nextLine();
		save(fileLocation);
		break;
	case "info":
		printcommands();
	case "print-deleted":
		printDeleted();
		break;
	case "save-deleted":
		System.out.println("Where do you want me to save your file, sir?");
		System.out.print(">");
		fileLocation = scanner.nextLine();
		saveDeleted(fileLocation);
		break;
	case "exam":
		ec.controller();
	default:
		System.out.println("Invalid command!");
		System.out.println("Type 'info' for more :)");
		break;
	        }

	} while (!quit);


	}
	//This function is overloaded to be used by a database only.
	public void command(ArrayList<String> csvInput)
	{
		printcommands();
	    Iterator<String> iterate = csvInput.iterator();
		
	{

	    final int INDEX_PARAMTER = 1;
	    final int INDEX_COMMAND = 0;
	    do {
	    	System.out.print(">");
	        String[] command = iterate.next().split(" ");
	        String[] paramter = command[INDEX_PARAMTER].split(";");
	switch (command[INDEX_COMMAND]) {
	case "create":
		if(paramter.length == 3)
			{
			adduser(paramter[0],paramter[1],Integer.parseInt(paramter[2]));
			break;
			}
		adduser(paramter[0],paramter[1],Integer.parseInt(paramter[3]));
		break;
	case "retrieve":
		retrieve(Integer.parseInt(paramter[0]));
		print();
		break;
	case "update":
		if(paramter.length == 3)
		{
			update(paramter[0],paramter[1],Integer.parseInt(paramter[2]));
			break;
		}
		update(paramter[0],paramter[1],Integer.parseInt(paramter[2]),Integer.parseInt(paramter[3]));
		break;
	case "delete":
		delete(Integer.parseInt(paramter[0]));
		break;
	default:
		break;
	        }

	} while (iterate.hasNext());
	    
	}
	}
}

