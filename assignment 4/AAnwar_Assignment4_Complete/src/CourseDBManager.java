import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {

	CourseDBStructure map = new CourseDBStructure(100);

	/**
	 * Uses the add method from the structure to create and add a new element.
	 * @param id course id
	 * @param crn course crn
	 * @param credits number of credits
	 * @param roomNum course room number
	 * @param instructor name of the instructor
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement c = new CourseDBElement(id, crn, credits, roomNum, instructor);
		map.add(c);

	}

	/**
	 * Returns an element from the structure, returns null if nothing is found.
	 * @param crn course crn (key)
	 * @return
	 */
	@Override
	public CourseDBElement get(int crn) {
		int index = map.calcIndex("" + crn);
		//System.out.println(list.get(index).isEmpty());
		
		
		if(!(map.list.get(index).isEmpty()))
		{
			for (int i =0; i < map.list.get(index).size(); i++)
			{
				if (((CourseDBElement) map.list.get(index).get(i)).getCRN() == crn)
					return ((CourseDBElement) map.list.get(index).get(i));
			}
		}
		return null;
	}

	/**
	 * Reads from a file and adds all course information to the structure.
	 * @param input input file
	 * @throws FileNotFoundException
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner sc;

		 try {
		        sc = new Scanner(input);
		        while (sc.hasNextLine())
		        {
		        	String s = sc.nextLine();
		        	String[] temp = s.split("\\s+");
		        	this.add(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), temp[3],temp[4]);
		        	temp = null;
		        }	
		        
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    }
		 
	
	}

	/**
	 *
	 * @return an array list of all elements in the sturcture
	 */
	@Override
	public ArrayList<String> showAll() {
		return map.showAll();
	}

}
