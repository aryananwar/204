import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<E, V> implements GraphInterface<Town, Road>{

	private Set<Town> towns;
	private Set<Road> roads;
	ArrayList<String> path;

	/**
	 * No-arg constructor
	 */
	public Graph()
	{
		towns = new HashSet<Town>();
		roads = new HashSet<Road>();
		path = new ArrayList<String>();
		
	}

	/**
	 *
	 * @param sourceVertex source vertex of the edge.
	 * @param destinationVertex target vertex of the edge.
	 *
	 * @return
	 */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		if (sourceVertex == null || destinationVertex == null)
			return null;

		for (Road r: roads)
		{
			if (r.equals(new Road(sourceVertex, destinationVertex, null)))
				return r;
		}
		return null;
	}

	/**
	 *
	 * @param sourceVertex source vertex of the edge.
	 * @param destinationVertex target vertex of the edge.
	 * @param weight weight of the edge
	 * @param description description for edge
	 *
	 * @return
	 */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description){
		if (sourceVertex == null || destinationVertex == null)
			throw new NullPointerException();
		if(towns.contains(sourceVertex) == false || towns.contains(destinationVertex) == false )
			throw new IllegalArgumentException();
		
		Road temp = new Road(sourceVertex, destinationVertex, weight, description);
		roads.add(temp);
		return temp;

	}

	/**
	 *
	 * @param v vertex to be added to this graph.
	 *
	 * @return
	 */
	@Override
	public boolean addVertex(Town v) {
		if (v== null)
			return false;
		if (towns.contains(v))
			return false;
		return towns.add(v);
	}

	/**
	 *
	 * @param sourceVertex source vertex of the edge.
	 * @param destinationVertex target vertex of the edge.
	 *
	 * @return
	 */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		for (Road r: roads)
		{
			if (r.contains(destinationVertex) && r.contains(sourceVertex))
				return true;
		}
		return false;
	}

	/**
	 *
	 * @param v vertex whose presence in this graph is to be tested.
	 *
	 * @return
	 */
	@Override
	public boolean containsVertex(Town v) {
		if (v==null)
			return false;
		return towns.contains(v);
	}

	/**
	 *
	 * @return set representation of all roads
	 */
	@Override
	public Set<Road> edgeSet() {
		return this.roads;
	}

	/**
	 *
	 * @param vertex the vertex for which a set of touching edges is to be
	 * returned.
	 *
	 * @return
	 */
	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> edges = new HashSet<Road>();
		
		if (vertex==null)
			return null;
		for (Road r: roads)
		{
			if(r.contains(vertex))
				edges.add(r);
		}
		return edges;
	}

	/**
	 *
	 * @param sourceVertex source vertex of the edge.
	 * @param destinationVertex target vertex of the edge.
	 * @param weight weight of the edge
	 * @param description description of the edge
	 *
	 * @return
	 */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		for (Road r: roads)
		{
			if(r.contains(destinationVertex) && r.contains(sourceVertex))
			{	
				roads.remove(r);
				return r;
			}
		}
		return null;
	}

	/**
	 *
	 * @param v vertex to be removed from this graph, if present.
	 *
	 * @return
	 */
	@Override
	public boolean removeVertex(Town v) {
		if (v== null)
			return false;
		this.towns.remove(v);
		return true;
	}

	/**
	 *
	 * @return set representation of all towns
	 */
	@Override
	public Set<Town> vertexSet() {
		return this.towns;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
	}


}
