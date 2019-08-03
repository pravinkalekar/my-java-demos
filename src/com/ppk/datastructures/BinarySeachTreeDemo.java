package com.ppk.datastructures;

/**
 * 
 * Binary Search Tree -
 * <br>
 * Condition -
 * <br> 1. Every node can have a max. of 2 nodes
 * <br> 2. For any node, elements on the left are smaller and elements on the right are larger
 * 
 * <br> <b>Balanced</b> BST -
 * <br> Balanced BST have equal number of left and right elements.
 * <br>
 * <br>
 * Time Complexity (Search/Insert/Delete on Balanced BST)- <b> O(log2 n)</b>
 * 
 * @author pkalekar
 *
 */
public class BinarySeachTreeDemo {

	/**
	 * The given array creates the below BinarySearchTree
	 * <br>
	 * <br>		   211
	 * <br>		/		\
	 * <br>	   8		570
	 * <br>	 /   \		/  \
	 * <br> 6	125	   403  600
	 * <br>		/  \		/
	 * <br>	  94	132	   590
	 * <br>		   /  \		 \
	 * <br>		129	   134	 595
	 * <br>		  \
	 * <br>		 130
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 211, 570, 8, 6, 600, 125, 94, 590, 132, 595, 403, 134, 129, 130};
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		for (int i : array) {
			binarySearchTree.insertNode(i);
		}
		
		//traverse in-order i.e. left->root->right
		System.out.println("Original Tree -");
		binarySearchTree.traverseInOrder();
		System.out.println();
		System.out.println("findNode(125) (should return node) - "+ binarySearchTree.findNode(125));
		System.out.println("findNode(99) (should return null) - "+ binarySearchTree.findNode(99));
		
		System.out.println("Smallest node - "+binarySearchTree.smallestNode());
		
		System.out.println("Largest node - "+binarySearchTree.largestNode());
		
		System.out.println("Number of Leaf nodes - "+binarySearchTree.numOfLeafNodes());
		
		System.out.println("Height of Tree - "+binarySearchTree.height());
		
		binarySearchTree.deleteNode(0);
		System.out.println("deleteNode(0) - Uknown Node -");
		binarySearchTree.traverseInOrder();
		System.out.println();
		
		binarySearchTree.deleteNode(6);
		System.out.println("deleteNode(6) - Leaf Node -");
		binarySearchTree.traverseInOrder();
		System.out.println();
		
		binarySearchTree.deleteNode(590);
		System.out.println("deleteNode(590) - Node having one child (right) -");
		binarySearchTree.traverseInOrder();
		System.out.println();
		
		binarySearchTree.deleteNode(600);
		System.out.println("deleteNode(600) - Node having one child (left) -");
		binarySearchTree.traverseInOrder();
		System.out.println();
		
		binarySearchTree.deleteNode(125);
		System.out.println("deleteNode(125) - Node having both children -");
		binarySearchTree.traverseInOrder();
		System.out.println();
		
		binarySearchTree.deleteNode(132);
		System.out.println("deleteNode(132) - Node having both children -");
		binarySearchTree.traverseInOrder();
		System.out.println();
		
		binarySearchTree.deleteNode(211);
		System.out.println("deleteNode(211) - Node having both children - this time root itself -");
		binarySearchTree.traverseInOrder();
		System.out.println();
		
		binarySearchTree.deleteNode(8);
		System.out.println("deleteNode(8) -");
		binarySearchTree.traverseInOrder();
		System.out.println();
		
		System.out.println("Smallest node - "+binarySearchTree.smallestNode());
		
		binarySearchTree.deleteNode(403);
		System.out.println("deleteNode(403) -");
		binarySearchTree.traverseInOrder();
		System.out.println();
		
		binarySearchTree.deleteNode(129);
		System.out.println("deleteNode(129) -");
		binarySearchTree.traverseInOrder();
		System.out.println();
		
		binarySearchTree.deleteNode(130);
		System.out.println("deleteNode(130) -");
		binarySearchTree.traverseInOrder();
		System.out.println();
		
		binarySearchTree.deleteNode(134);
		System.out.println("deleteNode(134) -");
		binarySearchTree.traverseInOrder();
		System.out.println();
		
		binarySearchTree.deleteNode(570);
		System.out.println("deleteNode(570) -");
		binarySearchTree.traverseInOrder();
		System.out.println();
		
		binarySearchTree.deleteNode(595);
		System.out.println("deleteNode(595) -");
		binarySearchTree.traverseInOrder();
		System.out.println();
		
		binarySearchTree.deleteNode(94);
		System.out.println("deleteNode(94) -");
		binarySearchTree.traverseInOrder();
		System.out.println();
		
		binarySearchTree.deleteNode(94);
		System.out.println("deleteNode(94) -");
		binarySearchTree.traverseInOrder();
		System.out.println();
		
		System.out.println("Smallest node - "+binarySearchTree.smallestNode());
		
	}

}

/**
 * A Binary Search Tree
 * <br>
 * It contains the reference to the root node alone
 * 
 * @author pkalekar
 *
 */
class BinarySearchTree{
	
	private TreeNode root;
	
	public BinarySearchTree() {
		this.root = null;
	}

	public int height() {
		if(this.root == null) return 0;
		return root.height();
	}

	public int numOfLeafNodes() {
		if(this.root == null) return 0;
		
		return root.numOfLeafNodes();
	}

	public TreeNode findNode(int data) {
		if(root == null) return null;
		
		return root.findNode(data);
	}
	
	public void insertNode(int data) {
		
		if(root == null) {
			root = new TreeNode(data);
		}else {
			root.insertNode(data);
		}
	}
	
	/**
	 * Delete a node (Not recursive)
	 * <br>
	 * For deleting a node, first need to search for it and then update the parent node references
	 * <br>
	 * Since we need a reference to the parent of the node we want to delete, we will not use recursion here
	 * <br>
	 * So we need maintain references to current node, it's parent node and weather the child is a left or right child
	 * <br>
	 * There are three use cases to consider -
	 * <br>1. if the node to be deleted is a leaf node
	 * <br>2. if the node to be deleted has only one child
	 * <br>3. if the node to be deleted has both children
	 * 
	 * @param data
	 */
	public void deleteNode(int data) {
		
		if(this.root == null) return;
		
		TreeNode current = this.root;
		TreeNode parent = this.root;
		boolean isLeftChild = false;
		
		//here we are just trying to identify the node to be deleted
		//go down the tree until current is not null (when current reaches null, it means it's the end of the tree)
		//and we also stop the loop when the data is equal to current node
		while(current!=null && current.getData() != data) {
			//keep a reference to current node's parent
			parent = current;
			
			if(data < current.getData()) {
				current = current.getLeftNode();
				isLeftChild = true;
			}else {
				current = current.getRightNode();
				isLeftChild = false;
			}
		}
		
		//here, either current will be null or point to the node to be deleted
		
		//reached end of tree, data not found, just return
		if(current == null)
			return;
		
		//Now check how many children the current node has
		
		if(current.getLeftNode() == null && current.getRightNode() == null) {	//the node to be deleted is a leaf node
			//imp - it can be the root node as well
			if(current == root) {
				root = null;	//delete root
			}else {
				if(isLeftChild) {
					parent.setLeftNode(null);
				}else{
					parent.setRightNode(null);
				}
			}
		} else if(current.getLeftNode() == null) {	//the node to be deleted has one child i.e. right
			//imp - it can be the root node as well
			if(current == root) {
				root = current.getRightNode();	//make right node the new root
			}else {
				if(isLeftChild) {
					//if current node to be deleted is a left node of parent
					parent.setLeftNode(current.getRightNode()); //make right node the left node of parent
				}else {
					//if current node to be deleted is a right node of parent
					parent.setRightNode(current.getRightNode()); //make right node the right node of parent
				}
			}
			
		} else if(current.getRightNode() == null) {	//the node to be deleted has one child i.e. left
			//imp - it can be the root node as well
			if(current == root) {
				root = current.getLeftNode(); //make left node the new root
			}else {
				if(isLeftChild) {
					//if node to be deleted is left node of parent
					parent.setLeftNode(current.getLeftNode());
				}else {
					//if node to be deleted is right node of parent
					parent.setRightNode(current.getLeftNode());
				}
			}
			
		}else {	//the node to be deleted is has both children i.e. both left and right
			
			//1. Find element greater than current node but smaller than its right child
			//i.e. keep traversing left from its right child
			TreeNode successor = smallestNode(current.getRightNode());
			
			//imp - it can be the root node as well
			if(current == root) {
				root = successor;
			}
			
			//2. Handle left node of current node to be deleted
			//successor does not have left node, as it is the smallest in the tree
			successor.setLeftNode(current.getLeftNode());
			
			if(successor != current.getRightNode()) {
				//3. Handle right node of current node to be deleted
				//but before setting right node on successor, check if it has right node 
				if(successor.getRightNode() != null) {
					//make the successor's right tree the left tree of current node's right child
					current.getRightNode().setLeftNode(successor.getRightNode());
				}
				else {
					//otherwise break the connection
					current.getRightNode().setLeftNode(null);
				}

				//now that successor's right tree if there was is handled
				successor.setRightNode(current.getRightNode());
			}
			
			//Now successor has been setup with new left and right
			//4. Attach successor to the parent based on if current was left child or right child
			if(isLeftChild) {
				parent.setLeftNode(successor);
			}else {
				parent.setRightNode(successor);
			}
			
		}
		
	}
	
	public TreeNode smallestNode() {
		if(this.root == null) 
			return null;
		
		return smallestNode(this.root);
	}
	
	private TreeNode smallestNode(TreeNode node) {
		//breaking condition
		if(node != null && node.getLeftNode() == null) return node;

		return smallestNode(node.getLeftNode());
	}
	
	
	public TreeNode largestNode() {
		if(this.root == null) 
			return null;
		
		return largestNode(this.root);
	}
	
	private TreeNode largestNode(TreeNode node) {
		//breaking condition
		if(node != null && node.getRightNode() == null) {
			return node;
		}
		
		return largestNode(node.getRightNode());
	}
	
	/**
	 * Traverse and print the node data in-order
	 * <br>
	 * left->root->right
	 */
	public void traverseInOrder() {
		if(this.root == null) {
			System.out.println("Empty Tree");
			return;
		}
		
		traverseNode(this.root);
	}
	
	/**
	 * Private traverse method which first goes to left node if exists, then prints the current root and then goes to right node recursively
	 * 
	 * <br> This could be implemented inside TreeNode class well
	 * 
	 * @param current
	 */
	private void traverseNode(TreeNode current) {
		if(current == null)	return;
		
		if(current.getLeftNode() != null)
			traverseNode(current.getLeftNode());
		
		if(current == this.root)
			System.out.print(current.getData() + "* -> ");
		else
			System.out.print(current.getData() + " -> ");
		
		if(current.getRightNode() != null)
			traverseNode(current.getRightNode());
		
	}
	
}

/**
 * 
 * A Binary Search Tree Node
 * <br>
 * It contains the data and the references to left and right nodes
 * 
 * @author pkalekar
 *
 */
class TreeNode{
	private int data;
	private TreeNode leftNode;
	private TreeNode rightNode;
	
	public TreeNode(int data) {
		this.data = data;
	}

	public int height() {
		// breaking condition
		if(isLeaf())
			return 1;
		
		int heightLeft = 0;
		int heightRight = 0;
		if(this.leftNode != null) {
			heightLeft = this.leftNode.height();
		}
		if(this.rightNode != null) {
			heightRight = this.rightNode.height();
		}
		//check which of left/right tree has more height, take the max of them
		//notice that we increment by 1 every time we go one level up the tree 
		return Math.max(heightLeft, heightRight)+1;
	}

	public TreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public TreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}

	public int getData() {
		return data;
	}
	
	@Override
	public String toString() {
		return "Node("+this.data+")";
	}
	
	/**
	 * Find a node (Recursive)
	 * <br>
	 * Simple 3 cases based on if data is equal , less than or greater than current node data
	 * <br>1. if equal return current node
	 * <br>2. if less than current data, make recursive call on left child if not null
	 * <br>3. if data is greater then current node data), make recursive call on right child if not null
	 * <br>4. finally, if it reaches here, it means node not found, simply return null
	 * 
	 * @param data
	 * @return
	 */
	public TreeNode findNode(int data) {
		
		if(data == this.data) 
			return this;
		
		if(data < this.data && this.leftNode != null)
			return this.leftNode.findNode(data);
		
		if(this.rightNode != null)
			return this.rightNode.findNode(data);
		
		return null;
	}
	
	/**
	 * Insert a new Node (Recursive)
	 * <br>
	 * First check if we need to insert on left child or right child
	 * <br>
	 * Then based on if left/right child is present, make a recursive insert call or create a new node and make it the left/right child
	 * 
	 * @param data
	 */
	public void insertNode(int data) {
		if(data < this.data) {
			if(this.leftNode != null) 
				this.leftNode.insertNode(data);
			else
				this.leftNode = new TreeNode(data);
		}else {
			if(this.rightNode != null)
				this.rightNode.insertNode(data);
			else
				this.rightNode = new TreeNode(data);
		}
	}
	
	public boolean isLeaf() {
		if(this.leftNode == null && this.rightNode == null)
			return true;
		else
			return false;
	}
	

	public int numOfLeafNodes() {
		//breaking condition
		if(isLeaf())
			return 1;
		
		int sum = 0;
		if(this.leftNode != null) {
			sum += this.leftNode.numOfLeafNodes();
		}
		if(this.rightNode != null) {
			sum += this.rightNode.numOfLeafNodes();
		}
		return sum;
	}
	
}