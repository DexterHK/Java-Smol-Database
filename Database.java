
import java.io.FileNotFoundException; 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class Database { 
//	private ArrayList<Student> studenten;
	private static	ArrayList<Student> students = new ArrayList<Student>();
	private	 static ArrayList<Student> backup = new ArrayList<Student>();
	private static int fivedigits = 00000;
	private final int year = 22;
	//Auto-Generation.
	//It starts with 22 then 
	//Then we take a look at the Semesterzahl
	// If it's Sommer -> we add 1. else if Winter -> 2
	//And then 5 Auto-Incremental digits
	public  int matgenerator(int numberOfSemesters)
	{
		int returnedValue = year*1000000;
		returnedValue += numberOfSemesters*100000;
		returnedValue += fivedigits;
		return returnedValue;
	}
	public void adduser(String name, String firstName,int numberOfSemesters)
	{
		fivedigits++;
		if( numberOfSemesters <= 0)
		{
			System.out.println("Wrong Matknr or semesterzahl");
			return;
		}
		if(name == null || name == "" || firstName == null || firstName == "" )
		{
			System.out.println("Invalid input!");
			return;
		}
		if(exists(matgenerator(numberOfSemesters)))
		{
			System.out.println("A user with this Matknr was already register!");
			System.out.println("You can use the command 'update' to change the user.");
			return;
		}
		Student temp = new Student(name,firstName,matgenerator(numberOfSemesters),numberOfSemesters);
		students.add(temp);
		System.out.println("successfully added the user:");
		printOne(matgenerator(numberOfSemesters));
	}
	public void adduser(String name, String firstName)
	{
		fivedigits++;
		if( name == null || name== "" || firstName == null || firstName == "" )
		{
			System.out.println("Invalid Input!");
			return;
		}
		if(exists(matgenerator(1)))
		{
			System.out.println("A user with this Matknr was already register!");
			System.out.println("You can use the command 'update' to change the user.");
			return;
		}
		Student temp = new Student(name,firstName,matgenerator(1));
		students.add(temp);
		System.out.println("successfully added the user:");
		printOne(matgenerator(1));
	}
	public boolean exists(int matknr)
	{
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
			System.out.println("Inavlid!");
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
	        pw.println(s.getName() + ";" + s.getVorname() + ";" + s.getMatknr() + ";" + s.getnumberOfSemesters());
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
	        pw.println(s.getName() + ";" + s.getVorname() + ";" + s.getMatknr() + ";" + s.getnumberOfSemesters());
	    pw.close();
	}
	public void print()
	{
		int counter = 0;
		for(Student s : students)
			System.out.println("id: " + counter++ + " Name: "+ s.getName() + "," 
		+ " Vorname: " + s.getVorname() + ","
		+ " Matrikelnummber: " + s.getMatknr() + ","
		+ " Semesteranzahl:" + s.getnumberOfSemesters());
			
	}
	public void printDeleted()
	{
		int counter = 0;
		for(Student s : backup)
			System.out.println("id: " + counter++ + " Name: "+ s.getName() + "," 
		+ " Vorname: " + s.getVorname() + ","
		+ " Matrikelnummber: " + s.getMatknr() + ","
		+ " Semesteranzahl:" + s.getnumberOfSemesters());
			
	}
	public void printOne(int matknr)
	{
		int counter = 0;
		for(Student s : students)
		{	if(matknr == s.getMatknr())
			{
				
			System.out.println("id: " + counter++ + " Name: "+ s.getName() + "," 
					+ " Vorname: " + s.getVorname() + ","
					+ " Matrikelnummber: " + s.getMatknr() + ","
					+ " Semesteranzahl:" + s.getnumberOfSemesters());
			break;
			}
		}
	}
	public void adduserwithoutnumberOfSemesters(String name, String firstName, int matknr)
	{
		if(matknr <= 0 || name == null || name== "" || 
				firstName == null || firstName == "" || matknr <= 0)
		{
			System.out.println("Invalid Input!");
			return;
		}
		
		students.add(new Student(name,firstName,matknr));
	}
	
	public void update(String name, String vorname, int matknr,int numberOfSemesters)
	{
		if(matknr <= 0 || numberOfSemesters <= 0)
		{
			System.out.println("Wrong Matknr or semesterzahl");
			return;
		}
		Student temp = new Student(name,vorname,matknr,numberOfSemesters);
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
	public void update(String name, String vorname, int matknr)
	{
		if(matknr <= 0 || name == null || name== "" ||
				vorname == null || vorname == "" || matknr <= 0)
		{
			System.out.println("Invalid Input!");
			return;
		}
		Student zusatzSpeicher = new Student(name,vorname,matknr);
		int counter = 0 ;
		
		boolean found = false;
		for(Student s : students)
			{	
			if(matknr == s.getMatknr())
			{
				
				students.set(counter,zusatzSpeicher);
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
	public void printcommands()
	{
		
		System.out.println("CMD:");
		System.out.println("This are the following commands to use:");
		System.out.println("To create a user use the command: ('create' name vorname matknr semesteranzahl)");
		System.out.println("To retrieve a user use the command: ('retrieve' matknr)");
		System.out.println("To update a user use the command: ('update' name vorname matknr semesteranzahl)");
		System.out.println("To delete a user use the command: ('delete' matknr)");
		System.out.println("To print all users use the command ('print-all')");
		System.out.println("To print a user use the command ('print' matknr)");
		System.out.println("To save the file use the command ('save') Note:the database should be a csv file: ");
		System.out.println("To save the deleted-database use the command ('save-deleted') Note:the database should be a csv file: ");
		System.out.println("To see more type ('info')");
		System.out.println("To quit use the command: ('quit')");
		
	}
public void dex() throws IOException
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
case "save-deleted":
	System.out.println("Where do you want me to save your file, sir?");
	System.out.print(">");
	fileLocation = scanner.nextLine();
	saveDeleted(fileLocation);
	break;
default:
	break;
        }

} while (!quit);


}
public void dex(ArrayList<String> csvInput)
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
case "print-all":
		print();
		break;
case "print":
	printOne(Integer.parseInt(paramter[0]));
	break;
default:
	break;
        }

} while (iterate.hasNext());
}

}
}
