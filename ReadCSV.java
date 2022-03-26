
import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.charset.Charset;

public class ReadCSV {
	private	ArrayList<String> csvInput = new ArrayList<String>();
public void readFile(String fileLocation) throws FileNotFoundException
{
	Database databaseObj = new Database();
	File getCSVFile = new File(fileLocation);
	Scanner input = new Scanner(getCSVFile);
	
	while(input.hasNext())
	{
		 csvInput.add("create "+ input.next());
	}
	 
		databaseObj.dex(csvInput);

	input.close();
	
}
	
}
