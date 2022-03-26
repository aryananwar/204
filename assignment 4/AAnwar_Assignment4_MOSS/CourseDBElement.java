import java.util.Comparator;
import java.util.Objects;

public class CourseDBElement implements Comparable<CourseDBElement>{

	private String ID;
	private int CRN;
	private int credits;
	private String room;
	private String instructor;

	/**
	 *
	 * @param ID
	 * @param CRN
	 * @param credits
	 * @param room
	 * @param instructor
	 */
	public CourseDBElement(String ID, int CRN, int credits, String room, String instructor) {
		this.ID = ID;
		this.CRN = CRN;
		this.credits = credits;
		this.room = room;
		this.instructor = instructor;
	}

	/**
	 * Creates hash code based on CRN.
	 * @return
	 */
	public String getHash() {

		return ("" + CRN);
	}


	/**
	 *
	 * @return id
	 */
	public String getID() {
		return ID;
	}

	/**
	 *
	 * @param ID
	 */
	public void setID(String ID) {
		this.ID = ID;
	}

	/**
	 *
	 * @return CRN
	 */
	public int getCRN() {
		return CRN;
	}

	/**
	 *
	 * @param CRN
	 */
	public void setCRN(int CRN) {
		this.CRN = CRN;
	}

	/**
	 *
	 * @return Credits
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 *
	 * @param credits
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}

	/**
	 *
	 * @return room number
	 */
	public String getRoomNum() {
		return room;
	}

	/**
	 *
	 * @param room
	 */
	public void setRoom(String room) {
		this.room = room;
	}

	/**
	 *
	 * @return instructor
	 */
	public String getInstructor() {
		return instructor;
	}

	/**
	 *
	 * @param instructor
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}


	/**
	 *
	 * @param c
	 * @return determines if two courses are equal.
	 */
	@Override
	public int compareTo(CourseDBElement c) {
		String thistempCRN = "" + this.CRN;
		String thistempcred = "" + this.credits;
		String ctempCRN = "" + c.CRN;
		String ctempcred = "" + c.credits;
		
		int value;
		value = this.ID.compareTo(c.ID);
		value = thistempCRN.compareTo(ctempCRN);
		value = thistempcred.compareTo(ctempcred);
		value = this.room.compareTo(c.room);
		value = this.instructor.compareTo(c.instructor);
		
		
		return value;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public String toString()
	{
		return ("\nCourse:" + this.getID() + " CRN:" + this.getCRN() 
			+ " Credits:" + this.getCredits() + " Instructor:" + this.getInstructor() +  " Room:"+ this.getRoomNum() );
	}





}
