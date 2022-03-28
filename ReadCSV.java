package StudentenVerwaltung;
import java.util.*;
import java.io.*;


public class ReadCSV {
	private	ArrayList<String> csvInput = new ArrayList<String>();
	//In case of missing the folder/Directory this function has the right to throw an Exception.
	
public void readFile(String fileLocation, int commandNumber) throws FileNotFoundException
{
	Database databaseObj = new Database();
	File getCSVFile = new File(fileLocation);
	Scanner input = new Scanner(getCSVFile);
	//My method is simply to add create before the database, which adds all together.
	String convertedCommand = "";
	switch(commandNumber)
	{
	case 1:
		convertedCommand = "create ";
		break;
	case 2: 
		convertedCommand = "update ";
		break;
	case 3:
		convertedCommand = "delete ";
		break;
	case 4:
		convertedCommand = "retrieve ";
		break;
	}
	while(input.hasNext())
	{
		 csvInput.add(convertedCommand + input.next());
	}
		databaseObj.command(csvInput);
		csvInput.clear();
		
	input.close();
}

	

}
