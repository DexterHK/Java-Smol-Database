package StudentenVerwaltung.Domain;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class DatabaseTest {

	public Database db;

	@Test
	 public  void adduserTest()
	{
		 db = new Database();
		//Null values and String errors with a valid number of semester
		assertEquals(false, db.adduser(null,"test",1));
		assertEquals(false, db.adduser("test",null,1));
		assertEquals(false, db.adduser("","test",1));
		assertEquals(false, db.adduser("test","",1));
		assertEquals(false, db.adduser(null,null,1));
		assertEquals(false, db.adduser("","",1));
		//None of them should work
		assertEquals(false, db.adduser(null,"test"));
		assertEquals(false, db.adduser("test",null));
		assertEquals(false, db.adduser("","test"));
		assertEquals(false, db.adduser("test",""));
		assertEquals(false, db.adduser(null,null));
		assertEquals(false, db.adduser("",""));
		//This should work
		assertEquals(true, db.adduser("This","Works")); //22100001
		//Null values and String errors with a valid number of semester
		assertEquals(false, db.adduser(null,"test",2));
		assertEquals(false, db.adduser("test",null,2));
		assertEquals(false, db.adduser("","test",2));
		assertEquals(false, db.adduser("test","",2));
		assertEquals(false, db.adduser(null,null,2));
		assertEquals(false, db.adduser("","",2));
		//Valid first and last name, but invalid number of semester
		assertEquals(false, db.adduser("ThisDoesnt","work",3));
		assertEquals(false, db.adduser("De","Noice",0));
		assertEquals(false, db.adduser("Not","Worky:(",Integer.MAX_VALUE));
		assertEquals(false, db.adduser("Wrong","Value",Integer.MIN_VALUE));
		//Now let's test true cases
		assertEquals(true, db.adduser("This","works",1)); //22100002
		assertEquals(true, db.adduser("This","worksToo",2)); // 22200003
	}
	@Test
	 public  void matgeneratorTest()
	{
		 db = new Database();
		
		assertEquals(22100003, db.matgenerator(1)); 
		assertEquals(-1, db.matgenerator(Integer.MAX_VALUE));
		assertEquals(-1, db.matgenerator(Integer.MIN_VALUE));
		assertEquals(22200003, db.matgenerator(2));
		assertEquals(-1, db.matgenerator(3));
		assertEquals(-1, db.matgenerator(0));
	}
	@Test
	 public  void existsTest()
	{
		 db = new Database();
		assertEquals(false, db.exists(1)); 
		assertEquals(false, db.exists(Integer.MAX_VALUE)); 
		assertEquals(false, db.exists(Integer.MIN_VALUE));
		assertEquals(false, db.exists(-1)); 
		assertEquals(true, db.exists(22200003));  //Already exists up there
		assertEquals(true, db.exists(22100002));
		assertEquals(true, db.exists(22100001));
		
	}
	@Test
	public void deleteTest()
	{
		db = new Database();
		
		assertEquals(false, db.delete(1)); 
		assertEquals(false, db.delete(Integer.MAX_VALUE));
		assertEquals(false, db.delete(Integer.MIN_VALUE));
		assertEquals(false, db.delete(2));
		assertEquals(false, db.delete(3));
		assertEquals(false, db.delete(0));
		//True case
		assertEquals(true, db.delete(22100001)); //Deleted 22100001
		assertEquals(true, db.delete(22100002)); //Deleted 22100002
	}
	@Test
	public void isDeletedTest()
	{
		db = new Database();
		
		assertEquals(null, db.isdeleted(1)); 
		assertEquals(null, db.isdeleted(Integer.MAX_VALUE));
		assertEquals(null, db.isdeleted(Integer.MIN_VALUE));
		assertEquals(null, db.isdeleted(2));
		assertEquals(null, db.isdeleted(3));
		assertEquals(null, db.isdeleted(0));

	}
	@Test
	public void retrieveTest()
	{
		db = new Database();
		assertEquals(false, db.retrieve(1)); 
		assertEquals(false, db.retrieve(Integer.MAX_VALUE));
		assertEquals(false, db.retrieve(Integer.MIN_VALUE));
		assertEquals(false, db.retrieve(2));
		assertEquals(false, db.retrieve(3));
		assertEquals(false, db.retrieve(0));
	}
	
	@Test
	public void updateTest()
	{
				 db = new Database();
				//Null values and String errors with a valid number of semester
				assertEquals(false, db.update(null,"test",22100001,1));
				assertEquals(false, db.update("test",null,22100001,1));
				assertEquals(false, db.update("","test",22100001,1));
				assertEquals(false, db.update("test","",22100001,1));
				assertEquals(false, db.update(null,null,22100001,1));
				assertEquals(false, db.update("","",22100001,1));

				assertEquals(false, db.update(null,"test",1));
				assertEquals(false, db.update("test",null,1));
				assertEquals(false, db.update("","test",1));
				assertEquals(false, db.update("test","",1));
				assertEquals(false, db.update(null,null,1));
				assertEquals(false, db.update("","",1));				
				
	}
	
	
}
