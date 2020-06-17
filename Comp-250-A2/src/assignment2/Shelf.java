
// Name: Farouk Arab
// ID: 260806502

package assignment2;

public class Shelf {
	
	
	protected int height;
	protected int availableLength;
	protected int totalLength;
	protected Box firstBox;
	protected Box lastBox;

	public Shelf(int height, int totalLength){
		this.height = height;
		this.availableLength = totalLength;
		this.totalLength = totalLength;
		this.firstBox = null;
		this.lastBox = null;
	}
	
	protected void clear(){
		availableLength = totalLength;
		firstBox = null;
		lastBox = null;
	}
	
	public String print(){
		String result = "( " + height + " - " + availableLength + " ) : ";
		Box b = firstBox;
		while(b != null){
			result += b.id + ", ";
			b = b.next;
		}
		result += "\n";
		return result;
	}
	
	/**
	 * Adds a box on the shelf. Here we assume that the box fits in height and length on the shelf.
	 * @param b
	 */
	public void addBox(Box b){
		//ADD YOUR CODE HERE
	
		// when there is no box in the shelf
		if (this.lastBox == null) {
		 this.lastBox=b;
		 this.firstBox=b;
	
		 // when there is already at least one box 	 
	 } else {
		 this.lastBox.next= b;
		 b.previous=this.lastBox;
		 this.lastBox= b;
		 
	 }
	
	 
	 // update of the length of the shelfs after we add a box
	 this.availableLength = this.availableLength - b.length;
	
	
	
	}
	
	/**
	 * If the box with the identifier is on the shelf, remove the box from the shelf and return that box.
	 * If not, do not do anything to the Shelf and return null.
	 * @param identifier
	 * @return
	 */
	public Box removeBox(String identifier){
		//ADD YOUR CODE HERE
		
		// temporary box named currentBox
		Box currentBox;
		
		// currentBox initialized to the first box
		currentBox = this.firstBox;
	
		
		while (currentBox != null) {
			
		// compare the id of the currentBox with the argument	
		if( currentBox.id == identifier) {
				
			// currentBox is the first in the list
			if(currentBox == this.firstBox) {
				
					// there is only one box
					if ( currentBox == this.lastBox) {
						
						// remove the box
						this.firstBox = null;
						this.lastBox = null;
						
					// when there is already at least one box and the currentBox is the first
					} else if (currentBox.next != null){
						
						this.firstBox = currentBox.next; // this is null
						this.firstBox.previous=null;
					   }
			}
			// when currentBox is the last
			else if(currentBox == this.lastBox) {
				
				// remove the last box 	
				this.lastBox = currentBox.previous;
				this.lastBox.next = null;
			
			//  when the currentBox is between 	the first and the last box	
			} else {
				
				// remove the box
				currentBox.previous.next = currentBox.next;
				currentBox.next.previous = currentBox.previous;
				
				}
				
				// update the available length in the shelf
				this.availableLength = this.availableLength + currentBox.length;
				
				// the removed currentBox
				currentBox.next = null;
				currentBox.previous = null;
			
			return currentBox;
			 
		}
		
		// go through each box till to find the good one 
		currentBox= currentBox.next;		
}
		
		
		// if the box that we looking for doesn't exist
		return null;
}
	
	
}

	

