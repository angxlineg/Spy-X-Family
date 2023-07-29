package application;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/// extending the enemy class
public class Boss extends Enemy
{
	// declaring local variables
	private int speed;
	private Image imgBoss;

	// initializing the fields in the constructor
	public Boss(double sceneWidth, double sceneHeight)
	{
		super(sceneWidth, sceneHeight);
		
		speed = 10;
		
		imgBoss = new Image("file:enemy_fancy.png");
		
		width = imgBoss.getWidth();
		height = imgBoss.getHeight();
	}
	
	// if this method is called in the main, the move method from the enemy class is accessed but the speed of how much the boss enemy is moved is diffrent
	public void move()
	{
		super.move();
		
		super.setY(super.getY() + speed);
	}
	
	// this method calls on the image variable from the enemy class and sets the image of the boss enemy
	public ImageView getNode()
	{
		ivE.setImage(imgBoss);
		
		return ivE;
	}
	
}
