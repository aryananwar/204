import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements  CourseDBStructureInterface{

	ArrayList<LinkedList> list;
	final double loadFactor = 1.5;
	int length;

	/**
	 * Determines if integer passed is prime.
	 * @param num
	 * @return true if number is prime, false otherwise.
	 */
	public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
 }

	/**
	 * Constructor that takes size value.
	 * @param n
	 */
	public CourseDBStructure(int n)
	{
		int d = (int) (n / loadFactor); 
		
		for (int i =0; i <d; i++) 
		{
			if ((4*i + 3) > d && isPrime(4*i+3)) // what the fuck?
			{
				int num = 4*i +3;
				this.length = num;
				break;
			}
		}
		
		list = new ArrayList<LinkedList>(length);
		for (int i=0; i <length; i++)
		{
			list.add(new LinkedList<CourseDBElement>());
		}
	}

	/**
	 * Testing constructor that takes size value.
	 * @param t
	 * @param n
	 */
	public CourseDBStructure(String t, int n)
	{
		this.length = n;
		list = new ArrayList<LinkedList>(length);
		
		for (int i=0; i <length; i++)
		{
			list.add(new LinkedList<CourseDBElement>());
		}
	}

	/**
	 * Calculates index of element based on hash code passed.
	 * @param hashString
	 * @return index based on hash code.
	 */
	public  int calcIndex(String hashString)
	{
		int hash = Integer.parseInt(hashString);
		return hash % length;
	}

	/**
	 * Adds an element to the structure. If element is already within structure exits quietly.
	 * If there is a change edit the element.
	 * @param element the CourseDBElement to be added to CourseDBStructure
	 */
	@Override
	public void add(CourseDBElement element) {
		int index = this.calcIndex(element.getHash());
		
		if (!(list.get(index).contains(element)))
		{
			list.get(index).add(element);
		}
		
		for (int i =0; i < list.get(index).size(); i++)
		{
			if (((CourseDBElement) list.get(index).get(i)).getCRN() == element.getCRN() 
					&& !((CourseDBElement) list.get(index).get(i)).getID().equals(element.getID()))
			{
				list.get(index).remove(i);
				list.get(index).add(element);
			}
		}
		
	}

	/**
	 * @param crn crn (key) whose associated courseDatabaseElement is to be returned
	 * @return CourseDBElement based on CRN passed.
	 * @throws IOException
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		int index = calcIndex("" + crn);
		//System.out.println(list.get(index).isEmpty());
		
		
		if(!(list.get(index).isEmpty()))
		{
			for (int i =0; i < list.get(index).size(); i++)
			{
				if (((CourseDBElement) list.get(index).get(i)).getCRN() == crn)
					return ((CourseDBElement) list.get(index).get(i));
			}
		}
		throw new IOException();
		
	}

	/**
	 *
	 * @return ArrayList of all elements in structure.
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> t = new ArrayList<String>(this.length);
		
		for (int i =0; i <this.length; i++)
		{
			if (!(list.get(i).isEmpty()))
					t.add(list.get(i).toString().replace("[", "").replace("]", ""));
		}
		return t;
	}

	/**
	 *
	 * @return length of map.
	 */
	@Override
	public int getTableSize() {
		return this.length;
	}

}
