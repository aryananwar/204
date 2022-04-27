import java.util.ArrayList;
import java.util.Objects;

public class Town implements Comparable{

	private String name;
	private ArrayList<Town> adjacent;

	/**
	 * Constructor that takes name
	 * @param name
	 */
	public Town(String name)
	{
		this.name = name;
	}

	/**
	 * Copy constructor
	 * @param t
	 */
	public Town(Town t)
	{
		this.name = t.name;
	}

	/**
	 * HashCode generator
	 * @return
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
	}

	/**
	 * Returns true if these towns are the same
	 * @param t
	 * @return
	 */
	@Override
	public boolean equals(Object t)
	{
		if (this == t) return true;
		if (getClass() != t.getClass()) return false;
		Town town = (Town) t;
		return name != null ? name.equals(town.name) : town.name == null;
	}


	/**
	 * Determines if this town is the same as town passed.
	 * @param o
	 * @return
	 */
	@Override
	public int compareTo(Object o) {
		Town t = new Town((Town)o);
		return (this.name.compareTo(t.name));
	}


	/**
	 *
	 * @return name of town
	 */
	public String getName() {
		return name;
	}

	/**
	 *
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *
	 * @return arraylist representation of towns adjacent to this town
	 */
	public ArrayList<Town> getAdjacent() {
		return adjacent;
	}

	/**
	 *
	 * @param adjacent
	 */
	public void setAdjacent(ArrayList<Town> adjacent) {
		this.adjacent = adjacent;
	}
}
