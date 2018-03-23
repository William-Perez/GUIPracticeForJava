package practiceGUI2;

import javafx.util.Duration;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import pairOfDice.copy.DicePair;
import javafx.scene.image.*;
import javafx.scene.layout.StackPane;


public class cardGame extends Application 
{

	public DicePair dice;
	public int count,count2;
	double opacity;
	public int current,current2;
	public Image image[];
	public Image image2[];
	public Image imageBack;
	
	public ImageView imageview[];
	public ImageView imageview2[];
	public ImageView imageview3[];
	boolean on_off;
	
	
	//method
	//public void processButtonPress(ActionEvent event);
	
	
	
	public void start(Stage primaryStage)
	{
		
		imageBack = new Image("gull.jpg");
		
		dice = new DicePair();
		current = 1;
		current2 = 1;
		opacity = 0.0;
		
		
		
		//image declarations
		
		
		image = new Image[6];
		image[0] = new Image("one.jpg");
		image[1]= new Image("two.jpg");
		image[2]= new Image("three.jpg");
		image[3]= new Image("four.jpg");
		image[4]= new Image("five.jpg");
		image[5]= new Image("six.jpg");
		
		
		//second dice array
		image2 = new Image[6];
		image2[0] = new Image("one.jpg");
		image2[1]= new Image("two.jpg");
		image2[2]= new Image("three.jpg");
		image2[3]= new Image("four.jpg");
		image2[4]= new Image("five.jpg");
		image2[5]= new Image("six.jpg");
		
		imageview = new ImageView[6];
		imageview2 = new ImageView[6];
		imageview3 = new ImageView[1];
		
		
		
		imageview3[0] = new ImageView(imageBack);
		
		
		
		//assign images to image view
		for(int count = 0; count < 6; count++) {
			imageview[count] = new ImageView(image[count]);
		}
		
		
		//assign images to image view
		for(int count = 0; count < 6; count++) {
			imageview2[count] = new ImageView(image2[count]);
		}
		
		//setting opacity for dice
				for(int count = 0;count < 6;count++) {
					imageview[count].setOpacity(0.0);
					imageview2[count].setOpacity(0.0);
				}
		
		//stack pane
		StackPane pane = new StackPane(imageview[0],imageview[1],imageview[2],imageview[3],imageview[4],imageview[5]);
		StackPane pane2 = new StackPane(imageview2[0],imageview2[1],imageview2[2],imageview2[3],imageview2[4],imageview2[5]);
		StackPane pane3 = new StackPane(imageview3);
		
		
		
		//button
		Button push = new Button("Roll Dice");
		push.setOnAction(this::processButtonPress);
	
	
		
		FlowPane paneMain = new FlowPane(pane3,push,pane,pane2);
		paneMain.setAlignment(Pos.CENTER);
		paneMain.setHgap(80);
		//paneMain.setBackground(;
		
		
		
		
		//scene
		
		Scene scene = new Scene(paneMain,1300,900);
		
		primaryStage.setTitle("Program");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}//end start function
	
	public void processButtonPress(ActionEvent event)
	{


		System.out.println(on_off);
		
		if(on_off==true) {
			on_off = false;
			imageview3[0].setOpacity(0.0);
			
		}
		
		
		else if (on_off!=true) {
			
			on_off = true;
			imageview3[0].setOpacity(100.0);
			
		}
		
		
		imageview[current-1].setOpacity(0.0);
		imageview2[current2-1].setOpacity(0.0);
		System.out.println(current2);
		
		//roll dice
		dice.rollDice1();
		dice.rollDice2();
		
		current = dice.getFaceValue1();
		current2 = dice.getFaceValue2();
		
		System.out.println(current);

		
		imageview[current-1].setOpacity(100.0);
		imageview2[current2-1].setOpacity(100.0);
	
		
		/*//change opacity of dice
		FadeTransition ft = new FadeTransition();
	      ft.setNode(imageview[current-1]);
	      ft.setDuration(new Duration(3000));
	      ft.setFromValue(0.0);
	      ft.setToValue(100.0);
	      ft.setCycleCount(6);
	      ft.setAutoReverse(true);
	      imageview[current-1].setOnMouseClicked(me->ft.play());
	      //second transition
	      
	      FadeTransition ft2 = new FadeTransition();
	      ft2.setNode((imageview2[(current2)-1]));
	      ft2.setDuration(new Duration(3000));
	      ft2.setFromValue(0.0);
	      ft2.setToValue(100.0);
	      ft2.setCycleCount(6);
	      ft2.setAutoReverse(true);
	      imageview2[current-1].setOnMouseClicked(me->ft2.play());
	      */
		
		
		System.out.println(on_off);
		
	}//end void function
	
	public static void main(String[] args) {launch(args);}	
}
