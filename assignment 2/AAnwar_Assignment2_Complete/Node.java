
public class Node<T> {
	private T data;
	private Node next;
	
	public Node(T x)
	{
		this.setData(x);
	}
	
	public Node(T x, Node n)
	{
		this.setData(x);
		this.setNext(n);
	}

	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	
	
}


