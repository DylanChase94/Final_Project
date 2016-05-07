//class Menu

import java.util.Scanner;

public class Menu1{
	private int n;

	public Menu1(){
		int n=0;

	}	

	public static void main(String[] args){

		//initiate all of the data structures
		BSTmovie idBST= new BSTmovie(); 
		BSTCustomer customerBST = new BSTCustomer();
		BSTrd  rdBST= new BSTrd();
		MovieHeap heap = new MovieHeap();
		Wishlist wishes = new Wishlist();

		/*
		CustomerNode testNode = new CustomerNode("Jane", 12340000, "jane.doe@conncoll.edu");
		System.out.println(testNode.getName());
		customerBST.insert(testNode);
		System.out.println(customerBST.search(12340000));
		*/

		Scanner s=new Scanner(System.in);
		String pagestatus = "";

		while (!pagestatus.equals("quit")){
			int n = -1;
			if(pagestatus.equals("initialPage"))
			{
				System.out.println("Enter 1 for Admin or 2 for Customer");		
				while(n != 1 && n != 2){
		   			n=s.nextInt();
		   			if (n != 1 && n != 2){
		   				System.out.println("You did not enter 1 or 2");
		   			}
				}
				if(n==1)
					pagestatus="admin";
				else
					pagestatus="user";
			}
		if(pagestatus.equals("admin")){
			System.out.println("This is the Admin page");
			System.out.println("1. Add Movie");
			System.out.println("2. Find movie with the worst Rotten Tomatoes rating");
			System.out.println("3. Search movie by Rotten Tomatoes Scores");
			System.out.println("4. Add Customer");
			System.out.println("5. Delete Customer");
			System.out.println("6. Edit Customer");
			System.out.println("7. Search for Customer");
			System.out.println("8. Return to Main Menu");
			while (n>7 ||  n<1){
					System.out.println("user paga 212312" + n);
					n=s.nextInt();
					if (n>7 ||  n<1)
						System.out.println("Incorrect Key. Please choose valid option.");
			}
			if (n==1)
				pagestatus = "Addmovie";
			else if(n==2)
				pagestatus = "Findworst";
			else if(n==3)
				pagestatus = "RTs";
			else if(n==4)
				pagestatus = "Addcust";
			else if(n==5)
				pagestatus = "Deletecust";
			else if(n==6)
				pagestatus = "Editcust";
			else if(n==7)
				pagestatus = "Searchcust";
			else 
				pagestatus = "initialPage";
		}
		else if (pagestatus.equals("user")){
			int c=0;
			System.out.println("This is the Customer page");
			System.out.println("1. Edit Account");
			System.out.println("2. Access Wishlist");
			System.out.println("3. Search Movies By Date");
			System.out.println("4. Search Movies By ID");
			System.out.println("5. Print Movies By Release Date");
			System.out.println("6. Delete Account");
			System.out.println("7. Return to Main Menu");
			while (n>7 ||  n<1){
					System.out.println("user paga 212312" + n);
					n=s.nextInt();
					if (n>7 ||  n<1)
						System.out.println("Incorrect Key. Please choose valid option.");
			}
			if (n==1)
				pagestatus = "Ea";
			else if(n==2)
				pagestatus = "Ew";
			else if(n==3)
				pagestatus = "Searchmd";
			else if(n==4)
				pagestatus = "Searchid";
			else if(n==5)
				pagestatus = "Printm";
			else if(n==6)
				pagestatus = "DA";
			else 
				pagestatus = "initialPage";
		}
			if (pagestatus.equals("Ea")){
				System.out.println("Enter the credit card number your account is registered under");
				int ccinput = s.nextInt(); //use this to search for this customer in the BST
				System.out.println("What would you like to edit?");
				System.out.println("1. Name");
				System.out.println("2. Credit Card");
				System.out.println("3. Email address");
				System.out.println("4. Go back to user menu");
				int editInput = s.nextInt();

					if (editInput ==1){
						System.out.println("Enter the name you want registered under this account");
						System.out.println("Your current account name is:"+ customerBST.search(ccinput).getName());
						s.nextLine();
						String newName = s.nextLine();
						customerBST.search(ccinput).setName(newName);
						 //change their name

					}
					else if (editInput ==2){
						System.out.println("Enter the credit card number you want registered under this account");
						System.out.println("Your current number is:"+ customerBST.search(ccinput).getCredit());
						int newcc = s.nextInt();
						customerBST.search(ccinput).setCredit(newcc);
						//edit cc
					}
					else if (editInput ==3){
						System.out.println("Enter the email address you want registered under this account");
						System.out.println("Your current account name is:"+ customerBST.search(ccinput).getName());

						//edit email address
					}
					else if (editInput ==4){
						pagestatus = "user";
					}


			}
			//im not sure how the wishlist is accessed
			else if (pagestatus.equals("Ew")){
				System.out.println("2. Acess Wishlist");
				System.out.println("Enter the credit card number your account is registered under");
				int ccinput = s.nextInt();
				System.out.println("What would you like to edit?");
				System.out.println("1. Add a movie to your wishlist");
				System.out.println("2. watch a movie");
				System.out.println("3. Email address");
				System.out.println("4. Go back to user menu");


			}

			else if (pagestatus.equals("Searchmd")){
				System.out.println("3. Search Movies By Date");
				System.out.println("Enter the release date of the movie you want to search.");
				System.out.println("If the release date is October 25th, 2005 enter the date as:");
				System.out.println("Year, month, day: 20051025");
				int dateinput = s.nextInt();
				while (rdBST.search(dateinput) != null){
					System.out.println("there is no movie in our database with that id");
					System.out.println("Enter 1 to return the user main menu, or enter another date");
					dateinput = s.nextInt();
					if (dateinput == 1){
						pagestatus = "user";
					}
					else{
						System.out.println("That movie is in our database:" + rdBST.search(dateinput).getTitle());
						pagestatus = "user";
					}
					
				}
			}
			else if (pagestatus.equals("Searchid")){
				System.out.println("Enter movie ID");
				int movie_ID=s.nextInt();
				if(idBST.search(movie_ID)!=null){
				System.out.println(idBST.search(movie_ID).getTitle());
			}
				else{
				System.out.println("Movie Not Found");
			}
			pagestatus = "user";
			}
			else if (pagestatus.equals("Printm")){
				System.out.println("5. Printing Movies By Release Date");
				rdBST.traverse();
				pagestatus = "user";
			}
			else if (pagestatus.equals("DA")){
				System.out.println("6. Delete Account");
				System.out.println("Enter the credit card number of the count you want to delete:");
				int ccinput1 = s.nextInt();
				System.out.println("This account is registered to" + customerBST.search(ccinput1).getName());
				System.out.println("To delete their account enter 1, to enter 2 to return to the user menu");
				int deleteinput = s.nextInt();
				if (deleteinput == 1){
					customerBST.delete(customerBST.search(ccinput1));
					System.out.println("This customer is no longer registered in our database");
					pagestatus = "user";
				}
				else {
					pagestatus = "user";
				}

			}
			else if (pagestatus.equals("initialPage")){
				System.out.println("7. Returning to Main Menu");
				pagestatus = "initialPage";
			}
		
	
			//ADMIN SECTION



			if (pagestatus.equals("Addmovie")){
				System.out.println("1. Add Movie");
				System.out.println("Enter the title of the movie")
				String newtitle = s.nextLine();
				System.out.println("Enter the release date. If the release is October 25th, 2005 enter the date as:");
				System.out.println("Year, month, day: 20051025");
				int newdate = s.nextInt();
				System.out.println("Enter the rotten tomatoes score for this movie");
				int newscore = s.nextInt();
				System.out.println("Enter the 5 digit ID code");
				int newcode = s.nextInt();
				while (idBST.search(newcode) != null){
					System.out.println("there is already a movie with that code, please enter a new code");
					newcode = s.nextInt();
				}
				MNode newmovie = new MNode(newtitle, newdate, newcode, newscore);
				idBST.insert(newmovie);
				rdBST.insert(newmovie);
				heap.insert(newmovie);
				System.out.println("Your movie was successfully added to the data base");
				
			}
			else if (pagestatus.equals("Findworst")){
				System.out.println("The worst movie in your data base is:");
				if (heap.isEmpty() != true){
					System.out.println(heap.findMin().getTitle());
					System.out.println("It's rotten tomatoes score is:" + heap.findMin().getTitle());
				}
				else{
					System.out.println("There are no movies in the database");
				}
				System.out.println("Enter 1 to delete this movie, otherwise you will be redirected to the Admin menu");
				int decision = s.nextInt();
				if (decision == 1){
					heap.deleteMin();
					System.out.println("The movie has been deleted");
					pagestatus = "admin";
				}
				else{
					pagestatus = "admin";
				}

			}
			else if (pagestatus.equals("RTs")){
				System.out.println("3. Rotten Tomatoes Scores");
				//we dont need this section 
				//we cant search by RT bc they only stored in a heap by RT score and heaps 
				//do not have a search function
			}
			else if (pagestatus.equals("Addcust")){
				System.out.println("4. Add Customer");
				System.out.println("Enter the name of the customer");
				String cname = s.nextLine();
				System.out.println("Enter the customer's credit card number");
				int ccc = s.nextInt();
				System.out.println("Enter the customer's email address");
				String cemail = s.nextLine();
				CustomerNode cnode = new CustomerNode(cname, ccc, cemail);
				customerBST.insert(cnode);
				//Do we need to do anything with the customer's wishlist here????????????????????????
				System.out.println("Enter 1 to insert another customer, enter anyother number to be redirected");
				int decision2 = s.nextInt();
				if (decision2 ==1){
					pagestatus = "Addcust";
				}
				else{
					pagestatus = "admin";
				}
			}
			else if (pagestatus.equals("Deletecust")){
				System.out.println("5. Delete Customer");
				System.out.println("Enter the credit card of the customer you would like to delete");
				int deletecc = s.nextInt();
				if (customerBST.search(deletecc) == null){
					System.out.println("there is no customer with this credit card number in our database");
					pagestatus = "Deletecust";
				}
				else if (customerBST.isEmptyTree() == true){
					System.out.println("There are no customers in the database yet");
					System.out.println("You are being redirected to the admin main menu");
					pagestatus = "admin";
				}
				else{
					System.out.println("You are deleting" + customerBST(deletecc).getName() + "from the database");
					customerBST.delete(customerBST.search(deletecc));
				}
				pagestatus = "admin";
			}
			else if (pagestatus.equals("Editcust")){
				System.out.println("6. Edit Customer");
				System.out.println("Enter the customer's credit card number");
				int editcc = s.nextInt();
				while (customerBST.search(editcc) = null){
					System.out.println("There is no customer under this credit card number");
					System.out.println("if you want to go back to the admin menu enter 1");
					int decision5 = s.nextInt();
					if (decision5 == 1){
						pagestatus = "admin";
					}
					else{
						System.out.println("Enter the customer's credit card number");
						int editcc = s.nextInt();
					}
				}
				System.out.println("1. Edit their name");
				System.out.println("2. Edit their credit card number");
				System.out.println("3. Edit their email address");
				System.out.println("4. Edit another customer");
				int decision4 = s.nextint();
				while (decision4 < 1 || decision4 > 4){
					System.out.println("Incorrect command, please enter the number corresponding to the function you wish to complete");
					System.out.println("1. Edit their name");
					System.out.println("2. Edit their credit card number");
					System.out.println("3. Edit their email address");
					System.out.println("4. Edit another customer");
					int decision4 = s.nextint();
				}
				if (decision4 == 1){
					System.out.println("Enter the new name for this customer");
					String newname1 = s.nextLine();
					customerBST.search(editcc).setName(newname1);
					pagestatus = "Editcust";
				}
				else if (decision4 ==2){
					System.out.pring("Enter the new credit card number for this customer");
					int newcc1 = s.nextInt();
					customerBST.search(editcc).setCredit(newcc1);
					pagestatus = "Editcust";
				}
				else if (decision4 ==3){
					System.out.println("Enter the new email address for this customer");
					String newemail = s.nextLine();
					customerBST.search(editcc).setMail(newemail);
					pagestatus = "Editcust"
				}
				else{
					pagestatus = "Editcust";
				}
			}
			else if (pagestatus.equals("Searchcust")){
				System.out.println("7. Search for Customer");
				System.out.println("Enter the credit card number of the customer you want to search for:");
				int searchcc = s.nextInt();
				if (customerBST.search(searchcc) != null){
					System.out.println("The customer registered under this cc number is:"+ customerBST.search(searchcc).getName());
					System.out.println("If you want to edit this customer's account  enter 1");
					System.out.println("If you want to delete this customer enter 2");
					int ed = s.nextInt();
					if (ed == 1){
						pagestatus = "Editcust";
					}
					else if (ed ==2){
						pagestatus = "Deletecust";
					}
				}
				else{
					System.out.println("There is no customer in the database registered to this cc");
					System.out.println("Enter 1 to search again, otherwise  you will be redirected to the main menu");
					int decision3 = s.nextInt();
					if (decision3 == 1){
						pagestatus = "Searchcust";
					}
					else{
						pagestatus = "admin";
					}
				}
			}
			
			/*
			else if (pagestatus.equals("")){
				System.out.println("Returning to the main menu");
				pagestatus = "initialPage";
			}
			*/
			
		
	}
	}

}


