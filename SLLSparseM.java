//SLLSparseM
/*
 * Mohammad Naqvi
 * 
 * public class SLLSparse M implements SparseM{
 *
 * public static class Node{}
 * public SLLSparseM(int nr, int nc){}
 * public int nrows(){}
 * public int ncols(){}
 * public int numElements(){}
 * private boolean outOfBounds(int rowIndex, int columnIndex){}
 * public int getElement(int rowIndex, int columnIndex){}
 * 	public void clearElement(int rowIndex, int columnIndex){}
 * public void setElement(int rowIndex, int columnIndex, int value){}
 * public void getAllElements(int[] rowIndex, int[] columnIndex, int[] value){}
 * public void addition(SparseM otherM){}
 * 
 * }
 * 
 */

//SLLSparseM
public class SLLSparseM implements SparseM {
	
	
	private Node head = null;
	
	private	int nrows, ncols; 	// # of rows and columns
	private int nelements = 0; 	// # of nonzero elements, initially zero
	public static class Node{ //Node class
		 int rowIndex, columnIndex, value, size;
		 int row, column;
		 Node next, previous;
		 
		 Node(int r, int c, int v, Node n, Node p){
			 row = r;
			 column = c;
			 value = v;
			 next = n;
			 previous = p;
		 }
		 
		
		 
		 Node(int rIndex, int cIndex, int v){
			 rowIndex = rIndex;
			 columnIndex = cIndex;
			 value = v;
		 }
		 
		 
		 Node getNext(){return next;}
		 Node getPrev(){ return previous;}
		 void setPrev(Node p){ previous = p;}
		 void setNext(Node n){ next = n;}
		 void setvalue(int v){ value = v;}
		 int getvalue(){ return value;}
		 int getRI(){return rowIndex;}
		 int getColumnIndex(){ return columnIndex;}
		 int getSize(){return size;}
		 void ISize(){size++;}
		 
	}
	
    
    
    public SLLSparseM(int nr, int nc) {
        while (nr == 0) nr = 1;
        while (nc ==0) nc = 1;
        if(nr <= 0) nr = 1;	// if num of rows is less than zero, set num of rows = 1;
        if(nc <= 0) nc = 1;	// if num of columns is less than zero, set num of cols = 1;
        nrows = nr;
        ncols = nc;
    }
    
  

    public int nrows() {//num of rows
        return nrows;
    }

    public int ncols() {//num of cols
        return ncols;
    }

    public int numElements() {// num of non zero entries
        return nelements;
    }

    // out of bounds check
    private boolean outOfBounds(int rowIndex, int columnIndex){
        return((rowIndex < 0) || (rowIndex >= nrows) || (columnIndex < 0) || (columnIndex >= ncols));
    }    
    
    public int getElement(int rowIndex, int columnIndex) { //getting element at rowIndex, columnIndex
        if (outOfBounds(rowIndex, columnIndex))
            return -1; //returns if its out of bounds
        else{
        	Node current = head;
        	while (current != null && current.row <= rowIndex) {	//checks from row to rowIndex
        		if (current.row == rowIndex && current.column == columnIndex)	//if rowIndex == colIndex, then get value of the node 
        			return current.value;
        		current = current.getNext();	//sets current to the next node
        	}
        	return 1;
        }
    }

    public void clearElement(int rowIndex, int columnIndex) { //clearing element at rowIndex, columnIndex
        Node current = head;
        
        while (current != null && current.row <= rowIndex) {
        	
            if (current.row == rowIndex && current.column == columnIndex) {	
                if (current.getPrev() != null) {	
                    current.getPrev().setNext(current.getNext());
                }
                
                if (current.getNext() != null) {	
                    current.getNext().setPrev(current.getPrev());
                }
                
                if (current == head) {	
                    head = current.getNext();
                }
                nelements--; 
                return;
            }
            current = current.getNext();
        }
    }
    

    public void setElement(int rowIndex, int columnIndex, int value) {//setting element at rowIndex, columnIndex, to value
    	if(outOfBounds(rowIndex, columnIndex))
    		return;
    	if(value == 0){
    		clearElement(rowIndex, columnIndex);
    		return;
    	}
        Node newNode = new Node(rowIndex, columnIndex, value);
        
        if(head == null) { 
            head = newNode;
        }
        else if
        ((head.row > rowIndex) || (head.row == rowIndex && head.column > columnIndex)) {	//setting the new node in front
            newNode.setNext(head);	
            head.setPrev(newNode);	
            head = newNode;
        }
        else{
            Node current = head;
            
            if (current.getNext() != null) {	
                newNode.setNext(current.getNext());
                newNode.getNext().setPrev(newNode);
                current.setNext(newNode); 
                newNode.setPrev(current);
            }
        }nelements++; 
    }


    public void getAllElements(int rowIndex[], int columnIndex[], int value[]) { // getting all nonzero values
        int counter = 0;
        Node current = head;
        while (current != null) {	
            rowIndex[counter] = current.row;
            columnIndex[counter] = current.column;
            value[counter] = current.value;
            counter++;
            current = current.getNext();
        }
    }

    
    public void addition(SparseM otherM){//adding otherM into current matrix
    	int nelem = otherM.numElements();
    	int[] rowIndex = new int[nelem];
    	int[] columnIndex = new int[nelem];
    	int[] value = new int[nelem];
    	
    	otherM.getAllElements(rowIndex, columnIndex, value);
    	for(int i = 0; i < otherM.numElements(); i++){
    		int v = getElement(rowIndex[i], columnIndex[i]) + otherM.getElement(rowIndex[i], columnIndex[i]);
    		setElement(rowIndex[i], columnIndex[i],v);
    	}	
    }
    
}
