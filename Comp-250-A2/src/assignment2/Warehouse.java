
// Name: Farouk Arab
// ID: 260806502

package assignment2;

public class Warehouse {
	
	protected Shelf[] storage;
	protected int nbShelves;
	public Box toShip;
	public UrgentBox toShipUrgently;
	static String problem = "problem encountered while performing the operation";
	static String noProblem = "operation was successfully carried out";
	
	public Warehouse(int n, int[] heights, int[] lengths){
		this.nbShelves = n;
		this.storage = new Shelf[n];
		for (int i = 0; i < n; i++){
			this.storage[i]= new Shelf(heights[i], lengths[i]);
		}
		this.toShip = null;
		this.toShipUrgently = null;
	}
	
	public String printShipping(){
		Box b = toShip;
		String result = "not urgent : ";
		while(b != null){
			result += b.id + ", ";
			b = b.next;
		}
		result += "\n" + "should be already gone : ";
		b = toShipUrgently;
		while(b != null){
			result += b.id + ", ";
			b = b.next;
		}
		result += "\n";
		return result;
	}
	
 	public String print(){
 		String result = "";
		for (int i = 0; i < nbShelves; i++){
			result += i + "-th shelf " + storage[i].print();
		}
		return result;
	}
	
 	public void clear(){
 		toShip = null;
 		toShipUrgently = null;
 		for (int i = 0; i < nbShelves ; i++){
 			storage[i].clear();
 		}
 	}
 	
 	/**
 	 * initiate the merge sort algorithm
 	 */
	public void sort(){
		mergeSort(0, nbShelves -1);
	}
	
	/**
	 * performs the induction step of the merge sort algorithm
	 * @param start
	 * @param end
	 */
	protected void mergeSort(int start, int end){
		//ADD YOUR CODE HERE
	// merge sort inspired by https://www.geeksforgeeks.org/merge-sort/
		int mid;
		
		// Divide the array till we got many one array 
		if(start < end) {
			
			mid = (start+end)/2;
			mergeSort(start,mid);
			mergeSort(mid+1,end);
			merge(start,mid,end);
		}
		
		
	}
	
	/**
	 * performs the merge part of the merge sort algorithm
	 * @param start
	 * @param mid
	 * @param end
	 */
	protected void merge(int start, int mid, int end){
		//ADD YOUR CODE HERE
		
		
		
	int i, j, k;
	int n1 = mid - start + 1;
	int n2 =  end - mid;
		 
	// temp arrays 
	 Shelf [] left = new Shelf [n1];
	 Shelf [] right = new Shelf [n2];
		 
	 // store elements that need to be sort in left & right array  
	for (i = 0; i < n1; i++)
		left [i] = this.storage[start + i];
	for (j = 0; j < n2; j++)
		right [j] = this.storage[mid +j+1];
		  
		i = 0; // Initial index of left array
		j = 0; // Initial index of right array
		k = start; // Initial index of merged array
		 
		while (i < n1 && j < n2)
		  {
		      if (left [i].height <= right [j].height)
		  {
		      this.storage[k] = left [i];
		        i++;
		  }
		      else
		  {
		      this.storage[k] = right [j];
		      j++;
		  }
		      k++;
		  }
		 
		    // Copy the remaining elements of left array, if there  are any 
		      
		 while (i < n1)
		  {
		     this.storage[k] = left[i];
		      i++;
		      k++;
		  }
		 
		    // Copy the remaining elements of the right array, if there are any 
		       
		  while (j < n2)
		  {
		    this.storage[k] = right[j];
		     j++;
		     k++;
		  }
	}
		 
		
		
	/**
	 * Adds a box is the smallest possible shelf where there is room available.
	 * Here we assume that there is at least one shelf (i.e. nbShelves >0)
	 * @param b
	 * @return problem or noProblem
	 */
	public String addBox (Box b){
		//ADD YOUR CODE HERE
		
		// go through all shelves
		for (int i = 0; i < this.storage.length;i++) {
			
			//compare the length & the height of the box with the length & the height of the shelves
			if(b.height <= this.storage[i].height && b.length <= this.storage[i].availableLength) {
				
			// add the box in the optimal shelf
			this.storage[i].addBox(b);
					
			return noProblem;
					
			}
		}
			
			return problem;
	}
	
	/**
	 * Adds a box to its corresponding shipping list and updates all the fields
	 * @param b
	 * @return problem or noProblem
	 */
	public String addToShip (Box b){
		//ADD YOUR CODE HERE
		
	// when there is no box to add to the ship
		if (b == null) {
			return problem;
		}
		
		// when the box b is an urgent box
		else if ( b instanceof UrgentBox ) {
			
			// when the toShipUrgently list is empty
				if(this.toShipUrgently== null) {
			
			// adding the first box to the urgent list
				toShipUrgently= (UrgentBox) b;
				toShipUrgently.next= null;
				toShipUrgently.previous= null;
				
			//	when the toShipUrgently list have already at least one box
			} else {
			
				// adding a new box toShipUrgentList 
				toShipUrgently.previous=b;
				b.next= toShipUrgently;
				toShipUrgently =(UrgentBox) b;
				toShipUrgently.previous = null;
			}
			
	}
		// when the box is not urgent 
		else {
			
			// when toShip list is empty
			if(this.toShip== null) {
				
				// adding the first box to the empty toShip list
				toShip=  b;
				toShip.next= null;
				toShip.previous= null;
			  // when there is at least one box in the toShip list
			} else {
				
				// adding a box to the toShip list at the last 
				toShip.previous=b;
				b.next= toShip;
				toShip = b;
				toShip.previous = null;
			}
			
			
			
			
		}
		return noProblem;
		
}
	
	/**
	 * Find a box with the identifier (if it exists)
	 * Remove the box from its corresponding shelf
	 * Add it to its corresponding shipping list
	 * @param identifier
	 * @return problem or noProblem
	 */
	public String shipBox (String identifier){
		//ADD YOUR CODE HERE
		
		// currentBox initialized to null
		Box currentBox = null;
		
		// going through each shelves in the storage
		for (int i = 0; i < this.storage.length; i++) {
			
			// currentBox will take the value of the corresponding box with the identifier entered
			currentBox = (this.storage[i].removeBox(identifier));
				
				// when we find the box that we looking for
				if (currentBox!=null) {
					
				// go out the loop	
					break;
				} 
				
		}			
				
		if(currentBox != null) {
		// add to the corresponding  ship list
			addToShip(currentBox);
			return noProblem;
		}
		// when we dont't find the box that we looking for
		else {
			return problem;
		}
	}
	
	

	
	
	/**
	 * if there is a better shelf for the box, moves the box to the optimal shelf.
	 * If there are none, do not do anything
	 * @param b
	 * @param position
	 */
	public void moveOneBox (Box b, int position){
		//ADD YOUR CODE HERE
		
		// add a box in a shelf when there is a new place availaible
		
			if (addBox(b)== noProblem) {
				this.storage[position].removeBox(b.id);
			}
			
		
		
	}
	
	/**
	 * reorganize the entire warehouse : start with smaller shelves and first box on each shelf.
	 */
	public void reorganize (){
		//ADD YOUR CODE HERE
	
	Box nextBox;
	Box thisBx;
	
	// going through all the shelves	
	for(int i = 0; i < this.storage.length; i++) {
		
	// thisBx take the first box in each shelves
		thisBx = this.storage[i].firstBox;
			
		while (thisBx != null) {
			
		// nextBox is always be next to thisBx
		nextBox = thisBx.next;
				
		// update the optimized place
		this.moveOneBox(thisBx, i);	
			
			
		// update thisBx 
				thisBx= nextBox;
			
			}
		
		}
	}


}
