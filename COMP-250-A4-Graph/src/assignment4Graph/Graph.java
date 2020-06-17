
// Name: Arab Farouk
// ID: 260806502



package assignment4Graph;

public class Graph {
	
	boolean[][] adjacency;
	int nbNodes;
	
	public Graph (int nb){
		this.nbNodes = nb;
		this.adjacency = new boolean [nb][nb];
		for (int i = 0; i < nb; i++){
			for (int j = 0; j < nb; j++){
				this.adjacency[i][j] = false;
			}
		}
	}
	
	public void addEdge (int i, int j){
		// ADD YOUR CODE HERE
		//add the edjes
		this.adjacency[i][j]= true;
		this.adjacency[j][i]=true;
		
		
		
		
	}
	
	public void removeEdge (int i, int j){
		// ADD YOUR CODE HERE
		
		this.adjacency[i][j]= false;
		this.adjacency[j][i]= false;
	}
	
	public int nbEdges(){
		// ADD YOUR CODE HERE
		int count= 0;
		
		for (int i = 0; i < this.nbNodes; i++) {
			
			for (int j= 0 ; j< this.nbNodes; j++) {
				if ( this.adjacency[i][j] ) {
					count++ ;
				} 
				
			}
			
		}
		
		
		return count/2; // DON'T FORGET TO CHANGE THE RETURN
	}
	
	public boolean cycle(int start){
		// ADD YOUR CODE HERE
	
		
		int currentNode=0;
		boolean isCorrect= false;
		
		boolean[][] copy = new boolean [this.nbNodes][this.nbNodes];
		
		for (int i = 0; i < this.nbNodes; i++){
			for (int j = 0; j < this.nbNodes; j++){
				copy[i][j]= this.adjacency[i][j];
			}
		}
	
		
		
	for (int j=0; j < this.nbNodes;j++) {
			
		if (this.adjacency[start][j]==true) {
				
				this.removeEdge(start, j);
				
				currentNode = j;
				if (start==currentNode) {
					return false;
				}
				if ((isCorrect = isCycle(start,currentNode))== true) {
					break;
				} 
				
			
			}
		}
	
	for (int i = 0; i < this.nbNodes; i++){
		for (int j = 0; j < this.nbNodes; j++){
			 this.adjacency[i][j]= copy[i][j];
		}
	}
	if(isCorrect == true) {
	return true;
	}
	
	else {
		return false;
	}
		
		
		
		
		 // DON'T FORGET TO CHANGE THE RETURN
	}
	
	// helper method
	public boolean isCycle(int start, int currentNode) {
		
		int formerNode = 0;
		
		if (currentNode == start) {
			
			return true;
		}
		
		
		else {
		
		for (int j=0; j<this.nbNodes; j++) {
			
			if(this.adjacency[currentNode][j]== true) {
				this.removeEdge(currentNode, j);
				formerNode=currentNode;
				currentNode= j;
			if(	this.isCycle(start, currentNode)==true) {
				return true;
				
			}
			else if(this.isCycle(start, formerNode)) {
				return true;
			}
			else {
				this.isCycle(start, formerNode);
			}
			
			}
		}
	}
			
		return false;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	public int shortestPath(int start, int end){
		

		// ADD YOUR CODE HERE
	

		boolean isVisited[] = new boolean[this.nbNodes];

		int[] queue = new int[this.nbNodes];//the queue
		int[] dist = new int[this.nbNodes];//the distance array
		int[] former = new int [this.nbNodes];//to keep track of the parent
		
		for(int i = 0;i < this.nbNodes;i++) {
			queue[i]=-1;
		}
		
		if(start == end && this.adjacency[start][end] == false) {//no self loop
			return this.nbNodes + 1;
		}
		
		if(start == end && this.adjacency[start][end] == true) {//self loop return 1
			return 1;
		}
		
		dist[start]=0;//set the start distance  to 0
		this.enqueue(queue, start);//enqueue the start
		isVisited[start]=true;//marks to visited
		
		while(!this.isEmpty(queue)) {
			int parent = this.dequeue(queue);//dequeue 
			
			for(int i = 0;i<this.nbNodes;i++) {//check the son of the parent
				if(this.adjacency[parent][i] == true && isVisited[i] == false) {//checks if its a son and it isn't visited yet

					dist[i] = dist[parent]+1;//calculate the distance from the parent
					former[i] = parent;// track of his parent
					isVisited[i]=true;//marked to visited
					this.enqueue(queue, i);//enqueue
				}
			}
			
		}
		if(dist[end] > 0) {
		return dist[end];// DON'T FORGET TO CHANGE THE RETURN
		}
		else {
			return this.nbNodes+1;//no path founded
		}
	}

		
		
		
	
	
	public void enqueue(int[] queue, int node) {//helper method to implement the queue method with an array
		for(int i = 0; i < queue.length;i++) {
			if(queue[i]==-1) {
				queue[i]=node;
				return;
			}
		}
	}
	// implement the dequeue with an array
	public int dequeue(int[] queue) {
		for(int i=0;i<queue.length;i++) {
			if(queue[i]!=-1) {
				int out = queue[i];
				queue[i]=-1;
				return out;
			}
		}
		return -1;
	}
	// check if the queue is empty
	public boolean isEmpty(int[] queue) {
		for(int i=0;i<queue.length;i++) {
			if(queue[i] != -1) {
				return false;
			}
		}
		return true;
	}

	
	
}
