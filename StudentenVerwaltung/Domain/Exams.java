package StudentenVerwaltung.Domain;

import java.util.ArrayList;

public class Exams {
	
	//private String name;
//	private String firstName;
	private String exams;
	private int matknr;
	private String semester;
	private int ECT;
	
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
	
	


	
}
