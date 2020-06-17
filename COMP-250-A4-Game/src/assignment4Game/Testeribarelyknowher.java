
package assignment4Game;

import java.io.*;

public class Testeribarelyknowher {

	public static void main(String[] args) {
		
		System.out.println("***assuming addDisk works***");
		
		// TEST CANWININTWOTURNS
		
		Configuration d = new Configuration();
		d.board[0][0] = 2; d.board[1][0] = 1; d.board[2][0] = 2; d.board[2][1] = 1; d.board[2][2] = 2;
		d.board[3][0] = 2; d.board[4][0] = 1; d.board[4][1] = 1; d.board[4][2] = 2; d.board[4][3] = 1;
		d.board[5][0] = 2; d.board[5][1] = 1; d.board[6][0] = 2;
		d.available[0] = 1; d.available[1] = 1; d.available[2] = 3; d.available[3] = 1; d.available[4] = 4;
		d.available[5] = 2; d.available[6] = 1;  
		System.out.println("1");
		d.print();
		System.out.println(d.canWinNextRound(1) + " should be 3");
		System.out.println(d.canWinTwoTurns(1) + " should be 0");
		System.out.println("2");
		d.print();
		System.out.println();
		
		
		d.board[2][3] = 1; d.board[5][2] = 2; d.board[0][1] = 1; d.board[0][2] = 2; d.board[6][1] = 1;
//		d.print();
		d.available[0] = 3; d.available[1] = 1; d.available[2] = 4; d.available[3] = 1; d.available[4] = 4;
		d.available[5] = 3; d.available[6] = 2;
//		d.print();
		System.out.println();
//		System.out.println(d.canWinTwoTurns(2) + " should be -1");
//		d.board[4][3] = 0; d.available[4] = 3;
//		System.out.println(d.canWinTwoTurns(2));
//		d.print();
		System.out.println(d.canWinTwoTurns(2) + " should be -1");
		
//		System.out.println(d.canWinNextRound(1) + " should be 3");
//		System.out.println(d.canWinNextRound(2) + " should be 3");
//		System.out.println(d.canWinTwoTurns(1) + d.canWinTwoTurns(2) + " should be 0");
		
	}

}

