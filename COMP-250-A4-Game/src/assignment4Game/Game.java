// Name: Arab Farouk
// ID: 260806502


package assignment4Game;

import java.io.*;

public class Game {
	
	public static int play(InputStreamReader input){
		BufferedReader keyboard = new BufferedReader(input);
		Configuration c = new Configuration();
		int columnPlayed = 3; int player;
		
		// first move for player 1 (played by computer) : in the middle of the grid
		
		c.addDisk(firstMovePlayer1(), 1);
		int nbTurn = 1;
		
		while (nbTurn < 42){ // maximum of turns allowed by the size of the grid
			player = nbTurn %2 + 1;
			if (player == 2){
				columnPlayed = getNextMove(keyboard, c, 2);
			}
			if (player == 1){
				columnPlayed = movePlayer1(columnPlayed, c);
				
			}
			
			System.out.println(columnPlayed);
			
			c.addDisk(columnPlayed, player);
			
			if (c.isWinning(columnPlayed, player)){
				c.print();
				System.out.println("Congrats to player " + player + " !");
				return(player);
			}
			nbTurn++;
		}
		return -1;
	}
	
	public static int getNextMove(BufferedReader keyboard, Configuration c, int player){
		// ADD YOUR CODE HERE
		
		
		String inputPlayer;
		int inputPlayerToInteger=0;
		c.print();
		System.out.println("player "+player + " : wich column  do you want to add the disk : ");
		
		try {
			
			inputPlayer = keyboard.readLine(); 
	try {	
			// convert the input player to integer
			inputPlayerToInteger=Integer.parseInt(inputPlayer);	
	}
	// if the input player is ohther than an integer its catch the execption
	catch(NumberFormatException e) {
		inputPlayerToInteger=-1;
	}

	
			
		//while  the input player (column) is not between 0 and 6 or the column that he want to play into is full 
		// it will ask again to enter an input
	while ( inputPlayerToInteger >6 ||  inputPlayerToInteger<0 || c.available[inputPlayerToInteger] >=6 ) {
		System.out.println("player "+player + " : wich column  do you want to add the disk : ");
				
		inputPlayer = keyboard.readLine(); 
		try {		
			inputPlayerToInteger=Integer.parseInt(inputPlayer);	
		}
		// catch the exception if the other input after we ask him again is not an integer between 0 and 6 	
		catch(NumberFormatException e) {
			inputPlayerToInteger=-1;
		}
	}
		
			//if (c.available[inputPlayerToInteger]<6)	
			//c.addDisk(inputPlayerToInteger, player);
			
			
		}
		catch (IOException e) {
		    System.err.println("Caught IOException: " + e.getMessage());
		    System.out.println("wrong Input");
		}
		
		return inputPlayerToInteger ; // DON'T FORGET TO CHANGE THE RETURN
	}
	
	public static int firstMovePlayer1 (){
		return 3;
	}
	
	public static int movePlayer1 (int columnPlayed2, Configuration c){
		// ADD YOUR CODE HERE

  
		// if the column played by the user is between 0 and 6 inclusive then we enter in the if 	
	if (columnPlayed2 >-1 && columnPlayed2<7) {		
	
		// if the computer can win next round return the winning column
		if (c.canWinNextRound(1)>-1) {
			//c.addDisk(column, 1);
			return c.canWinNextRound(1);
		}
		
		
	
		// if the computer can win in 2 round return the winning column
			if (c.canWinTwoTurns(1) > -1) {
				return c.canWinTwoTurns(1);
				//c.addDisk(column, 1);
				
			}
		
		
		
	// if there is still place in the column after that the user played
		if (c.available[columnPlayed2]<6) {
			//c.addDisk(columnPlayed2, 1);
			
			return columnPlayed2;
		} 
		// check the valid column that the computer can play depending of the algorithm asked
		for (int i=1; i<7; i++) {
			 
			if (columnPlayed2-i >-1 &&c.available[columnPlayed2-i]<6) {
				return columnPlayed2-i;
				}
			if (columnPlayed2+i<7 && c.available[columnPlayed2+i]<6) {
				return columnPlayed2+i;
			}
			
		}
			
			
	}	
			
			return -1; // DON'T FORGET TO CHANGE THE RETURN
	}
	
	
}
