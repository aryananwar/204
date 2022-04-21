import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws two car shapes.
*/
public class CarPanel extends JComponent
{  
	private Car car1;
	private int x,y, delay;
	private CarQueue carQueue;
	private int direction;
	
	CarPanel(int x1, int y1, int d, CarQueue queue)
	{
		delay = d;
        x=x1;
        y=y1;
        car1 = new Car(x, y, this);
        carQueue = queue;
	}
	public void startAnimation()
	   {
	      class AnimationRunnable implements Runnable
	      {
	         public void run()
	         {
	            try
	            {     	
	            	for (; ;  )
	            	{
	            		int tempx = x;
		            	int tempy = y;
		            	int changex = 10;
		            	int changey =  10;
		            	
	            		direction = carQueue.deleteQueue();
	            		
	            		// doesnt actually change where car will move, just checks if it will run into wall
	            		switch(direction)
	            		{
	            			case 0:
	            				tempy-= changey;
	            				break;
	            			case 1:
	            				tempy+=changey;
	            				break;
	            			case 2:
	            				tempx+=changex;
	            				break;
	            			case 3:
	            				tempx-=changex;
	            				break;
	            		}
	            		
	            		if(tempy >= 400 || tempy <= 0)
	            		{
	            			changey*=-1;
	            		}
	            		if(tempx >= 300 || tempx <= 0)
	            		{
	            			changex*=-1;
	            		}
	            		
	            		switch(direction)
	            		{
	            			case 0:
	            				y-= changey;
	            				break;
	            			case 1:
	            				y+=changey;
	            				break;
	            			case 2:
	            				x+=changex;
	            				break;
	            			case 3:
	            				x-=changex;
	            				break;
	            		}
	            		repaint();
	            		Thread.sleep(1000);
	            	}
	            }

	            catch (InterruptedException exception)
	            {
	            	
	            }
	            finally
	            {
	            	
	            }
	         }
	      }
	      
	      Runnable r = new AnimationRunnable();
	      Thread t = new Thread(r);
	      t.start();
	   }
	
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;

      car1.draw(g2,x,y);    
   }
}