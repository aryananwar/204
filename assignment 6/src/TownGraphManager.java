import java.util.ArrayList;
import java.util.Collections;

public class TownGraphManager implements TownGraphManagerInterface{
	private Graph<Town, Road> graph = new Graph<Town, Road>();


	/**
	 *
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param weight
	 * @param roadName name of road
	 * @return
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		graph.addVertex(t1);
		graph.addVertex(t2);
		
		graph.addEdge(t1, t2, weight, roadName);
		return true;
	}

	/**
	 *
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return
	 */
	@Override
	public String getRoad(String town1, String town2) {
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		Road r = graph.getEdge(t1, t2);
		
		return r.getName();
	}

	/**
	 *
	 * @param v the town's name  (lastname, firstname)
	 * @return
	 */
	@Override
	public boolean addTown(String v) {
		Town t1 = new Town(v);
		return graph.addVertex(t1);
		
	}

	/**
	 *
	 * @param name the town's name
	 * @return
	 */
	@Override
	public Town getTown(String name) {
		Town temp = new Town(name);
		for (Town t: graph.vertexSet() )
		{
			if (temp.equals(t))
				return t;
		}
		return null;
	}

	/**
	 *
	 * @param v the town's name
	 * @return
	 */
	@Override
	public boolean containsTown(String v) {
		Town t = new Town(v);
		if (graph.containsVertex(t))
			return true;
		return false;
	}

	/**
	 *
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		return graph.containsEdge(t1, t2);
	
	}

	/**
	 *
	 * @return arraylist representation of roads
	 */
	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> temp = new ArrayList<String>();
		
		for (Road r: graph.edgeSet())
			temp.add(r.getName());
		Collections.sort(temp);
		return temp;
	}

	/**
	 *
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param road
	 * @return
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		Road r = graph.getEdge(t1, t2);
		
		graph.removeEdge(t1, t2, r.getWeight(), road);
		return true;
		
	}

	/**
	 *
	 * @param v name of town (lastname, firstname)
	 * @return
	 */
	@Override
	public boolean deleteTown(String v) {
		Town temp = new Town(v);
		if (this.containsTown(v))
		{
			for (Town t: graph.vertexSet())
				if (temp.equals(t))
				{
					graph.removeVertex(t);
					return true;
				}		
		}
		return false;
	}

	/**
	 *
	 * @return arraylist representation of all towns
	 */
	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> temp = new ArrayList<String>();
		
		for (Town t: graph.vertexSet())
			temp.add(t.getName());
		Collections.sort(temp);
		return temp;
	}


	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		// TODO Auto-generated method stub
		return null;
	}

}
