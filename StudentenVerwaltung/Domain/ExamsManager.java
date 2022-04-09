package StudentenVerwaltung.Domain;

import java.util.ArrayList;
import java.util.Scanner;

public class ExamsManager {
	
	//Temp, I HOPE HOPE HOPE
	//Prüfungen:
	//What attributes do I need? Private ArrayList is enough. String.
	//Functions: Get, search, set, print-all-Exams,
	//Function die alle Prüfungen ausgibt, die man sich dafür angemeldet hat.
	//Wie viele Prüfungen gibt es? : Eine Liste von den Prüfugen soll erstellt werden, hhmm...
	//List, loop through it and see the match
	//Max limit : 10 Prüfungen ist der Limit... Sinnvoll
	//Minimum: Kein minimum, da man Pause haben kann.
	//Durch name oder Matrikelnummer? anmelden/abmelden.
	//Note: Man kann sich nicht zwei mal für die gleiche Prüfung anmelden.
	//Brauchen wir ein Menu für nur "Prüfugen" Reasonable...tbh.
		

	private static	ArrayList<Exams> exams = new ArrayList<Exams>();
	private Database database;
	
	//Oveload it and add using matriculation number
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
	//Overload the removeExam function and search by name

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
			output[counter++] = "Exam: " + e.getExams() + " Name: " + database.importMatknr(matknr) ;
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
			output[counter++] = "Exam: " + e.getExams() + " Name: " + database.importMatknr(e.getMatknr());
			
		}
		for(int i = 0;i<output.length;i++)
		{
			System.out.println(output[i]);
		}
		
	}
	
}
