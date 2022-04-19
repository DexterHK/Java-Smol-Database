package StudentenVerwaltung.Domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

	@Test
	void test() {
		Student st = new Student("Test","Working",22200001);
		
		assertEquals("Working", st.getFirstname());
		assertEquals("Test", st.getName());
		assertEquals(22200001, st.getMatknr());

	}

}
