//Mohammad Naqvi
//project1 in java

	import java.io.*;
	import java.util.Scanner;

	public class ArrayStack {
	      private int top;
	      private int[] dynamic;
	 
	     ArrayStack(int capacity) {
	            if (capacity <= 0)
	            	System.out.println("ArrayStack's capacity is positive");
	            dynamic = new int[capacity];
	            top = -1;
	      } 
	     void pop() {
	            if (top == -1)
	                  System.out.println("ArrayStack is empty");
	            top--;
	      }  
	     int isTop() {
	            if (top == -1)
	            	System.out.println("ArrayStack is empty");
	            return dynamic[top];
	      }
	 
	      void push(int value) {
	            if (top == dynamic.length)
	            	System.out.println("ArrayStack's underlying dynamic is overflow");
	            top++;
	            dynamic[top] = value;
	      }
	 
	    boolean isEmpty() {
	            return (top == -1);
	      }
	      public static void main(String args[]) throws FileNotFoundException{
	    	  //scanning file 
	    	  Scanner infile = new Scanner(new FileReader("C:\\Users\\admin\\Documents\\data.txt"));
	    	 
	    	  //initializes the count 
	    	  int count = 0;
	    	  
	    	  //updates the count with the amount of integersin the data file while its not empty
	    	  while(infile.hasNext()){
	    		  infile.next();
	    		  count++;
	    	  }
	    	  //infile.close();
	    	  //intItem = infile.nextInt();
	    	  
	    	  //initialize array same size as the count
	    	  int []intItems = new int[count];
	    	  
	    	  //stack same size of count
	    	  ArrayStack s = new ArrayStack(count); 
	    	  
	    	  //outputs to the console how many integers are in the file
	    	  System.out.println("There are " + count + " integers in the data file");
	    	  System.out.println();
	    	  
	    	  //closes the file before we reopen to read datainto the array
	    	  infile.close();
	    	  
	    	  //reopents the file to read data into the array
	    	  infile = new Scanner(new FileReader("C:\\Users\\admin\\Documents\\data.txt"));
	    	  
	    	  //reads integers into the array one by one
	    	  for(int i = 0; i < intItems.length; i++){
	    		  intItems[i] = infile.nextInt();
	    	  }
	    	  
	    	  //closes the file again
	    	  infile.close();
	    	  
	    	  //prints contents of the array
	    	  System.out.println("The integers from the data file are: ");
	    	  for(int i = 0; i < intItems.length; i++){
	    		  System.out.print(intItems[i] + " ");
	    	  }
	    	  System.out.println();
	    	  System.out.println();
	    	  
	    	  //reopens file to read data into the stack 
	    	  infile = new Scanner(new FileReader("C:\\Users\\admin\\Documents\\data.txt"));
	    	  
	    	  //reads integers into stack 1 by 1
	    	  for(int i = 0; i < count; i++){
	    		  s.push(infile.nextInt());
	    	  }
	    	  
	    	  //closes file again
	    	  infile.close();
	    	  
	    	  //showing the most top element in stack
	    	  System.out.println("The top of the stack is currently: " + s.isTop());
	    	  System.out.println();
	    	  
	    	  //printing elements from the stack in reverse
	    	  System.out.println("The elements in reverse order are: ");
	    	  for(int i = 0; i < count; i++){
	    		  System.out.print(s.isTop() + " ");
	    		  s.pop();
	    	  }
	    		
	      }

	}

