import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {

	private Comparator<T> comparator;

	public SortedDoubleLinkedList(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public void add(T data) {
	}

	@Override
	public void addToEnd(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public T getLast() {
		// TODO Auto-generated method stub
		return super.getLast();
	}

	@Override
	public T getFirst() {
		// TODO Auto-generated method stub
		return super.getFirst();
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return super.getSize();
	}

	@Override
	public void addToFront(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public T retrieveLastElement() {
		// TODO Auto-generated method stub
		return super.retrieveLastElement();
	}

	@Override
	public T retrieveFirstElement() {
		// TODO Auto-generated method stub
		return super.retrieveFirstElement();
	}

	@Override
	public ArrayList<T> toArrayList() {
		// TODO Auto-generated method stub
		return super.toArrayList();
	}

	public Node remove(T targetData, Comparator<T> comparator) {
		// TODO Auto-generated method stub
		return super.remove(targetData, comparator);

	}

	@Override
	public ListIterator<T> iterator() {
		// TODO Auto-generated method stub
		return super.iterator();
	}

}