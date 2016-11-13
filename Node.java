
public class Node {
	
	int value;
	
	int rowNumber;
	int colNumber;
	
	Node top;
	Node bottom;
	Node left;
	Node right;
	
	
	
	Node(){
		top = null;
		bottom = null;
		left = null;
		right = null;
		rowNumber=0;
		colNumber=0;
	}
	
	
	void set(int val){
		value = val;
	}
	
	void clear(){
		value = 0;
	}
	
	int get(){
		return value;
	}
	
	void ExpandRight(int nodes){
		
		
		Node root = new Node();
		Node last = root;
		for(int i =1; i < nodes; i++){
			last.right = new Node();
			last.right.left = last;
			last = last.right;
		}
		
		if(this.right!= null) {
			this.right.left = last;
			last.right = this.right;
		}
	
		this.right = root;
		
		//update Node #'s
		
		Node current = this;
		int curCol = current.colNumber;
		while(current.right != null){
			current.colNumber = curCol;
			current.rowNumber = this.rowNumber;
			curCol++;
			current = current.right;
		}
		
		
	}
	
	void ExpandBottom(int nodes){
		
		
		Node root = new Node();
		Node last = root;
		for(int i =1; i < nodes; i++){
			last.bottom = new Node();
			last.bottom.top = last;
			last = last.bottom;
		}
		
		
		
		if(this.bottom!= null) {
			this.bottom.top = last;
			last.bottom = this.bottom;
		}
		this.bottom = root;
		//update Node #'s
		
				Node current = this;
				int curRow = current.rowNumber;
				while(current != null){
					current.rowNumber = curRow;
					curRow++;
					
					current = current.bottom;
				}
		
	}
	
	
	void printRight(){
		
		Node current = this;
		while(current != null){
			System.out.print( current.value + "," + current.rowNumber + "," + current.colNumber + "  ; ");
			current = current.right;
		}
		
	}
	
	
	int getRow(){
		
		int distance = 0;
		Node current = this;
		while(current.top != null){
			distance+=1;
			current = current.top;
		}
		
		return distance;
		
	}
	
	int getColumn(){
		
		int distance = 0;
		Node current = this;
		while(current.right != null){
			distance+=1;
			current = current.right;
		}
		
		return distance;
		
	}
	
	

}
