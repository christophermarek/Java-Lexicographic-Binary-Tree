/**
 * 
 * @author Christopher Marek
 * Student Number: 251034808
 * Course: Comp Sci 1027b
 * Assignment 4
 * 
 * This class uses a linked structure to implement
 * a binary search tree. The nodes of this tree are of the
 * provided class BinSearchTreeNode
 * 
 */

public class BinSearchTree {

	/**
	 * This is reference variable to the root node
	 * of the binary search tree
	 */
	private BinSearchTreeNode root;
	
	
	/**
	 * Create an empty Binary Search Tree
	 */
	public BinSearchTree() {
		this.root = null;
	}
	
	/**
	 * Returns the node of the binary search
	 * tree storing searchWord, or null if no node stores it
	 * @param searchWord
	 * @return
	 */
	public BinSearchTreeNode getWord(String searchWord) {
		
		if(root == null) {
			return null;
		}else if(root.getWord().equals(searchWord)) {
			return root;
		}else{
			BinSearchTreeNode node = search(root, searchWord);
			return node;
		}
	}
	
	/**
	 * Recursive method that traverses the binary tree
	 * to find the searchWord
	 * 
	 * @param r
	 * @param searchWord
	 * @return
	 */
	private BinSearchTreeNode search(BinSearchTreeNode r, String searchWord) {

		if(r == null){
			return null;
		}else if(r.getWord().equals(searchWord)){
			return r;
		}else if(searchWord.compareTo(r.getWord()) < 0){
			return search(r.getLeft(), searchWord);
		}else{
			return search(r.getRight(), searchWord);
		}

	}
	
	/**
	 * This method inserts the word into the lexicon if it doesnt exist
	 * or it gets added as a reference if it already exists into the 
	 * linked list with its position of appearance and filename
	 * @param theWord
	 * @param theFileName
	 * @param thePosition
	 */
	public void insertWord(String theWord, String theFileName, int thePosition) {

		if(root == null){
			BinSearchTreeNode Node = new BinSearchTreeNode(theWord, theFileName, thePosition);
			root = Node;
		}else if(root.getWord().equals(theWord)){
			LinkedList files = root.getFiles();
			files.insertWord(theFileName, thePosition);
		}else{
			insert(root, theWord, theFileName, thePosition);
		}
		
	}
	
	/**
	 * Recursive function that goes through the binary search tree r
	 * to find a node that contains the word already or a spot to
	 * place the word in a new node
	 * 
	 * @param r
	 * @param theWord
	 * @param theFileName
	 * @param thePosition
	 */
	private void insert(BinSearchTreeNode r, String theWord, String theFileName, int thePosition) {

		if (r == null) {
			BinSearchTreeNode Node = new BinSearchTreeNode(theWord, theFileName, thePosition);
			root = Node;
		}else if(r.getWord().equals(theWord)){
			LinkedList files = r.getFiles();
			files.insertWord(theFileName, thePosition);
		}else if(theWord.compareTo(r.getWord()) < 0) {
			if(r.getLeft() ==  null) {
				BinSearchTreeNode Node = new BinSearchTreeNode(theWord, theFileName, thePosition);
				r.setLeft(Node);
			}else {
				insert(r.getLeft(), theWord, theFileName, thePosition);
			}
		}else if(r.getRight() == null) {
			BinSearchTreeNode Node = new BinSearchTreeNode(theWord, theFileName, thePosition);
			r.setRight(Node);
		}else { insert(r.getRight(), theWord, theFileName, thePosition); }
	}
	
}
