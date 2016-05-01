//movie node

public class mNode {
	private String title;
	private int release;
	private int code;
	private int rtScore;
	private boolean inStock;
	private Node right;
	private Node left;

	//instance variables of the node class
	public mNode(String title0, int release0, int code0, int rtScore0){
		title = title0;
		release = release0;
		code = code0;
		rtScore = rtScore0;
		inStock = true;
		right = null;
		left = null;
	}

	public int getRdate(){
		return release;
	}
	public String getTitle(){
		return title;
	}
	public int getRTscore(){
		return  rtScore;
	}
	public int getCode(){
		return code;
	}
	public Node getRight(){
		return right;
	}
	public boolean checkStock(){
		return inStock;
	}
	public Node getLeft(){
		return left;
	}



	//to set the name of a node, make its name = to name0
	public void setTitle(String name0){
		title = title0;
	}
	public void setRdate(int release0){
		release = release0;
	}
	public void setRTscore(int rtScore0){
		rtScore = rtScore0;
	}
	public void setCode(int code0){
		code = code0;
	}
	public void changeStatus(boolean inStock0){
		inStock = inStock0;
	}
	public void setLeft(Node next){
		left = next;
	}
	public void setRight(Node next){
		right = next;
	}

}

