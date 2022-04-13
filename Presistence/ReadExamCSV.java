package StudentenVerwaltung.Presistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import StudentenVerwaltung.facade.CLI;
import StudentenVerwaltung.facade.ExamCLI;

public class ReadExamCSV {
	private	ArrayList<String> csvInput = new ArrayList<String>();
	//In case of missing the folder/Directory this function has the right to throw an Exception.
	
public void readFile(String fileLocation, int commandNumber) throws FileNotFoundException
{
	
	ExamCLI cli = new ExamCLI();
	File getCSVFile = new File(fileLocation);
	Scanner input = new Scanner(getCSVFile);
	//My method is simply to add create before the database, which adds all together.
	String convertedCommand = "";
	switch(commandNumber)
	{
	case 1:
		convertedCommand = "add ";
		break;
	case 2: 
		convertedCommand = "remove ";
		break;
	default:
		System.out.println("Wrong Value...");
		return;
	}
	while(input.hasNext())
	{
		 csvInput.add(convertedCommand + input.next());
	}
	cli.mainMenu(csvInput);
		csvInput.clear();
		
	input.close();
}
}
