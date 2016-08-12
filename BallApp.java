//import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class BallApp {
	public static void main(String[] args){
		Scanner input= new Scanner(System.in);
		boolean continueLoop = true;
		double bounceperc=0.0;
		double initHeight=0.0;
		int BounceNo=0;
		do
		{
			try
			{	System.out.println("Enter Bounce Percentage: ");
				bounceperc= input.nextDouble();
				continueLoop = false; // input successful; end looping
			}
			catch ( InputMismatchException inputMismatchException )          
			{                                                                
				System.err.print( "\nException: "+inputMismatchException +"\n");                                  
				input.nextLine(); // discard input so user can try again    
				System.out.println("Please enter an integer or a floating point number.\n" );    
			} // end catch                                                   
	      
		}while(continueLoop);
		continueLoop = true;
		do
		{
			try
			{	System.out.println("Enter Initial Height : ");
				initHeight=input.nextDouble();
				continueLoop = false; // input successful; end looping
			}
			catch ( InputMismatchException inputMismatchException )          
			{                                                                
				System.err.print( "\nException: "+inputMismatchException +"\n");                                  
				input.nextLine(); // discard input so user can try again    
				System.out.println("Please enter an integer or a floating point number.\n" );    
			} // end catch                                                   
	      
		}while(continueLoop);
		
		continueLoop = true;
		do
		{
			try
			{	System.out.println("Enter Bounce Number : ");
			BounceNo=input.nextInt();
				continueLoop = false; // input successful; end looping
			}
			catch ( InputMismatchException inputMismatchException )          
			{                                                                
				System.err.print( "\nException: "+inputMismatchException +"\n");                                  
				input.nextLine(); // discard input so user can try again    
				System.out.println("Please enter an integer or a floating point number.\n" );    
			} // end catch                                                   
	      
		}while(continueLoop);
		
		Ball b1= new Ball(bounceperc);
		System.out.println(b1);
		System.out.println(b1.bounceTable(initHeight, BounceNo));
	}

}
