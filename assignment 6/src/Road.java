
public class Road implements Comparable {
	private Town source;
	private Town destination;
	private String name;
	private int weight;

	/**
	 * Paramaterized constructor
	 * @param source
	 * @param destination
	 * @param name
	 */
	public Road(Town source, Town destination, String name) {
		this.source = source;
		this.destination = destination;
		this.name = name;
	}

	/**
	 * Paramaterized constructor
	 * @param source
	 * @param destination
	 * @param weight
	 * @param name
	 */
	public Road(Town source, Town destination, int weight, String name) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		this.name = name;
	}

	/**
	 * If this road contains a town
	 * @param t
	 * @return if town is accesible through this road
	 */
	public boolean contains(Town t)
	{
		return (source.equals(t)|| destination.equals(t));
	}

	/**
	 *
	 * @return string representation of road
	 */
	@Override
	public String toString() {
		return "Road [source=" + source + ", destination=" + destination + ", name=" + name + ", weight=" + weight
				+ "]";
	}

	/**
	 *
	 * @return source town
	 */
	public Town getSource() {
		return source;
	}

	/**
	 *
	 * @param source
	 */
	public void setSource(Town source) {
		this.source = source;
	}

	/**
	 *
	 * @return destination town
	 */
	public Town getDestination() {
		return destination;
	}

	/**
	 *
	 * @param destination
	 */
	public void setDestination(Town destination) {
		this.destination = destination;
	}

	/**
	 *
	 * @return name of raod
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
	 * @return cost of road
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 *
	 * @param weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}


	/**
	 * Determines if this road is the same as road passed
	 * @param o
	 * @return
	 */
	@Override
	public int compareTo(Object o) {
		if(this.name == ((Road) o).getName() )
			return 0;
		return 1;
	}

	/**
	 * Equality of roads
	 * @param r
	 * @return
	 */
	@Override
	public boolean equals(Object r)
	{
		Road road = (Road) r;
		return r != null && contains(road.source) && contains(road.destination);
	}


}
