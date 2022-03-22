import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T>{

	private T[] queue;
	private int front;
	private int back;
	private int size;
	
	
	public MyQueue(int init)
	{
		queue =  (T[]) new Object[init];
		front =0;
		back =init;
		size =0;
	}
	
	@Override
	public boolean isEmpty() {
		return size ==0;
	}

	@Override
	public boolean isFull() {
		return size==queue.length;
	}
	
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {

		if (isFull()) {
			throw new QueueOverflowException();
		}
		queue[size] = e;
		size++;
		return true;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T ahh = queue[0];
		
		if (isEmpty())
			throw new QueueUnderflowException();
		
	
		
		for (int i=0; i < size; i++) 
		{
			if (i != size-1)
				queue[i] = queue[i+1];
		}
		size--;
		return ahh;
	}

	@Override
	public int size() {
		return this.size;
	}


	@Override
	public String toString(String delimiter) {
		String str = "";
		for (int i=0; i <size; i++)
		{
			str+= queue[i] + delimiter;
		}
		return str.substring(0,str.length()-1);
	}
	
	@Override

	public String toString()
	{
		String str = "";
		for (int i=0; i <size; i++)
		{
			str+= queue[i];
		}
		return str;
	}

	@Override
	public void fill(ArrayList<T> list) {
		queue = (T[]) list.toArray();
		size = list.size();
	}


}
