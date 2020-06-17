// NAME: Farouk Arab
// ID ; 260806502

package assignment1;

public class Message {
	

	
	public String message;
	public int lengthOfMessage;

	public Message (String m){
		message = m;
		lengthOfMessage = m.length();
		this.makeValid();
	}
	
	public Message (String m, boolean b){
		message = m;
		lengthOfMessage = m.length();
	}
	
	/**
	 * makeValid modifies message to remove any character that is not a letter and turn Upper Case into Lower Case
	 */
	public void makeValid(){
		//INSERT YOUR CODE HERE
		
		// put every upper case to lower case in the string
		message = message.toLowerCase();
		
		// new String that will contain the finale message
		String finaleMessage= "";
		
		// Initialization of our counter to 0
		int count=0;
		
		for (int i = 0; i < message.length(); i++ ) {
			
			//consider each letter of the string alone
			 char ch = message.charAt(i); 
			
			// from ascii table all lower letters are between 97 and 122
		if ( ch >= 97 && ch <= 122) {
			
			//our final message is composed only lower letter
			finaleMessage += ch;
			// counter increment each time our condition is respected
			
			//count++;
			}
		
		}
		
		// the original message take the value of "finaleMessage"
		message = finaleMessage;
		// the length of the original message take the value of the length of the "finaleMessage" 
		this.lengthOfMessage= finaleMessage.length();
		
	}
	
	
		
		
		
		

	
	/**
	 * prints the string message
	 */
	public void print(){
		System.out.println(message);
	}
	
	/**
	 * tests if two Messages are equal
	 */
	public boolean equals(Message m){
		if (message.equals(m.message) && lengthOfMessage == m.lengthOfMessage){
			return true;
		}
		return false;
	}
	
	/**
	 * caesarCipher implements the Caesar cipher : it shifts all letter by the number 'key' given as a parameter.
	 * @param key
	 */
	public void caesarCipher(int key){
		// INSERT YOUR CODE HERE
		
		// convert the original message to an array
		char [] arrayMessage= message.toCharArray();
		
		// convert any key into a key in base 26
		while (key>=26 || key<= -26 ) {
			
			 key= key%26;
		}
		
	
	for (int i = 0; i < arrayMessage.length ; i++ ) {
			
		char eachLetter= arrayMessage[i]; // consider the message letter by letter
			
		// the value of the new letter that been shifted by the key
		int shiftedValue= eachLetter+key;
				
		//when the value of the letter exceeds 122(z), we put it in the same base, base 122 to can count from 'a'(97)
		if (shiftedValue> 122) {
				
		// the new shifted value that is between 97 and 122
		int newShiftedValue = 96+(shiftedValue%122);
				
		char letterShifted= (char) newShiftedValue;
			arrayMessage[i] = letterShifted;
				
		// when the shiftedValue is smaller than 'a'(97) we count from 122(z)
		} else if (shiftedValue < 97) {
					
		int newShiftedValue= 122-(96-shiftedValue);
				
		char letterShifted = (char) newShiftedValue;
		arrayMessage[i] = letterShifted;
		
		
		} else  {
			//when the shiftedValue is between 97(a) and 122(z) it puts it inside the array that contain the message shifted 
			char letterShifted= (char) shiftedValue;
			arrayMessage[i] = letterShifted;
	
			}
			
			
		  }
		
		// the original message becomes a shifted message by a key value
		message = message.valueOf(arrayMessage);
		
	   }
	
	

	
	public void caesarDecipher(int key){
		this.caesarCipher(- key);
		
		
	}
		
		
		
	
	
	/**
	 * caesarAnalysis breaks the Caesar cipher
	 * you will implement the following algorithm :
	 * - compute how often each letter appear in the message
	 * - compute a shift (key) such that the letter that happens the most was originally an 'e'
	 * - decipher the message using the key you have just computed
	 */
	public void caesarAnalysis(){
		// INSERT YOUR CODE HERE
		
		
	// initialize the 'initiale' array of length 26 to 0
		int [] initiale = new int [26];
		int frequency=0,key=0;
				
	// each time that a letter is repeated, the value inside the index compared to the 'a', as reference, increase	
		for (int  i = 0; i < message.length(); i++) 
			initiale[(message.charAt(i)-'a')]++;		
				
	// to get the most repeated letter we compare frequency to the value of the 'initiale'array 
		for(int i=0;i<26;i++) 
					
			if(frequency<initiale[i]) {
						
	// 'frequency' takes a new value each time that it meet a bigger value
			frequency=initiale[i];
	
	// key takes the value of the index that contain the most bigger number
			key=i;
			}
					
	// 'letter is the most repeated letter'
			char letter=(char) (key+'a') ;
				
	// print the most repeated letter
				
			key =  letter-'e';
				
		this.caesarDecipher(key);
}
		
		
	
	
	/**
	 * vigenereCipher implements the Vigenere Cipher : it shifts all letter from message by the corresponding shift in the 'key'
	 * @param key
	 */
	public void vigenereCipher (int[] key){
		// INSERT YOUR CODE HERE
		
		
		
		char[] arrayMessage = message.toCharArray();
		
		int shiftValue;
		//int [] key = {1,2,1,0,4};
		
	
		
		
		int location;
		
		for (int i = 0 ; i < arrayMessage.length; i++) {
			// determine the location of the letter that will be shifted	
			 location = i% (key.length);
			// the shift value depends on the position
			 shiftValue= key[location];
				
			
				
				
		// handle any key even if its bigger than 26
		while (shiftValue>=26 || shiftValue<= -26 ) {
					
				 shiftValue= shiftValue%26;
				}
				
				char eachLetter= arrayMessage[i];
				
				
				int shiftedValue= eachLetter+shiftValue;
				
		//when the value of the letter exceeds 122(z), we put it in the same base, base 122 to can count from 'a'(97)

		if (shiftedValue> 122) {
					
			int newShiftedValue = 96+(shiftedValue%122);
					
			char letterShifted= (char) newShiftedValue;
					
					
				arrayMessage[i]= letterShifted;
					
		// when the shiftedValue is smaller than 'a'(97) we count from 122(z)
				} else if (shiftedValue<97) {
						
					int newShiftedValue= 122-(96-shiftedValue);
					
					char letterShifted = (char) newShiftedValue;
					arrayMessage[i]= letterShifted;
					
				} else  {
					//when the shiftedValue is between 97(a) and 122(z) it puts it inside the array that contain the message shifted 
				char letterShifted = (char) shiftedValue;
				
				arrayMessage[i]= letterShifted;
				
			
				}
				
			}		
			 
		
		
		
		message = message.valueOf(arrayMessage);
		
		
	}
		
		
	

	/**
	 * vigenereDecipher deciphers the message given the 'key' according to the Vigenere Cipher
	 * @param key
	 */
	public void vigenereDecipher (int[] key){
		// INSERT YOUR CODE HERE
		
		for	(int i=0; i<key.length;i++) {
			key[i] =  key[i]*-1;
		}
		
		
char[] arrayMessage = message.toCharArray();
		
		int shiftValue;
		//int [] key = {1,2,1,0,4};
		
	
		
		
		int location;
		
		for (int i = 0 ; i < arrayMessage.length; i++) {
			// determine the location of the letter that will be shifted	
			 location = i% (key.length);
			// the shift value depends on the position
			 shiftValue= key[location];
				
			
				
				
		// handle any key even if its bigger than 26
		while (shiftValue>=26 || shiftValue<= -26 ) {
					
				 shiftValue= shiftValue%26;
				}
				
				char eachLetter= arrayMessage[i];
				
				
				int shiftedValue= eachLetter+shiftValue;
				
		//when the value of the letter exceeds 122(z), we put it in the same base, base 122 to can count from 'a'(97)

		if (shiftedValue> 122) {
					
			int newShiftedValue = 96+(shiftedValue%122);
					
			char letterShifted= (char) newShiftedValue;
					
					
				arrayMessage[i]= letterShifted;
					
		// when the shiftedValue is smaller than 'a'(97) we count from 122(z)
				} else if (shiftedValue<97) {
						
					int newShiftedValue= 122-(96-shiftedValue);
					
					char letterShifted = (char) newShiftedValue;
					arrayMessage[i]= letterShifted;
					
				} else  {
					//when the shiftedValue is between 97(a) and 122(z) it puts it inside the array that contain the message shifted 
				char letterShifted = (char) shiftedValue;
				
				arrayMessage[i]= letterShifted;
				
			
				}
				
			}		
			 
		
		
		
		message = message.valueOf(arrayMessage);
		
		
	}
		
		
		
		
		
	
	
	/**
	 * transpositionCipher performs the transition cipher on the message by reorganizing the letters and eventually adding characters
	 * @param key
	 */
	public void transpositionCipher (int key){
		// INSERT YOUR CODE HERE
		
int rowNumber;
		
		int count=0;
		
		// to make a array with the good dimensions
		if (message.length()%key >0) {
			
			rowNumber= message.length()/key+1;
			
		} else {
			rowNumber = message.length()/key;
		}
			
		char [] [] ch= new char [rowNumber] [key] ;
		// fill the 2D array horizontally	
		for (int i =0; i<rowNumber; i++) {
				
				for (int j=0; j<key; j++) {
			
			if (count <message.length()) {
				
			ch[i][j]=message.charAt(count) ;
			
			// when all the letter in the string are in the 2D array put stars(*) in the empty indexes
			} else if  (count>=message.length() && count< (key*rowNumber) ) {
				ch[i][j]= '*';
				
		  }
	count++;
	}		
					
}
			
		// will eventually contain the final message	
			
		String finalMessage = ""; 
	
			
	// read the message vertically
	for (int a = 0; a<key; a++) {
			
		for(int b=0; b<rowNumber; b++) {
		
		// fill the final message vertically	
		finalMessage+=ch[b][a];
						
				
			
			}
		
		}

	// the original message become finaleMessage
	message=finalMessage;
	lengthOfMessage = message.length();
			
	}		
			
			
		

	
	/**
	 * transpositionDecipher deciphers the message given the 'key'  according to the transition cipher.
	 * @param key
	 */
	public void transpositionDecipher (int key){
			// INSERT YOUR CODE HERE
		

	int rowNumber;
		
	int count=0;
		
	if (message.length()%key >0) {
			
		rowNumber= message.length()/key+1;
			
		} else {
			
			rowNumber = message.length()/key;
		}
			
		
	char [] [] ch= new char [rowNumber] [key] ;
			
	// fill the String vertically
	for (int j=0; j < key; j++) {
			
		for (int i =0; i<rowNumber; i++) {
				
		if (count <message.length()) {
				
		ch[i][j]=message.charAt(count) ;
			
	}
		
		count++;
		}		
					
	}
			
			
	String finalMessage = "";
		
	// read the code horizontally 
	for(int b=0; b<rowNumber; b++) {
					
		for (int a = 0; a<key; a++) {
				
	// remove the stars (*)		
		if (ch[b][a] != '*'){
	
	// fill the string horizontally
			
	finalMessage += ch[b][a];
					
		}
				
		}
				
			
	}
	
	// the original message becomes finalMessage
	message = finalMessage;
		lengthOfMessage=message.length();
				
	}

}

