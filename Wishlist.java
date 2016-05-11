/*
PT Prigoda
5/1/16
Final Project
*/
import java.io.*;

public class Wishlist implements java.io.Serializable{
	private MNode[] wishlist;
	private int n;

	public Wishlist(){
		wishlist = new MNode[20];
		n = 0;
	}

	public Boolean isEmpty(){
		return n==0;
	}

//user inputs wrong nmber check at menu
	public void delete(int index){
		n--;
		for(int i = index; i < n; i++){
			wishlist[i] = wishlist[i + 1];
		}
	}

	public void insert(MNode newNode, int index){
		n++;
		if (n != 0){
			for (int i = n; i >= index; i--){
				wishlist[i] = wishlist[i-1];
			}
		}
		wishlist[index-1] = newNode;
	}

	public void watchMovie(){
		if (wishlist[0].checkStock()){
			System.out.println("You are now watching your favorite movie.");
		}
		else{
			System.out.println("Movie no longer avalible.");
		}
		delete(0);
    }

    public void printMovies(){
    	for(int i = 0; i < n; i++){
    		if (wishlist[i] == null){
    			System.out.println("You have no movie in this position:"+i);

    		}
    		else{
    		System.out.println(wishlist[i].getTitle());
    		System.out.println(wishlist[i].getCode());
    		}
    	}
    }
}