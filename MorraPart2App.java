/*
MorraPart2App.java
Group F
20 3 2020
*/

import javax.swing.*;
public class MorraPart2App{
	public static void main(String args[]){

		//variable
		String side;//input
		String message;//output
		int userNumber;//input
		int sumPMarks=0;
		int sumCMarks=0;
		int randNumber=0;
		String replay; //added to play again
		String winnerMessage;

		//objects
		MorraPart2 myMorraPart2;
		myMorraPart2=new MorraPart2();

		do{
			//inputs
			side=JOptionPane.showInputDialog(null, "To play the game, please choose between Even or Odd.\n\nType stop to end the game: ");
				if(!side.equalsIgnoreCase("stop") && sumCMarks<12 && sumPMarks<12){
					if(side.equalsIgnoreCase("even") || side.equalsIgnoreCase("odd")){
						myMorraPart2.setSide(side);
						userNumber=Integer.parseInt(JOptionPane.showInputDialog(null, "Please, choose between 1 to 10: "));
						if(userNumber>=1 && userNumber<=10){
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
						else{
							JOptionPane.showMessageDialog(null, "Ivalid value, start again.");
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Invalid value, start again.");
					}
			}
		}
		while(!side.equalsIgnoreCase("stop") && sumCMarks<12 && sumPMarks<12);
		winnerMessage=myMorraPart2.getWinnerMessage();
		JOptionPane.showMessageDialog(null, winnerMessage);
		replay=JOptionPane.showInputDialog("Do you want to play again?");
		myMorraPart2.setReplay(replay);
		if(replay.equalsIgnoreCase("yes")){
		main(args); // replays the game
		}
		else{
			JOptionPane.showMessageDialog(null,"Thank you!");
		}

	}
}
