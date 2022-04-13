package StudentenVerwaltung.Domain;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Scanner;

public class ExamsManager {
	
	//Temp, I HOPE HOPE HOPE
	/*
	 * Class to combine both of Exams and Students.
	 */
		

	private static	ArrayList<Exams> exams = new ArrayList<Exams>();
	private Database database;
	
	public boolean setGrade(int matknr,String exam,double grade)
	{
		int counter = 0;
		try {
		for(Exams e : exams)
		{
			
			if(e.getMatknr() == matknr && e.getExams().equals(exam))
			{
				Exams temp = exams.get(counter);
				GradeUnit gradeObj = new GradeUnit(grade);
				gradeObj.setValue(grade);
				Exams modified = new Exams(matknr,temp.getExams(),temp.getSemester(),temp.getECT(),gradeObj.getValue());
				exams.set(counter, modified);
				return true;
				
			}
			counter++;
		}
		}

		catch(IndexOutOfBoundsException  e)
		{
			System.out.println("Invalid input");
			return false;
		}
		
		return false;
	}
	
	public boolean addExam(int matknr,String exam,String semester)
	{
		 database = new Database();
		if(!database.exists(matknr))
		{
			return false;
		}
		if(exam == null || exam == "" || semester == null || semester == "")
		{
			return false;
		}
	if(!limit(matknr)) 
	{
		return false;
	}
	exams.add(new Exams(matknr,exam,semester));
	return true;	
	}
	public boolean addExam(int matknr,String exam,String semester,int ETC)
	{
		 database = new Database();
		if(!database.exists(matknr))
		{
			return false;
		}
		if(exam == null || exam == "" || semester == null || semester == "")
		{
			return false;
		}
	if(!limit(matknr)) 
	{
		return false;
	}
	exams.add(new Exams(matknr,exam,semester,ETC));
	return true;	
	}
	
	//Remove exam from student using matknr
	public boolean removeExam(int matknr,String exam)
	{
		if(exam == null || exam == "")
		{
			return false;
		}
		for(Exams e : exams)
		{
			if(e.getExams().equals(exam) && e.getMatknr() == matknr)
			{
				System.out.println("true");
				exams.remove(e);
				return true;
			}
		}
	return false;	
	}

	public boolean limit(int matknr)
	{
		int counter = 0;
		for(Exams e : exams)
		{
			if(e.getMatknr() == matknr)
			{
				counter++;
				
			}
		}
		if(counter > 10 )
		{
			return false;
		}
		
		return true;
	}
	

	
	public void printuser(int matknr)
	{
	    database = new Database();
		int counter = 0;
		for(Exams e : exams)
		{
			if(e.getMatknr() == matknr) {
				counter++;
			}
		}
		String output[] = new String[counter] ;
		counter = 0;
		for(Exams e : exams)
		{
			if(e.getMatknr() == matknr  && database.exists(matknr)) {
			output[counter++] = "Exam: " + e.getExams() + " Name: " + database.importMatknr(matknr)
			+ " Grade: "+ e.getGrade();
			}
		}
		for(int i = 0;i<output.length;i++) {
		System.out.println(output[i]);
		}
	}
	public void printAll()
	{
		database = new Database();
		int counter = 0;
		for(Exams e : exams)
		{
				counter++;
			
		}
	String[] output = new String[counter];	
		counter = 0;
		for(Exams e : exams)
		{
			output[counter++] = "Exam: " + e.getExams() + " Name: " + database.importMatknr(e.getMatknr())
			+ " Grade: "+ e.getGrade();
			
		}
		for(int i = 0;i<output.length;i++)
		{
			System.out.println(output[i]);
		}
		
	}
	public boolean save(String fileLocation) throws FileNotFoundException  {
		if(fileLocation == null || fileLocation =="")
		{
			return false;
		}
	    PrintWriter pw = new PrintWriter(fileLocation);
	    for (Exams s : exams)
	        pw.println(s.getMatknr() + ";" + s.getExams() + ";" + s.getSemester() + ";" + s.getECT());
	    pw.close();
	    return true;
	}
	
}
