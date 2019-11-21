import java.util.InputMismatchException;
import java.util.Scanner;
/*
 *  Worked on by Tino Pimentel. Homework due Tuesday 
 *  Step 2 : revise the program to properly validate input and gracefully recover from errors. 
 * 
 */
public class Input {

	public static void main(String[] args)  {
		Scanner scan = new Scanner(System.in);
		int sz = getArraySize(scan);
		String[] names = getNames(scan,sz);
		int which = getWhich(scan);
		String aName = getName(which,names);
		System.out.println("You choose name: " + aName);
	}

	private static int getArraySize(Scanner scan){
		// TODO Auto-generated method stub
		boolean n;
		int n2= 0;
		try{
			System.out.print("How many names? ");
			//n = scan.hasNextInt(); // broken right now 
			n2 = scan.nextInt();
			n = scan.hasNextInt(n2);
			//gathers the input from useraaassss
			//while(!all the thing we want) run these tests 
			while(!(n || n2<=0 || n2>100)) {
				if(n2<=0) throw new IllegalArgumentException("Try Again! Only Positive Integers allowed");
				else if(n2> 100) throw new IllegalArgumentException("Try Again! No more than 100 Integers allowed");
				else scan.nextLine();
			}

		 /*  original code before try catches 
		try {
		System.out.print("How many names? ");
		 n = scan.nextInt();//gathers the input from user
		scan.nextLine();
		return n;
		}
		*/
		return n2;
		} // put catches from specific to least specific, be graceful and allow the user to keep trying. while loop? 
		catch (InputMismatchException e){
			System.out.println("Positive only");
		
		}
		catch (IllegalArgumentException e) {
			System.out.println("You did not give an allowed integer");
		
		}
		finally {
			System.out.println("The try catch block is finished");
		}
		return n2;
	}

	private static String[] getNames(Scanner scan, int sz) {
		// TODO Auto-generated method stub
		String []names = new String[sz];
		for (int i = 0; i < sz; i++) {
			System.out.print("type name #" + (i+1) + ": ");
			names[i] = scan.nextLine();
		} return names;
	}

	private static int getWhich(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.print("Which name: ");
		int x = scan.nextInt();
		return x;
	}

	private static String getName(int n, String[] vals) {
		// TODO Auto-generated method stub
		return vals[n-1];
	}
}
