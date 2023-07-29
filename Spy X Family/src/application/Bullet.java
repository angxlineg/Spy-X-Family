package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bullet {
	
	// declaring local variables
	private Image imgEast, imgWest;
	private ImageView iviewBullet;
	public boolean fired;
	private double xPos, yPos, width, height;
	private int dir;
	private final static int EAST = 0, WEST = 1;
	
	// initializing all the fields declared above in the constructors
	public Bullet()
	{
		imgEast = new Image("file:bulletEast.png");
		imgWest = new Image("file:bulletWest.png");
		
		iviewBullet = new ImageView(imgEast);
		
		fired = false;
		
		xPos = -100;
		yPos = -100;
		
		width = imgEast.getWidth();
		height = imgEast.getHeight();
		
		dir = EAST;
	}
	
	public Bullet(double x, double y)
	{
		imgEast = new Image("file:bulletEast.png");
		imgWest = new Image("file:bulletWest.png");
		
		iviewBullet = new ImageView(imgEast);
		
		fired = false;
		
		xPos = x ;
		yPos = y;
		
		width = imgEast.getWidth();
		height = imgEast.getHeight();
		
		dir = EAST;
	}
	
	// returns the direction of the bullet
	public int getDirection()
	{
		return dir;
	}
	
	// returns the height of the bullet image
	public double getHeight() 
	{
		return height;
	}
	
	// returns the width of the bullet image
	public double getWidth()
	{
		return width;
	}
	
	// returns the x position of the bullet image
	public double getX()
	{
		return xPos;
	}
	
	// returns the y position of the bullet image
	public double getY()
	{
		return yPos;
	}
	
	// returns the boolean fired variable
	public boolean isFired() 
	{
		return fired;
	}
	
	// when the method is called, depending on the dir, the xPos of the bullet image will move 10 at a time
	public void move()
	{
		if(dir == EAST)
		{
			xPos += 10;
		}
		else
		{
			xPos -= 10;
		}
		
		// update the x position of the image
		iviewBullet.setX(xPos);
	}
	
	// setting the position of the bullet within the gui when called upon
	public void setPosition(double playerX, double playerY, int dir)
	{
		
		this.dir = dir;
		
		// check the direction of the calling object and see which way they are facing. Based off of the direction, this will determine 
		// where to place the bullet image. They following values were obtained by the trail and error; running the game and testing which values worked
		if(this.dir == EAST)
		{
			xPos = playerX + 75;
			
		}
		else
		{
			xPos = playerX;
		}
		
		yPos = playerY + 75;
		
		// the bullet was fired so the variable will be equal to true
		fired = true;
		
		// update the x and y pos of the bullet image with the new coordinates that it is set with
		iviewBullet.setX(xPos);
		iviewBullet.setY(yPos);
		
	}
	
	// setting the x position of the bullet image to the value that was passed on
	public void setX(int x)
	{
		xPos = x;
	}
	
	// setting the y position of the bullet image to the value that was passed on
	public void setY(int y)
	{
		yPos = y;
	}
	
	// checking if the bullet is off the screen so we can use the bullet again
	public boolean isOffScreen(double edge)
	{
		boolean offScreen = false;
		
		// if the x position of the bullet image is outside of the window frame then offscreen variable will be true and fired variable will be false
		if(xPos >= edge || xPos + width <= 0)
		{
			offScreen = true;
			fired = false;
		}
		
		return offScreen;
	}
	
	// depending on the dir, this method returns the image of the bullet
	public ImageView getNode()
	{
		
		if(dir == EAST)
		{
			iviewBullet.setImage(imgEast);
		}
		else
		{
			iviewBullet.setImage(imgWest);
		}
	
		return iviewBullet;
	}

}
