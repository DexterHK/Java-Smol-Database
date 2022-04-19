package StudentenVerwaltung.Presistance;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import StudentenVerwaltung.Domain.Database;
import StudentenVerwaltung.Domain.Student;

public class WriteFile {
private static  ArrayList<Student> students;
private static  ArrayList<Student> backup;
	public boolean save(String fileLocation) throws IOException  {
		if(fileLocation == null || fileLocation =="")
		{
			return false;
		}
		Database db = new Database();
		students = db.getStudent();
		FileOutputStream fileOut = new FileOutputStream(fileLocation);
		ObjectOutputStream oos = new ObjectOutputStream(fileOut);
			oos.writeObject(students);
	    
	    oos.close();
	    return true;
	}
	public boolean saveDeleted(String fileLocation) throws IOException  {
		if(fileLocation == null || fileLocation =="")
		{
			return false;
		}
		Database db = new Database();
		backup = db.getStudent();
		FileOutputStream fileOut = new FileOutputStream(fileLocation);
		ObjectOutputStream oos = new ObjectOutputStream(fileOut);
			oos.writeObject(backup);
	    
	    oos.close();
	    return true;
	}
}
