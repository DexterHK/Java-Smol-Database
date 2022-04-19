package StudentenVerwaltung.Domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExamsTest {

	@Test
	void test() {
		Exams exam = new Exams(22100001,"PR2","Sose22",20);
		
		assertEquals(22100001, exam.getMatknr());
		assertEquals("PR2", exam.getExams());
		assertEquals("Sose22", exam.getSemester());
		assertEquals(20, exam.getECT());
	}

}
