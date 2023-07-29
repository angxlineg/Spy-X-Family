package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player {

	// declaring the local and global fields
	private ImageView iviewPlayer;
	private Image imgWest, imgEast;
	private double xPos, yPos, width, height;
	public final static int EAST = 0, WEST = 1;
	private int dir;

	// Initializing the fields in the constructor which also passes on the boolean to notify whether the user wants the image to be a boy or a girl
	public Player(boolean character)
	{
		// if the character is true initialize the east and west images to be the girl, if it is not true then initialize the east and west images to be the boy
		if(character == true)
		{
			imgEast = new Image("file:Girl_East.png");
			imgWest = new Image("file:Girl_West.png");
		}
		else
		{
			imgEast = new Image("file:Male_East.png");
			imgWest = new Image("file:Male_West.png");
		}

		// set the image view to default each image
		iviewPlayer = new ImageView(imgEast);

		width = imgEast.getWidth();
		height = imgEast.getHeight();

		xPos = 500;
		yPos = 650;

		iviewPlayer.setX(xPos);
		iviewPlayer.setY(yPos);
	}
	
	// Returns the height of the player image
	public double getHeight()
	{
		return height;
	}

	// Returns the width of the player image
	public double getWidth()
	{
		return width;
	}

	// return the dir variable
	public int getDirection()
	{
		return dir;
	}

	// Returns the updated image to the class that it was called from
	public ImageView getNode()
	{
		// if the direction of the player is east, then the image will change into the east's version of the image
		if(dir == EAST)
		{
			iviewPlayer.setImage(imgEast);
		}
		// if the direction of the player is west, then the image will change into the west's version of the image
		else if(dir == WEST)
		{
			iviewPlayer.setImage(imgWest);
		}

		// update the x and y coordinates with the new positons
		iviewPlayer.setX(xPos);
		iviewPlayer.setY(yPos);

		// return the image view object
		return iviewPlayer;
	}

	// Returning the x position of the player image
	public double getX()
	{
		return xPos;
	}

	// Returning the y position of the player image
	public double getY()
	{
		return yPos;
	}

	// The player's image will move right on the x axis of the room by the speed value that was passed on into the method
	// The player's image will be updated of the new x coordinate value
	public void moveEast()
	{
		dir = EAST;
		xPos += 10;
		iviewPlayer.setX(xPos);
	}

	// The player's image will move left on the x axis of the room by the speed value that was passed on into the method
	// The player's image will be updated of the new x coordinate value
	public void moveWest()
	{
		dir = WEST;
		xPos -= 10;
		iviewPlayer.setX(xPos);
	}

	// The player's image will move up the y axis of the room by the speed value that was passed on into the method
	// The player's image will be updated of the new y coordinate value
	public void moveUp()
	{
		yPos -= 10;
		iviewPlayer.setY(yPos);
	}

	// The player's image will move down the y axis of the room by the speed value that was passed on into the method
	// The player's image will be updated of the new y coordinate value
	public void moveDown()
	{
		yPos += 10;
		iviewPlayer.setY(yPos);
	}


	// setting the location of the player using the values passed in and setting it as x pos and ypos, then setting the xpos and ypos where the image view should be
	public void setLocation(double x, double y)
	{
		xPos = x;
		yPos = y;

		iviewPlayer.setX(xPos);
		iviewPlayer.setY(yPos);

	}

	// Setting the x coordinate of the player image and updating the imageview
	public void setX(double x)
	{
		xPos = x;

		iviewPlayer.setX(x);
	}

	// Setting the y coordinate of the player image and updating the imageview
	public void setY(double y)
	{
		yPos = y;

		iviewPlayer.setY(y);
	}


}
