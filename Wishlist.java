/*
PT Prigoda
5/1/16
Final Project
*/
import java.io.*;

public class Wishlist implements java.io.Serializable{
	private MNode[] wishlist; //creates a wish list
	private int n; //counter variable

	public Wishlist(){
		wishlist = new MNode[20];  //sets the limit of the wish list to 20 movies
		n = 0; //counter variable starts at 0
	}

	public Boolean isEmpty(){
		return n==0;  //list is empty if n is equal to zero
	}

//user inputs wrong number check at menu
	public void delete(int index){
		n--; //accumulate list downward by 1
		for(int i = index; i < n; i++){ //runs through the wish list
			wishlist[i] = wishlist[i + 1]; //moves everything closer to the front of the list
		}
	}

	public void insert(MNode newNode, int index){
		n++; //accumulate list upward by 1
		if (n != 0){
			for (int i = n; i >= index; i--){ //runs through the wish list
				wishlist[i] = wishlist[i-1]; //moves everything back 
			}
		}
		wishlist[index-1] = newNode; //the new wishlist with newNode added to it
	}

	public void watchMovie(){
		if (wishlist[0].checkStock()){ //checks the first movie in the wishlist
			System.out.println("You are now watching your favorite movie.");
		}
		else{ //if it isn't there, prints that it is no longer available
			System.out.println("Movie no longer avalible.");
		}
		delete(0); //deletes the movie once you are done watching it
    }

    public void printMovies(){
    	for(int i = 0; i < n; i++){ //runs through the wishlist
    		if (wishlist[i] == null){ //returns there is no movie in the 'i' location
    			System.out.println("You have no movie in this position:"+i);

    		}
    		else{ //if the movie is there then it prints the title and code
    		System.out.println(wishlist[i].getTitle());
    		System.out.println(wishlist[i].getCode());
    		}
    	}
    }
}