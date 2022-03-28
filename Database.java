package StudentenVerwaltung;
import java.io.FileNotFoundException; 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class Database { 
	//Static to have not all the database NOT deleted if the user switches to another object like "Main"
	//For example: by quitting from the CLI
	private static	ArrayList<Student> students = new ArrayList<Student>();
	private	 static ArrayList<Student> backup = new ArrayList<Student>(); 
	private static int fivedigits = 00000; //Must be static to have an incremental matriculation number
	private final int year = 22; //Year is a constant, due to this year!
	
	public  int matgenerator(int numberOfSemesters)
	{
		// Multiply it by 1000000 to push the year ahead other numbers.to make it look like this 22000000
		int returnedValue = year*1000000; 
		//Now we multiply the number of semesters with only 00000 digits, because of the varaible "fivedigits"
		//All we want to achieve is to make this variable ahead the other.
		returnedValue += numberOfSemesters*100000;
		returnedValue += fivedigits;
		return returnedValue;
	}
	public void adduser(String lastname, String firstName,int numberOfSemesters)
	{
		//users should be incremented everytime on of them is created.
		fivedigits++;
		//Input mistakes should not be accepted 
		if( numberOfSemesters <= 0 || numberOfSemesters >= 20)
		{
			System.out.println("Wrong matriculation number or number of Semesters");
			return;
		}
		if(lastname == null || lastname == "" || firstName == null || firstName == "" ||
				firstName.length() >= 20 || lastname.length() >= 20 || numberOfSemesters <= 0 || numberOfSemesters > 2)
		{
			System.out.println("Invalid input!");
			return;
		}
		//If Matriculation number was already in use!
		if(exists(matgenerator(numberOfSemesters)))
		{ 
			System.out.println("A user with this Matriculation number was already register!");
			System.out.println("You can use the command 'update' to change the user.");
			return;
		}
		Student temp = new Student(lastname,firstName,matgenerator(numberOfSemesters),numberOfSemesters);
		students.add(temp);
		System.out.println("successfully added the user:");
		printOne(matgenerator(numberOfSemesters));
	}
	//overloading, to make it easier to catch all user input!.
	//The number of semesters is just an option and not something necessarily 
	public void adduser(String lastname, String firstName)
	{
		//users should be incremented everytime on of them is created.
		fivedigits++;
		if( lastname == null || lastname== "" || firstName == null || firstName == "" 
				|| firstName.length() >= 20 || lastname.length() >= 20 )
		{
			System.out.println("Invalid Input!");
			return;
		}
		//If Matriculation number was already in use!
		if(exists(matgenerator(1)))
		{
			System.out.println("A user with this Matknr was already register!");
			System.out.println("You can use the command 'update' to change the user.");
			return;
		}
		Student temp = new Student(lastname,firstName,matgenerator(1));
		students.add(temp);
		System.out.println("successfully added the user:");
		printOne(matgenerator(1));
	}
	// Return true if Matriculation number was already created!
	public boolean exists(int matknr)
	{
		//Loop through all users and look for the for any mat in the database that matches the parameter
		for(Student s : students)
			if(matknr == s.getMatknr())
			   return true;
	return false;
	}
	
	public void delete(int matknr)
	{
		if(matknr <= 0)
			{
			System.out.println("Invalid input");
			return;
			}
		boolean found = false;
		for(Student s : students)
		{	if(matknr == s.getMatknr())
			{
			    printOne(matknr);
			    backup.add(s);
				students.remove(s);
				System.out.println("deleted!");
				found = true;
				break;
			}
		}
		if(!found)
		{
			System.out.println("User: " + matknr + " not found!");
			System.out.println("All users:");
			print();
		}
	}
	// Loop through deleted users "backup" to match the same condition up 
	public Student isdeleted(int matknr)
	{
		for(Student s : backup)
			{
			if(matknr == s.getMatknr())
			{
				Student temp = s;
				//backup.remove(s);
				return temp;
			}
			}
			return null;
	}
	public void retrieve(int matknr)
	{
		if(isdeleted(matknr) == null || matknr <= 0)
		{
			System.out.println("Inavlid matriculation number!");
			System.out.println("This user does either not exist at all or is already in database and was not delete");
			System.out.println("This is all deleted users:");
			printDeleted();
			return;
		}
		Student temp = isdeleted(matknr);
		students.add(temp);
		
		
	}
	public void save(String fileLocation) throws FileNotFoundException  {
		if(fileLocation == null || fileLocation =="")
		{
			System.out.println("Invalid file location");
			return;
		}
	    PrintWriter pw = new PrintWriter(fileLocation);
	    for (Student s : students)
	        pw.println(s.getName() + ";" + s.getFirstname() + ";" + s.getMatknr() + ";" + s.getnumberOfSemesters());
	    pw.close();
	}
	public void saveDeleted(String fileLocation) throws FileNotFoundException  {
		if(fileLocation == null || fileLocation =="")
		{
			System.out.println("Invalid file location");
			return;
		}
		
	    PrintWriter pw = new PrintWriter(fileLocation);
	    for (Student s : backup)
	        pw.println(s.getName() + ";" + s.getFirstname() + ";" + s.getMatknr() + ";" + s.getnumberOfSemesters());
	    pw.close();
	}
	//Print and printDeleted are the same the only difference to not overload, was the name.
	//Because "print" only should print normal users and not the deleted too.
	public void print()
	{
		int counter = 0;
		for(Student s : students)
			System.out.println("id: " + counter++ + " Lastname: "+ s.getName() + "," 
		+ " Firstname: " + s.getFirstname() + ","
		+ " Matriculation number: " + s.getMatknr() + ","
		+ " number of semesters:" + s.getnumberOfSemesters());
			
	}
	public void printDeleted()
	{
		int counter = 0;
		for(Student s : backup)
			System.out.println("id: " + counter++ + " Lastname: "+ s.getName() + "," 
		+ " Firstname: " + s.getFirstname() + ","
		+ " Matriculation number: " + s.getMatknr() + ","
		+ " number of semesters:" + s.getnumberOfSemesters());
			
	}
	public void printOne(int matknr)
	{
		int counter = 0;
		for(Student s : students)
		{	if(matknr == s.getMatknr())
			{
				
			System.out.println("id: " + counter++ + " Lastname: "+ s.getName() + "," 
					+ " Firstname: " + s.getFirstname() + ","
					+ " Matriculation number: " + s.getMatknr() + ","
					+ " number of semesters:" + s.getnumberOfSemesters());
			break;
			}
		}
	}
	//overloading update to make things easier for user-input
	public void update(String lastname, String firstName, int matknr,int numberOfSemesters)
	{
		//catching wrong user input
		if(matknr <= 0 || numberOfSemesters <= 0 || 
				firstName.length() >= 20 || lastname.length() >= 20
				|| numberOfSemesters <= 0 || numberOfSemesters >= 20)
		{
			System.out.println("Wrong matriculation number or number of Semesters");
			return;
		}
		Student temp = new Student(lastname,firstName,matknr,numberOfSemesters);
		int counter = 0 ;
		
		boolean found = false;
		for(Student s : students)
			{	
			if(matknr == s.getMatknr())
			{
				
				students.set(counter,temp);
				found = true;
				printOne(matknr);
				System.out.println("successfully updated!");
				break;
			}
			counter++;
			}
		if(!found)
		{
			System.out.println("User: " + matknr + " not found!");
			System.out.println("All users:");
			print();
		}
		
	}
	public void update(String lastname, String firstName, int matknr)
	{
		if(matknr <= 0 || lastname == null || lastname== "" ||
				firstName == null || firstName == "" || firstName.length() >= 20 || lastname.length() >= 20)
		{
			System.out.println("Invalid Input!");
			return;
		}
		Student temp = new Student(lastname,firstName,matknr);
		int counter = 0 ;
		
		boolean found = false;
		for(Student s : students)
			{	
			if(matknr == s.getMatknr())
			{
				
				students.set(counter,temp);
				found = true;
				printOne(matknr);
				System.out.println("successfully updated!");
				break;
			}
			counter++;
			}
		if(!found)
		{
			System.out.println("User: " + matknr + " not found!");
			System.out.println("All users:");
			print();
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
		+ "\nTo update a user use the command: ('update';name;firstname;numberOfSemesters)"
		+ "\nTo delete a user use the command: ('delete';matriculation number)"
		+ "\nTo print all users use the command ('print-all')"
		+ "\nTo print a user use the command ('print' matknr)"
		+ "\nTo save the file use the command ('save') Note:the database should be a csv file: "
		+ "\nTo save the deleted-database use the command ('save-deleted') Note:the database should be a csv file: "
		+ "\nTo see more type ('info')"
		+ "\nTo quit use the command: ('quit')");
		
	}
	//Here is where all the methods are going to be used
public void command() throws IOException
{
	printcommands();
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
		adduser(paramter[0],paramter[1],Integer.parseInt(paramter[2]));
		break;
		}
	adduser(paramter[0],paramter[1],Integer.parseInt(paramter[3]));
	break;
case "retrieve":
	retrieve(Integer.parseInt(paramter[0]));
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
case "print-all":
		print();
		break;
case "print":
	printOne(Integer.parseInt(paramter[0]));
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
