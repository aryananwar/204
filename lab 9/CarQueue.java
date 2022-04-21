import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;


public class CarQueue {
	Queue<Integer> queue; 
	Random direction = new Random();
	
	
	public CarQueue()
	{
		queue = new ArrayDeque<Integer>();
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
	}
	
	public int deleteQueue()
	{
		return queue.remove();
	}
	
	public void addToQueue()
	{
		class Run implements Runnable
		{
			@Override
			public void run() {
					try {
						for (; ;)
						{
							queue.add(direction.nextInt(4));
							Thread.sleep(100);
						}
						
					}
					catch (Exception e) {}
			}
		}
		Run r = new Run();
		Thread t = new Thread(r);
		t.start();
	}
	

}
