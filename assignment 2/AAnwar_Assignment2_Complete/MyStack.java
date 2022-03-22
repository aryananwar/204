import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T>{
	
	public T[] stack;
	private int topIndex =-1;
	

	
	public MyStack(int init) {
		stack = (T[]) new Object[init];
	}
	@Override
	public boolean isEmpty() {
		return topIndex < 0;
	}

	@Override
	public boolean isFull() {
		return (topIndex+1) == stack.length;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty())
			throw new StackUnderflowException();
		else
		{
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return top;
		}
	}

	@Override
	public T top() throws StackUnderflowException {
		if (isEmpty())
			throw new StackUnderflowException();
		else
		{
			return stack[topIndex];
		}
	}

	@Override
	public void fill(ArrayList<T> list) {
		
		for (int i =0; i <list.size(); i++)
		{
			stack[i] = list.get(i);
		}
		topIndex = list.size()-1;
	}
	
	@Override
	public int size() {
		return topIndex+1;
	}

	@Override
	public boolean push(T e) throws StackOverflowException {
		try
		{
			stack[++topIndex] = e; 
			return true;
		}
		catch(Exception a)
		{
			throw new StackOverflowException();
		}
	}
		

	@Override
	public String toString(String delimiter) {
		String str = "";
		for (int i = 0; i < topIndex+1; i++) {

			str += stack[i] + delimiter;

		}
		return str.substring(0, str.length() - 1);
	}
	
	@Override
	public String toString()
	{
		String str = "";
		for (int i =0; i< topIndex+1; i++)
		{
			str+= stack[i];
		}
		return str;
	}



}
