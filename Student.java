
public class Student {

	//Attributes
public String name;
private String vorname;
private int matknr;
private int numberOfSemesters;
public static boolean quit = false;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getVorname() {
	return vorname;
}
public void setVorname(String vorname) {
	this.vorname = vorname;
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
//Private counter;
//Singleton
//Constructors

Student(String name, String firstName, int matknr,int numberOfSemesters)
{
	
this.name = name;
this.vorname = firstName;
this.matknr = matknr;
this.numberOfSemesters = numberOfSemesters;
	
	
}
Student(String name, String vorname, int matknr)
{
this(name,vorname,matknr,1);
	
}
   
    
	
	


//Methodes

}
