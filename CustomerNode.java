/*
PT Prigoda
3/7/16
Assignment Zero
*/

//creates a class with strings, nodes, a wishlist, and integers
public class CustomerNode implements java.io.Serializable{
	private String name;
	private int credit;
	private String mail;
	private CustomerNode next;
	private CustomerNode left;
	private CustomerNode right;
	private Wishlist wishlist;
	
	//gives those variables different names
	public CustomerNode(String name0, int credit0, String mail0){
		name = name0;
		credit = credit0;
		mail = mail0;
		wishlist = new Wishlist();
	}
	
	public int getKey(){ //gets the key by taking the last 4 digits of the user's credit card number
		return credit%10000;
	}
		
	public String getName(){ //gets the name of the customer
		return name;
	}
	
	public int getCredit(){ //gets the user's credit card number
		return credit;
	}
	
	public void setNext(CustomerNode newNext){ //sets a value for the next node
		next = newNext;
	}
		
	public void setCredit(int credit0){ //sets a new credit card number
		credit = credit0;
	}
	
	public CustomerNode getNext(){ //gets the next node
		return next;
	}
	
	public void setName(String newName){ //sets the name of a new user
		name = newName;
	}

	public String getMail(){ //gets the user's email
		return mail;
	}

	public void setMail(String mail0){ //sets the email into the database
		mail = mail0;
	}

	public CustomerNode getRight(){ //gets the right child of a node
		return right;
	}
	
	public CustomerNode getLeft(){ //gets the left child of a node
		return left;
	}

	public void setRight(CustomerNode newRight){ //allows to set something in the right slot
		right = newRight;
	}
	
	public void setLeft(CustomerNode newLeft){ //allows to set something in the left slot
		left = newLeft;
	}

	public Wishlist getWishlist(){ //gets the customer's wish list
		return wishlist;
	}
}

