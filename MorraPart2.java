/*
MorraPart2.java
Group F
20 3 2020
*/

import java.util.*; //brought in for math function
import javax.swing.*; //brought in for JOptionPane
public class MorraPart2{

	//data members
	private String side;//input - ask Player odd or even
	private int userNumber;//input - asks which number Player is choosing
	private String replay; //input - asks if the Player wants to play again
	private Random rand;//process - random function used for Computer to pick a random number
	private int randNumber;//process - int to hold the random number
	private int cRMarks;//process - how many points Computer wins
	private int pRMarks;//process - how many points Player wins
	private int sumRound;//process - sum of both the Computer and Players choice
	private int sumCMarks;//process&output - sum of all Computers points
	private int sumPMarks;//process&output - sum of all Players points
	private final int EXTPOINTS;//CONSTANT int for 2 extra points
	private int indexC;//process - stores number of rows in array
	private int won;//process - total Win Player
	private int lost;//process - total Lost Player
	private int evenP;//process - how many times Player chose even
	private int oddP;//process - how many times Player chose odd
	private int evenC;//process - how many times Computer chose even
	private int oddC;//process - how many times Computer chose odd
	private int totalPExtra;//process - total points extra per game Player
	private int totalCExtra;//process - total points extra per game Comp
	private int gameCounter;//process Number of games played
	private int con; // CONTROL VARIABLE to keep track of END of GAME (STOP GAME)
	private int c0; //columns of the Arrays
	private int c1;
	private int c2;
	private int c3;
	private int[][] arrHist = new int[10][2]; //process history of games array
	List<Integer> arrRndWList = new ArrayList<>();//process Number of rounds Won
	List<Integer> arrRndLList = new ArrayList<>();//process Number of rounds Lost
	List<Integer> arrOddPList = new ArrayList<>();//process - Number of Odd numbers by Player
	List<Integer> arrEvenPList = new ArrayList<>();//process - Number of Even numbers by Player
	List<Integer> arrOddCList = new ArrayList<>();//process - Number of Odd numbers by Computer
	List<Integer> arrEvenCList = new ArrayList<>();//process - Number of Even numbers by Computer
	List<Integer> arrPExtra = new ArrayList<>();//process - amount of Extra Points for Player
	List<Integer> arrCExtra = new ArrayList<>();//process - amount of Extra Points for Computer
	private String message;//output - prints message out to user
	private String winnerMessage; //output


	//constructor - initialises the variables
	public MorraPart2(){
		side="";
		userNumber=0;
		replay="";
		rand=new Random();
		randNumber=0;
		sumRound=0;
		cRMarks=0;
		pRMarks=0;
		sumCMarks=0;
		sumPMarks=0;
		EXTPOINTS=2;
	   	indexC=0;
	   	won=0;
	  	lost=0;
	    evenP=0;
		oddP=0;
		evenC=0;
		oddC=0;
		totalPExtra=0;
		totalCExtra=0;
		gameCounter=0;
		con=0;
		c0=0;
		c1=1;
		c2=2;
		c3=3;
		message="";
		winnerMessage="";
	}
	//setter - variables that will needed to be input by the user.
	public void setSide(String side){
		this.side=side;
	}
	public void setUserNumber(int userNumber){
		this.userNumber=userNumber;
	}
	public void setReplay(String replay){
	this.replay=replay;
	}

	//process
	public void compute(){
		randNumber=rand.nextInt(10-1)+1;//creating random number generator
		sumRound=userNumber+randNumber;


		//if statement to check if Player Chose "EVEN"
		if(side.equalsIgnoreCase("even") && sumRound%2==0){

			//Player Won! Send 1 to computePoints
			computePoints(1);

		} else if(side.equalsIgnoreCase("even") && sumRound%2!=0){

			//Player Lost! Send 0 to computePoints
			computePoints(0);
		}

		//if statement to check if Player Chose "ODD"
		if(side.equalsIgnoreCase("odd") && sumRound%2!=0){

			//Player Won! Send 1 to computePoints
			computePoints(1);

		} else if(side.equalsIgnoreCase("odd") && sumRound%2==0){

			//Player Lost! Send 0 to computePoints
			computePoints(0);
		}
		//adding sum of points for Player and Computer
		sumPMarks=sumPMarks+pRMarks;
		sumCMarks=sumCMarks+cRMarks;

		//calling history array
		getHistory(userNumber, randNumber, indexC);
		indexC++;

		// if statement to declare the winner and their scores
		if(sumPMarks>=12){
			winnerMessage="Player wins the Game with "+sumPMarks+" points"+"\nComputer loses the Game with "+sumCMarks+" points\n";
		}
		else if(sumCMarks>=12){
			winnerMessage="Computer wins the Game with "+sumCMarks+" points"+"\n\nPlayer loses the Game with "+sumPMarks+" points\n";
		}
	}
	//resets the scores to 0 when the game is replayed
	public void reset(){
		sumPMarks=0;
		sumCMarks=0;
		indexC=0;
		won=0;
		lost=0;
		evenP=0;
		oddP=0;
		evenC=0;
		oddC=0;
		totalPExtra=0;
		totalCExtra=0;
	}

	//holds result for history array
	public void computePoints(int result){

		if(result == 1){
			//bigger the number, the closer to the sum i.e win extra points
			if(userNumber>randNumber){
				message="You win 5 points!";
				won++;
				pRMarks=3+EXTPOINTS;
				cRMarks=0;
				totalPExtra+=2;
			} else if(randNumber>userNumber){
				message="You win 3 points!";
				won++;
				pRMarks=3;
				cRMarks=EXTPOINTS;
				totalCExtra+=2;
			} else{
				message="You win 3 points!";
				won++;
				pRMarks=3;
				cRMarks=0;
			}

		} else{

			if(randNumber>userNumber){
				message="Computer wins 5 points!";
				lost++;
				cRMarks=3+EXTPOINTS;
				pRMarks=0;
				totalCExtra+=2;
			} else if(userNumber>randNumber){
				message="Computer wins 3 points!";
				lost++;
				cRMarks=3;
				pRMarks=EXTPOINTS;
				totalPExtra+=2;
			} else{
				message="Computer wins 3 points!";
				lost++;
				cRMarks=3;
				pRMarks=0;
			}
		}
	}

	//history array
	public void getHistory(int player, int comp, int indexC){
		int i=0;
		arrHist[indexC][i]=player;
		i++;
		arrHist[indexC][i]=comp;

		if(player % 2 == 0){
			evenP++;
		} else{
			oddP++;
		}

		if (comp % 2 == 0){
			evenC++;
		} else{
			oddC++;
		}
	}

	public String displayHist(int arrHist[][], int round){
		String output="";
		for(int x=0; x<round; x++){
			for(int j= 0; j<2; j++){
				if(j==0){
		    		output += "Round "+ (x+1) + ": Player "+ Integer.toString(arrHist[x][j]) +" -";
				} else{
					output += " Comp ";
					output += Integer.toString(arrHist[x][j]);
				}
		    }
		    output += "\n";
		}
		//List array to keep track of data per round
		/*List arrays were used at this point since we don't know
		how many Round/Games will be played therefore we can initialize
		an array with a precise size*/
		arrRndWList.add(won);
		arrRndLList.add(lost);
		arrOddPList.add(oddP);
		arrEvenPList.add(evenP);
		arrOddCList.add(oddC);
		arrEvenCList.add(evenC);
		arrPExtra.add(totalPExtra);
		arrCExtra.add(totalCExtra);
		gameCounter++;
	    output += "\n";
		return output;
	}

	public void finalHist(){

		String finalHistLog="";

		/*Array containing the result of Rounds won/lost Per Game.
		Column: 0 Player won, 1 Player lost*/
		int[][] arrHistResult = new int[gameCounter][2];//output

		/*Array containing the number of odds and even numbers chosen by Player/Comp Per Game.
		Column: 0 PlayEven, 1 PlayOdd, 2 CompEven, 3 CompOdd*/
		int[][] arrHistOE = new int[gameCounter][4];//output

		/*Array containing the number of Extra Points received by Player/Comp Per Game.
		Column: 0 Player, 1 Comp*/
		int[][] arrHistEXTPOINTS = new int[gameCounter][2];//output

		//Index for List Arrays
		int ind = 0;

		//For loop to populate arrHist arrays with data from List Arrays
		for(int i=0; i < gameCounter; i++){

			int j=0;

			arrHistResult[i][j]=arrRndWList.get(ind);
			arrHistOE[i][j]=arrEvenPList.get(ind);
			arrHistEXTPOINTS[i][j]=arrPExtra.get(ind);

			j++;
			arrHistResult[i][j]=arrRndLList.get(ind);
			arrHistOE[i][j]=arrOddPList.get(ind);
			arrHistEXTPOINTS[i][j]=arrCExtra.get(ind);

			j++;
			arrHistOE[i][j]=arrEvenCList.get(ind);

			j++;
			arrHistOE[i][j]=arrOddCList.get(ind);

			ind++;

		}

		//for loop to append finalHistLog String with data from arrHist
		finalHistLog += "History of Games\n\n";
		for(int i=0; i<gameCounter; i++){

			finalHistLog += "Game " + (i+1) + "\n";

			finalHistLog += "Player Rounds: Won " + arrHistResult[i][c0] + " - Lost " + arrHistResult[i][c1] + "\n";
			finalHistLog += "Extra Points: Player " + arrHistEXTPOINTS[i][c0] + " - Comp " + arrHistEXTPOINTS[i][c1] + "\n";
			finalHistLog += "Number of Even numbers played by: Player " + arrHistOE[i][c0] + " - Comp "+arrHistOE[i][c2] + "\n";
			finalHistLog += "Number of Odd numbers played by: Player " + arrHistOE[i][c1] +" - Comp "+arrHistOE[i][c3]+"\n\n";

		}

		JOptionPane.showMessageDialog(null, finalHistLog);
	}


	//getter
	public String getMessage(){
		return message;
	}
	public String getWinnerMessage(){
		return winnerMessage;
	}
	public int getSumPMarks(){
		return sumPMarks;
	}
	public int getSumCMarks(){
		return sumCMarks;
	}
	public int getRandNumber(){
	return randNumber;
	}
	public String getHist(){
		return displayHist(arrHist, indexC);
	}
	public int getCon(){
		return con;
	}
}
