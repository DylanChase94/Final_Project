//class Menu

import java.util.Scanner;

public class Menu{
	private int n;

	public Menu(){
		int n=0;

	}	

	public static void main(String[] args){
		BSTmovie a= new BSTmovie();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter 1 for Admin or 2 for Customer");

		int n = -1;
		while(n != 1 && n != 2){
		   	n=s.nextInt();
		   	if (n != 1 && n != 2){
		   		System.out.println("You did not enter 1 or 2");
		   	}
		}

		String pagestatus = "User";
		if(n==1){
			System.out.println("This is the Admin page");
			pagestatus = "Admin";
			System.out.println("1. Add Movie");
			System.out.println("2. Delete Movie");
			System.out.println("3. Rotten Tomatoes Scores");
			System.out.println("4. Add Customer");
			System.out.println("5. Delete Customer");
			System.out.println("6. Edit Customer");
			System.out.println("7. Search for Customer");
			System.out.println("8. Return to Main Menu");
		}
		else if (n==2){
			int c=0;
			System.out.println("This is the Customer page");
			pagestatus = "User";
			System.out.println("1. Edit Account");

			System.out.println("2. Edit Wishlist");
			
			System.out.println("3. Search Movies By Date");
			System.out.println("4. Search Movies By ID");
			System.out.println("5. Print Movies By Release Date");
			System.out.println("6. Delete Account");
			System.out.println("7. Return to Main Menu");
		
		}

		n = -1;
		if (pagestatus.equals("User")){
			while (n!=1 && n!=2 && n!=3 && n!=4 && n!=5 && n!=6 && n!=7){
				n=s.nextInt();
				if (n!=1 && n!=2 && n!=3 && n!=4 && n!=5 && n!=6 && n!=7){
					System.out.println("Incorrect Key. Please choose valid option.");
			}

			if (n==1){
				System.out.println("1. Edit Account");

			}
			else if (n==2){
				System.out.println("2. Edit Wishlist");
			}
			else if (n==3){
				System.out.println("3. Search Movies By Date");
			}
			else if (n==4){
				System.out.println("Enter movie ID");
				int movie_ID=s.nextInt();
				if(a.search(movie_ID)!=null){
				System.out.println(a.search(movie_ID).getTitle());
			}
				else{
				System.out.println("Movie Not Found");
			}
	
			}
			
			else if (n==5){
				System.out.println("5. Print Movies By Release Date");
			}
			else if (n==6){
				System.out.println("6. Delete Account");
			}
			else if (n==7){
				System.out.println("7. Return to Main Menu");
			}
		}
	}
	else if (pagestatus.equals("Admin")){
		while (n!=1 && n!=2 && n!=3 && n!=4 && n!=5 && n!=6 && n!=7 && n!=8){
				n=s.nextInt();
				if (n!=1 && n!=2 && n!=3 && n!=4 && n!=5 && n!=6 && n!=7 && n!=8){
					System.out.println("Incorrect Key. Please choose valid option.");
			if (n==1){
				System.out.println("1. Add Movie");
			}
			else if (n==2){
				System.out.println("2. Delete Movie");
			}
			else if (n==3){
				System.out.println("3. Rotten Tomatoes Scores");
			}
			else if (n==4){
				System.out.println("4. Add Customer");
			}
			else if (n==5){
				System.out.println("5. Delete Customer");
			}
			else if (n==6){
				System.out.println("6. Edit Customer");
			}
			else if (n==7){
				System.out.println("7. Search for Customer");
			}
			else if (n==8){
				System.out.println("8. Return to Main Menu");
			}
		}
	}

}
}
}