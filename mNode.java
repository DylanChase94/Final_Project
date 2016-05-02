//movie node

public class mNode implements java.io.Serializable{
	private String title;
	private int release;
	private int code;
	private int rtScore;
	private boolean inStock;
	private mNode right;
	private mNode left;

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
	public mNode getRight(){
		return right;
	}
	public boolean checkStock(){
		return inStock;
	}
	public mNode getLeft(){
		return left;
	}



	//to set the name of a node, make its name = to name0
	public void setTitle(String title0){
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
	public void setLeft(mNode next){
		left = next;
	}
	public void setRight(mNode next){
		right = next;
	}
	/*
	public static void main(String[] args){
		mNode x = new mNode("jack", 1234, 00000, 1);
		System.out.println(x.getCode());
		System.out.println(x.getRTscore());
		System.out.println(x.getRdate());
		mNode y = new mNode("jill", 1111, 123456, 2);
		x.setRight(y);
		System.out.println(x.getRight().getTitle());
	}
	*/
}

