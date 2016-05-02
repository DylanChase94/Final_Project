/*
PT Prigoda
4/4/16
Customer BST
*/

//sets up the class BST
public class BSTCustomer{
	private CustomerNode root;
	
	//class BST
	public BSTCustomer(){
		root = null;
	}
	
	//checks to see if BST is empty
	public boolean isEmptyTree(){
		return root == null;
	}
	
	//returns the node being searched for
	public CustomerNode search(int key){
		return search2(root,key);
	}
		
	private CustomerNode search2(CustomerNode p,int key){
		if (p == null){
			return null;
		}
		else if (key == p.getKey()){
			return p;
		}
		else if (key < p.getKey()){
			return search2(p.getLeft(),key);
		}
		else{
			return search2(p.getRight(),key);
		}
	}
	
	//inserts a node based on the function insert2
	public void insert(CustomerNode p){
		if (root == null){
			root = p;
		}
		else{
			insert2(root,p);
		}
	}
	
	//checks to see where to insert node
	private void insert2(CustomerNode temp, CustomerNode p){
		if (p.getKey() < temp.getKey()){
			if (temp.getLeft() == null){
				temp.setLeft(p);
			}
			else {
				insert2(temp.getLeft(),p);
			}
		}
		else{
			if (temp.getRight() == null){
				temp.setRight(p);
			}
			else{
				insert2(temp.getRight(),p);
			}
		}
	}
	
	//prints the contentes of root
	public void traverse2(CustomerNode temp){
		if (temp != null){
			traverse2(temp.getLeft());
			System.out.print(temp.getKey()+" ");
			traverse2(temp.getRight());
		}
	}
		
	//prints out contents of root
	public void traverse(){
		if (root != null){
			traverse2(root);
		}
		System.out.println();
	}

	//prints the BST
	public void printTree() {
	printTree2(root);
	System.out.println();
    }

    //prints the BST
    private void printTree2(CustomerNode tree) {
	if (tree != null) {
	    System.out.print(tree.getKey() + " ");
            if (tree.getLeft() != null)
	        System.out.print("Left: " + tree.getLeft().getKey() + " ");
            else
                System.out.print("Left: null ");
            if (tree.getRight() != null)
	        System.out.println("Right: " + tree.getRight().getKey() + " ");
            else
                System.out.println("Right: null ");
	    printTree2(tree.getLeft());
	    printTree2(tree.getRight());
		}
    }
	
	//finds the parent of a node
	private CustomerNode findParent(CustomerNode d){
		CustomerNode temp = root;
		while (temp.getLeft() != d && temp.getRight() != d){
			if (d.getKey() < temp.getKey()){
				temp = temp.getLeft();
			}
			else{
				temp = temp.getRight();
			}
		}
		return temp;
	}
	
	//checks to see if the node has a left or right kid
	private boolean isLeft(CustomerNode p, CustomerNode c){
		if (p.getKey() > c.getKey()){
			return true;
		}
		else {
			return false;
		}
	}
	
	//checks to see what the root is, then deletes and replaces it based on the check
	private void deleteRoot(){
		if (root.getLeft() == null && root.getRight() == null){
			root = null;
		}
		else if (root.getLeft() == null || root.getRight() == null){
			if (root.getLeft() == null){
				root = root.getRight();
			}
			else{
				root = root.getLeft();
			}
		}
		else{
			CustomerNode successor = findSuccessor(root);
			successor.setLeft(root.getLeft());
			if (root.getRight() == successor){
				successor.setRight(null);
			}
			else{
				successor.setRight(root.getRight());
			}
			root = successor;
		}
	}

	//finds the successor of a node
	private CustomerNode findSuccessor(CustomerNode temp){
        CustomerNode s = temp.getRight();
        while (s.getLeft() != null){
        	s = s.getLeft();
        }
        CustomerNode parent = findParent(s);
        if (parent != temp){
        	parent.setLeft(s.getRight());
        }
        return s;

	}

	//case in which there are no kids to delete
	public void deleteNoKids(CustomerNode a){
		CustomerNode parent = findParent(a);
		if (isLeft(parent,a) == true){
			parent.setLeft(null);
		}
		else{
			parent.setRight(null);
		}
	}

	//case in which there is only one kid to delete
	public void deleteOneKid(CustomerNode a){
		CustomerNode parent = findParent(a);
		if (isLeft(parent,a) == true){
			if (a.getLeft() != null){
				parent.setLeft(a.getLeft());
			}
			else{
				parent.setLeft(a.getRight());
			}
		}
		if (isLeft(parent,a) == false){
			if (a.getRight() != null){
				parent.setRight(a.getRight());
			}
			else{
				parent.setRight(a.getLeft());
			}
		}
	}

	//case in which there are two kids to delete
	public void deleteTwoKid(CustomerNode a){
		CustomerNode parent = findParent(a);
		CustomerNode successor = findSuccessor(a);
		if (isLeft(parent,a) == true){
			parent.setLeft(successor);
		}
		else{
			parent.setRight(successor);
		}
		successor.setLeft(a.getLeft());
		if (a.getRight() != successor){
			successor.setRight(a.getRight());
		}
	}

	//the delete method
	public void delete(CustomerNode a) {
    	if(a.getKey() == root.getKey()) {
        	deleteRoot();
    	}
        else if(a.getLeft() == null && a.getRight() == null) {
        	deleteNoKids(a);
        }
        else if(a.getLeft() == null || a.getRight() == null) {
        	deleteOneKid(a);
        }
        else {
        	deleteTwoKid(a);
        }
	}
}	
			