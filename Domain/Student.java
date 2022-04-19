package StudentenVerwaltung.Domain;

import java.io.Serializable;

public class Student implements Serializable {

	//Attributes
	private String name;
private String firstname;
private int matknr;
private int numberOfSemesters;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String vorname) {
	this.firstname = vorname;
}
public int getMatknr() {
	return matknr;
}
public void setMatknr(int matknr) {
	this.matknr = matknr;
}
public int getnumberOfSemesters() {
	return numberOfSemesters;
}
public void setnumberOfSemesters(int numberOfSemesters) {
	this.numberOfSemesters = numberOfSemesters;
}


public Student(String name, String firstName, int matknr,int numberOfSemesters)
{
	
this.name = name;
this.firstname = firstName;
this.matknr = matknr;
this.numberOfSemesters = numberOfSemesters;
	
	
}
public Student(String name, String vorname, int matknr)
{
this(name,vorname,matknr,1);
	
}
   
    
	
	


//Methodes

}
