package StudentenVerwaltung.Domain;
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
	public String importMatknr(int matknr)
	{
		for(Student s : students)
			if(matknr == s.getMatknr())
			   return s.getFirstname() + " " + s.getName() ;
	return null;
	}
	public String importName(String name)
	{
		for(Student s : students)
			if(name.equals(s.getName()))
			   return  s.getName() ;
	return null;
	}
	public String importFirstName(String firstName)
	{
		for(Student s : students)
			if(firstName.equals(s.getFirstname()))
			   return  s.getFirstname();
	return null;
	}
	public boolean adduser(String lastname, String firstName,int numberOfSemesters)
	{
		//users should be incremented everytime on of them is created.
		
		//Input mistakes should not be accepted 
		if( numberOfSemesters <= 0 || numberOfSemesters >= 20)
		{
			return false;
		}
		if(lastname == null || lastname == "" || firstName == null || firstName == "" ||
				firstName.length() >= 40 || lastname.length() >= 40 || numberOfSemesters <= 0 || numberOfSemesters > 2)
		{
			
			return false;
		}
		//If Matriculation number was already in use!
		fivedigits++;
		Student temp = new Student(lastname,firstName,matgenerator(numberOfSemesters),numberOfSemesters);
		students.add(temp);
		printOne(matgenerator(numberOfSemesters)); 
		return true;
	}
	//overloading, to make it easier to catch all user input!.
	//The number of semesters is just an option and not something necessarily 
	public boolean adduser(String lastname, String firstName)
	{
		
		if( lastname == null || lastname== "" || firstName == null || firstName == "" 
				|| firstName.length() >= 40 || lastname.length() >= 40 )
		{
			
			return false;
		}
		//users should be incremented everytime on of them is created.
		fivedigits++;
		
		Student temp = new Student(lastname,firstName,matgenerator(1));
		students.add(temp);
		printOne(matgenerator(1)); 
		return true;
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
	public int exists(String firstName, String name)
	{
		//Loop through all users and look for the for any mat in the database that matches the parameter
		for(Student s : students)
			if(firstName.equals(s.getFirstname()) && name.equals(s.getName()))
			   return s.getMatknr();
	return 0;
	}
	
	public boolean delete(int matknr)
	{
		if(matknr <= 0)
			{
			
			return false;
			}
		boolean found = false;
		for(Student s : students)
		{	if(matknr == s.getMatknr())
			{
			    printOne(matknr);
			    backup.add(s);
				students.remove(s);
				found = true;
				return true;
			}
		}
		
		return false;
	}
	// Loop through deleted users "backup" to match the same condition up 
	public Student isdeleted(int matknr)
	{
		for(Student s : backup)
			{
			if(matknr == s.getMatknr())
			{
				Student temp = s;
				
				return temp;
			}
			}
			return null;
	}
	public boolean retrieve(int matknr)
	{
		if(isdeleted(matknr) == null || matknr <= 0)
		{
			
			return false;
		}
		Student temp = isdeleted(matknr);
		students.add(temp);
		
		return true;
	}
	public boolean save(String fileLocation) throws FileNotFoundException  {
		if(fileLocation == null || fileLocation =="")
		{
			return false;
		}
	    PrintWriter pw = new PrintWriter(fileLocation);
	    for (Student s : students)
	        pw.println(s.getName() + ";" + s.getFirstname() + ";" + s.getMatknr() + ";" + s.getnumberOfSemesters());
	    pw.close();
	    return true;
	}
	public boolean saveDeleted(String fileLocation) throws FileNotFoundException  {
		if(fileLocation == null || fileLocation =="")
		{
			return false;
		}
		
	    PrintWriter pw = new PrintWriter(fileLocation);
	    for (Student s : backup)
	        pw.println(s.getName() + ";" + s.getFirstname() + ";" + s.getMatknr() + ";" + s.getnumberOfSemesters());
	    pw.close();
	    return true;
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
	public boolean update(String lastname, String firstName, int matknr,int numberOfSemesters)
	{
		//catching wrong user input
		if(matknr <= 0 || numberOfSemesters <= 0 || 
				firstName.length() >= 40 || lastname.length() >= 40
				|| numberOfSemesters <= 0 || numberOfSemesters >= 20)
		{
			
			return false;
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
				break;
			}
			counter++;
			}
		return true;
		
	}
	public boolean update(String lastname, String firstName, int matknr)
	{
		if(matknr <= 0 || lastname == null || lastname== "" ||
				firstName == null || firstName == "" || firstName.length() >= 40 || lastname.length() >= 40)
		{
			return false;
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
				
				break;
			}
			counter++;
			}
		return true;
	}

	

}
