import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
	GradeBook g1 = new GradeBook(5);
	GradeBook g2 = new GradeBook(5);
	@BeforeEach
	void setUp() throws Exception {
		g1.addScore(53);
		g1.addScore(45);
		g1.addScore(86);
		g1.addScore(97);
		g1.addScore(32);
		g2.addScore(11);
		g2.addScore(88);
		g2.addScore(47);
		g2.addScore(69);
		g2.addScore(23);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null;
		g2 = null;
	}

	@Test
	void testAddScore()
	{
		assertTrue(g1.toString().equals("53.0 45.0 86.0 97.0 32.0 "));
		assertEquals(g1.getScoresSize(), 5);
	}
	
	@Test
	void testSum()
	{
		assertEquals(g1.sum(), 313.0);
	}
	
	@Test
	void testMinimum()
	{
		assertEquals(32.0, g1.minimum());
	}
	
	@Test
	void testFinalScore()
	{
		assertEquals(g1.finalScore(), 281);
	}
	
	

}
