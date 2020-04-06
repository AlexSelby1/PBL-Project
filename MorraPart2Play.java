/*
MorraPart2Play.java
Group F
03 4 2020
*/

import java.util.*;
import javax.swing.*;
public class MorraPart2Play{

	//variable
		String side;//input
		String message;//output
		int userNumber;//input
		int sumPMarks;
		int sumCMarks;
		int randNumber;
		String replay; //added to play again
		String winnerMessage;
		MorraPart2 myMorraPart2;

			public MorraPart2Play() {

				side="";//input
				message="";//output
				userNumber=0;//input
				sumPMarks=0;
				sumCMarks=0;
				randNumber=0;
				replay=""; //added to play again
				winnerMessage="";
				myMorraPart2=new MorraPart2();
			}

			public int play() {
				//the game will run until the user decides to stop
				do{
					//ask the user if they want to choose even, odd or stop
					side=JOptionPane.showInputDialog(null, "To play the game, please choose between Even or Odd.\n\nType stop to end the game: \n\n");
						if(!side.equalsIgnoreCase("stop") && sumCMarks<12 && sumPMarks<12){//check the user decision and play the game
							if(side.equalsIgnoreCase("even") || side.equalsIgnoreCase("odd")){
								myMorraPart2.setSide(side);//store the information in the varibale side on the inst class
								userNumber=Integer.parseInt(JOptionPane.showInputDialog(null, "Please, choose between 1 to 10: "));//ask the user for a number
								if(userNumber>=1 && userNumber<=10){//if the number meets the cretiria the games play
									myMorraPart2.setUserNumber(userNumber);

									//process
									myMorraPart2.compute();

									//output
									message=myMorraPart2.getMessage();
									randNumber=myMorraPart2.getRandNumber();
									sumPMarks=myMorraPart2.getSumPMarks();
									sumCMarks=myMorraPart2.getSumCMarks();
									JOptionPane.showMessageDialog(null, message);
									JOptionPane.showMessageDialog(null,"The computer chose: "+randNumber+"\n\nThis round result:"+"\nPlayer: "+sumPMarks+"\nComputer: "+sumCMarks); //have to show what the computer chose
								}
								else{//if the user doesn't enter a valid number the game repeates
									JOptionPane.showMessageDialog(null, "Ivalid value, start again.");
								}
							}
							else{// if the user doesn't enter a valid number the game repeates
								JOptionPane.showMessageDialog(null, "Invalid value, start again.");
							}
					}
			}while(!side.equalsIgnoreCase("stop") && sumCMarks<12 && sumPMarks<12);//condition to stop the game at any time
				winnerMessage=myMorraPart2.getWinnerMessage();
				winnerMessage += "\n";
				winnerMessage += myMorraPart2.getHist();
				JOptionPane.showMessageDialog(null, winnerMessage);
				replay=JOptionPane.showInputDialog("Do you want to play again?");
				myMorraPart2.setReplay(replay);
				if(replay.equalsIgnoreCase("yes")){
					side="";//input
					message="";//output
					userNumber=0;//input
					sumPMarks=0;
					sumCMarks=0;
					randNumber=0;
					replay=""; //added to play again
					winnerMessage="";
					myMorraPart2.reset();
					return 0; // replays the game
				}else{
					myMorraPart2.finalHist();
					JOptionPane.showMessageDialog(null,"Thank you!");
					return 1;
				}

			}

}
