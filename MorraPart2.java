/*
MorraPart2.java
Group F
20 3 2020
*/

import java.util.*;
import javax.swing.*;
public class MorraPart2{

	//members data
	private Random rand;//process
	private int randNumber;//process
	private String side;//input
	private String message;//output
	private int userNumber;//input
	public int sumCMarks;//process&output
	public int sumPMarks;//process&output
	private int cRMarks;//process
	private int pRMarks;//process
	private int sumRound;//process
	private String replay; //input
	private String winnerMessage; //output
	public int[][] arrHist = new int[10][2]; // history array
	private int histlen;
	public int indexC;
	/*
	private final int CREXTRA;//process
	private final int PREXTRA;//process
	*/
	public int won;//output - total Win Player
	public int lost;//output - total Lost Player
	public int evenP;//output
	public int oddP;//output
	public int evenC;//output
	public int oddC;//output
	List<Integer> arrRndWList = new ArrayList<>();//outpout Number of rounds Won
	List<Integer> arrRndLList = new ArrayList<>();//outpout Number of rounds Lost
	List<Integer> arrOddPList = new ArrayList<>();//outpout
	List<Integer> arrEvenPList = new ArrayList<>();//outpout
	List<Integer> arrOddCList = new ArrayList<>();//outpout
	List<Integer> arrEvenCList = new ArrayList<>();//outpout
	public int totalPExtra;//outpout total points extra per game Player
	public int totalCExtra;//outpout total points extra per game Comp
	List<Integer> arrPExtra = new ArrayList<>();
	List<Integer> arrCExtra = new ArrayList<>();
	public int gameCounter = 0;//outpout Number of games played
	public int con; // CONTROL VARIABLE to keep track of END of GAME (STOP GAME)
	public int extPoints;

	//constructor
	public MorraPart2(){
		rand = new Random();
		sumRound=0;
		side="";
		message="";
		userNumber=0;
		cRMarks=0;
		pRMarks=0;
		sumCMarks=0;
		sumPMarks=0;
		replay="";
		winnerMessage="";
	   	indexC=0;
	   	histlen=0;
	    //PREXTRA=2;//Constant used for players extra points
	    extPoints=2;
	    won=0;
	    lost=0;
	    con=0;
	    evenP=0;
		oddP=0;
		evenC=0;
		oddC=0;
		totalPExtra=0;
		totalCExtra=0;
	}

	public void reset() {
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

	public void computePoints(int result) {

		if (result == 1) {

			if(userNumber>randNumber){
				message="You win 5 points!";
				won++;
				pRMarks=3+extPoints;
				cRMarks=0;
				totalPExtra+=2;
			} else if (randNumber>userNumber) {
				message="You win 3 points!";
				won++;
				pRMarks=3;
				cRMarks=extPoints;
				totalCExtra+=2;
			} else {
				message="You win 3 points!";
				won++;
				pRMarks=3;
				cRMarks=0;
			}

		} else {

			if(randNumber>userNumber) {
				message="Computer wins 5 points!";
				lost++;
				cRMarks=3+extPoints;
				pRMarks=0;
				totalCExtra+=2;
			} else if (userNumber>randNumber) {
				message="Computer wins 3 points!";
				lost++;
				cRMarks=3;
				pRMarks=extPoints;
				totalPExtra+=2;
			} else {
				message="Computer wins 3 points!";
				lost++;
				cRMarks=3;
				pRMarks=0;
			}
		}
	}

	//setter
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
		randNumber=rand.nextInt(10-1)+1;
		sumRound=userNumber+randNumber;


		//if statement to check if Player Chose "EVEN"
		if(side.equalsIgnoreCase("even") && sumRound%2==0){

			//Player Won! Send 1 to computePoints
			computePoints(1);

		} else if(side.equalsIgnoreCase("even") && sumRound%2!=0) {

			//Player Lost! Send 0 to computePoints
			computePoints(0);
		}

		//if statement to check if Player Chose "ODD"
		if(side.equalsIgnoreCase("odd") && sumRound%2!=0){

			//Player Won! Send 1 to computePoints
			computePoints(1);

		} else if(side.equalsIgnoreCase("odd") && sumRound%2==0) {

			//Player Lost! Send 0 to computePoints
			computePoints(0);
		}



		/*
		if(side.equalsIgnoreCase("even") && sumRound%2==0 && Math.abs(userNumber-sumRound)>Math.abs(randNumber-sumRound)){//user picked the closest number - user gets extra points
			message="You win 5 points!";
			won++;
			pRMarks=3+PREXTRA;
			cRMarks=0;
			totalPExtra+=2;
			}
		else if(side.equalsIgnoreCase("even") && sumRound%2==0 && Math.abs(randNumber-sumRound)>Math.abs(userNumber-sumRound)){//computer picked the closest number - computer gets extra points
			message="You win 3 points!";
			won++;
			pRMarks=3;
			cRMarks=CREXTRA;
			totalCExtra+=2;
			}
		else if(side.equalsIgnoreCase("odd") && sumRound%2!=0 && Math.abs(userNumber-sumRound)>Math.abs(randNumber-sumRound)){
			message="You win 5 points!";
			won++;
			pRMarks=3+PREXTRA;
			cRMarks=0;
			totalPExtra+=2;
			}
		else if(side.equalsIgnoreCase("odd") && sumRound%2!=0 && Math.abs(randNumber-sumRound)>Math.abs(userNumber-sumRound)){
			message="You win 3 points!";
			won++;
			pRMarks=3;
			cRMarks=CREXTRA;
			totalCExtra+=2;
			}
		else if(side.equalsIgnoreCase("odd") && sumRound%2!=0 && Math.abs(userNumber-sumRound)==Math.abs(randNumber-sumRound)){//both picked the same number - no extra points
			won++;
			message="You Win 3 points!";
			pRMarks=3;
			cRMarks=0;
			}
		else if(side.equalsIgnoreCase("even") && sumRound%2==0 && Math.abs(userNumber-sumRound)==Math.abs(randNumber-sumRound)){
			message="You Win 3 points!";
			won++;
			pRMarks=3;
			cRMarks=0;
			}
		else if(side.equalsIgnoreCase("even") && sumRound%2!=0 && Math.abs(randNumber-sumRound)>Math.abs(userNumber-sumRound)){
			message="Computer Win 5 points!";
			lost++;
			cRMarks=3+CREXTRA;
			pRMarks=0;
			totalCExtra+=2;
			}
		else if(side.equalsIgnoreCase("even") && sumRound%2!=0 && Math.abs(userNumber-sumRound)>Math.abs(randNumber-sumRound)){
			message="Computer Win 3 points!";
			lost++;
			cRMarks=3;
			pRMarks=PREXTRA;
			totalPExtra+=2;
			}
		else if(side.equalsIgnoreCase("odd") && sumRound%2==0 && Math.abs(randNumber-sumRound)>Math.abs(userNumber-sumRound)){
			message="Computer Win 5 points!";
			lost++;
			cRMarks=3+CREXTRA;
			pRMarks=0;
			totalCExtra+=2;
			}
		else if(side.equalsIgnoreCase("odd") && sumRound%2==0 && Math.abs(userNumber-sumRound)>Math.abs(randNumber-sumRound)){
			message="Computer Win 3 points!";
			lost++;
			cRMarks=3;
			pRMarks=PREXTRA;
			totalPExtra+=2;
			}
		else if(side.equalsIgnoreCase("odd") && sumRound%2!=0 && Math.abs(userNumber-sumRound)==Math.abs(randNumber-sumRound)){
			message="Computer Win 3 points!";
			lost++;
			cRMarks=3;
			pRMarks=0;
			}
		else if(side.equalsIgnoreCase("even") && sumRound%2==0 && Math.abs(userNumber-sumRound)==Math.abs(randNumber-sumRound)){
			message="Computer Win 3 points!";
			lost++;
			cRMarks=3;
			pRMarks=0;
			}
		    else{
				message="Invalid value, try again.";
			}
		*/

		sumPMarks=sumPMarks+pRMarks;
		sumCMarks=sumCMarks+cRMarks;

		//calling history array
		getHistory(userNumber, randNumber, indexC);
		indexC++;

		if(sumPMarks>=12){
			winnerMessage="Player wins the Game with "+sumPMarks+" points"+"\nComputer loses the Game with "+sumCMarks+" points\n";
		}
		else if(sumCMarks>=12){
			winnerMessage="Computer wins the Game with "+sumCMarks+" points"+"\n\nPlayer loses the Game with "+sumPMarks+" points\n";
		}
	}

	//history array
	public void getHistory(int player, int comp, int indexC) {
		int i = 0;
		arrHist[indexC][i]=player;
		i++;
		arrHist[indexC][i]=comp;

		if (player % 2 == 0) {
			evenP++;
		} else {
			oddP++;
		}

		if (comp % 2 == 0) {
			evenC++;
		} else {
			oddC++;
		}
	}

	public String displayHist(int arrHist[][], int round) {
		String output="";
		for (int x=0; x<round; x++) {
			for(int j= 0; j<2; j++) {
				if (j==0) {
		    		output += "Round "+ (x+1) + ": Player "+ Integer.toString(arrHist[x][j]) +" -";
				} else {
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

	public void finalHist() {

		String finalHistLog = "";

		/*Array containing the result of Rounds won/lost Per Game.
		Column: 0 Player won, 1 Player lost*/
		int[][] arrHistResult = new int[gameCounter][2];

		/*Array containing the number of odds and even numbers chosen by Player/Comp Per Game.
		Column: 0 PlayEven, 1 PlayOdd, 2 CompEven, 3 CompOdd*/
		int[][] arrHistOE = new int[gameCounter][4];

		/*Array containing the number of Extra Points received by Player/Comp Per Game.
		Column: 0 Player, 1 Comp*/
		int[][] arrHistExtPoints = new int[gameCounter][2];

		//Index for List Arrays
		int ind = 0;

		//For loop to populate arrHist arrays with data from List Arrays
		for(int i=0; i < gameCounter; i++) {

			int j = 0;

			arrHistResult[i][j]=arrRndWList.get(ind);
			arrHistOE[i][j]=arrEvenPList.get(ind);
			arrHistExtPoints[i][j]=arrPExtra.get(ind);

			j++;
			arrHistResult[i][j]=arrRndLList.get(ind);
			arrHistOE[i][j]=arrOddPList.get(ind);
			arrHistExtPoints[i][j]=arrCExtra.get(ind);

			j++;
			arrHistOE[i][j]=arrEvenCList.get(ind);

			j++;
			arrHistOE[i][j]=arrOddCList.get(ind);

			ind++;

		}

		//for loop to append finalHistLog String with data from arrHist
		finalHistLog += "History of Games\n\n";
		for(int i=0; i<gameCounter; i++) {

			int c0 = 0;
			int c1 = 1;
			int c2 = 2;
			int c3 = 3;

			finalHistLog += "Game " + (i+1) + "\n";

			finalHistLog += "Player Rounds: Won " + arrHistResult[i][c0] + " - Lost " + arrHistResult[i][c1] + "\n";
			finalHistLog += "Extra Points: Player " + arrHistExtPoints[i][c0] + " - Comp " + arrHistExtPoints[i][c1] + "\n";
			finalHistLog += "Number of Even numbers played by: Player " + arrHistOE[i][c0] + " - Comp "+arrHistOE[i][c2] + "\n";
			finalHistLog += "Number of Odd numbers played by: Player " + arrHistOE[i][c1] +" - Comp "+arrHistOE[i][c3]+"\n\n";

		}

		JOptionPane.showMessageDialog(null, finalHistLog);
	}


	//getter
	public String getMessage(){
		return message;
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
	public String getWinnerMessage(){
		return winnerMessage;
	}
	public String getHist(){
		return displayHist(arrHist, indexC);
	}
	public int getCon(){
		return con;
	}
}
