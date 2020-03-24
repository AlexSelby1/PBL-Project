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
		String replay; //added to play again

		//objects
		MorraPart2 myMorraPart2;
		myMorraPart2=new MorraPart2();

		do{
			//inputs
			side=JOptionPane.showInputDialog(null, "To play the game, please choose between Even or Odd. Type stop to end the game: ");
				if(!side.equals("stop") && sumCMarks<12 && sumPMarks<12){
					myMorraPart2.setSide(side);
					userNumber=Integer.parseInt(JOptionPane.showInputDialog(null, "Please, choose between 1 to 10: "));
					myMorraPart2.setUserNumber(userNumber);

					//process
					myMorraPart2.compute();

					//output
					message=myMorraPart2.getMessage();
					randNumber=myMorraPart2.getRandNumber();
					sumPMarks=myMorraPart2.getSumPMarks();
					sumCMarks=myMorraPart2.getSumCMarks();
					JOptionPane.showMessageDialog(null, message);
					JOptionPane.showMessageDialog(null," The computer chose "+randNumber); //have to show what the computer chose
					JOptionPane.showMessageDialog(null, "The atual result is Player: "+sumPMarks+" and the Computer: "+sumCMarks+".");
			}
		}
		while(!side.equals("stop") && sumCMarks<12 && sumPMarks<12);
		JOptionPane.showMessageDialog(null, "The final result is Player: "+sumPMarks+" and Computer: "+sumCMarks+".");
				replay=JOptionPane.showInputDialog("Do you want to play again?");
		myMorraPart2.setReplay(replay);
			if(replay.equalsIgnoreCase("yes")){
			main(args); // replays the game
		} else{
			JOptionPane.showMessageDialog(null,"Thank you");
		}

	}
}