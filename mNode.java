


public class mNode {
	private String name;
	private int release;
	private

	private Node next;
	private String email;
	//instance variables of the node class
	public cNode(String name0, int cc, String email){
		name = name0;
		cc = cc0;
		next = null;
		email = email0;
	}
	// these are the methods that the node class uses
	//to get the ssn of a node, just return its ssn.
	public int getcc(){
		return cc;
	}
	// just return the name, which is a string
	public String getName(){
		return name;
	}
	//the key is the last four digits of a ssn, so we can get it by
	//returning the mod 10000 of the ssn
	public int getKey(){
		return  cc % 10000;
	}
	//to get the next node, just return what the pointer is pointing to
	public Node getNext(){
		return next;
	}
	//to set the name of a node, make its name = to name0
	public void setName(String name0){
		name = name0;
	}
	//to set the next node, make its pointer point to next0
	public void setNext(Node next0){
		next = next0;
	}
	//to set the ssn, make its ssn equal to ssn0
	public void setSSN(int ssn0){
		ssn = ssn0;
	}
	public void setEmail(String email0) {
		email = email0;
	}
}

