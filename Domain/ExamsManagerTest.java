package StudentenVerwaltung.Domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExamsManagerTest {

	@Test
	void testSetGrade() {
		ExamsManager em = new ExamsManager();
		
		assertEquals(false, em.setGrade(22200001,"",1));
		assertEquals(false, em.setGrade(22200001,null,1));


		
	}
	@Test
	void testAddExam() {
		ExamsManager em = new ExamsManager();
		
		assertEquals(false, em.addExam(22200001,"","test"));
		assertEquals(false, em.addExam(22200001,null,"test"));
		assertEquals(false, em.addExam(22200001,"test",""));
		assertEquals(false, em.addExam(22200001,"test",null));


		
	}
	@Test
	void testRemoveExam() {
		ExamsManager em = new ExamsManager();
		
		assertEquals(false, em.removeExam(22200001,""));
		assertEquals(false, em.removeExam(22200001,null));



		
	}


}
