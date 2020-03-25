/*
MorraPart2.java
Group F
20 3 2020
*/

import java.util.*;
public class MorraPart2{

	//members data
	private Random rand;//process
	private int randNumber;//process
	private String side;//input
	private String message;//output
	private int userNumber;//input
	private int sumCMarks;//process&output
	private int sumPMarks;//process&output
	private int cRMarks;//process
	private int pRMarks;//process
	private int sumRound;//process
	private String replay; //input

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
		if(side.equalsIgnoreCase("even") && sumRound%2==0 && Math.abs(userNumber-sumRound)<Math.abs(randNumber-sumRound)){//user picked the closest number - user gets extra points
			message="You win!";
			pRMarks=5;
			cRMarks=0;
			}
		else if(side.equalsIgnoreCase("even") && sumRound%2==0 && Math.abs(randNumber-sumRound)<Math.abs(userNumber-sumRound)){//computer picked the closest number - computer gets extra points
			message="You win!";
			pRMarks=3;
			cRMarks=2;
			}
		else if(side.equalsIgnoreCase("odd") && sumRound%2!=0 && Math.abs(userNumber-sumRound)<Math.abs(randNumber-sumRound)){
			message="You win!";
			pRMarks=5;
			cRMarks=0;
			}
		else if(side.equalsIgnoreCase("odd") && sumRound%2!=0 && Math.abs(randNumber-sumRound)<Math.abs(userNumber-sumRound)){
			message="You win!";
			pRMarks=3;
			cRMarks=2;
			}
		else if(side.equalsIgnoreCase("odd") && sumRound%2!=0 && Math.abs(userNumber-sumRound)==Math.abs(randNumber-sumRound)){//both picked the same number - no extra points
			message="You Win!";
			pRMarks=3;
			cRMarks=0;
			}
		else if(side.equalsIgnoreCase("even") && sumRound%2==0 && Math.abs(userNumber-sumRound)==Math.abs(randNumber-sumRound)){
			message="You Win!";
			pRMarks=3;
			cRMarks=0;
			}
		else if(side.equalsIgnoreCase("even") && sumRound%2!=0 && Math.abs(randNumber-sumRound)<Math.abs(userNumber-sumRound)){
			message="Computer Win!";
			cRMarks=5;
			pRMarks=0;
			}
		else if(side.equalsIgnoreCase("even") && sumRound%2!=0 && Math.abs(userNumber-sumRound)<Math.abs(randNumber-sumRound)){
			message="Computer Win!";
			cRMarks=3;
			pRMarks=2;
			}
		else if(side.equalsIgnoreCase("odd") && sumRound%2==0 && Math.abs(randNumber-sumRound)<Math.abs(userNumber-sumRound)){
			message="Computer Win!";
			cRMarks=5;
			pRMarks=0;
			}
		else if(side.equalsIgnoreCase("odd") && sumRound%2==0 && Math.abs(userNumber-sumRound)<Math.abs(randNumber-sumRound)){
			message="Computer Win!";
			cRMarks=3;
			pRMarks=2;
			}
		else if(side.equalsIgnoreCase("odd") && sumRound%2!=0 && Math.abs(userNumber-sumRound)==Math.abs(randNumber-sumRound)){
			message="Computer Win!";
			cRMarks=3;
			pRMarks=0;
			}
		else if(side.equalsIgnoreCase("even") && sumRound%2==0 && Math.abs(userNumber-sumRound)==Math.abs(randNumber-sumRound)){
			message="Computer Win!";
			cRMarks=3;
			pRMarks=0;
			}
		    else{
				message="Invalid value, try again.";
			}
		sumPMarks=sumPMarks+pRMarks;
		sumCMarks=sumCMarks+cRMarks;
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













}
