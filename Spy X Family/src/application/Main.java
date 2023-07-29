package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/*
 * ICS4U1 CPT: Spy X Family: Training Edition
 * Name: Angeline Sheeba Grace Garapati
 * Teacher: Mr. Conway
 * PROGRAM DESCRIPTION: The game is called Spy X Family: Training edition. It is a game that is consisted of two levels which trains the user to become recruited by a "spy agency". Once the program runs the poster of the game will be shown with
 * the start and the high score button. If the user clicks on the high score button then the alert will pop up with the top 10 high scores which they can see and when they are done they click the "ok" to exit the alert. Once they click on the start button
 * then an alert will pop up with loid asking for the user's name. If the user does not type in a name then their default name will be "A". Then, the user is introduced to the context of the game. An alert will pop up tell the user that their training will
 * begin and lead to a cut scene which shows that Loid aka Agent Twilight is the spy in charge of recruiting talented spies for the upcoming mission due to a threat on the peace of the nation Westalis. The two countries of Ostania and Westalis are in war right now
 * and the director of their spy association needs spies to get intel from the enemy. Therefore, in the meeting one of the members told the director that Twilight found a few spies that he will be training to see if they qualify for this mission. The cut scene
 * ends and the user is directed to level one which is an exam (so much fun). If the user wanted to, they could also skip the whole cut scene and it will change the stage into level one so they can start on the exam without the context. As previously mentioned, 
 * level one is an exam that the user has to write. When they first enter the level, an alert pops up with Anya (one of Loid's spy agents) who introduces herself and what level one is about and its instructions. There are 10 questions that the user has to answer
 * within 5 minutes. The questions consists of terms we have learned about in grade 12 coding and a few riddles because as a spy for this mission the user needs to know a few terms that are needed for coding since spies need to be good at hacking in order to gather intel
 * using the enemy's technology. There are also a few riddles in this exam because the user needs to develop quick thinking because as a spy they need to be careful and be quick on their feet. The user has 5 minutes to finish as many questions as they can. Within the 5 minutes,
 * the user needs to click on the submit button to lock in their answers and to stop the 5 minute timer. If they don't click the submit button in time which means that they are not done the exam, then the user fails the level and does not move on to the next level. An alert will
 * pop up that they failed the exam and are disqualified to be a part of the mission that they are training for. Once the user clicks submit, the file reader will take the answers from the file and the actions in the submit button method will check if the answers that the user
 * wrote matches the answer that is on the file. Every line in the file has an answer which will be compared to the user's answer to a particular question. When the user writes the answer they don't need to care about case sensitivity since the program only cares about the letter 
 * and ignores the case sensitivity. Every time that the user has an answer right, their mark will go up. For the user to move on to the next level, they have to pass the exam with a 50% or higher. So they need to get 5 out of the 10 questions correct. If they pass the exam, an 
 * alert will pop up of Anya congratulating the user and once the user clicks "ok" on the alert the scene will change into level 2 and level 2 will begin. Also, the user will gain points depending on how much time they took finishing the exam. Once the scene changes, an alert of another 
 * spy agent who works with Loid named Yor introduces level 2. She shares the rules of the game and important notes that the user needs to read. The next level is all about agility and strength. Once the user reads the instructions, the user gets to choose a location out of the three 
 * themes that has been provided. The themes are starwars, spy, and FBI. Then the user picks what character they would like to be. The user can choose to be a girl or a boy in this level. Once they customize the level, the timers of the fireball, enemy and boss enemy starts. So depending 
 * on their timing, the fireballs, fake enemies and boss enemies start to move from the top of the screen to the bottom of the screen. The user can move the player using the arrow keys up, down, left and right and can also use the space bar to hit an enemy with a bullet. Every time 
 * that a fireball reaches the bottom of the room, the user will get 10 points added to their score. For every fake enemy that they hit with their bullet, they gain 20 points. However, if they collide with a fireball, their lives which is 3 decreases by one and if they lose all of their
 * lives, then the user fails level 2 and the program exits. If the user collides with the boss enemy once, then the user fails level 2 and the program exits. The user needs to score 500 points in level 2 so they can pass the level and essentially finish their training. When they get 500
 * points or higher, then the user wins the game and the alert of Yor will pop up congratulating the user that they are selected for the future mission and that they have a long journey ahead of them, then the program exits. If the user tries to close the window throughout the whole
 * game, there will be an alert confirming if they are sure that they want to exit.
 * 
 * PROGRAM DETAILS: 
 * 
 * Java Fx Components:
 * 
 * Buttons: There are several buttons that are used throughout the whole program, most of the buttons are initialized in the main and then kept on the gui under other methods for when they need to be called. The first two buttons are the start button and the highscores button which are kept
 * on the pane in the main method The start button is what makes the stage into level one and the high scores button shows an alert of the top ten scores. Each of those two buttons have a action method on its own, for the start it changes the stage into level one and calls on the level one method
 * . For the highscore action method, it reads the file that has the top 10 scores and writes it in the alert. The skip button is shown once the cut scene starts, it is initialized in the main method but then kept on the gui in the level one method. If the user clicks on the skip button they can 
 * skip the cut scene and move on to level one. The submit, clear and quit button is used for the level one exam. They are all initialized in the main but put into the gui in the level one method. The submit button when clicked, locks in the user's answers and checks if they are correct or not, the
 * clear button clears all of the textfields if the user wants to clear their answers, the quit button will make the program exit if the user clicks on it.
 * 
 * Panes: The majority of the panes that I have used was the borderpane. The borderpanes were all initialized in the main but the variables were declared locally to be used through all of the main class. The first root was used to view the title poster and the start and highscores button, Root 2 
 * was used for the beginning cut scene. The root2 was set to the 'cutscene1' scene so the images of the cut scene, the labels and the skip button can be added. In this root border pane, the images keep changing as well as the labels but the skip button will stay the same. Root 4 is used for all
 * of the components involved in level 2. The background image, player, score labels, fireballs, fake enemy and boss enemies graphics are all added into this pane. One of the unique panes
 * that I used was root3 because that root had the grid pane instead of a borderpane, so all of the components in level one was kept in a grid like layout. 
 * 
 * Image and ImageView: There were many images that were initialized to set the imageview variables in the main class and also in the other classes. All the images were initialized in the main start method or either the constructors in several classes. Most of the images and imageview variables in the
 * main start method are for alerts and the scenes. The images in the player class was used and depended on what image did the user want for their player (boy or girl). In the bullet class the images were the bullet images facing east and west. In the fireballs class, the image was a fireball and in the
 * boss enemy class the imageview variable was set as the boss enemy image.
 * 
 * Text Fields: There are ten textfields used in level one that is first initialized in the main method and then added into the grid pane layout of root3 in same location as well. They are used for the users to write their answers for each question in the exam. They are also used to check the user's answers using the
 * file that contains the answers to the level one exam.
 * 
 * Label: There are several labels that are used in this program. All of the labels are initialized in the main method and used throughout the whole program. For level one, the labels are used to write down the questions and the main title. For the cut scene, labels are used for dialogs of the characters and to emphasize
 * what the cut scene is about. In level 2 the labels are used for score labels and updating them with a new score if the player gains points.
 * 
 * Layouts: I used a few layouts throughout the program, the grid pane layout was used for level 1 to maintain an exam type of structure, all of the components that was important for that layout was all added in the main start method. In level one, an Hbox layout was used as well to group the 3 buttons which were the submit button,
 * quit and clear button. The rest of the layouts were the default borderpane 
 * 
 * 2D Array: The 2D array was used in the method of level 2 and was used to store imageview variables and their images for the customization of level 2. So when the user picks a certain background from the alert, we can set the window to be that background theme by accessing the image from the 2D array.
 * 
 * Sorting Methods: I used the sorting arrayLists for when I had to record the top 10 highscores everytime that a player plays the game, in the highscores method, we add the recent score into the scoredPoints arraylist and then add the other scores in the "scores.txt" file, then we use the sorting method to sort the numbers from greatest to least
 * , we then write in the file the top 10 scores from that sorted arrayList. The same thing occurs when the user clicks on the highscores button, in the hsBtn_Click() method, we take the top 10 scores from the file add into the array list, sort it again and use it to type the scores in into an alert.
 * 
 * Inheritance and polymorphism: Inheritance was used for level 2 where the enemy class is the super class and boss class is the subclass. The boss enemy moves the same as the fake enemies. They start from the top of the screen and move to the bottom of the screen. The subclass has a few extra changes and those are changing the image of the enemy iview variable
 * to the boss enemy image and making the speed variable higher to make the boss enemies go faster than the fake enemies. The boss enemies are created and the class is initialized in the level 2 method.
 * 
 * Animation: I used animation for several components in level 2 and its method. The animation was used to move the player in the control of the user using the arrow keys and move methods for various directions in the animation timer. It also checked whether the score is 0 or higher than 500 to end the game in the right way. The animation method also used a lot of the player
 * class methods like getNode(), getX() etc. The key event was used to trigger what move method should be used to move the image of the player and animate it. The animation timer was also used to move the fireballs from the top of the screen to the bottom of the screen. It also checked the collisions between the player and the fireball and went through the actions in that if statement.
 * There was an animation timer to move the bullet across the room when it was triggered by the space key and an animation timer for the fake enemies and the boss enemies. The fake enemies and the boss enemies used the animation timer to move from the top of the screen and bottom of the screen. Also to check for collisions and to update the scores depending on what type of collision occurred
 * 
 * File Class: There are two file classes that are used in this program. The first file is the exam.txt which is used in the subBtn_Click() method. This file has the answers to the questions that was in the level one exam. I used it to compare with the user's answers using the file reader and buffered reader. The second file is the "scores.txt" which stores the top 10 highscores of the game. It 
 * is accessed in the highscores method and the hsBtn_Click() method. In the highscores method, we compare the recent score of the player with the top 10 and change it according to the scores being greatest to smallest of top 10. In the click method, I read the file's top scores and convert them into text to type it into an alert for the user to see.
 * 
 * ArrayLists: There are four arraylists used in this program. The enemy arraylist is to use the enemy class but create several indexes that access each of the enemy class to spawn new enemies every 5 seconds. The fireball arraylist is used to spawn new fireballs in a specific amount of seconds and to for each new element in the array have access to the fireball array class. The boss enemy array list is
 * to create many boss enemies and spawn then every 7 seconds and for each element to have access to the boss class. All of those arraylists are initialized in the level 2 method. The last array list is to add the scores and record the top 10 scores from that array list and is used in the highscores method and the hsBtn_Click() method.
 * 
 * Sounds: The background sound is initialized in the beginning of the main and will keep repeating throughout the whole game. I used the media and mediafile concepts to play the background sound. There are sound effects that are stored in a 1D array of an audioclip array and used in level 2 method. The sad clip is used for when the user fails the task in a level and get the "failed" alert. The fireball sound
 * is used whenever a new fireball has been spawned and is now moving in the room. The collision sound effect is used when the play collides with any of the image components that can move in the level 2 part of the game.
 *
 * Solution for Level 1:
 * What is the word that refers to the instance of a superclass?
 * super
 * What method is used to read data members and set them as a value to a variable? 
 * accessor
 * What do you define a class that is being extended?
 * superclass
 * What is the word that refers to the property of using a previous value to obtain the next.
 * Recursion
 * True or False: Polymorphism is a data structure that can store many of the same kind of data together at once
 * False
 * What is the default layout manager of a new JavaFX project?
 * BorderPane
 * What is a method we can use for exception handling?
 * Try-Catch
 * What word starts with E and ends with E but only has one letter in it?
 * Envelope
 * The more you take, the more you leave behind. What am I?
 * Fingerprint
 * I have no life, but I can die. What am I?
 * Battery
 */

public class Main extends Application {
	//@Override

	// declaring the global variables so it can be accessed through the whole program in the main
	private Button startBtn, skipBtn, subBtn, cleBtn, quitBtn, highscoresBtn;
	private Pane root, root2, root4;
	private GridPane root3;
	private Scene scene, cutscene1, lvl1, lvl2, endScene;
	private String name;
	private ImageView loidAlert, iviewLoid, iviewH1, iviewH2, anyaAlert;
	private Timeline tl1, tl2, tl3, tl4, tl5, tlQTimer, tEnemy, tFb, bulletTimer, tBEnemy;
	private Image imgHead1, imgHead2, imgHead3, imgHead4;
	private Label lbl1, lblTitle, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, min, tscorelbl, scorelbl;
	private Font textF1, textF2;
	private KeyFrame kfText1, kfText2, kfText3, kfText4, kfText5, kfQtimer, kfFb;
	private TextField ta1, ta2, ta3, ta4, ta5, ta6, ta7, ta8, ta9, ta10;
	private int minCounter, eSeconds = 5, eCounter = -1, livesF = 3, fSeconds = 3, fCounter = -1, bCounter = -1, bSeconds = 7, livesBE = 2, score = 50, scorelvl2 = 0;
	private boolean timeUp = false, goRight, goLeft, goUp, goDown, character, gameOverlvl2 = false, gameOverL = false, gameOverW = false;
	private ImageView[][] customlvl2;
	private Player player;
	private AnimationTimer tPlayer, aFb, aEnemy, aBEnemy;
	private Random rnd;

	// accessing certain classes through several array lists
	private ArrayList<Enemy> enemy = new ArrayList<Enemy>();
	private ArrayList<Boss> bossEnemy = new ArrayList<Boss>();
	private ArrayList<Fireball> fb = new ArrayList<Fireball>();
	ArrayList <Integer> sortedPoints = new ArrayList <Integer>();
	private Media background;
	private MediaPlayer backgroundPlayer;
	private Bullet bullet;
	private AudioClip[] clip;

	public void start(Stage primaryStage) {
		try {

			// initializing the text fonts with unique fonts to be used in alerts, labels etc
			textF1 = Font.loadFont(new FileInputStream(new File("Gamer Bold.ttf")), 25);
			textF2 = Font.loadFont(new FileInputStream(new File("spyagency.ttf")), 20);

			// Play the background music throughout the whole game when it runs
			File backFile = new File("exo.wav");
			background = new Media(backFile.toURI().toString());
			backgroundPlayer = new MediaPlayer(background);
			backgroundPlayer.setOnEndOfMedia(new Runnable()
			{
				public void run()
				{
					backgroundPlayer.seek(Duration.ZERO);
				}
			});

			backgroundPlayer.play();

			// adding all the audio clip sound effects into an array so it can be used throughout the game when added
			clip = new AudioClip[] {new AudioClip("file:Fireball_Sound.wav"), new AudioClip("file:Collision.wav"), new AudioClip("file:sad.wav")};

			// initializing the random class
			rnd = new Random();

			// Adding the poster image for the introduction of the game
			Image imgTitle = new Image("file:Spy X Family.png");
			ImageView iviewTitle = new ImageView(imgTitle);

			// initializing the image of Loid for the first cut scene
			Image imgLoid = new Image("file:Loid_Cut.jpg");
			iviewLoid = new ImageView(imgLoid);

			// initializing the loid image for certain alerts and setting its properties
			Image imgLAlert = new Image("file:Loid_alert.gif");
			loidAlert = new ImageView(imgLAlert);
			loidAlert.setPreserveRatio(true);
			loidAlert.setFitHeight(200);

			//initializing the anya image for the alerts
			Image imgA = new Image("file:Anya_Icon.png");
			anyaAlert = new ImageView(imgA);

			// initializing the images for the first cut scene
			imgHead1 = new Image("file:headquarters.png");
			imgHead2 = new Image("file:headquarters2.png");
			imgHead3 = new Image("file:headquarters3.png");
			imgHead4 = new Image("file:headquarters4.png");

			// initializing the images to be set into a 2D array for the customization of level 2's background and character
			Image star = new Image("file:Starwars.jpeg");
			Image train = new Image("file:Train_room.jpg");
			Image lab = new Image("file:Spy_lab.png");
			Image male = new Image("file:Male.png");
			Image female = new Image("file:Girl.jpg");

			// Making the 2D array for the user to customize the level
			customlvl2 = new ImageView[2][3];

			// making the images for the customization of the level to initialize the 2D imageview array

			// The first row is the background
			customlvl2[0][0] = new ImageView(star);
			customlvl2[0][1] = new ImageView(train);
			customlvl2[0][2] = new ImageView(lab);

			// The second row is the character
			customlvl2[1][0] = new ImageView(male);
			customlvl2[1][1] = new ImageView(female);


			// setting up the pane and scene for the title image
			root = new Pane();
			scene = new Scene(root,imgTitle.getWidth(), imgTitle.getHeight());

			// Making the start button to start the game
			startBtn = new Button();
			startBtn.setFont(textF1);
			startBtn.setTextFill(Color.FORESTGREEN);
			startBtn.setPrefSize(150,70);
			startBtn.setText("START");
			startBtn.setLayoutX(200);
			startBtn.setLayoutY(410);

			// making the highscores button for the user to check the top 10 highscores, also setting the properties of the button
			highscoresBtn = new Button();
			highscoresBtn.setFont(Font.font("Courier New", FontWeight.BOLD, FontPosture.REGULAR, 14));
			highscoresBtn.setTextFill(Color.FORESTGREEN);
			highscoresBtn.setPrefSize(150,40);
			highscoresBtn.setText("Highscores");
			highscoresBtn.setLayoutX(200);
			highscoresBtn.setLayoutY(500);

			// if the user clicks on the start button it will lead to the actions inside the start click method
			// if the user clicks on the high score button it will lead to the actions inside the high score click method
			startBtn.setOnAction(e -> startBtn_Click(primaryStage));
			highscoresBtn.setOnAction(e -> hsBtn_Click());

			// Initializing the skip button so the user will be able to skip the cut scene and go straight to the levels and setting their properties
			skipBtn = new Button();
			skipBtn.setFont(textF2);
			skipBtn.setTextFill(Color.FORESTGREEN);
			skipBtn.setPrefSize(150,50);
			skipBtn.setText("SKIP");
			skipBtn.setLayoutX(800);
			skipBtn.setLayoutY(500);
			skipBtn.setOnAction(e -> skipBtn_Click(primaryStage));

			// adding all the components to the first scene (poster, start button, highscores button)
			root.getChildren().add(iviewTitle);
			root.getChildren().add(startBtn);
			root.getChildren().add(highscoresBtn);

			// A new scene and root for when the player clicks start and the first cut scene pops up
			root2 = new Pane();
			cutscene1 = new Scene(root2, imgLoid.getWidth(), imgLoid.getHeight());
			root2.setStyle("-fx-background-color: black");

			// initializing the root for level 1 scene and setting its properties
			root3 = new GridPane();
			lvl1 = new Scene(root3, 900,800);
			root3.setStyle("-fx-background-color: black");
			root3.setGridLinesVisible(false);
			root3.setHgap(10);
			root3.setVgap(10);
			root3.setPadding(new Insets(20,20,20,20));

			// Use root 3 layout to make the exam gui for level 1 here

			// creating the title of level one
			lblTitle = new Label();
			lblTitle.setText("Spy X Family: The Exam");
			lblTitle.setTextFill(Color.WHITE);
			lblTitle.setPrefSize(500,70);
			lblTitle.setFont(Font.loadFont(new FileInputStream(new File("spyagency.ttf")), 30));
			lblTitle.setAlignment(Pos.CENTER);

			// making the labels of each question to add into the gridpane layout
			q1 = new Label();
			q1.setText("1. What is the word that refers to the instance of a superclass?");
			q1.setTextFill(Color.WHITE);
			q1.setFont(Font.font("Courier New", FontWeight.LIGHT, FontPosture.REGULAR, 14));
			q1.setAlignment(Pos.CENTER);

			q2 = new Label();
			q2.setText("2. What method/word is used to read data members \n   and set them as a value to a variable?");
			q2.setTextFill(Color.WHITE);
			q2.setFont(Font.font("Courier New", FontWeight.LIGHT, FontPosture.REGULAR, 14));
			q2.setAlignment(Pos.CENTER);

			q3 = new Label();
			q3.setText("3. What do you define a class that is being extended?");
			q3.setTextFill(Color.WHITE);
			q3.setFont(Font.font("Courier New", FontWeight.LIGHT, FontPosture.REGULAR, 14));
			q3.setAlignment(Pos.CENTER);

			q4 = new Label();
			q4.setText("4. What is the word that refers to the property of using a \n   previous value to obtain the next?");
			q4.setTextFill(Color.WHITE);
			q4.setFont(Font.font("Courier New", FontWeight.LIGHT, FontPosture.REGULAR, 14));
			q4.setAlignment(Pos.CENTER);

			q5 = new Label();
			q5.setText("5. True or False: Polymorphism is a data structure that can store many \n   of the same kind of data together at once.");
			q5.setTextFill(Color.WHITE);
			q5.setFont(Font.font("Courier New", FontWeight.LIGHT, FontPosture.REGULAR, 14));
			q5.setAlignment(Pos.CENTER);

			q6 = new Label();
			q6.setText("6. What is the default layout manager of a new javaFX project?");
			q6.setTextFill(Color.WHITE);
			q6.setFont(Font.font("Courier New", FontWeight.LIGHT, FontPosture.REGULAR, 14));
			q6.setAlignment(Pos.CENTER);

			q7 = new Label();
			q7.setText("7. What is a method we can use for exception handling?");
			q7.setTextFill(Color.WHITE);
			q7.setFont(Font.font("Courier New", FontWeight.LIGHT, FontPosture.REGULAR, 14));
			q7.setAlignment(Pos.CENTER);

			q8 = new Label();
			q8.setText("8. What words starts with E and ends with E but only has one letter in it?");
			q8.setTextFill(Color.WHITE);
			q8.setFont(Font.font("Courier New", FontWeight.LIGHT, FontPosture.REGULAR, 14));
			q8.setAlignment(Pos.CENTER);

			q9 = new Label();
			q9.setText("9. The more you take, the more you leave behind. What am I?");
			q9.setTextFill(Color.WHITE);
			q9.setFont(Font.font("Courier New", FontWeight.LIGHT, FontPosture.REGULAR, 14));
			q9.setAlignment(Pos.CENTER);

			q10 = new Label();
			q10.setText("10. I have no life, but I can die. What am I?");
			q10.setTextFill(Color.WHITE);
			q10.setFont(Font.font("Courier New", FontWeight.LIGHT, FontPosture.REGULAR, 14));
			q10.setAlignment(Pos.CENTER);

			// making the text areas for each question so that the user can type in their answers for each question
			ta1 = new TextField();
			ta1.setEditable(true);
			ta1.setFont(Font.font("Courier New", FontWeight.NORMAL, FontPosture.REGULAR,14));
			ta1.setPrefSize(200, 200);

			ta2 = new TextField();
			ta2.setEditable(true);
			ta2.setFont(Font.font("Courier New", FontWeight.NORMAL, FontPosture.REGULAR,14));
			ta2.setPrefSize(200, 200);

			ta3 = new TextField();
			ta3.setEditable(true);
			ta3.setFont(Font.font("Courier New", FontWeight.NORMAL, FontPosture.REGULAR,14));
			ta3.setPrefSize(200, 200);

			ta4 = new TextField();
			ta4.setEditable(true);
			ta4.setFont(Font.font("Courier New", FontWeight.NORMAL, FontPosture.REGULAR,14));
			ta4.setPrefSize(200, 200);

			ta5 = new TextField();
			ta5.setEditable(true);
			ta5.setFont(Font.font("Courier New", FontWeight.NORMAL, FontPosture.REGULAR,14));
			ta5.setPrefSize(200, 200);

			ta6 = new TextField();
			ta6.setEditable(true);
			ta6.setFont(Font.font("Courier New", FontWeight.NORMAL, FontPosture.REGULAR,14));
			ta6.setPrefSize(200, 200);

			ta7 = new TextField();
			ta7.setEditable(true);
			ta7.setFont(Font.font("Courier New", FontWeight.NORMAL, FontPosture.REGULAR,14));
			ta7.setPrefSize(200, 200);

			ta8 = new TextField();
			ta8.setEditable(true);
			ta8.setFont(Font.font("Courier New", FontWeight.NORMAL, FontPosture.REGULAR,14));
			ta8.setPrefSize(200, 200);

			ta9 = new TextField();
			ta9.setEditable(true);
			ta9.setFont(Font.font("Courier New", FontWeight.NORMAL, FontPosture.REGULAR,14));
			ta9.setPrefSize(200, 200);

			ta10 = new TextField();
			ta10.setEditable(true);
			ta10.setFont(Font.font("Courier New", FontWeight.NORMAL, FontPosture.REGULAR,14));
			ta10.setPrefSize(200, 200);

			// Creating buttons for the HBox layout
			//setting up the submit button and making its properties
			subBtn = new Button();
			subBtn.setPrefSize(100, 30);
			subBtn.setText("SUBMIT");
			subBtn.setAlignment(Pos.CENTER);

			// when the user clicks submit, it leads to the actions within the method
			subBtn.setOnAction(e -> sub_Click(primaryStage));

			// creating the clear button and setting its properties
			cleBtn = new Button();
			cleBtn.setPrefSize(100, 30);
			cleBtn.setText("CLEAR");
			cleBtn.setAlignment(Pos.CENTER);
			cleBtn.setOnAction(e -> cle_Click());

			// creating the quit button and setting its properties
			quitBtn = new Button();
			quitBtn.setPrefSize(100, 30);
			quitBtn.setText("QUIT");
			quitBtn.setAlignment(Pos.CENTER);
			quitBtn.setOnAction(e -> quit_Click());

			// Creating the Hbox to add the buttons
			HBox hb = new HBox();
			hb.setSpacing(10);
			hb.setAlignment(Pos.CENTER);

			hb.getChildren().addAll(subBtn, cleBtn, quitBtn);

			// making a label for the amount of minutes that the user has left in the exam
			min = new Label();
			min.setPrefSize(200, 100);
			min.setText("5:00");
			min.setFont(Font.font("Courier New", 17));
			min.setTextFill(Color.WHITE);
			min.setAlignment(Pos.CENTER);

			// aligning the title and for the hbox to be aligned in the center of the layout
			GridPane.setHalignment(lblTitle, HPos.CENTER);
			GridPane.setHalignment(hb, HPos.RIGHT);

			// adding the title and all of the labels of the questions and the text areas
			root3.add(lblTitle, 0, 0);

			root3.add(q1, 0, 1);
			root3.add(ta1, 1, 1);

			root3.add(q2, 0, 2);
			root3.add(ta2, 1, 2);

			root3.add(q3, 0, 3);
			root3.add(ta3, 1, 3);

			root3.add(q4, 0, 4);
			root3.add(ta4, 1, 4);

			root3.add(q5, 0, 5);
			root3.add(ta5, 1, 5);

			root3.add(q6, 0, 6);
			root3.add(ta6, 1, 6);

			root3.add(q7, 0, 7);
			root3.add(ta7, 1, 7);

			root3.add(q8, 0, 8);
			root3.add(ta8, 1, 8);

			root3.add(q9, 0, 9);
			root3.add(ta9, 1, 9);

			root3.add(q10, 0, 10);
			root3.add(ta10, 1, 10);

			root3.add(hb, 0, 11);

			root3.add(min, 1, 0);

			// initializing the root pane for level 2 and adding the level 2 scene into the root
			root4 = new Pane();
			lvl2 = new Scene(root4, 1000, 800);
			root4.setStyle("-fx-background-color: black");

			// initializing the total score label of level 1 and level 2 and setting its properties
			tscorelbl = new Label();
			tscorelbl.setText("Total Score: " + score);
			tscorelbl.setTextFill(Color.RED);
			tscorelbl.setPrefSize(200,70);
			tscorelbl.setLayoutX(0);
			tscorelbl.setLayoutY(0);
			tscorelbl.setFont(Font.font("Courier New", FontWeight.NORMAL, FontPosture.REGULAR,20));
			tscorelbl.setAlignment(Pos.CENTER);

			// initializing the score label of level 2 and setting its properties
			scorelbl = new Label();
			scorelbl.setText("Score: " + scorelvl2);
			scorelbl.setTextFill(Color.RED);
			scorelbl.setPrefSize(200,70);
			scorelbl.setLayoutX(0);
			scorelbl.setLayoutY(60);
			scorelbl.setFont(Font.font("Courier New", FontWeight.NORMAL, FontPosture.REGULAR,20));
			scorelbl.setAlignment(Pos.CENTER);

			// This occurs when the user closes the window by clicking the top window option to close, it confirms using an alert whether they are
			// are sure that they want to exit the program
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>()
			{
				public void handle(WindowEvent e)
				{
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setContentText("Are you sure you want to exit?");
					alert.setGraphic(loidAlert);
					alert.setTitle("Exit");

					// Adding the button yes or no to the alert where the program asks the user if they are sure that they want to exit
					alert.setHeaderText(null);
					alert.getButtonTypes().clear();
					alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);

					Optional<ButtonType> result = alert.showAndWait();

					// If the click on the YES button, the program will stop running
					if(result.get() == ButtonType.YES)
					{
						Platform.exit();
						System.exit(0);
					}

				}

			}); 	


			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	// once the user clicks the start button the primary stage is set to the scene where the cut scene is and the dialog pops up asking for their name
	// the method goes through key frames to show the cut scene 
	public void startBtn_Click(Stage primaryStage)
	{
		primaryStage.setScene(cutscene1);
		primaryStage.show();



		// initalizing the alert so the user can type in their name
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("What is you name?");
		dialog.setHeaderText(null);
		dialog.setContentText("Welcome new recruit!\nFirst things first, what is your name agent?");

		// adding their input into a variable
		Optional<String> result = dialog.showAndWait();
		
		// when the user presses ok in the alert it first checks whether the user wrote something or left it empty
		// if it is empty then their default name will be 'A' else, the user input will be stored in a variable and will be used for other alerts
		if(result.isPresent())
		{

			if(result.get() == null || result.get().equalsIgnoreCase(" ") || result.get().length() < 1)
			{

				name = "A";


			}
			else
			{
				name = result.get(); 

			}


			// make sure that you catch the error if the user left the name empty
			//Initializing the alert and confirming their name
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setGraphic(loidAlert);
			alert.setContentText("Hello Agent " + name + ".\nLet us being with your training...");
			alert.setHeaderText(null);
			alert.showAndWait();

			// adding the first cut scene image and also a skip button if user wants to skip to the levels of the game
			root2.getChildren().add(iviewLoid);
			root2.getChildren().add(skipBtn);

			// Initializing the label for the first part of the cut scene and setting its properties
			lbl1 = new Label();
			lbl1.setTextFill(Color.WHITE);
			lbl1.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 14));
			lbl1.setStyle("-fx-background-color: black");
			lbl1.setText("Twilight: Good Afternoon Agent " + name + ", my name is 'Twilight' aka Loid Forger.\nYou may have seen me around, "
					+ "after all, I was the one who recurited you\nfor this mission in the first place. You got one heck of a talent " + name + ".\nLet's put that to the test before our agency offically assigns you this mission...");
			lbl1.setLayoutX(40);
			lbl1.setLayoutY(470);
			lbl1.setAlignment(Pos.CENTER);

			// adding it to the following root pane
			root2.getChildren().add(lbl1);


			// change back to 15000
			// after 15 seconds, set the image of the cut scene to the next image and change the label on the gui as well
			kfText1 = new KeyFrame(Duration.millis(15000), new EventHandler<ActionEvent>()
			{
				public void handle(ActionEvent e)
				{
					//run(primaryStage);

					iviewLoid.setImage(imgHead1);

					lbl1.setFont(textF2);
					lbl1.setTextFill(Color.BLACK);
					lbl1.setStyle("-fx-background-color: lightgreen");
					lbl1.setText("A few days earlier...");
					lbl1.setLayoutX(40);
					lbl1.setLayoutY(50);
					lbl1.setAlignment(Pos.CENTER);

					tl2 = new Timeline(kfText2);
					tl2.setCycleCount(1);
					tl2.play();
				}
			});

			// starting the timeline automatically after the first alert pops up that confirms their name
			tl1 = new Timeline(kfText1);
			tl1.setCycleCount(Timeline.INDEFINITE);
			tl1.play();

			// after 5 seconds move on to the next image of the cut scene and start the timeline for the next image
			kfText2 = new KeyFrame(Duration.millis(5000), new EventHandler<ActionEvent>()
			{
				public void handle(ActionEvent e)
				{
					iviewLoid.setImage(imgHead2);

					tl3 = new Timeline(kfText3);
					tl3.setCycleCount(1);
					tl3.play();
				}
			}); 

			// after 5 seconds of the previous image scene, move on to the next image and change the label's properties
			kfText3 = new KeyFrame(Duration.millis(5000), new EventHandler<ActionEvent>()
			{
				public void handle(ActionEvent e)
				{
					iviewLoid.setImage(imgHead3);

					lbl1.setFont(textF2);
					lbl1.setStyle("-fx-background-color: black");
					lbl1.setTextFill(Color.WHITE);
					lbl1.setText("Director: We need to recruit our best agents\n for this mission if we want to suceed.");
					lbl1.setLayoutX(100);
					lbl1.setLayoutY(520);
					lbl1.setAlignment(Pos.CENTER);

					// starting the next timeline so it can move on to the next image in a certain amount of seconds
					tl4 = new Timeline(kfText4);
					tl4.setCycleCount(1);
					tl4.play();
				}
			}); 

			// after 5 seconds of the previous image scene, move on to the next image and change the label's properties
			kfText4 = new KeyFrame(Duration.millis(5000), new EventHandler<ActionEvent>()
			{
				public void handle(ActionEvent e)
				{
					tl4.stop();

					iviewLoid.setImage(imgHead4);

					lbl1.setFont(textF2);
					lbl1.setStyle("-fx-background-color: black");
					lbl1.setTextFill(Color.WHITE);
					lbl1.setText("Agent Ironman: Leave it to 'twilight', sir.\nHe will take care of the rest.");
					lbl1.setLayoutX(150);
					lbl1.setLayoutY(515);
					lbl1.setAlignment(Pos.CENTER);

					// starting the next timeline so it can move on to the next image in a certain amount of seconds
					tl5 = new Timeline(kfText5);
					tl5.setCycleCount(1);
					tl5.play();
				}
			}); 

			// after 5 seconds and the last image of the scene is done, stop all the timers and move on to level one
			kfText5 = new KeyFrame(Duration.millis(5000), new EventHandler<ActionEvent>()
			{
				public void handle(ActionEvent e)
				{

					tl1.stop();
					tl2.stop();
					tl3.stop();
					tl4.stop();
					tl5.stop();

					level1(primaryStage);

				}

			}); 



		}

	}

	// the method controls what occurs in level 1, it has all the mechanisms like scoring, checking the user's answers and the alerts for instructions etc
	public void level1(Stage primaryStage)
	{
		// setting the stage to the level one scene
		primaryStage.setScene(lvl1);

		// running the alert once the method is called about the level one instructions which is introduced by anya forger
		Platform.runLater(new Runnable()
		{
			public void run()
			{

				// the alert pops up when the scene changes about the level 1 instructions and how to play level one and its time system
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setGraphic(anyaAlert);
				alert.setTitle("Level 1 Instructions");
				alert.setContentText("Hello Agent " + name + "! Nice to meet you! My name is Anya Forger and we are going to start your training by testing your knowledge.\n\nThe mission you are training for requires you to have experience in hacking and quick thinking. "
						+ "So, we are testing you on terms that you need for coding along with a few riddles!\n\nFYI: The exam is timed, you will only have 5 minutes to finish the exam! This assesment only requires you to use one word to answer each question. So answer the questions as quickly as you can! If you do not pass the exam with a grade of"
						+ " 50% or higher, you will not be officially selected to be a part of the mission.\n\nI would be sad to see you go so try your best agent!\n\nAfter you finish your exam, make sure you click the submit button to submit your final answers!!!");
				alert.setHeaderText(null);
				alert.showAndWait();

				// the 5 min timer starts since the user only have 5 min to finish the exam
				tlQTimer.play();

			}
		});

		// in a try catch method, the key frame goes by 1 min and decreases the minute counter by one min, for every min that the user wastes, there is a decrease of 10 points from their initial score of 50 points
		try {

			minCounter = 5;

			// change back to 60000
			KeyFrame kf = new KeyFrame(Duration.millis(60000), new EventHandler<ActionEvent>()

			{
				public void handle(ActionEvent e)
				{
					minCounter--;
					score = score - 10;
					tscorelbl.setText("Total Score: " + score);

					// if the 5 min are up, then the user lost the game since they didnt use the submit button in time which means they were not done
					if(minCounter == 0)
					{
						min.setFont(Font.font("Counter", 14));
						min.setText("Time's Up!");
						tlQTimer.stop();

						timeUp = true;

						// if they did not press the submit button within the 5 min then the user failed and the game is over
						if(timeUp == true)
						{
							Platform.runLater(new Runnable()
							{
								public void run()
								{
									Alert alert = new Alert(AlertType.CONFIRMATION);
									alert.setGraphic(anyaAlert);
									alert.setTitle("Failed");
									alert.setContentText("Uh oh. Sorry Agent " + name + ", you didn't finish the exam in time which means that you can't move on to the next part of the training :/. The agency made a decision that you are not the right spy for this mission. Better luck next time agent! Keep working hard and you will get to be in amazing missions!\n\nSee you next time. ");
									alert.setHeaderText(null);
									alert.showAndWait();
									Platform.exit();
									System.exit(0);
								}
							});

						}

					}
					// other wise if the minute counter still hasnt reached zero set the text to the number that is in the updated variable
					else
					{
						min.setText(Integer.toString(minCounter) + ":00");
					}

				}
			});

			// initialize the timeline object of the questions timer 
			tlQTimer = new Timeline(kf);
			tlQTimer.setCycleCount(Timeline.INDEFINITE);


		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	// if the user clicks on the skip button it will automatically change the scene to become level one
	public void skipBtn_Click(Stage primaryStage)
	{
		tl1.stop();

		level1(primaryStage);

	}

	// once the use clicks on the submit button the, make the text area non editable and check whether the answers they put in are correct
	public void sub_Click(Stage primaryStage)
	{
		// stopping the 5 min timer
		tlQTimer.stop();

		// making the question's text area non editable
		ta1.setEditable(false);
		ta2.setEditable(false);
		ta3.setEditable(false);
		ta4.setEditable(false);
		ta5.setEditable(false);
		ta6.setEditable(false);
		ta7.setEditable(false);
		ta8.setEditable(false);
		ta9.setEditable(false);
		ta10.setEditable(false);

		try
		{
			// accessing the file with the answers of the exam
			File dataFile = new File ("exam.txt");

			// initializing the file reader and the buffered reader
			FileReader in = new FileReader(dataFile);
			BufferedReader readFile = new BufferedReader(in);

			// declaring local variables to access in this method
			String answer, fullString = "";
			String [] arrayAns = null, arrayUser;
			int counter = 0;

			// creating an array and taking the user's answers and putting it into the array
			arrayUser = new String[10];

			arrayUser[0] = ta1.getText();
			arrayUser[1] = ta2.getText();
			arrayUser[2] = ta3.getText();
			arrayUser[3] = ta4.getText();
			arrayUser[4] = ta5.getText();
			arrayUser[5] = ta6.getText();
			arrayUser[6] = ta7.getText();
			arrayUser[7] = ta8.getText();
			arrayUser[8] = ta9.getText();
			arrayUser[9] = ta10.getText();

			// Going through each line of the text file until we reach the last line before the line = null
			while((answer = readFile.readLine()) != null )
			{
				// adding each line's string into a variable so it can later on be split
				fullString += answer + ", ";
			}

			// Splitting the fullString variable into an array
			arrayAns = fullString.split(", ");


			// going through the answer array and seeing if it equals the user's answers in their array, if it is then increase the counter by one
			for(int i = 0; i < arrayAns.length; i++)
			{
				if(arrayUser[i].equalsIgnoreCase(arrayAns[i]))
				{
					counter++;
				}

			}

			readFile.close();
			in.close();

			// if they pass the exam with a 50 percent or higher the user gets a congrats alert and moves on to level 2 else, the game is over 
			if(counter >= 5)
			{

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setGraphic(anyaAlert);
				alert.setTitle("Passed");
				alert.setContentText("Congrats Agent " + name + "! You result is " + counter + "0% which means that you passed your exam! Also, you gained " + score + " points so far! You are now reading to move on to the second part of your training, strength and endurance.\n\nBest of luck agent!");
				alert.setHeaderText(null);
				alert.showAndWait();

				level2(primaryStage);

			}
			else
			{
				// a sad clip plays 
				clip[2].play();
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setGraphic(anyaAlert);
				alert.setTitle("Failed");
				alert.setContentText("Uh oh. Sorry Agent " + name + ", you failed the exam which means that you can't move on to the next part of the training :/. The agency made a decision that you are not the right spy for this mission.\n\nBetter luck next time agent! Keep working hard and you will get to be in amazing missions!\n\nSee you next time. ");
				alert.setHeaderText(null);
				alert.showAndWait();

				Platform.exit();
				System.exit(0);
			}

		}
		// Catch any errors that might occur in the program
		catch (FileNotFoundException e)
		{
			System.out.println("File does not exist or is not found.");
			System.out.println("FileNotFoundException: " + e.getMessage());
		}
		catch (IOException e)
		{
			System.out.println("Error.");
			System.out.println("IOExcpetion: " + e.getMessage()); 
		}

	}

	// if the user presses clear, clear all of the text areas
	public void cle_Click()
	{
		ta1.clear();
		ta2.clear();
		ta3.clear();
		ta4.clear();
		ta5.clear();
		ta6.clear();
		ta7.clear();
		ta8.clear();
		ta9.clear();
		ta10.clear();


	}

	// if the user clicks quit, an alert will pop up confirming their exit and the game exits
	public void quit_Click()
	{
		tlQTimer.stop();

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText("Are you sure you want to exit? You still have time to finish the exam!");
		alert.setTitle("Exit");

		// Adding the button yes or no to the alert where the program asks the user if they are sure that they want to exit
		alert.setHeaderText(null);
		alert.getButtonTypes().clear();
		alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);

		Optional<ButtonType> result = alert.showAndWait();

		// If the click on the YES button, the program will stop running
		if(result.get() == ButtonType.YES)
		{
			Platform.exit();
			System.exit(0);
		}
	}

	// the level 2 method has all the mechanisms for level 2 and we set the primary scene to the level 2 so all the components like the labels, images etc can be added
	public void level2(Stage primaryStage)
	{


		primaryStage.setScene(lvl2);

		// initializing the yor image for the alerts in the level 2
		Image imgYor = new Image("file:Yor_Icon.png");
		ImageView ivYor = new ImageView(imgYor);

		// the beginning alert shares the instructions and concepts about level 2 that the user needs to read
		Alert alertStart = new Alert(AlertType.CONFIRMATION);
		alertStart.setGraphic(ivYor);
		alertStart.setTitle("Level 2 Instructions");
		alertStart.setContentText("Congrats on making it this far agent! Your almost done your training. Now for this part of the session, we are going to train your agility and strength.\n\nThis might be a"
				+ " bit tough but don't worry! You got this! You are to first choose a location out of the three themes we have provided you. Then choose the character you want to play as. Your training will start right away so"
				+ " you have to be very careful! You can use the arrow keys to move up, down, left and right. The space bar can be used to hit the enemy with a bullet. Make sure to not collide with the fireballs as well!\n\nNOTE:\n- The"
				+ " bullet can only be used one at a time\n- You have three chances of surviving if hit by a fireball, if you lose all those chances you will not be joining us on the mission\n- You have to score 500 points in order to be selected as one of the spies for the upcoming mission.\n      - You gain 10 points for every"
				+ " fireball you avoid and if you collide with a fireball once, you will lose 50 points\n     - You can gain 20 points everytime you shoot the fake enemies"
				+ "\n- You don't have to worry about colliding with the fake enemies but if you ever collide with a real enemy then your disqualified from training for the upcoming mission"
				+ "\n\nGood luck Agent " + name + ", I'm counting on you.");
		alertStart.setHeaderText(null);
		alertStart.showAndWait();

		// the user gets to customize the background and adding those options into the alert button types
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setGraphic(ivYor);
		alert.setContentText("What background theme would you like to use?");
		alert.setHeaderText(null);

		alert.getButtonTypes().clear();

		ButtonType btStar = new ButtonType("Starwars");
		ButtonType btTraining = new ButtonType("Spy");
		ButtonType btLab = new ButtonType("FBI");
		ButtonType btCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);


		alert.getButtonTypes().addAll(btStar, btTraining, btLab, btCancel);

		Optional<ButtonType> result = alert.showAndWait();

		// if a user picks a certain button on the alert that image will be set as the background
		if(result.get() == btStar)
		{
			root4.getChildren().add(customlvl2[0][0]);
		}
		else if(result.get() == btTraining)
		{
			root4.getChildren().add(customlvl2[0][1]);
		}
		else if(result.get() == btLab)
		{
			root4.getChildren().add(customlvl2[0][2]);
		}
		else if(result.get() == btCancel)
		{
			root4.getChildren().add(customlvl2[0][1]);
		}


		// customizing what character that the user would like to be using an alert and its button types
		Alert alert2 = new Alert(AlertType.CONFIRMATION);
		alert2.setGraphic(ivYor);
		alert2.setContentText("What character would you like to use?");
		alert2.setHeaderText(null);

		alert2.getButtonTypes().clear();

		ButtonType btmale = new ButtonType("Boy");
		ButtonType btfemale = new ButtonType("Girl");
		ButtonType btCancel2 = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);



		alert2.getButtonTypes().addAll(btmale,  btfemale, btCancel2);

		Optional<ButtonType> result1 = alert2.showAndWait();

		// if the user picks a certain button then it will effect the boolean variable so when we initialize the player class it sets the player's image to the character that they chose
		if(result1.get() == btmale)
		{
			character = false;
		}
		else if(result1.get() == btfemale)
		{
			character = true;
		} 

		// adding the score labels onto the level 2 gui
		root4.getChildren().addAll(scorelbl, tscorelbl);

		// initializing the player class and adding the player's image into the gui
		player = new Player(character);
		root4.getChildren().add(player.getNode());

		// initializng the bullet class and add the bullet image onto the gui
		bullet = new Bullet();
		root4.getChildren().add(bullet.getNode());

		// To move the bullet, we need a timeline and keyframe object to control the movement of the bullet
		KeyFrame kfBullet = new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent e)
			{
				// making the bullet move
				bullet.move();

				// To obtain the current image of the bullet facing the correct direction
				bullet.getNode();

				// if the bullet is off the screen then the bullet timer will stop
				if(bullet.isOffScreen(lvl2.getWidth()))
				{
					bulletTimer.stop();

				}
			}
		});

		// in order to activate the keyframe, we need to make a timeline
		bulletTimer = new Timeline(kfBullet);
		bulletTimer.setCycleCount(Timeline.INDEFINITE);


		// the key even is used for the player's movement, depending on what arrow key they use it will cause that direciton variable to be true and cause the player to move into that dir
		lvl2.setOnKeyPressed(new EventHandler<KeyEvent> ()
		{
			public void handle(KeyEvent e)
			{
				if(e.getEventType() == KeyEvent.KEY_PRESSED)
				{

					if(e.getCode() == KeyCode.RIGHT)
					{
						goRight = true;

					}
					else if(e.getCode() == KeyCode.LEFT)
					{
						goLeft = true;


					}
					else if(e.getCode() == KeyCode.UP)
					{
						goUp = true;

					}
					else if(e.getCode() == KeyCode.DOWN)
					{
						goDown = true;

					}

					// if the user clicks on the space a projectile is created of the bullet and the bullet will start to move because of the timer
					if(e.getCode() == KeyCode.SPACE)
					{
						// checking if there are no other bullet in the room
						if(bullet.isFired() == false)
						{
							// if there is no bullet in the room, then we set the bullet at the player's location
							bullet.setPosition(player.getX(), player.getY(), player.getDirection());

							bulletTimer.play();
						}
					}
				}

				player.getNode();

			}
		});

		// Check if an arrow key is not being held down
		lvl2.setOnKeyReleased(new EventHandler <KeyEvent>()
		{
			public void handle (KeyEvent e)
			{
				if(e.getCode() == KeyCode.RIGHT)
				{
					goRight = false;
				}
				else if(e.getCode() == KeyCode.LEFT)
				{
					goLeft = false;
				}
				else if(e.getCode() == KeyCode.UP)
				{
					goUp = false;
				}
				else if(e.getCode() == KeyCode.DOWN)
				{
					goDown = false;
				}
			}
		});

		// initializing the player's animation timer
		tPlayer = new AnimationTimer()
		{
			public void handle(long now)
			{

				// if the score of level 2 is less than 0 stop all of the timers that are occuring in level 2 and make the game over variable to true
				if(scorelvl2 < 0)
				{
					tFb.stop();
					tBEnemy.stop();
					tEnemy.stop();
					tPlayer.stop();

					gameOverL = true;

				}
				// if the score of level 2 is greater than 0 then stop all the timers and make the different varaible to be true
				else if(scorelvl2 >= 500)
				{
					tFb.stop();
					tBEnemy.stop();
					tEnemy.stop();
					tPlayer.stop();

					gameOverW = true;


				}

				// run the specific alert when one of the booleans is equal to true
				Platform.runLater(new Runnable()
				{
					public void run()
					{
						// if they lost play the sad clip, show the alert about how the user failed the training and exit the program
						if(gameOverL == true)
						{
							clip[2].play();
							Alert alertL = new Alert(AlertType.INFORMATION);
							alertL.setHeaderText(null);
							alertL.setTitle("Failed");
							alertL.setGraphic(ivYor);
							alertL.setContentText("Uh oh. Sorry Agent " + name + ", you failed your training and the agency made a decision that you are not the right spy for this mission.\n\nBetter luck next time agent! Keep working hard and you will get to be in amazing missions!\n\nSee you next time.");
							alertL.showAndWait();

							highscores();
							System.exit(0);
						}

						// if they won the game, congratulate them and exit the game
						if(gameOverW == true)
						{

							Alert alertW = new Alert(AlertType.INFORMATION);
							alertW.setHeaderText(null);
							alertW.setTitle("WIN");
							alertW.setGraphic(ivYor);
							alertW.setContentText("Congratulations!\nYou are selected to be a part of this mission! Loid really has a good eye on recruiting the best agents! The training was only the beginning, we got a long journey ahead of us.");
							alertW.showAndWait();

							highscores();
							System.exit(0);
							//end(primaryStage);
						}

					}
				});

				// depending on what variable becomes true the certain direction move method is accessed and there are boundaries set so the player doesnt leave the room
				if(goUp == true)
				{

					player.moveUp();

					if(player.getY() < 0)
					{
						player.setY(0);
					}

				}
				else if(goDown == true)
				{
					player.moveDown();

					if(player.getY() + player.getHeight() > lvl2.getHeight())
					{
						player.setY(lvl2.getHeight() - (int) player.getHeight());
					}

				}
				else if(goLeft == true)
				{
					player.moveWest();

					if(player.getX() < 0)
					{
						player.setX(0);
					}
				}
				else if(goRight == true)
				{
					player.moveEast();

					if(player.getX() + player.getWidth() > lvl2.getWidth())
					{
						player.setX(lvl2.getWidth() - player.getWidth());
					}

				}

				// update the player's image with the new updates
				player.getNode();
			}

		};

		// start the player's animation timer
		tPlayer.start();

		// every 3 seconds create a fireball in the array list and add it into the gui
		kfFb = new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent> ()
		{
			public void handle(ActionEvent e)
			{
				fSeconds --;

				if(fSeconds == 0)
				{
					clip[0].play();
					fCounter++;
					fb.add(fCounter, new Fireball(lvl2.getWidth(), lvl2.getHeight()));
					fb.get(fCounter).setLocation(lvl2.getWidth(), lvl2.getHeight());
					root4.getChildren().add(fb.get(fCounter).getNode());


					fSeconds = 3;

				}
			}
		});

		// starting the fireball timer so the fireballs can start and move
		tFb = new Timeline(kfFb);
		tFb.setCycleCount(Timeline.INDEFINITE);
		tFb.play();

		// initializing the fireball animation timer
		aFb = new AnimationTimer()
		{
			public void handle(long val)
			{
				// if the size of the fireball is greater than 0, go through the arraylists fireballs
				if(fb.size() > 0)
				{
					for (int i = 0; i < fb.size(); i++)
					{
						// move the fireballs and draw the fireball image into the gui
						fb.get(i).move();
						fb.get(i).getNode();

						// if the player collides with the fireball, decrease their points by 50 and play the fireball audio, also make the counter less by one and check if the counter equals to zero
						if(fb.get(i).getNode().getBoundsInParent().intersects(player.getNode().getBoundsInParent()))
						{
							clip[1].play();

							//decrease in 50 points
							scorelvl2 = scorelvl2 - 50;
							score -= 50;

							// update the score labels
							scorelbl.setText("Score: " + scorelvl2);
							tscorelbl.setText("Score: " + score);

							// remove the fireball that collided with the player
							root4.getChildren().remove(fb.get(i).getNode());
							fb.remove(i);
							fCounter--;

							livesF--;

							// if lives equal to 0 then stop all the timers and make the alert pop up telling the user that they failed, also play the sad audio clip, then exit the program also make the highscore method run
							if(livesF == 0)
							{

								tFb.stop();
								tEnemy.stop();
								tBEnemy.stop();

								gameOverlvl2 = true;

								if(gameOverlvl2 == true)
								{
									gameOverlvl2 = false;
									Platform.runLater(new Runnable()
									{
										public void run()
										{
											clip[2].play();
											Alert alert = new Alert(AlertType.CONFIRMATION);
											alert.setGraphic(ivYor);
											alert.setTitle("Failed");
											alert.setContentText("Uh oh. The fireball hit you three times! Sorry Agent " + name + ", you failed the agility test which means that you can't be recruited for this mission :/. The agency made a decision that you are not the right spy for this mission.\n\nBetter luck next time agent! Keep working hard and you will get to be in amazing missions!\n\nSee you next time. ");
											alert.setHeaderText(null);
											alert.showAndWait();

											highscores();
											Platform.exit();
											System.exit(0);
										}
									});
								}

							}


						}

						// if the size is greater than 0, check that the fireball is outside of the room and add the score by 10 and remove that image
						if(fb.size() > 0)
						{
							if(fb.get(i).getY() >= lvl2.getHeight())
							{
								if(fb.size() > 0)
								{
									scorelvl2 = scorelvl2 + 10;
									score = score + 10;

									scorelbl.setText("Score: " + scorelvl2);
									tscorelbl.setText("Score: " + score);

									root4.getChildren().remove(fb.get(i).getNode());
									fb.remove(i);
									fCounter--;
								}




							}
						}


					}
				}



			}

		};
		// start the fireball animation timer
		aFb.start();

		// The key frame is used to spawn the enemy every 5 seconds in the game
		KeyFrame kfEnemy = new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent> ()
		{
			public void handle(ActionEvent e)
			{
				eSeconds --;

				if(eSeconds == 0)
				{
					eCounter++;
					enemy.add(eCounter, new Enemy(lvl2.getWidth(), lvl2.getHeight()));
					enemy.get(eCounter).setLocation(lvl2.getWidth(), lvl2.getHeight());
					root4.getChildren().add(enemy.get(eCounter).getNode());

					eSeconds = 5;

				}
			}
		});

		// starts the timeline for the enemy to be spawned
		tEnemy = new Timeline(kfEnemy);
		tEnemy.setCycleCount(Timeline.INDEFINITE);
		tEnemy.play();

		// initializing the animation timer of the enemy
		aEnemy = new AnimationTimer()
		{
			public void handle(long val)
			{
				// if the size of the enemy array lists is greater than 0, go through the array and check certain conditions
				if(enemy.size() > 0)
				{

					for (int i = 0; i < enemy.size(); i++)
					{
						if(enemy.size() > 0)
						{
							// making the enemy move and set its image into the gui
							enemy.get(i).move();
							enemy.get(i).getNode();

							// if the player collides with the enemy, play collision clip and remove the enemy from the gui and array list
							if(enemy.get(i).getNode().getBoundsInParent().intersects(player.getNode().getBoundsInParent()))
							{
								clip[1].play();
								root4.getChildren().remove(enemy.get(i).getNode());
								enemy.remove(i);
								eCounter--;

							}

							// if the enemy collides with a bullet remove the enemy from the gui and add 20 points to the total score and score for level2
							if(enemy.get(i).getNode().getBoundsInParent().intersects(bullet.getNode().getBoundsInParent()))
							{
								root4.getChildren().remove(enemy.get(i).getNode());
								enemy.remove(i);
								eCounter--;

								//increase the points by 20 points
								scorelvl2 = scorelvl2 + 20;
								score = score + 20;

								scorelbl.setText("Score: " + scorelvl2);
								tscorelbl.setText("Score: " + score);
							}

						}
					}
				}
			}

		};

		// starting the animation timer
		aEnemy.start();	


		// The key frame is used to spawn the boss enemy every 7 seconds in the game
		KeyFrame kfBEnemy = new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent> ()
		{
			public void handle(ActionEvent e)
			{
				// decrease the amount of seconds and if reached to zero make the boss enemy
				bSeconds --;

				if(bSeconds == 0)
				{
					bCounter++;
					bossEnemy.add(bCounter, new Boss(lvl2.getWidth(), lvl2.getHeight()));
					bossEnemy.get(bCounter).setLocation(lvl2.getWidth(), lvl2.getHeight());
					root4.getChildren().add(bossEnemy.get(bCounter).getNode());

					bSeconds = 7;

				}
			}
		});

		// initializing the timeline timer and playing it for the boss enemy to be spawned  every 7 sec
		tBEnemy = new Timeline(kfBEnemy);
		tBEnemy.setCycleCount(Timeline.INDEFINITE);
		tBEnemy.play();

		// initalizing the animation timer of the boss enemy
		aBEnemy = new AnimationTimer()
		{
			public void handle(long val)
			{
				// if the boss enemy's array list is bigger than zero go through the array and check the certain conditions in the for loop
				if(bossEnemy.size() > 0)
				{
					for (int i = 0; i < bossEnemy.size(); i++)
					{
						if(bossEnemy.size() > 0)
						{
							// making the boss enemy move through the screen and getting its image
							bossEnemy.get(i).move();
							bossEnemy.get(i).getNode();

							// if the boss enemy collides with the player, the player automatically loses and the collision audio plays, the boss enemy is removed from the enemy and an alert pops up saying how the spy failed, then the program exits
							if(bossEnemy.get(i).getNode().getBoundsInParent().intersects(player.getNode().getBoundsInParent()))
							{

								clip[1].play();
								root4.getChildren().remove(bossEnemy.get(i).getNode());
								bossEnemy.remove(i);
								bCounter--;


								gameOverlvl2 = true;

								if(gameOverlvl2 == true)
								{
									gameOverlvl2 = false;

									Platform.runLater(new Runnable()
									{
										public void run()
										{
											clip[2].play();
											Alert alert = new Alert(AlertType.CONFIRMATION);
											alert.setTitle("Failed");
											alert.setGraphic(ivYor);
											alert.setContentText("Uh oh. Sorry Agent " + name + ", you failed the agility test which means that you can't be recruited for this mission :/. The agency made a decision that you are not the right spy for this mission.\n\nBetter luck next time agent! Keep working hard and you will get to be in amazing missions!\n\nSee you next time. ");
											alert.setHeaderText(null);
											alert.showAndWait();

											// to check if their score is high among the top 10 scores and keep it in the highscores file if it is  before the program exits
											highscores();
											Platform.exit();
											System.exit(0);
										}
									});
								}

								tBEnemy.stop();
								tFb.stop();
								tPlayer.stop();
								tEnemy.stop();


							}

							// if boss enemy collides with the bullet then check if the bullet hit the enemy twice, if it did then remove the boss enemy from the gui and update the scores by 50 points
							if(bossEnemy.get(i).getNode().getBoundsInParent().intersects(bullet.getNode().getBoundsInParent()))
							{

								livesBE--;

								if(livesBE == 0)

								{
									livesBE = 2;
									root4.getChildren().remove(bossEnemy.get(i).getNode());
									bossEnemy.remove(i);
									bCounter--;

									//increase the points by 50 points
									scorelvl2 = scorelvl2 + 50;
									score = score + 50;

									scorelbl.setText("Score: " + scorelvl2);
									tscorelbl.setText("Score: " + score);


								}

							}


						}
					}
				}
			}

		};

		// start the animation timer of the boss enemy
		aBEnemy.start();


	}



	// When this method is called upon, initialize the scores file and the file reader, buffered reader, then check if the score that the user got in the recent game belongs in the top 10 highscores list, if it does then add into the top 10 and remove the last score from the file 
	public void highscores()
	{
		try
		{
			File dataFile = new File ("scores.txt");
			FileReader in = new FileReader(dataFile);
			BufferedReader readFile = new BufferedReader(in);

			String scoreS;

			sortedPoints.add(score);

			while((scoreS = readFile.readLine()) != null)
			{
				sortedPoints.add(Integer.parseInt(scoreS));
			}

			sortedPoints.sort(Collections.reverseOrder());

			FileWriter out = new FileWriter(dataFile);
			BufferedWriter writeFile = new BufferedWriter(out);

			for(int i = 0 ; i < 10 && i < sortedPoints.size(); i++)
			{
				writeFile.write(sortedPoints.get(i).toString());

				// So the text file won't create a new blank line
				if(i < sortedPoints.size() - 1)
				{
					writeFile.newLine();
				}
			}


			writeFile.close();
			out.close();
			readFile.close();
			in.close();

		}
		catch(IOException e)
		{
			System.out.println("Problem writing to file.");
			System.err.println("IOException: " + e.getMessage());
		}

	}

	// if the highscores button on the poster is clicked, the file will be initalizied and the file reader, buffered reader so each line in the file can be read, added into the array which then in an alert is printed out
	public void hsBtn_Click()
	{
		try
		{
			File dataFile = new File ("scores.txt");
			FileReader in = new FileReader(dataFile);
			BufferedReader readFile = new BufferedReader(in);

			String scoreS;

			while((scoreS = readFile.readLine()) != null)
			{
				sortedPoints.add(Integer.parseInt(scoreS));
			}

			sortedPoints.sort(Collections.reverseOrder());

			readFile.close();
			in.close();

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Highscores");
			alert.setGraphic(loidAlert);
			alert.setContentText(sortedPoints.get(0) + "\n" + sortedPoints.get(1) + "\n" + sortedPoints.get(2) + "\n" + sortedPoints.get(3) + "\n" + sortedPoints.get(4) + "\n" + sortedPoints.get(5) + "\n" + sortedPoints.get(6) + "\n" + sortedPoints.get(7) + "\n"
					+ sortedPoints.get(8) + "\n" + sortedPoints.get(9));
			alert.setHeaderText(null);
			alert.showAndWait();

		}
		catch(IOException e)
		{
			System.out.println("Problem writing to file.");
			System.err.println("IOException: " + e.getMessage());
		}
	}


}
