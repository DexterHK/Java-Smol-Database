package StudentenVerwaltung.Presistance;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import StudentenVerwaltung.Domain.Exams;
import StudentenVerwaltung.Domain.ExamsManager;
import StudentenVerwaltung.Domain.Student;

public class WriteFileExam {
	private static  ArrayList<Exams> e;
	public boolean save(String fileLocation) throws IOException  {
		ExamsManager em = new ExamsManager();
		if(fileLocation == null || fileLocation =="")
		{
			return false;
		}
		e = em.getExams();
		FileOutputStream fileOut = new FileOutputStream(fileLocation);
		ObjectOutputStream oos = new ObjectOutputStream(fileOut);
			oos.writeObject(e);
	    
	    oos.close();
	    return true;
	}


}
