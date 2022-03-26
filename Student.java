

public class Student {
	// UI -> API -> Gesch�ftslogic(DOMAIN) -> Infrastruktur(ORM persistence)
	//Attributes
public String name;
private String vorname;
private int matknr;
private int semesterzahl;
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
public int getSemesterzahl() {
	return semesterzahl;
}
public void setSemesterzahl(int semesterzahl) {
	this.semesterzahl = semesterzahl;
}
//Private counter;
//Singleton
//Constructors

Student(String name, String vorname, int matknr,int semesterzahl)
{
	
this.name = name;
this.vorname = vorname;
this.matknr = matknr;
this.semesterzahl = semesterzahl;
	
	
}
Student(String name, String vorname, int matknr)
{
this(name,vorname,matknr,1);
	
}
   
    
	
	


//Methodes

}
