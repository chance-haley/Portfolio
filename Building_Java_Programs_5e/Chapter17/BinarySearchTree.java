import java.util.*;
/**
 * Binary Search Tree
 */
public class BinarySearchTree{
	private TreeNode root;
	
	/**
	 * Constructor
	 */
	public BinarySearchTree(){
		root = null;
	}
	
	/**
	 * Searches the BST for the given value.
	 * 
	 * @param value the value to find
	 * @return true if the value exists in the BST
	 */
	public boolean contains(int value){
		return contains(value, root);
	}
	
	private boolean contains(int value, TreeNode node){
		if(node == null){
			return false;
		}
		if(value == node.getData()){
			return true;
		}
		if(value > node.getData()){
			return contains(value, node.getRight());
		}
		return contains(value, node.getLeft());
	}
	/**
	 * Removes any nodes from the list that are greater than max or lower than min.
	 * 
	 * @param max the integer value that will be the highest possible remaining after running.
	 * @param min the integer value that will be the lowest possible remaining after running.
	 */
	public void trim(int max, int min){
		trim(max,min,root);
	}
	private void trim(int max, int min, TreeNode temp){
		int data = temp.getData();
		
		if(data<max){
			if(temp.getRight() != null){
				trim(max,min,temp.getRight());
			}
		}
		if(data>max){
			while(temp.getRight() != null){
				TreeNode temp2 = temp.getRight();
				remove(temp2.getData());
			}
			remove(temp.getData());
		}
		
		if(data>min){
			if(temp.getRight() != null){
				trim(max,min,temp.getLeft());
			}
		}
		if(data<min){
			while(temp.getLeft() != null){
				TreeNode temp2 = temp.getLeft();
				remove(temp2.getData());
			}
			remove(temp.getData());
		}
		
	}
	/**
	 * Removes any nodes from the BST that have 0 children ie leaves
	 * 
	 */
	public void removeLeaves(){
		removeLeaves(root);
		
	}
	private void removeLeaves(TreeNode temp){
		
		if(temp.getRight() ==null && temp.getLeft()==null){
			remove(temp.getData());
			return;
		}
		if(temp.getRight() !=null){
			removeLeaves(temp.getRight());
		}
		if(temp.getLeft() != null){
			removeLeaves(temp.getLeft());
		}
	}
	
	private TreeNode getRoot(){
		return root;
	}
	/**
	 * Compares another BST and returns true if they are equal is order and elements.
	 * 
	 * @param other the BST you wish to compare.
	 * @return true if they are functionally equal, otherwise return false.
	 */
	public boolean equals(BinarySearchTree other){
		TreeNode root2 = other.getRoot(); //needed so we don't change the tree
		
		return equals(root,root2);
	}
	private boolean equals(TreeNode temp, TreeNode temp2){
		if( temp == null && temp2 ==null) return true;
		if( temp != null && temp2 ==null) return false;
		if( temp == null && temp2 !=null) return false;
		
		boolean placeholder = equals2(temp,temp2);
		
		if(temp.getRight() == null && temp.getRight() != null) return false;
		if(temp.getRight() != null && temp.getRight() == null) return false;
		placeholder = equals(temp.getRight(), temp2.getRight());
		if(placeholder == false) return false;
		
		if(temp.getLeft() == null && temp.getLeft() != null) return false;
		if(temp.getLeft() != null && temp.getLeft() == null) return false;
		placeholder = equals(temp.getLeft(), temp2.getLeft());
		
		if(placeholder == false) return false;
		else{ return true;}
	}
	
	
	private boolean equals2(TreeNode temp, TreeNode temp2){
		return temp.getData() == temp2.getData();
	}
	/**
	 * Returns true if every node within the BST has either 0 or 2 children.
	 * 
	 * @return true if the BST is full, otherwise return false.
	 */
	public boolean isFull(){
		if(root ==null) return true;
		return isFull(root);
	}
	private boolean isFull(TreeNode temp){
		return hasLeftAndRightOrNone(temp) & hasLeftAndRightOrNone(temp.getRight()) & hasLeftAndRightOrNone(temp.getLeft());
	}
	
	private boolean hasLeftAndRightOrNone(TreeNode temp){
		if(temp.getRight() !=null && temp.getLeft() !=null) return true;
		if(temp.getRight() ==null && temp.getLeft() == null) return true;
		return false;
	}
	
	/**
	 * Adds a new value to the BST.
	 * 
	 * @param value The new value to be added to the BST.
	 */
	public void add(int value){
		root = add(value, root);
	}
	
	private TreeNode add(int value, TreeNode temp){
		if(temp == null){
			temp = new TreeNode(value);
		}
		else if(value <= temp.getData()){
			temp.setLeft(add(value, temp.getLeft()));
		}else{
			temp.setRight(add(value, temp.getRight()));
		}
		return temp;
	}
	/**
	 * Removes the given value from the BST.
	 * 
	 * @param value The value to remove
	 * @throws NoSuchElementException if the root is null.
	 */
	public void remove(int value){
		if(root == null){
			throw new NoSuchElementException();
		}
		root = remove(value, root);
	}
	private TreeNode remove(int value, TreeNode temp){
		if(temp == null){
			return temp;
		}
		if(value < temp.getData()){
			temp.setLeft(remove(value, temp.getLeft()));
		}else if(value > temp.getData()){
			temp.setRight(remove(value, temp.getRight()));
		}else{
			if(temp.getLeft()==null&& temp.getRight()==null){
				return null;
			}
			if(temp.getLeft()!=null && temp.getRight()==null){
				return temp.getLeft();
			}
			if(temp.getLeft()==null && temp.getRight()!=null){
				return temp.getRight();
			}
			temp.setData(max(temp.getLeft()));
			temp.setLeft(remove(temp.getData(), temp.getLeft()));
		}
		return temp;
	}
	private int max(TreeNode node){
		if(node == null){
			throw new IllegalArgumentException("max does not exist");
		}
		if(node.getRight() == null){
			return node.getData();
		}
		return max(node.getRight());

	}
	private void printRight(){ //for testing
		printRight(root);
	}
	private void printRight(TreeNode temp){ //for testing
	temp= root;
	while(temp != null){
		System.out.println(temp.getData());
		temp= temp.getRight();
		}
	}
	/**
	 * Prints the BST to the terminal horizontally. 
	 */
	public void printBST(){
		printBST(root, "");
	}
	
	private void printBST(TreeNode temp, String padding){
		if(temp == null){
			return;
		}
		printBST(temp.getRight(), padding+ "   ");
		System.out.println(padding + temp.getData());
		printBST(temp.getLeft(), padding+ "   ");
	}
	public static void main(String[]args){
		BinarySearchTree test = new BinarySearchTree();
		BinarySearchTree test2 = new BinarySearchTree();
		BinarySearchTree test3 = new BinarySearchTree();
		BinarySearchTree test4 = new BinarySearchTree();
		BinarySearchTree testnull = new BinarySearchTree();
		
		test.add(25);
		test.add(14);
		test.add(30);
		test.add(35);
		test.add(29);
		test.add(31);
		test.add(42);
		test.add(7);
		test.add(15);
		
		test3.add(25);
		test3.add(14);
		test3.add(30);
		test3.add(35);
		test3.add(29);
		test3.add(31);
		test3.add(42);
		test3.add(7);
		test3.add(15);
		test3.add(28);

		
		test2.add(80);
		test2.add(60);
		test2.add(65);
		test2.add(64);
		test2.add(92);
		test2.add(89);
		
		test4.add(25);
		test4.add(14);
		test4.add(30);
		test4.add(35);
		test4.add(29);
		
		//test.printRight();
		
		test.printBST();
		System.out.println("--------------");
		test2.printBST();
		System.out.println("--------------");
		test3.printBST();
		System.out.println("--------------");
		test4.printBST();
		System.out.println("--------------");
		
		test.trim(31,15);
		
		test.printBST();
		//test.removeLeaves();
		//test3.removeLeaves();
		//test.trim(31,15);
		//test3.trim(31,29);
		
		//test.printBST();
		//System.out.println("--------------");
		//test3.printBST();
		//System.out.println(test.equals(test3));
		//System.out.println(test.equals(test2));
		//System.out.println(test.equals(test4));
		//System.out.println(test2.isFull());
		
	}
}
