// Name; Arab Farouk
// ID: 260806502



package assignment3;

public class Building {

	OneBuilding data;
	Building older;
	Building same;
	Building younger;
	
	public Building(OneBuilding data){
		this.data = data;
		this.older = null;
		this.same = null;
		this.younger = null;
	}
	
	public String toString(){
		String result = this.data.toString() + "\n";
		if (this.older != null){
			result += "older than " + this.data.toString() + " :\n";
			result += this.older.toString();
		}
		if (this.same != null){
			result += "same age as " + this.data.toString() + " :\n";
			result += this.same.toString();
		}
		if (this.younger != null){
			result += "younger than " + this.data.toString() + " :\n";
			result += this.younger.toString();
		}
		return result;
	}
	
	public Building addBuilding (OneBuilding b){
		// ADD YOUR CODE HERE
		
		Building tempb= null;
		
	
	//
		if (this.data.yearOfConstruction == b.yearOfConstruction && this.data != b) {
			
			if (b.height> this.data.height) {
				
				tempb= new Building(b);
				b = this.data;
				this.data = tempb.data;
				
				
				if (this.same != null) {
				this.same.addBuilding(b);
				}
				
				else
				
				{
					this.same= new Building(b);
					//System.out.println("allo "+  this.same);
				}
			}
				
			else if (b.height == this.data.height) {
										
					if (this.same != null) {
						this.same.addBuilding(b);
						//System.out.println("allo "+  this.same);
					}
					
					else
					
					{
						this.same= new Building(b);
						//System.out.println("allo "+  this.same);
					}
			} 
			
			else if(this.same != null) 
			{
				this.same.addBuilding(b);
				//System.out.println("salt  "+  this.same);
			}
				else 
				{
				this.same= new Building(b);
				}
	}
		
		if(b.yearOfConstruction< this.data.yearOfConstruction && this.data != b) {
			if(this.older != null) {
				this.older.addBuilding(b);
				//System.out.println(this.older.data);
				}
			else {
				this.older=new Building(b);
				//System.out.println(this.older.data);
				
			}
		}
		  if (b.yearOfConstruction > this.data.yearOfConstruction && this.data != b) {
			 
			 if (this.younger != null) {
			 
				 this.younger.addBuilding(b);
				 //System.out.println(this.younger.data);
			
		 }
			else{
				
				this.younger = new Building(b);
				//System.out.println(this.younger.data);
				
			}
		  }
		
		return this; // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
	public Building addBuildings (Building b){
		// ADD YOUR CODE HERE
		
		// add building if the argument is not null
		if (b.data != null ) {
			this.addBuilding(b.data);
			
		}
		
		if(b.older !=null) {
			this.addBuilding (b.older.data);
			if (b.older.older != null || b.older.same !=null || b.older.younger !=null) {
				this.addBuildings(b.older);
			}
		}
		
		if ( b.same!=null) {
			this.addBuilding(b.same.data);
			if (b.same.older != null || b.same.same !=null || b.same.younger !=null) {
				this.addBuildings(b.same);
			}
		}
		
		if(b.younger != null) {
			this.addBuilding(b.younger.data);
			if (b.younger.older != null || b.younger.same !=null || b.younger.younger !=null) {
				this.addBuildings(b.younger);
			}
		}
		
			return this; // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
	public Building removeBuilding (OneBuilding b){
		// ADD YOUR CODE HERE
		
		Building Temp;
		//Building temp2 = null;
	if(this.data.yearOfConstruction == b.yearOfConstruction) {
		
		if (this.data.equals(b)) {
			
			if(this.same !=null) {
			
			this.data = this.same.data; 
			
			if (this.same.same != null) {
			this.same = this.same.same;
			}
			else {
				this.same = null;
			}
			}
			
			else if(this.older != null )
			{
				if (this.younger != null) {
				 Temp = this.older.addBuildings(this.younger);
				 return Temp;
			} else {
				this.data = this.older.data;
				this.older= null;
			}
			}
			
			else if (this.younger !=null)
			{
				return this.younger;
			
			} 
		}
			else if (this.same == null && this.older==null && this.younger==null && !this.data.equals(b) ) {
				return this;
				
		} else if(this.same.data.equals(b)) {
				this.same=null;
			}
				
		else if( this.same != null) {
		
		this.same.removeBuilding(b);	
		} 
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
		else if (b.yearOfConstruction < this.data.yearOfConstruction) {
				
			if( this.older.data.equals(b)) {
			
		
			
			if(this.older.same !=null) {
				
				this.older = this.older.same;
				
				
				}
				
			else if(this.older.older != null ){
					
					this.older= this.older.older;
					
					if(this.older.older.same != null) {
						this.older.older= this.older.older.same;
					}
					else if (this.older.older.older !=null) {
							
						this.older.older= this.older.older.older;
					}   
					
					else if(this.older.older.younger !=null) {
					this.older.older= this.older.older.younger;
					}
				}
					
				
					else if (this.older.younger != null ) {
					
					this.older= this.older.younger;
					
					if (this.older.younger.same != null) {
						this.older.younger= this.older.younger.same;
					}
					else if (this.older.younger.older !=null) {
							
						this.older.younger= this.older.younger.older;
					}   
						else if(this.older.younger.younger !=null) {
						this.older.younger= this.older.younger.younger;
					}
					} 
					
		//	else if (this.same.data.equals(null) && this.older.data.equals(null) && this.younger.data.equals(null) ) {
						//this.data = null;
					//}
	
			}
			//else if(this.older.same.data.equals(b)) {
			//	this.older.same = null;
			//}
			else if (this.older != null) {
			this.older.removeBuilding(b);
			}
	}
			
			
			
///////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////			
			
		 
			
			else if(b.yearOfConstruction > this.data.yearOfConstruction){
				
				if(this.younger.data.equals(b)) {
					if(this.younger.same != null) {
								this.younger.data = this.younger.same.data;
										if(this.younger.same.same != null) {
									      this.younger.same = this.younger.same.same;
										}
										else {
											this.younger.same = null;
										}
								}
								
							else if(this.younger.older != null ) {
								
				this.younger.data = this.younger.older.data;
									
				if(this.younger.older.older != null || this.younger.older.same != null || this.younger.older.younger != null ) {
										this.younger.older = this.younger.older.older;
										//this.addBuildings(this.younger.older.removeBuilding(b));
										
									}
								
									if(this.younger.older.younger != null) {
										this.younger.older = null;
										this.addBuildings(this.younger.older.younger);
									}
									
									
								}
							else if(this.younger.younger != null ) {
								this.younger = this.younger.removeBuilding(b);
								}
							}
							
							else {
								this.younger.removeBuilding(b);
								}
							}

		
			
	
		return this; // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
}
	
	public int oldest(){
		// ADD YOUR CODE HERE
		if (this.older !=null) {
			
			return this.older.oldest();
			
			//return this.data.yearOfConstruction;
		} else {// (this.same != null)
			 return this.data.yearOfConstruction;
		}
		
		
		//return 0; // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
	public int highest(){
		// ADD YOUR CODE HERE
		int heightOfSame=0 ;
		int heightOfOlder =0;
		int heightOfYounger=0;
		int thisHeight= this.data.height;
		
			
			if (this.same != null) {
					heightOfSame= this.same.highest();
					
		}
		
		 if (this.older != null) {
				heightOfOlder= this.older.highest();
				
		}
			
		 if (this.younger != null) {
				
					heightOfYounger= this.younger.highest();
					
				}
				
		if (thisHeight >heightOfSame && thisHeight> heightOfOlder && thisHeight> heightOfYounger ) {
	 return thisHeight;	
} 
		if (heightOfSame >thisHeight && heightOfSame> heightOfOlder && heightOfSame> heightOfYounger ) {
			 return heightOfSame;	
		} 
		
		else if (heightOfOlder >heightOfSame &&  heightOfOlder >thisHeight && heightOfOlder> heightOfYounger ) {
			 return heightOfOlder;	
		}
		
		else { 
			
			 return heightOfYounger;	
		}
		
	}
	
	
	public OneBuilding highestFromYear (int year){
		// ADD YOUR CODE HERE
		
		if( this.data.yearOfConstruction == year) {
			return this.data;
		}
		
		else if(this.data.yearOfConstruction > year) {
			
			if(this.older == null) {
				return null;
			}
			else if(this.older.data.yearOfConstruction == year) {
				return this.older.data;
			}
			else {
				 return this.older.highestFromYear(year);
			}
		}
		
		else if(this.data.yearOfConstruction < year) {
			if(this.younger == null) { 
				return null;
			}
			else if(this.younger.data.yearOfConstruction == year) {
				return this.younger.data;
			}
			
			else {
			return	this.younger.highestFromYear(year);
			}
		}
		
		else {
			return null;
		}
		//return new OneBuilding("",0,0,0,0); // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
		
	}

	
	public int numberFromYears (int yearMin, int yearMax){
		// ADD YOUR CODE HERE
		
		int count = 0;
		
		if(yearMin > yearMax) {
			return 0;
		}
		
		if(this.data.yearOfConstruction >= yearMin && this.data.yearOfConstruction <= yearMax) {
			count++;
			if(this.same != null) {
			count = count + this.same.numberFromYears(yearMin, yearMax);
			}
		}
		
		if(this.older != null) {
			count = count + this.older.numberFromYears(yearMin, yearMax);
		}
		
		if(this.younger != null) {
			
			count = count + this.younger.numberFromYears(yearMin, yearMax);
		}
		return count; // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}

	public int[] costPlanning (int nbYears){
		// ADD YOUR CODE HERE
		return new int[0]; // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
}

