/*
MorraPart2Play.java
Group F
03 4 2020
*/

import javax.swing.*;//bring in JOptionPane
public class MorraPart2Play{

	//variable
		String side;//input - choose side
		int userNumber;//input - choose number
		int randNumber;//process - random number generated
		int sumPMarks;//process - sum of players marks
		int sumCMarks;//process - sum of players marks
		String replay; //input to play again
		String message;//output
		String winnerMessage;//output

		//objects
		MorraPart2 myMorraPart2=new MorraPart2();

			public int play(){
				//the game will run until the user decides to stop
				do{
					//ask the user if they want to choose even, odd or stop
					side=JOptionPane.showInputDialog(null, "To play the game, please choose between Even or Odd.\n\nType stop to end the game: \n\n");
						if(!side.equalsIgnoreCase("stop") && sumCMarks<12 && sumPMarks<12){//check the user decision and play the game
							if(side.equalsIgnoreCase("even") || side.equalsIgnoreCase("odd")){
								myMorraPart2.setSide(side);
								runGame();
							}
							else{// if the user doesn't enter a valid number the game repeats
								JOptionPane.showMessageDialog(null, "Invalid value, start again.");
							}
					}
				}
				while(!side.equalsIgnoreCase("stop") && sumCMarks<12 && sumPMarks<12);//condition to stop the game at any time
				winnerMessage=myMorraPart2.getWinnerMessage();
				winnerMessage +="\n";
				winnerMessage +=myMorraPart2.getHist();
				JOptionPane.showMessageDialog(null, winnerMessage);
				replay=JOptionPane.showInputDialog("Do you want to play again?");
				myMorraPart2.setReplay(replay);
				if(enterReplay(replay)){//resets the scores and replays the game if user chooses to play again
					side="";//input
					message="";//output
					userNumber=0;//input
					sumPMarks=0;
					sumCMarks=0;
					randNumber=0;
					replay="";
					winnerMessage="";
					myMorraPart2.reset();
					return 0; // replays the game
				}else{
					myMorraPart2.finalHist();//show history of games if user rejects
					JOptionPane.showMessageDialog(null,"Thank you!");
					return 1;
				}
			}

			//function to validate the user input (yes or no) at the end of each game
			private boolean enterReplay(String replay) {

				while(true){
					//if input is anything different than Yes or No continue loop until otherwise
					if(replay.equalsIgnoreCase("yes") || replay.equalsIgnoreCase("no")){
						break;
					}
					//ask to insert the value again
					replay=JOptionPane.showInputDialog("Invalid value. Please enter Yes or No!");
				}

				if(replay.equalsIgnoreCase("yes")){
					//if input is Yes
					return true;
				}else{
					//if input is No
					return false;
				}
			}

			public void runGame(){
				try{
				userNumber=Integer.parseInt(JOptionPane.showInputDialog(null, "Please, choose between 1 to 10: "));
					if(userNumber>=1 && userNumber<=10){//ensure number is between 1 and 10
						myMorraPart2.setUserNumber(userNumber);

						//process
						myMorraPart2.compute();

						//output
						message=myMorraPart2.getMessage();
						randNumber=myMorraPart2.getRandNumber();
						sumPMarks=myMorraPart2.getSumPMarks();
						sumCMarks=myMorraPart2.getSumCMarks();
						JOptionPane.showMessageDialog(null, message);
						JOptionPane.showMessageDialog(null,"The computer chose: "+randNumber+"\n\nThis round result:"+"\nPlayer: "+sumPMarks+ "   Computer: "+sumCMarks); //have to show what the computer chose
						}
					else{
						JOptionPane.showMessageDialog(null, "Invalid value, start again.");
						runGame();
					}
				}
				catch(NumberFormatException e){//catches strings when it should be an int input
					JOptionPane.showMessageDialog(null, "Invalid value, start again.");
					runGame();
				}
			}
}

