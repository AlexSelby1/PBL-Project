/*
MorraPart2App.java
Group F
20 3 2020
*/

import javax.swing.*;
public class MorraPart2App{

	public static void main(String args[]){

		int con=0;

		//objects
		MorraPart2 myMorraPart2=new MorraPart2();
		MorraPart2Play myMorraPart2Play=new MorraPart2Play();

		//variable
		String replay= myMorraPart2Play.replay;
		String winnerMessage= myMorraPart2Play.winnerMessage;


		//Call Function play on Class MorraPart2Play to play the game
		while(con==0){
			con=myMorraPart2Play.play();
		}

	}
}
