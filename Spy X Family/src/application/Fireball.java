package application;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Fireball
{
	// declaring the local fields for this class
	private Image imgFb;
	private ImageView ivFb;
	private Random rnd;
	private int xPos, yPos; 
	private int speed;
	private double width, height;
	private double roomWidth, roomHeight;

	// initializing all the fields delcared above in the constructor and passing on the frame dimensions
	public Fireball(double sceneWidth, double sceneHeight)
	{
		xPos = -10;
		yPos = -20;

		imgFb = new Image("file:fb.gif");
		ivFb = new ImageView(imgFb);

		ivFb.setPreserveRatio(true);
		ivFb.setFitHeight(100);

		rnd = new Random();

		xPos = 0;
		yPos = -10;

		speed = rnd.nextInt(6) + 10;
		
		// setting the image view coordinates as the x and y position
		ivFb.setX(xPos);
		ivFb.setY(yPos);

		width = imgFb.getWidth();
		height = imgFb.getHeight();

		roomWidth = sceneWidth;
		roomHeight = sceneHeight;
	}

	// setting the x position to the value passed in of the fireball's image
	public void setX(int x)
	{
		xPos = x;
		ivFb.setX(xPos);
		

	}

	// setting the y position to the value passed in of the fireball's image
	public void setY(int y)
	{
		yPos = y;
		ivFb.setY(yPos);
	}

	// return x position of the fireball's image
	public int getX()
	{
		return xPos;
	}

	// return the y position of the fireball's image
	public int getY()
	{
		return yPos;
	}

	// returning the width of the fireball image
	public double getWidth()
	{
		return width;
	}

	// returning the height of the fireball image
	public double getHeight()
	{
		return height;
	}

	// setting the location to be random in the x axis of the frame and setting it to be the xpos of the enmy image
	public void setLocation(double frameWidth, double frameHeight)
	{
		xPos = rnd.nextInt((int)(frameWidth - width));
		
		speed = rnd.nextInt(6) + 10 ;

		ivFb.setX(xPos);

	}

	// move the fireball along the yaxis by the number in the variable speed and set the image to that y position
	public void move()
	{
		yPos += speed;
		ivFb.setY(yPos);
	}

	// set the image of the fireball to be the imageview and set the x and y to their x and y positions and return the imageview variable
	public ImageView getNode()
	{

		ivFb.setImage(imgFb);

		ivFb.setX(xPos);
		ivFb.setY(yPos);

		return ivFb;
	}



}
