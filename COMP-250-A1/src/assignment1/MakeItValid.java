package assignment1;

public class MakeItValid {

	public static void main(String[] args) {
String originalMessage= "BONjour Farouk;;+ arab";
		
	//int lengthOfMessage = originalMessage.length();

	String str = originalMessage.toLowerCase();
	//System.out.println(str);
	//char [] newMessage = str.toCharArray();
	
	
	char [] finaleMessage=new char[str.length()];
	//System.out.println(newMessage[2]);
	int count=0;
	
	
	for (int i = 0; i < finaleMessage.length; i++ ) {
	
		 char ch = str.charAt(i); 
		
		
	if ( ch >= 97 && ch <= 122) {
		
				
			 finaleMessage[count]=ch;
				
				
			//System.out.print(newMessage[7]);
			count++;
			//System.out.print(count);
		}
	
	}
	
	//System.out.println(newMessage[16]);
	str= str.valueOf(finaleMessage);
	System.out.println(str);
	}
}



