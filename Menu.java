//class Menu

import java.util.Scanner;

public class Menu{
	private int n;

	public Menu(){
		int n=0;
}
	public static void main(String[]args){
	Scanner s=new Scanner(System.in);
	System.out.println("Enter 1 for Admin or 2 for Customer");

   int n=s.nextInt();
   
	if(n==1){
		System.out.println("This is the Admin page");
	}
	else if(n==2){
		System.out.println("This is the Customer page");
	}
	else{
		System.out.println("You did not enter 1 or 2");
	}
}
}
	
}

