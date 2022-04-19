package StudentenVerwaltung.Presistance;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import StudentenVerwaltung.Domain.Database;
import StudentenVerwaltung.Domain.Student;

public class ReadFile {
	private static  ArrayList<Student> students;
	
	public void readFile(String fileLocation)  throws IOException, ClassNotFoundException
	{
		Database db = new Database();
		try (InputStream is = Files.newInputStream(Paths.get(fileLocation));
			     ObjectInputStream iis = new ObjectInputStream(is)) {
			  ArrayList<Student> temp = (ArrayList<Student>) iis.readObject();
			  iis.close();
			 db.setStudent(temp);
			}
		
	}
	
}
