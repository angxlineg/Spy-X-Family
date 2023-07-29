package application;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Enemy {
	
	// declaring local and one global variables
	private Image imgE;
	public ImageView ivE;
	private Random rnd;
	private int xPos, yPos; 
	private int speed;
	public double width, height;
	private double roomWidth, roomHeight;
	
	// initializing all the fields declared above in the constructor and passing on the frame's measurements
	public Enemy(double sceneWidth, double sceneHeight)
	{
		rnd = new  Random();
		
		imgE = new Image("file:enemy_basic.png");
		ivE = new ImageView(imgE);

		xPos = 0;
		yPos = -20;

		ivE.setX(xPos);
		ivE.setY(yPos);
		
		speed =  4;

		width = imgE.getWidth();
		height = imgE.getHeight();

		roomWidth = sceneWidth;
		roomHeight = sceneHeight;
	}
	
	// setting the x position to the value passed in of the enemy's image
	public void setX(int x)
	{
		xPos = x;
		ivE.setX(xPos);
		
	}

	// setting the y position to the value passed in of the enemy's image
	public void setY(int y)
	{
		yPos = y;
		ivE.setY(yPos);

	}

	// return x position of the enemy's image
	public int getX()
	{
		return xPos;
	}

	// return the y position of the enemy's image
	public int getY()
	{
		return yPos;
	}

	// returning the width of the enemy image
	public double getWidth()
	{
		return width;
	}

	// returning the height of the enemy image
	public double getHeight()
	{
		return height;
	}

	// setting the location to be random in the x axis of the frame and setting it to be the xpos of the enmy image
	public void setLocation(double frameWidth, double frameHeight)
	{
		xPos = rnd.nextInt((int)(frameWidth - width));
		
		ivE.setX(xPos);

	}

	// move the enemy along the yaxis by the number in the variable speed and set the image to that y position
	public void move()
	{
		yPos += speed;
		ivE.setY(yPos);
	}

	// set the image of the enemy to be the imageview and set the x and y to their x and y positions and return the imageview variable
	public ImageView getNode()
	{

		ivE.setImage(imgE);

		ivE.setX(xPos);
		ivE.setY(yPos);

		return ivE;
	}	


}
