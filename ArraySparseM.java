// implementing SparseM using array
public class ArraySparseM implements SparseM {
	private	int nrows, ncols; 	// number of rows and columns of the matrix
	private int nelements = 0; 	// number of nonzero elements, initialized to be zero
	private int [][] elements;	// array of array for the matrix
	
	// constructor initialize a sparse matrix with nr rows and nc columns
	public ArraySparseM(int nr, int nc){
		if(nr <= 0) nr = 1;	// if zero or negative nr, set nr = 1;
		if(nc <= 0) nc = 1;	// if zero or negative nc, set nc = 1;	
		nrows = nr;	
		ncols = nc;
		elements = new int[nr][nc];	// allocate the matrix
	}

	// check if the given (ridx, cidx) is out of bounds
	private boolean outOfBounds(int ridx, int cidx){
		return((ridx < 0) || (ridx >= nrows) || (cidx < 0) || (cidx >= ncols));
	}
	
	// get number of rows
	public int nrows() {
		return nrows;
	}

	// get number of columns
	public int ncols() {
		return ncols;
	}

	// get number of nonzero entries
	public int numElements() {
		return nelements;
	}

	// get element at (ridx,cidx)
	// if out of bounds, return -1
	public int getElement(int ridx, int cidx) {
		if(outOfBounds(ridx,cidx))
			return -1;
		return elements[ridx][cidx];
	}

	// clear element at (ridx,cidx)
	public void clearElement(int ridx, int cidx) {
		if(outOfBounds(ridx,cidx))
			return;
		int tmp = elements[ridx][cidx];
		elements[ridx][cidx] = 0;	//set the element to zero
		if(tmp != 0)				//if the original element is nonzero, decrement nelements by 1
			nelements--;
		return;
	}
	
	// set the element at (ridx,cidx) to val
	public void setElement(int ridx, int cidx, int val) {
		if(outOfBounds(ridx,cidx))
			return;
		if(val == 0)
			clearElement(ridx,cidx);
		else{
			int tmp = elements[ridx][cidx];
			elements[ridx][cidx] = val;	//set the element to val			
			if(tmp == 0)	//if the original element is zero, increment nelements by 1
				nelements++;
		}
		return;
	}

	// get all nonzero elements, row by row, col by col
	// stores the row indices, column indices and values in the three arrays
	public void getAllElements(int[] ridx, int[] cidx, int[] val) {
		int counter = 0;
		for(int r = 0; r < nrows; r++)
			for(int c = 0; c < ncols; c++)
				if(elements[r][c] != 0){
					ridx[counter] = r;
					cidx[counter] = c;
					val[counter] = elements[r][c];
					counter++;
				}
		return;
	}

	// adding otherM into the current matrix
	public void addition(SparseM otherM) {
		
		// if the number of rows and cols are inconsistent, do nothing and return
		if((otherM.nrows() != nrows) || (otherM.ncols() != ncols))
			return;
		
		int tmp;
		for(int r = 0; r < nrows; r++)
			for(int c = 0; c < ncols; c++){
				tmp = getElement(r,c) + otherM.getElement(r,c);
				setElement(r,c,tmp);	// setElement take care of updating nelements
			}
		return;
	}
}
