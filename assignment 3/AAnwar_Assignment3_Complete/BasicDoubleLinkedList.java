import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable{
	Node head;
	Node tail;
	protected int size;
	
	public BasicDoubleLinkedList()
	{}
	
	@SuppressWarnings("unchecked")
	public void addToEnd(T data)
	{	
		Node n = new Node(data, null, tail);
		if(size ==0)
		{
			head =  n;
			tail =  n;
		}
		else
		{
			tail.setNext(n);
			tail =n;
		}
		size++;
	}
	 
	@SuppressWarnings("unchecked")
	public void addToFront(T data)
	{
		Node n = new Node(data, null, head);
		if(size == 0)
		{
			head = n;
			tail = n;
		}
		else {
			head.setPrev(n);
			head = n;
		}
		size++;
	}
	
	public T getFirst()
	{
		if (head != null)
			return (T) this.head.getData();
		return null;
	}
	
	
	public T getLast()
	{
		if (tail != null)
			return (T) this.tail.getData();
		return null;
	}


	public ListIterator<T> iterator() {
		// TODO Auto-generated method stub
		return new DoubleLinkedListIterator();
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public ArrayList<T> toArrayList()
	{
		ArrayList<T> arr = new ArrayList<T>();
		Node temp = head;
		for (int i=0; i< size; i++)
		{
			arr.add((T)temp.getData());
			temp=temp.getNext();
		}
		return arr;
	}
	
	public Node remove(T target, Comparator c)
	{
		Node temp = head;
		if (c.compare(target, head.getData()) == 0)
		{
			head = temp.getNext();
			size--;
			return head;
		}
		 
		if (c.compare(target, tail.getData()) == 0)
		{
			tail = temp.getNext();
			size--;
			return tail;
		}
		
		while (temp != null)
		{
			if(c.compare(target, temp.getData()) ==0)
			{
				size--;
				return temp;
			}
			temp = temp.getNext();
		}
		return null;
		
	}
	
	@SuppressWarnings("unchecked")
	public T retrieveFirstElement()
	{
		if (size ==0)
			return null;
		Node n = new Node(head.getData());
		head = head.getNext();
		return (T) n.getData();
	}
	
	public T retrieveLastElement()
	{
		if (size ==0)
			return null;
		Node n = new Node(tail.getData());
		tail = tail.getNext();
		return (T) n.getData();
	}
	
	protected class Node
	{
		T data;
		private Node prev;
		private  Node next;
		
		public Node(T d)
		{
			this.data = d;
		}
		
		public Node(T d, Node prev, Node next)
		{
			this.data = d;
			this.prev = prev;
			this.next = next;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
		

		
	}
	
	
	protected class DoubleLinkedListIterator implements ListIterator<T> {
		
		private Node current;
		private Node end;
		private int length =0;
		
		public DoubleLinkedListIterator()
		{
			current=head;
		}
		
		public boolean hasNext()
		{
			if (length < size)
				return true;
			return false;
		}

		@Override
		public T next() throws NoSuchElementException
		{
			if(hasNext() == true)
			{
				length++;
				end=current;
				current=current.getNext();
				return (T) end.getData();
			}
			else
				throw new NoSuchElementException();
		}

		@Override
		public boolean hasPrevious() {
			if (end != null)
				return true;
			return false;
		}

		@Override
		public T previous() throws NoSuchElementException {
			if (hasPrevious() == true) {
				current = end;
				end = end.getPrev();
				return (T) current.getData();
			}
			else 
				throw new NoSuchElementException();
		}
		
		
		@Override
		public int nextIndex() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() throws UnsupportedOperationException
		{	
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(Object e) throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(Object e) throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
		

	}


}
