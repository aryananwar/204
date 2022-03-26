import static org.junit.Assert.*;
import java.io.File;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the student test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * 
 */
public class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface manager = new CourseDBManager();

	@Before
	public void setUp() throws Exception {
		manager = new CourseDBManager();
	}


	@After
	public void tearDown() throws Exception {
		manager = null;
	}


	@Test
	public void testAddToDB() {

		try {
			manager.add("CMSC203",36708,4,"HT301","Farnaz Eivazi");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}

	@Test
	public void testShowAll() {
		manager.add("CMSC207",36707,4,"HT205","David Kuijt");
		ArrayList<String> list = manager.showAll();
		assertEquals(list.get(0),"\nCourse:CMSC207 CRN:36707 Credits:4 Instructor:David Kuijt Room:HT205");
	}
	

	@Test
	public void testRead() {
		try {
			File inputFile = new File("courses.txt");
			manager.readFile(inputFile);
			
			assertEquals("CMSC100",manager.get(21556).getID());
			assertEquals("CMSC100",manager.get(22344).getID());
			assertEquals("SC451",manager.get(21564 ).getRoomNum());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}