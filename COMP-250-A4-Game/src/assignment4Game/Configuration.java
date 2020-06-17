// Name: Arab Farouk
// ID: 260806502

package assignment4Game;

public class Configuration {
	
	public int[][] board;
	public int[] available;
	boolean spaceLeft;
	
	public Configuration(){
		board = new int[7][6];
		available = new int[7];
		spaceLeft = true;
	}
	
	public void print(){
		System.out.println("| 0 | 1 | 2 | 3 | 4 | 5 | 6 |");
		System.out.println("+---+---+---+---+---+---+---+");
		for (int i = 0; i < 6; i++){
			System.out.print("|");
			for (int j = 0; j < 7; j++){
				if (board[j][5-i] == 0){
					System.out.print("   |");
				}
				else{
					System.out.print(" "+ board[j][5-i]+" |");
				}
			}
			System.out.println();
		}
	}
	
	public void addDisk (int index, int player){
		// ADD YOUR CODE HERE
		int counter = 0;
		
		if(this.available[index]<6) {
		this.board[index][this.available[index]]=player; // insert the disk in the good place
		this.available[index]++; // update the row 
		}
	}

	
	public boolean isWinning (int lastColumnPlayed, int player){
		// ADD YOUR CODE HERE
		
		
		// verticale counter
		int vCounter=0;
		// horizontale counter 
		int hCounter=0;
		// diagonal counter
		int increasingDCounter=0;
		int decreasingDCounter=0;
		// keep track of the last column played
		int currentLastColumnPlayed= lastColumnPlayed;
		int position= this.available[lastColumnPlayed]-1; //position of the last disk added

		
//		// for the verticale case 
//		for (int i = this.available[lastColumnPlayed]-1; i>this.available[lastColumnPlayed]-5; i--) {
//			if(i >= 0) {	
//			if (this.board[lastColumnPlayed][i]== player) {
//				vCounter++;
//			}
//			}	
//			else {
//				vCounter=0;
//				break;
//			}
//			
//		}
//	
//			
//		
//			if (vCounter ==4) {
//				return true;
//			}
		
		
		
		for(int i = 0; i < 6; i++) {
			if(i+1<6) {
				if(this.board[lastColumnPlayed][i] == player && this.board[lastColumnPlayed][i+1] == player) {
					vCounter++;
				}
			}
			if(i == 5 && vCounter == 3 && this.board[lastColumnPlayed][i] == player) {
				vCounter++;
			}
			
			if(i+1<6 && vCounter == 3 && this.board[lastColumnPlayed][i] == player && this.board[lastColumnPlayed][i+1] != player) {
				vCounter++;
			}
			
		}
		
		if(vCounter == 4) {
			return true;
		}

		
		
			
	// horizontale	case 
	for (int i=0; i<6; i++ ) {
		for (int j = 0; j<7; j++) {
			
			if (this.board[j][i]== player) {
				hCounter++;
			
				if(hCounter == 4) {
			break;	
			}
			
			} else {
				hCounter=0;
			}
		}
		if (hCounter==4) {
			break;
		}
		
	}
	
	
	if (hCounter== 4) {
		return true;
		}
	
	
	
	//increasing diagonal case. the last disk played is at the top
			if(this.board[lastColumnPlayed][position] == player && hCounter != 4 && vCounter != 4) {
				increasingDCounter++;
				if(0 <= position-1 && 0 <= lastColumnPlayed-1 && this.board[lastColumnPlayed-1][position-1] == player) {
					increasingDCounter++;
					
					if(0 <= position-2 && 0 <= lastColumnPlayed-2 && this.board[lastColumnPlayed-2][position-2] == player) {
						increasingDCounter++;
						
						if(0 <= position-3 && 0 <= lastColumnPlayed-3 && this.board[lastColumnPlayed-3][position-3] == player) {
							increasingDCounter++;
						}	
					}
				}
				if(increasingDCounter == 4) {
					return true;
				}
				if(increasingDCounter != 4) {
					increasingDCounter = 0;
				}
			}
			//increasing diagonal case. the last disk played is at the bottom
			if(this.board[lastColumnPlayed][position] == player && hCounter != 4 && vCounter != 4) {
				increasingDCounter++;

				if(position+1 < 6 && lastColumnPlayed+1 < 7 && this.board[lastColumnPlayed+1][position+1] == player) {
					increasingDCounter++;
					
					if(position+2 < 6 && lastColumnPlayed+2 < 7 && this.board[lastColumnPlayed+2][position+2] == player) {
						increasingDCounter++;
						
						if(position+3 < 6 && lastColumnPlayed+3 < 7 && this.board[lastColumnPlayed+3][position+3] == player) {
							increasingDCounter++;
						}	
					}
				}
				
				if(increasingDCounter == 4) {
					return true;
				}
				
				if(increasingDCounter != 4) {
					increasingDCounter = 0;
				}
			}
				
			
			//increasing diagonal case. the last disk added is at the second position from the top
			if(this.board[lastColumnPlayed][position] == player && hCounter != 4 && vCounter != 4) {
				increasingDCounter++;
				if(0 <= position-1 && 0 <= lastColumnPlayed-1 && this.board[lastColumnPlayed-1][position-1] == player) {
					increasingDCounter++;
					
					if(0 <= position-2 && 0 <= lastColumnPlayed-2 && this.board[lastColumnPlayed-2][position-2] == player) {
						increasingDCounter++;
						}
					
					if(position+1 < 6 && lastColumnPlayed+1 < 7 && this.board[lastColumnPlayed+1][position+1] == player) {
						increasingDCounter++;
					}
				}

				if(increasingDCounter == 4) {
					return true;
				}
				
				if(increasingDCounter != 4) {
					increasingDCounter = 0;
				}
				
			}
			
			
			//increasing diagonal case. the last disk added is at the third position from the top
			if(this.board[lastColumnPlayed][position] == player && hCounter != 4 && vCounter != 4) {
				increasingDCounter++;
				if(position+1 < 6 && lastColumnPlayed+1 < 7 && this.board[lastColumnPlayed+1][position+1] == player ) {
					increasingDCounter++;
					
					if(position+2 < 6 && lastColumnPlayed+2 < 7 && this.board[lastColumnPlayed+2][position+2] == player) {
						increasingDCounter++;
						}
					
					if(0 <= position-1 && 0 <= lastColumnPlayed-1 && this.board[lastColumnPlayed-1][position-1] == player) {
						increasingDCounter++;
					}
				}

				if(increasingDCounter == 4) {
					return true;
				}
				
				if(increasingDCounter != 4) {
					increasingDCounter = 0;
				}
				
			}
			
				
			//down diagonal case. The last disk played is at the bottom.
			if(this.board[lastColumnPlayed][position] == player && hCounter != 4 && vCounter != 4) {
				decreasingDCounter++;
				if(position+1 < 6 && lastColumnPlayed-1 >= 0 && this.board[lastColumnPlayed-1][position+1] == player) {
					decreasingDCounter++;
					
					if(position+2 < 6 && lastColumnPlayed-2 >= 0 && this.board[lastColumnPlayed-2][position+2] == player) {
						decreasingDCounter++;
						
						if(position+3 < 6 && lastColumnPlayed-3 >= 0 && this.board[lastColumnPlayed-3][position+3] == player) {
							decreasingDCounter++;
						}	
					}
				}

				if(decreasingDCounter == 4) {
					return true;
				}
				
				if(decreasingDCounter != 4) {
					decreasingDCounter = 0;
				}
				
			}

			
			//down diagonal case. The last disk played is at the second position from the top.
			if(this.board[lastColumnPlayed][position] == player && hCounter != 4 && vCounter != 4) {
				decreasingDCounter++;
				if(0 <= position-1 &&  lastColumnPlayed+1 < 7 && this.board[lastColumnPlayed+1][position-1] == player) {
					decreasingDCounter++;
					
					if(0 <= position-2 &&  lastColumnPlayed+2 < 7 && this.board[lastColumnPlayed+2][position-2] == player) {
						decreasingDCounter++;
						}
					
					if(position+1 < 6 && lastColumnPlayed-1 >= 0 && this.board[lastColumnPlayed-1][position+1] == player) {
						decreasingDCounter++;
					}
				}

				if(decreasingDCounter == 4) {
					return true;
				}
				
				if(decreasingDCounter!= 4) {
					decreasingDCounter = 0;
				}
				
			}
		
			//down diagonal case. The last disk played is at the third position from the top.
			if(this.board[lastColumnPlayed][position] == player && hCounter != 4 && vCounter != 4) {
				decreasingDCounter++;
				if(position+1 < 6 && lastColumnPlayed-1 >= 0 && this.board[lastColumnPlayed-1][position+1] == player) {
					decreasingDCounter++;
					
					if(position+2 < 6 && lastColumnPlayed-2 >= 0 && this.board[lastColumnPlayed-2][position+2] == player) {
						decreasingDCounter++;
						}
					
					if(0 <= position-1 &&  lastColumnPlayed+1 < 7 && this.board[lastColumnPlayed+1][position-1] == player) {
						decreasingDCounter++;
					}
					
				}

				if(decreasingDCounter == 4) {
					return true;
				}
				
				if(decreasingDCounter != 4) {
					decreasingDCounter = 0;
				}
				
			}
			
			//down diagonal case. The last disk played is at the top.
			if(this.board[lastColumnPlayed][position] == player && hCounter != 4 && vCounter != 4) {
				decreasingDCounter++;
				if(position-1 >= 0 && lastColumnPlayed+1 < 7 && this.board[lastColumnPlayed+1][position-1] == player) {
					decreasingDCounter++;
					
					if(position-2>=0 && lastColumnPlayed+2<7 && this.board[lastColumnPlayed+2][position-2] == player) {
						decreasingDCounter++;
						
						if(position-3 >=0 && lastColumnPlayed+3 <7 && this.board[lastColumnPlayed+3][position-3] == player) {
							decreasingDCounter++;
						}	
					}
				}

				if(decreasingDCounter == 4) {
					return true;
				}
				
				if(decreasingDCounter != 4) {
					decreasingDCounter = 0;
				}
				
			}
			
			return false; // DON'T FORGET TO CHANGE THE RETURN
				
		}
		

	

	public int canWinNextRound (int player){
		// ADD YOUR CODE HERE
		 int copyBoard[][]= new int [7][6];
		 int copyAvailaible[]= new int [7]; 
		
		 //copy f the board
		 for (int h=0; h<7; h++) {
			 for (int v=0;v<6;v++) {
				 copyBoard[h][v]=this.board[h][v];
			 }
		 }
		 
		 // copy of the available
		 for(int i=0; i<7; i++) {
			 copyAvailaible[i]= this.available[i];
		 }
		 
		 for (int column=0; column<7; column++) {
			
			 this.addDisk(column, player);

			 // after  adding a disk in column checks if isWinning
			 if (this.isWinning(column, player)== true) {
				
				
			// if is winning than turn the bord to original and break the loop by a return	 
				 for (int h=0; h<7; h++) {
					 for (int v=0;v<6;v++) {
						 this.board[h][v]=copyBoard[h][v];
					 }
				 }
				 
				 for(int i=0; i<7; i++) {
					this.available[i]= copyAvailaible[i];
				 }
				 
				 
				 return column;
			
			 }else {
			
				// if there is no winning colum for the current column turn the board to original because we added a disk 	 
				 for (int h=0; h<7; h++) {
					 for (int v=0;v<6;v++) {
						 this.board[h][v]=copyBoard[h][v];
					 }
				 }
				 
				 for(int i=0; i<7; i++) {
					this.available[i]= copyAvailaible[i];
				 }
				 
				 
			 }
			 
		 }
		
		 
		 // if there is no winning column after we traversed all the column return to original board
		 for (int h=0; h<7; h++) {
			 for (int v=0;v<6;v++) {
				 this.board[h][v]=copyBoard[h][v];
			 }
		 }
		 
		 for(int i=0; i<7; i++) {
			this.available[i]= copyAvailaible[i];
		 }
		 
		 
		// there is no winning column for the current configuration of the board return -1  
		return -1; // DON'T FORGET TO CHANGE THE RETURN
	}
	
	public int canWinTwoTurns (int player){
		// ADD YOUR CODE HERE
		
		 int copyBoard[][]= new int [7][6];
		 int copyAvailaible[]= new int [7]; 
		 
		 int otherPlayer =0;
		 if (player == 1) {
			 otherPlayer=2;
		 }
		 if (player==2) {
			 otherPlayer=1;
		 }
		 
		// copiing the original board  
		 for (int h=0; h<7; h++) {
			copyAvailaible[h] =  this.available[h];
			 for (int v=0;v<6;v++) {
				 copyBoard[h][v] = this.board[h][v];
			 }
		 }
		
		 //this.print();
		 
		 // beggining of the analyse of the board to see if there is a wininig in 2 turns
		 // parcours des columns
		 for (int column=0; column <7; column++) {
		
			this.addDisk(column, player);
			
			// see if the other player can win after that the first player played
			if (this.canWinNextRound(otherPlayer) == -1) {
				// other player dosent win after the player played so we entred in the if
		
		// see if the player can win after that he added the disk
		if (this.canWinNextRound(player) > -1) {
			
			// if the first player can win after he added the disk than the other player block him 
			this.addDisk(this.canWinNextRound(player), otherPlayer);
		}	
		
		// see if after the first was is winning in 2 turns 
		if (this.canWinNextRound(player)>-1) {
			
			// board: retrun to original
			 for (int h=0; h<7; h++) {
				 this.available[h]= copyAvailaible[h];
				 for (int v=0;v<6;v++) {
					 this.board[h][v]=copyBoard[h][v];
				 }
			 }
		
			return column;
		}	

	}
		
			// board retrun to original
			 for (int h=0; h<7; h++) {
				 this.available[h]= copyAvailaible[h];
				 for (int v=0;v<6;v++) {
					 this.board[h][v]=copyBoard[h][v];
				 }
			 }
			
		
			
}
		
		// if there is no winning column that you can play and you will win in 2 rounds
		 
		return -1; // DON'T FORGET TO CHANGE THE RETURN
	}
	
}
