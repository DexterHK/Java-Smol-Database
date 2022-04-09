package StudentenVerwaltung.facade;

import java.util.Scanner;

import StudentenVerwaltung.Domain.ExamsManager;

public class ExamCLI {
	private ExamsManager em;
	public void addExam(int matknr,String exam,String semester,int ETC)
	{
	boolean output = em.addExam(matknr, exam, semester, ETC);
	if(!output)
	{
		System.out.println("Invalid input!");
	} 
	else {
		System.out.println("successfully added the user.");
	}
	}
	public void addExam(int matknr,String exam,String semester)
	{
		boolean output = em.addExam(matknr, exam, semester);
		if(!output)
		{
			System.out.println("Invalid input!");
		} 
		else {
			System.out.println("successfully added the user.");
		}
	}
	public void removeExam(int matknr,String exam)
	{
		boolean output = em.removeExam(matknr, exam);
		if(!output)
		{
			System.out.println("Invalid input!");
		} 
		else {
			System.out.println("successfully removed the user.");
		}
	}
		
	
	public void printcommands()
	{
		
		System.out.println("CMD:"
		+ "\nThis are the following commands to use:"
		+ "\nTo create a user use the command: ('add' (matknr;exam Name;)"
		+ "\nTo delete a user use the command: ('delete' (matknr or name))"
		+ "\nTo print all users use the command ('print-all')"
		+ "\nTo print a user use the command ('print' (matknr or name))"
		+ "\nTo see more type ('info')"
		+ "\nTo quit use the command: ('quit')");
		
	}
	//The Idea is to create a recursive main menu
	// First we start with a yes/no question 
	//After that we have a normal main menu explained in the docu
	//Now we create a main menu that only exists if you choose to enter the exams menu
	public void mainMenu()
	{
		ExamsManager em = new ExamsManager();
		printcommands();
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
	case "add":
		if(paramter.length == 4) {
		try {
			addExam(Integer.parseInt(paramter[0]),paramter[1],paramter[2],Integer.parseInt(paramter[3]));
		}
		catch (NumberFormatException  | ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid parameter");
			break;
			}
		break;
		}
			try {
				addExam(Integer.parseInt(paramter[0]),paramter[1],paramter[2]);
			}
			catch (NumberFormatException  | ArrayIndexOutOfBoundsException e){
				System.out.println("Invalid parameter");
				break;
				}
			
		break;
	case "remove":
		
		try {
			removeExam(Integer.parseInt(paramter[0]),paramter[1]);
		}
		catch (NumberFormatException  | ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid parameter");
			break;
			}
		break;
	case "print-all":
		em.printAll();
			break;
	case "print":
		
		try {
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
		break;
	default:
		System.out.println("Invalid command!");
		System.out.println("Type 'info' for more :)");
		break;
	        }

	} while (!quit);


	
	}
}
