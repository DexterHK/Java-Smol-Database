package StudentenVerwaltung.Presistance;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import StudentenVerwaltung.Domain.Database;
import StudentenVerwaltung.Domain.Exams;
import StudentenVerwaltung.Domain.ExamsManager;
import StudentenVerwaltung.Domain.Student;

public class ReadFileExam {

private static  ArrayList<Exams> exams;
	
	public void readFile(String fileLocation)  throws IOException, ClassNotFoundException
	{
		ExamsManager em = new ExamsManager();
		try (InputStream is = Files.newInputStream(Paths.get(fileLocation));
			     ObjectInputStream iis = new ObjectInputStream(is)) {
			  ArrayList<Exams> temp = (ArrayList<Exams>) iis.readObject();
			  iis.close();
			  em.setExams(temp);
			}
		
	}
	
}
