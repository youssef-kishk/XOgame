package xo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.animation.FadeTransition;
import javafx.util.Duration;
public class XoGame extends Application{
	private char[][] game = new char [3][3];
	private boolean checkTurn = true; //x turn
	public static void main(String[] args) {
		Application.launch(args);
	}
	public void start(Stage primaryStage){
		Pane pane = new Pane();
		Text t = new Text();
		t.setFont(Font.font(70));
		t.setX(90);
		t.setY(230);
		VBox bp = new VBox();
		Button b = new Button("Start Game");
		Text wel = new Text("Welcome to XO Game");
		wel.setFont(Font.font("Algerian",FontWeight.BLACK,FontPosture.ITALIC,50));
		ImageView tic = new ImageView("images/2000px-Tic_tac_toe.svg.png");
		tic.setFitHeight(300);
		tic.setFitWidth(300);
		bp.setAlignment(Pos.CENTER);
		bp.setLayoutX(40);
		bp.setLayoutY(20);
		bp.setSpacing(70);
		b.setScaleX(2);
		b.setScaleY(2);
		bp.getChildren().addAll(wel,tic,b);
		pane.getChildren().add(bp);
		pane.setOnMousePressed(null);
		b.setOnAction(e->{
			bp.setVisible(false);
			gameBody(pane);
			play(pane,t);
		});
		pane.setStyle("-fx-background-color:DarkSlateGray");
		Scene scene = new Scene(pane,590,590);
		primaryStage.setResizable(false);
		primaryStage.setTitle("XO Game");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
private void gameBody(Pane pane){
		for(int i=0;i<3;i++){
			for(int j=1;j<=2;j++){
				pane.getChildren().addAll(new Line(j*200,0,j*200,600),new Line(0,j*200,600,j*200));
			}
		}
	}
int x=10,y=0;

private void play(Pane pane,Text t){	
		pane.setOnMousePressed((MouseEvent e)->{
			if(checkTurn){
			y=x;
			checkPosition(e,new Text("X"),pane);
			if(y!=x)
				checkTurn = false;
			}
			else{
			y=x;
			 checkPosition(e,new Text("O"),pane);
			 if(y!=x)
				 checkTurn = true;
			}
			if(checkWin()=='a' && isFill()){
				t.setText("NO ONE WON");
				pane.getChildren().add(t);
				pane.setOnMousePressed(null);
			}
			else if(checkWin()!='a'){
				if(checkWin()=='X')
					t.setFill(Color.DARKRED);
				else
					t.setFill(Color.DARKBLUE);
				
					t.setText("Player " + checkWin() + " Won");
					ImageView cel = new ImageView("images/240_F_133080263_bYBEgnI4ycTfMFvIa0uLXffNWsyBUTUv.jpg");
					VBox bp = new VBox();
					bp.setAlignment(Pos.CENTER);
					bp.setLayoutX(100);
					bp.setLayoutY(20);
					bp.setSpacing(70);
					bp.getChildren().addAll(t,cel);
					cel.setFitHeight(300);
					cel.setFitWidth(300);
					Pane pane1 = new Pane();
					pane1.getChildren().add(bp);
					pane1.setStyle("-fx-background-color:white");
					Scene scene1 = new Scene(pane1,570,450);
					Stage stage2 = new Stage();
					stage2.setResizable(false);
					stage2.setTitle("Winner");
					stage2.setScene(scene1);
					stage2.show();
					pane.setOnMousePressed(null);
			}
			
		});
	}
private void checkPosition(MouseEvent e,Text t1,Pane pane){
		t1.setFont(Font.font("Matura MT Script Capitals",FontWeight.BLACK,FontPosture.ITALIC,100));
		if(t1.getText()=="O")
			t1.setFill(Color.DARKBLUE);
		else
			t1.setFill(Color.DARKRED);
		if(e.isPrimaryButtonDown()){
			if(e.getY()<200){
				if(e.getX()<200 && game[0][0] =='\u0000'){
					t1.setX(40); 
					game[0][0] = t1.getText().charAt(0);
					x=1;
				}	
				else if(e.getX()>200 && e.getX()<400 && game[0][1]== '\u0000'){
					t1.setX(240); 
					game[0][1] = t1.getText().charAt(0);
					x=2;
				}
				else if (e.getX()>400 && game[0][2]== '\u0000'){
					t1.setX(440);
					game[0][2] = t1.getText().charAt(0);
					x=3;
				}
				else
					t1.setText("");
				
				t1.setY(150); 
			}
			else if(e.getY()>200 && e.getY()<400){
				if(e.getX()<200 && game[1][0]== '\u0000'){
					t1.setX(40); 
					game[1][0] = t1.getText().charAt(0);
					x=4;
				}
					else if(e.getX()>200 && e.getX()<400 &&game[1][1]== '\u0000'){
						t1.setX(240); 
						game[1][1] = t1.getText().charAt(0);
						x=5;
					}
					else if (e.getX()>400 && game[1][2]== '\u0000'){
						t1.setX(440);
						game[1][2] = t1.getText().charAt(0);
						x=6;
					}
					else
						t1.setText("");
					t1.setY(350); 
			}
			else{
				if(e.getX()<200 && game[2][0]== '\u0000'){
					t1.setX(40); 
					game[2][0] = t1.getText().charAt(0);
					x=7;
				}
					else if(e.getX()>200 && e.getX()<400 && game[2][1]== '\u0000'){
						t1.setX(240); 
						game[2][1] = t1.getText().charAt(0);
						x=8;
					}
					else if (e.getX()>400 && game[2][2]== '\u0000'){
						t1.setX(440);
						game[2][2] = t1.getText().charAt(0);
						x=9;
					}
					else
						t1.setText("");
					t1.setY(550); 
			}
			pane.getChildren().add(t1);
		}
	}
private char checkWin(){
	for(int i=0;i<3;i++){
			if(game[i][0]==(game [i][1]) && game[i][0] == game [i][2] && game[i][0]!='\u0000')
					return game[i][0];
			
			else if(game[0][i]==(game [1][i]) && game[0][i] == game [2][i] && game[0][i]!='\u0000')
				return game[0][i];
			
			if(game[0][0]==(game [1][1]) && game[0][0] == game [2][2] && game[0][0]!='\u0000')
				return game[0][0];
			
			else if(game[0][2]==(game [1][1]) && game[0][2] == game [2][0] && game[0][2]!='\u0000')
				return game[0][2];
	}
	return 'a';	

}
private boolean isFill(){
	for(int i=0;i<3;i++){
		for(int j=0;j<3;j++){
			if(game[i][j]=='\u0000')
				return false;
		}	
	}
	return true;
}
}
