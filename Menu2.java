import java.util.Scanner;

import java.io.*;
import java.util.InputMismatchException;

public class Menu2 implements java.io.Serializable{
	private int n;

	public Menu2(){
		int n=0;

	}	

	public static void main (String[] args){

		//initiate all of the data structures
		HashID idhash= new HashID(); 
		BSTCustomer customerBST = new BSTCustomer();
		MovieHeap heap = new MovieHeap();
		BSTmovie movieBST= new BSTmovie();




		//seralziation for when program is opened 
		try {
	        FileInputStream fileIn = new FileInputStream("BSTMovie.ser");
	       	ObjectInputStream in = new ObjectInputStream(fileIn);
	        movieBST = (BSTmovie) in.readObject();
	        in.close();
	        fileIn.close();
      	}	
      	catch(IOException i) {
        	i.printStackTrace();
        	
    	}
     	catch(ClassNotFoundException c) {
	        System.out.println("BSTmovie class not found");
	        c.printStackTrace();
	        return;
      	}

	
		try {
	        FileInputStream fileIn = new FileInputStream("BSTCustomer.ser");
	       	ObjectInputStream in = new ObjectInputStream(fileIn);
	        customerBST = (BSTCustomer) in.readObject();
	        in.close();
	        fileIn.close();
      	}	
      	catch(IOException i) {
        	i.printStackTrace();
        	
    	}	
     	catch(ClassNotFoundException c) {
	        System.out.println("BSTCustomer class not found");
	        c.printStackTrace();
	        return;
      	}

		
		try {
	        FileInputStream fileIn = new FileInputStream("HashID.ser");
	       	ObjectInputStream in = new ObjectInputStream(fileIn);
	        idhash = (HashID) in.readObject();
	        in.close();
	        fileIn.close();
      	}	
      	catch(IOException i) {
        	i.printStackTrace();
        	
    	}	
     	catch(ClassNotFoundException c) {
	        System.out.println("HashID class not found");
	        c.printStackTrace();
	        return;
      	}

		
		try {
	        FileInputStream fileIn = new FileInputStream("MovieHeap.ser");
	       	ObjectInputStream in = new ObjectInputStream(fileIn);
	        heap = (MovieHeap) in.readObject();
	        in.close();
	        fileIn.close();
      	}	
      	catch(IOException i) {
        	i.printStackTrace();
        	
    	}//catches it if the heap is not found	
     	catch(ClassNotFoundException c) {
	        System.out.println("MovieHeap class not found");
	        c.printStackTrace();
	        return;
      	}

		Scanner s=new Scanner(System.in);
		String pagestatus = "initialPage";
		//run the code until the user quits the program
		while (!pagestatus.equals("quit")){
			int n = -1;
			try{	//initial page, choose admin or user function
				if(pagestatus.equals("initialPage"))
				{	//Prompts the user to be a admin or customer
					System.out.println("Enter 1 for Admin or 2 for Customer");		
					while(n != 1 && n != 2){
			   			n=s.nextInt();
			   			if (n != 1 && n != 2){ //catches if the user didn't type an option
			   				System.out.println("You did not enter 1 or 2");
			   			}
					}
					if(n==1) //takes you to admin page
						pagestatus="admin";
					else //takes you to user page
						pagestatus="user";
				}
			}
			catch(java.util.InputMismatchException ex){
				System.out.println("Please enter a valid input");
				s.nextLine(); //checks to see if input was correct
			}
		if(pagestatus.equals("admin")){ //prints out the functions of the admin page
			System.out.println("This is the Admin page");
			System.out.println("1. Add Movie");
			System.out.println("2. Find movie with the worst Rotten Tomatoes rating");
			System.out.println("3. Add Customer");
			System.out.println("4. Delete Customer");
			System.out.println("5. Edit Customer");
			System.out.println("6. Search for Customer");
			System.out.println("7. Return to Main Menu");
			System.out.println("8. Quit");
			try{ //assumes n is a number between 1 and 8
				while (n>=8 ||  n<=1){
					n=s.nextInt();
					s.nextLine();
					if (n>8 ||  n<1){ //if it isn't, it'll ask the user to try again
						System.out.println("Incorrect Key. Please choose valid option.");
					}
					else{
						break;
					}
				}	
			if (n==1) //takes user to add movie if 1 is pressed
				pagestatus = "Addmovie";
			else if(n==2) //if 2 is pressed, takes user to worst rt score
				pagestatus = "Findworst";
			else if(n==3) //if 3 is pressed, allows admin to add customoer
				pagestatus = "Addcust";
			else if(n==4) //admin can delete customer when 4 is pressed
				pagestatus = "Deletecust";
			else if(n==5) //after 5 is pressed, admin can edit customor info
				pagestatus = "Editcust";
			else if(n==6) //if 6 is pressed, takes admin to search customer page
				pagestatus = "Searchcust";
			else if(n==7) //returns to main menu if 7 is pressed
				pagestatus = "initialPage";
			else //quits the program if 8 is pressed
				pagestatus = "quit";
			}
			catch(java.util.InputMismatchException ex){
				System.out.println("Please enter a valid input");
				s.nextLine();
			}
		}
		else if (pagestatus.equals("user")){ //if user is selected, takes you to user menu
			int c=0; //prints out the user commands
			System.out.println("This is the Customer page");
			System.out.println("1. Edit Account");
			System.out.println("2. Access Wishlist");
			System.out.println("3. Search Movies By Date");
			System.out.println("4. Search Movies By ID");
			System.out.println("5. Print Movies By Release Date");
			System.out.println("6. Delete Account");
			System.out.println("7. Return to Main Menu");
			try{
				n=s.nextInt();
				while (n>=7 &&  n<1){ //makes sure user inputs a number between 0 and 8, so 1-7
					if (n>7 &&  n<1){
						System.out.println("Incorrect Key. Please choose valid option.");
					}
					else{
						break;
					}
				n=s.nextInt();
				}
				if (n==1) //if 1 is pressed, user can edit account
					pagestatus = "Ea";
				else if(n==2) //if 2 is pressed, user can access their wish list
					pagestatus = "Ew";
				else if(n==3) //if 3 is pressed, user can search movies by release date
					pagestatus = "Searchmd";
				else if(n==4) //if 4 is pressed, user can search movies by id
					pagestatus = "Searchid";
				else if(n==5) //if 5 is pressed, movies will be printed by release date
					pagestatus = "Printm";
				else if(n==6) //if 6 is pressed, user can delete their account
					pagestatus = "DA";
				else //if 7 is pressed, return the user to the main menu
					pagestatus = "initialPage";
			}
			catch(java.util.InputMismatchException ex){
				System.out.println("Please enter a valid input");
				s.nextLine();
			}
		}

		try{
			if (pagestatus.equals("Ea")){ //edit account code
				System.out.println("Enter the last 4 digits of the credit card number that your account is registered under");
				int ccinput = s.nextInt(); //has user put in 4-digits of credit card
				if(customerBST.search(ccinput)==null){ //checks to see if customer is in database
					System.out.println("You are not in our database. Press 1 to try again or any other number to go back to the customer menu");
					int ea=s.nextInt();
					if(ea==1){ //if 1 is pressed, runs edit account code
						pagestatus="Ea";
					}
					else{ //if not, takes user back to user menu
						pagestatus="user";
					}

				}

				else{ //greets the customer and gives them options on editing account
					System.out.println("Hello"+" "+ customerBST.search(ccinput).getName());
					System.out.println("What about yourself would you like to edit?");
					System.out.println("1. Name");
					System.out.println("2. Credit Card");
					System.out.println("3. Email address");
					System.out.println("4. Go back to user menu");
					int editInput = s.nextInt();

					if (editInput ==1){ //runs through the edit name if 1 is pressed
						System.out.println("Your current account name is:"+" "+ customerBST.search(ccinput).getName());
						System.out.println("What do you want to change your name to?");
						s.nextLine();
						String newName = s.nextLine(); 
						customerBST.search(ccinput).setName(newName);//sets new name
						System.out.println("Your name has been changed to"+" "+newName); //prints new name
						System.out.println("Press 1 to edit more information or any other number return to the customer page");
						int ei1=s.nextInt();
						if(ei1==1){ //takes user back to edit account if 1 is pressed
							pagestatus="Ea";
						}
						else{ //if not, returns user back to main menu
							pagestatus="user";
						}
					}

					else if(editInput==2){//code for changing user credit card
						System.out.println("Enter the last 4 digits of the credit card you want to change your account to");
						int newcc=s.nextInt();
						customerBST.search(ccinput).setCredit(newcc); //replaces old number with the new one
						System.out.println("Your new cc number has been changed to"+" "+newcc);
						System.out.println("Press 1 to edit more information or any other number return to the customer page");
						int ei2=s.nextInt(); //gives user option to go back to editing account
						if(ei2==1){
							pagestatus="Ea";
						}
						else{ //or go back to user menu
							pagestatus="user";
						}

					}


					else if(editInput==3){ //code for user to edit their email
						System.out.println("Enter the new email address you want your account to be under");
						s.nextLine();
						String newemail=s.nextLine(); 
						customerBST.search(ccinput).setMail(newemail);//replaces old email with new one
						System.out.println("Your new email address has been changed to"+" "+ newemail);
						System.out.println("Press 1 to edit more information or any other number return to the customer page");
						int ei3=s.nextInt();
						if(ei3==1){ //gives user option to go back to edit account page
							pagestatus="Ea";
						}
						else{ //or back to the user menu
							pagestatus="user";
						}

					}

					else if(editInput==4){ //takes user back to customer menu
						pagestatus="user";
					}



			}
		}

			
			else if (pagestatus.equals("Ew")){ //wish list function
				System.out.println("2. Acess Wishlist");
				System.out.println("Enter the last 4 digits your credit card number of your account is registered under");
				int ccinput = s.nextInt(); 
				if(customerBST.search(ccinput)==null){//finds the user by credit card number
					System.out.println("You are not in our database");
					pagestatus="user";
				}
				
				else{ //if the customer is found

					System.out.println("Welcome"+" "+ customerBST.search(ccinput).getName());

					if(customerBST.search(ccinput).getWishlist().isEmpty()){
						System.out.println("Your wishlist is empty");
						pagestatus="user"; //returns wish list is empty
					}
					else{ //if it isn't empty, prints wishlist
						System.out.println("Here is your wishlist:");
						customerBST.search(ccinput).getWishlist().printMovies();
					}
				
					//commands for wish list
				System.out.println("What would you like to edit?");
				System.out.println("1. Add a movie to your wishlist");
				System.out.println("2. Watch your favorite movie");
				System.out.println("3. Delete movie");
				System.out.println("4. Show me my wishlist");
				System.out.println("5. Go back to customer menu");


				int wInput=s.nextInt();
				if (wInput==1){
					if(movieBST.isEmptyTree()){//if no movies in database
						System.out.println("There are currently no movies in the database. Sending you back to customer page");
						pagestatus="user";
					}
					else{
						System.out.println("Here are your choices of movies to add to your wishlist");
						movieBST.traverse(); //list of movies in database
						System.out.println("Enter the release date of the movie you want to add to your wishlist");
						int mchoice = s.nextInt(); //add by release date
						System.out.println("Enter the index");
						int ichoice = s.nextInt(); //and desired slot you want movie in
						customerBST.search(ccinput).getWishlist().insert(movieBST.search(mchoice), ichoice);
						System.out.println("Movie added to wishlist");
						pagestatus="user"; //movie is added to wishlist
					}
				}
				else if (wInput ==2){ //lets user watch favorite movie
					customerBST.search(ccinput).getWishlist().watchMovie();
					pagestatus="user";
				}
				else if (wInput==3){ //delete movie from wish list
					customerBST.search(ccinput).getWishlist().printMovies();
					System.out.println("Enter the index number of the movie you want to delete from your wishlist");
					int deletew = s.nextInt(); //delete movie at this index
					customerBST.search(ccinput).getWishlist().delete(deletew);
					System.out.println("Your movie has been deleted");

				}
				//shows user their wish list
				else if(wInput==4){ 
	                 //if wishlist is empty
					if(customerBST.search(ccinput).getWishlist().isEmpty()){
						System.out.println("You have nothing in your wishlist. Redirecting you back to the customer menu");
						pagestatus="user";
					}
					else{

					customerBST.search(ccinput).getWishlist().printMovies();
					pagestatus="user";
					}
				}



				else if (wInput ==5){ //takes user back to user menu
					pagestatus = "user";
				}
			}


			}
		

			else if (pagestatus.equals("Searchmd")){ //search movies by date and instructions for it
				System.out.println("3. Search Movies By Date");
				System.out.println("Enter the release date of the movie you want to search.");
				System.out.println("If the release date is October 25th, 2005 enter the date as:");
				System.out.println("Year, month, day: 20051025");
				int dateinput = s.nextInt(); 
				if (movieBST.search(dateinput) == null){//checks to see if movie is in database
					System.out.println("There is no movie in our database with that date");
					System.out.println("Enter 1 to return the customer main menu or 2 to try again");
					dateinput = s.nextInt();
					if (dateinput == 1){ //user can either return to the user menu
						pagestatus = "user";
					}
					else{ //or search for another movie by release date
						pagestatus="Searchmd";
					}	
				
				}

				else{ //if it is in the data base
					System.out.println("That movie in our database is:" + movieBST.search(dateinput).getTitle());
					
					System.out.println("Press 1 to return to the customer main menu or 2 to search again");
					int dateinput1=s.nextInt(); //says it is in the data base
					if(dateinput1==1){ //either return to the menu
						pagestatus="user";
					}
					else{ //or search for another movie by date
						pagestatus="Searchmd";
					}

				}
			}

			//search movie by id
			else if (pagestatus.equals("Searchid")){
				System.out.println("Enter movie ID");
				int movie_ID=s.nextInt();
				if(idhash.lookUp(movie_ID)!= null){ //prints movie you searched for
					System.out.println("You searched for:"+idhash.lookUp(movie_ID));		
				
				}
				else{ //or if the id doesn't match with any in the data base, asks you to try again

					System.out.println("Movie Not Found,try again");
					
						
				}
			pagestatus = "user";
			} 
			//prints movies in order by release date
			else if (pagestatus.equals("Printm")){
				if(movieBST.isEmptyTree()==false){ //there are movies in the data base
					System.out.println("5. Printing Movies By Release Date");
					movieBST.traverse();
					pagestatus = "user";
				}
				else{ //if there aren't any movies in the database, doesn't print anything
					System.out.println("There are no movies in the database");
					pagestatus="user";
				}
			}//delete user account
			else if (pagestatus.equals("DA")){
				System.out.println("6. Delete Account");
				System.out.println("Enter the last 4 digits of the credit card number of the account you want to delete:");
				int ccinput1 = s.nextInt(); //finds account based off of credit card code
				if (customerBST.search(ccinput1)!=null){
					System.out.println("This account is registered to"+" " + customerBST.search(ccinput1).getName());
					System.out.println("To delete their account enter 1, to enter 2 to return to the user menu");
					int deleteinput = s.nextInt();
					if (deleteinput == 1){ //deletes the account if 1 is pressed
						customerBST.delete(customerBST.search(ccinput1));
						System.out.println("You are no longer registered in the database");
						pagestatus = "user";
					}
					else { //if not, returns user to the user menu, account is not deleted
						pagestatus = "user";
					}

				}

				else{ //or if the credit card code doesn't work, takes you back to user menu
					System.out.println("There are no customers with that CC number in the database");
					pagestatus="user";
				}

			}
				



			else if (pagestatus.equals("initialPage")){ //returns user to main menu
				System.out.println("7. Returning to Main Menu");
				pagestatus = "initialPage";
			}
		}
		catch(java.util.InputMismatchException ex){ //makes sure user actually inputs a valid choice
				System.out.println("Please enter a valid input");
				s.nextLine();
			}
		
		
	
			//ADMIN SECTION

		try{
			//movies leaving database when running the program again
			if (pagestatus.equals("Addmovie")){
				System.out.println("1. Add Movie");
				System.out.println("Enter the title of the movie");
				String newtitle = s.nextLine(); //saves title
				System.out.println("Enter the release date. If the release is October 25th, 2005 enter the date as:");
				System.out.println("Year, month, day: 20051025"); //and release date
				int newdate = s.nextInt();
				System.out.println("Enter the rotten tomatoes score for this movie");
				int newscore = s.nextInt(); //saves rt score
				System.out.println("Enter the 5 digit ID code");
				int newcode = s.nextInt(); //and the id
				
				boolean checkid = true; //now movie is in stock
				while (checkid == true){
					if (idhash.lookUp(newcode) == null){
						checkid = false;
					}
					else{ //makes sure this movie doesn;t already exist
					System.out.println("There is already a movie with that code, please enter a new code");
					newcode = s.nextInt();
					}
				}
				
				MNode newmovie = new MNode(newtitle, newdate, newcode, newscore);
				
				movieBST.insert(newmovie); //insert movie in the bst
				idhash.insert(newmovie);
				System.out.println("inserting "+idhash.lookUp(newmovie.getCode()));
				heap.insert(newmovie); //inserts movie in a heap by id code
				System.out.println("Your movie was successfully added to the database");
				n = 0;
				pagestatus = "admin"; //once movie is added, return to the admin page
				
			}
			else if (pagestatus.equals("Findworst")){ //find movie with the worst rt score
				if (heap.isEmpty() != true){ //if there are movies in the database
					System.out.println("The worst movie in your data base is:"+heap.findMin().getTitle());
					int t=heap.findMin().getRTscore(); //returns movie with the worst rt score
					System.out.println("Its rotten tomatoes score is:" + t+" "+ "Its movie ID is:"+" "+ heap.findMin().getCode());
					//gives user choice to delete movie
					System.out.println("Enter 1 to delete this movie, otherwise you will be redirected to the Admin menu");
					int decision = s.nextInt();
				    if (decision == 1){
				    	
						//check to make sure the data structures arent empty first
					
						MNode delNode = movieBST.search(heap.findMin().getRdate());
						boolean isitinstock = false;
						heap.findMin().changeStatus(isitinstock);
						movieBST.delete(delNode);
						idhash.delete(heap.findMin().getCode());
						heap.deleteMin();
					
			     		pagestatus = "admin"; //return user to admin page
					}
					else{
						pagestatus = "admin";
					}
				}


				else{ //if there are no movies in the database
					System.out.println("There are no movies in the database");
					System.out.println("Press any number to return to the admin page");
					int no_movie=s.nextInt(); //asks user to return to the admin page
					if(no_movie >= 0){
						pagestatus="admin";
					}
			}
		}

			
			else if (pagestatus.equals("Addcust")){ //code to add customer 
				System.out.println("3. Add Customer");
				System.out.println("Enter the name of the customer");
				String cname = s.nextLine(); //saves their name
				System.out.println("Enter the customer's last 4 digits of CC number");
				int ccc = s.nextInt(); //and last 4 digits of credit card
				System.out.println("Enter the customer's email address");
				s.nextLine(); //along with their email
				String cemail = s.nextLine();
				CustomerNode cnode = new CustomerNode(cname, ccc, cemail);
				customerBST.insert(cnode); //saves customer info in a node called CustomerNode
				System.out.println("                          ");
				System.out.println("Customer added to database"); //customer is added
				//gives option to add another customer
				System.out.println("Enter 1 to insert another customer, enter any other number to be redirected back to the admin page");
				int decision2 = s.nextInt();
				if (decision2 ==1){
					pagestatus = "Addcust";
					s.nextLine(); //add new customer
				}
				else{ //if not, return to admin page
					pagestatus = "admin";
				}
			}
			
			else if (pagestatus.equals("Deletecust")){ //delete customer
				System.out.println("4. Delete Customer");
				System.out.println("Enter the last 4 digits of the credit card of the customer you would like to delete");
				int deletecc = s.nextInt(); //find customer by credit card code
				if (customerBST.search(deletecc) == null){
					System.out.println("there is no customer with this credit card number in our database");
					pagestatus = "admin"; //retunrs to admin page if customer doesn't exist
				}
				else if (customerBST.isEmptyTree() == true){ //or if there are no customers at all
					System.out.println("There are no customers in the database yet");
					System.out.println("You are being redirected to the admin main menu");
					pagestatus = "admin"; //also returns admin to the admin menu
				}
				else{   //if customer does exist
					System.out.println("You deleted" + " " + customerBST.search(deletecc).getName()+" " + "from the database");
					customerBST.delete(customerBST.search(deletecc)); //deletes the customer
					System.out.println("If you want to delete another customer, press 1");
					System.out.println("If you want to return to the admin menu, press any other number");
					int z=s.nextInt(); //gives option to delete another or return to the menu
					if(z==1){
						pagestatus="Deletecust"; //takes user back to deletecust page
					}
					else{
						pagestatus="admin"; //return to admin menu
					}
				}
				
			}
			
			else if (pagestatus.equals("Editcust")){ //edit customer's info
				System.out.println("5. Edit Customer");
				System.out.println("Enter the customer's last 4 digits of credit card number");
				int editcc = s.nextInt(); //find customer with credit card code
				if (customerBST.search(editcc) == null){ //if customer doesn't exist
					System.out.println("There is no customer under this credit card number");
					System.out.println("If you want to go back to the admin menu enter 1");
					System.out.println("If you want to search for another customer,press a different number");
					int decision5 = s.nextInt(); //either search for another or return to menu
					if (decision5 == 1){
						pagestatus = "admin"; //return to menu
					}
					else{
						pagestatus.equals("Editcust"); //search for another
					}
				}

				else if (customerBST.search(editcc)!= null){ //if customer is found
					System.out.println("You are editing"+" "+ customerBST.search(editcc).getName());
					System.out.println("1. Edit their name");
					System.out.println("2. Edit their credit card number");
					System.out.println("3. Edit their email address");
					System.out.println("4. Edit another customer");
					System.out.println("5. Return to Admin menu");
					int decision4 = s.nextInt(); //5 choices for the admin

				    if (decision4 < 1 || decision4 > 5){ //need to choose whole number from 1 to 5
						System.out.println("Incorrect command, please enter the number corresponding to the function you wish to complete");
						System.out.println("1. Edit their name");
						System.out.println("2. Edit their credit card number");
						System.out.println("3. Edit their email address");
						System.out.println("4. Edit another customer");
						System.out.println("5. Return to Admin menu");
						decision4 = s.nextInt();
					}

					else if (decision4 == 1){ //edit name
						System.out.println("Enter the new name for this customer");
						s.nextLine(); //sets new name in for the old one
						String newname1 = s.nextLine();
						customerBST.search(editcc).setName(newname1);
						System.out.println("Name changed to" + " " + newname1); //shows new name
						System.out.println("                                   ");
						System.out.println("Press 1 to edit another customer's infromation");
						System.out.println("Press any other number to return to the admin page");
						int temp=s.nextInt(); //either edit customer more or return to menu
						if(temp==1){
							pagestatus="Editcust"; //edit again
						} 
						else{
							pagestatus="admin"; //return to menu
						}
					}

					else if (decision4 ==2){ //edit credit card
						System.out.print("Enter the 4 digit credit CC number you want to change to:");
						int newcc1 = s.nextInt(); //sets old number with new one
						customerBST.search(editcc).setCredit(newcc1);
						System.out.println("Credit card changed to" + " " + newcc1); //shows new number
						System.out.println("                                   ");
						System.out.println("Press 1 to edit another customer's infromation");
						System.out.println("Press any other number to return to the admin page");
						int temp1=s.nextInt();
						if(temp1==1){
							pagestatus="Editcust";//either edit more info
						}
						else{
							pagestatus="admin"; //or return to menu
						}
						
					}
					else if (decision4 ==3){ //edit email
						System.out.println("Enter the new email address for this customer");
						s.nextLine(); //sets new email in place of old one
						String newemail = s.nextLine();
						customerBST.search(editcc).setMail(newemail);
						System.out.println("New email changed to"+" "+ newemail); //displays new email
						System.out.println("                                   ");
						System.out.println("Press 1 to edit another customer's infromation");
						System.out.println("Press any other number to return to the admin page");
						int temp2=s.nextInt();
						if(temp2==1){
							pagestatus="Editcust"; //edit more info
						}
						else{
							pagestatus="admin";//or return to the menu
						}
						
					}

					else if(decision4==4){ //edit a different customer
						pagestatus = "Editcust"; //takes you back to search for customer you want to edit
					}
					else if (decision4==5){ //returns back to admin user
						pagestatus="admin";
					}
				}
			}



			
			else if (pagestatus.equals("Searchcust")){ //search customer with 4-digit cc number
				System.out.println("6. Search for Customer");
				System.out.println("Enter the last four digits of the customers credit card number:");
				int searchcc = s.nextInt(); //looks for customer with corresponding number
				if (customerBST.search(searchcc) != null){ //if customer is found
					System.out.println("The customer registered under this cc number is:"+" " +customerBST.search(searchcc).getName());
					System.out.println("Their email address is" +" "+ customerBST.search(searchcc).getMail());
					System.out.println("If you want to edit this customer's account enter 1");
					System.out.println("If you want to delete this customer enter 2");
					System.out.println("If you want to go back to the Admin page, press 3");
					int ed = s.nextInt(); //gives admin 3 options
					if (ed == 1){
						pagestatus = "Editcust"; //edit customer
					}
					else if (ed ==2){
						pagestatus = "Deletecust"; //delete customer
					}

					else if (ed==3){
						pagestatus = "admin"; //or return to admin menu
					}
				}
				else{	//if customer isn't found
					System.out.println("There is no customer in the database registered to this cc");
					System.out.println("Enter 1 to search again, otherwise  you will be redirected to the main menu");
					int decision3 = s.nextInt();
					if (decision3 == 1){ //can either search again
						pagestatus = "Searchcust";
					}
					else{	//or return to admin menu
						pagestatus = "admin";
					}
				}
			}
		}
		catch(java.util.InputMismatchException ex){ //makes sure admin puts in a valid output
				System.out.println("Please enter a valid input");
				s.nextLine();
			}
	}

		//Seralization for when user quits program
		//saves movies in .ser files 
		try{
			FileOutputStream fileOut = 
			new FileOutputStream("BSTMovie.ser"); 
			ObjectOutputStream out = 
			new ObjectOutputStream(fileOut); //creates new file output
			out.writeObject(movieBST);
			out.close(); //closes movies
			fileOut.close();
			System.out.println("serialized object succesfully in BSTMovie.ser"); //saves everything in database
		}
		catch(IOException i) {
			i.printStackTrace();
		}

      	try{
			FileOutputStream fileOut = 
			new FileOutputStream("BSTCustomer.ser");
			ObjectOutputStream out = 
			new ObjectOutputStream(fileOut);
			out.writeObject(customerBST);
			out.close();
			fileOut.close();
			System.out.println("serialized object succesfully in BSTCustomer.ser");
		}
		catch(IOException i) {
			i.printStackTrace();
		}

      	try{
			FileOutputStream fileOut = 
			new FileOutputStream("HashID.ser");
			ObjectOutputStream out = 
			new ObjectOutputStream(fileOut);
			out.writeObject(idhash);
			out.close();
			fileOut.close();
			System.out.println("serialized object succesfully in HashID.ser");
		}
		catch(IOException i) {
			i.printStackTrace();
		}

      	try{
			FileOutputStream fileOut = 
			new FileOutputStream("MovieHeap.ser");
			ObjectOutputStream out = 
			new ObjectOutputStream(fileOut);
			out.writeObject(heap);
			out.close();
			fileOut.close();
			System.out.println("serialized object succesfully in MovieHeap.ser");
		}
		catch(IOException i) {
			i.printStackTrace();
		}
	}
}