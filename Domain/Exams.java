package StudentenVerwaltung.Domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Exams implements Serializable {
	
	  
	 //composition
	
	//private String name;
//	private String firstName;
	private String exams;
	private int matknr;
	private String semester;
	private int ECT;
	private double grade;
	private GradeUnit gradeUnit;
	
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public int getECT() {
		return ECT;
	}
	public void setECT(int eCT) {
		ECT = eCT;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public String getExams() {
		return exams;
	}
	public void setExams(String exams) {
		this.exams = exams;
	}
	public int getMatknr() {
		return matknr;
	}
	public void setMatknr(int matknr) {
		this.matknr = matknr;
	}
	//Add using name
	
	//Add using matriculation number, 
	Exams(int matknr,String exams,String semester, int ECT)
	{
		this.matknr = matknr;
		this.exams = exams;
		this.semester = semester;
		this.ECT = ECT;
	}
	Exams(int matknr,String exams,String semester)
	{
		this.ECT = 0;
		this.matknr = matknr;
		this.exams = exams;
		this.semester = semester;
	}
	Exams(int matknr,String exams,String semester, int ECT, double grade)
	{
		this(matknr, exams, semester,ECT);
	this.grade = grade;
		
	}
	
	
	
	


	
}
