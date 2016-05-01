/*
PT Prigoda
3/7/16
Assignment Zero
*/

public class Node implements java.io.Serializable{
	private String name;
	private int credit;
	private String mail;
	private Node next;
	private Wishlist wishlist;
	
	public Node(String name0, int credit0, String mail0){
		name = name0;
		credit = credit0;
		mail = mail0;
	}
	
	public int getKey(){
		return credit%10000;
	}
		
	public String getName(){
		return name;
	}
	
	public int getCredit(){
		return credit;
	}
	
	public void setNext(Node newNext){
		next = newNext;
	}
		
	public void setCredit(int credit0){
		credit = credit0;
	}
	
	public Node getNext(){
		return next;
	}
	
	public void setName(String newName){
		name = newName;
	}

	public String getMail(){
		return mail;
	}

	public void setMail(String mail0){
		mail = mail0;
	}
}