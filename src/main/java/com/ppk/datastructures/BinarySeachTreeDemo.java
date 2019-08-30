package com.ppk.datastructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * Binary Search Tree -
 * <br>
 * BSTs are binary trees (every node can have a max. of 2 nodes) with special properties -
 * <br> 1. Left child is smaller than parent
 * <br> 2. Right child is greater than parent
 * 
 * <br> <b>Balanced</b> BST -
 * <br> Balanced BST have equal number of left and right elements.
 * <br>
 * <br>
 * Time Complexity (Search/Insert/Delete on Balanced BST)- <b> O(log<sub>2</sub> n)</b>
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
		
		System.out.println("Original Tree (pre-order)-");
		binarySearchTree.traversePreOrder();
		System.out.println();
		
		System.out.println("Original Tree (post-order)-");
		binarySearchTree.traversePostOrder();
		System.out.println();
		
		//traverse in-order i.e. left->root->right
		System.out.println("Original Tree (in-order)-");
		binarySearchTree.traverseInOrder();
		System.out.println();
		
		System.out.println("Original Tree (level-order)-");
		binarySearchTree.traverseLevelOrder();
		System.out.println();
		
		System.out.println("Original Tree (level-order using queue)-");
		binarySearchTree.traverseLevelOrderUsingQueue();
		System.out.println();
		
		System.out.println("Original Tree (reverse level-order)-");
		binarySearchTree.traverseReverseLevelOrder();
		System.out.println();
		
		System.out.println("Original Tree (reverse level-order using Queue and Stack)-");
		binarySearchTree.traverseReverseLevelOrderUsingQueueAndStack();
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
	 * So we need maintain references to current node, it's parent node and whether the child is a left or right child
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
	 * gives nodes in non-decreasing order
	 * <br>
	 * Note - To get nodes of BST in non-increasing order, a variation of in-order traversal where in-order traversal is reversed can be used.
	 * <br>
	 * left->root->right
	 * <br>
	 * Time Complexity: O(n)
	 */
	public void traverseInOrder() {
		if(this.root == null) {
			System.out.println("Empty Tree");
			return;
		}
		
		traverseInOrder(this.root);
	}
	
	/**
	 * Private traverse method which first goes to left node if exists, then prints the current root and then goes to right node recursively
	 * 
	 * <br> This could be implemented inside TreeNode class well
	 * 
	 * @param current
	 */
	private void traverseInOrder(TreeNode current) {
		if(current == null)	return;
		
		//No need for null check as the recursive call already first checks if the node is null
		//		if(current.getLeftNode() != null)
		traverseInOrder(current.getLeftNode());

		if(current == this.root)
			System.out.print(current.getData() + "* -> ");
		else
			System.out.print(current.getData() + " -> ");

		//		if(current.getRightNode() != null)
		traverseInOrder(current.getRightNode());

	}
	
	/**
	 * Traverse and print the node data pre-order
	 * <br>
	 * This is same as Depth First Search (DFS) in Graphs (trees are one kind of graphs)
	 * <br>
	 * root->left->right
	 * <br>
	 * used to create a copy of the tree
	 * <br>
	 * Time Complexity: O(n)
	 */
	public void traversePreOrder() {
		if(this.root == null) {
			System.out.println("Empty Tree");
			return;
		}
		
		traversePreOrder(this.root);
	}
	
	/**
	 * Private traverse method which first prints the current root, then goes to left node and then goes to right node recursively
	 * 
	 * <br> This could be implemented inside TreeNode class well
	 * 
	 * @param current
	 */
	private void traversePreOrder(TreeNode current) {
		if(current == null)	return;
		
		if(current == this.root)
			System.out.print(current.getData() + "* -> ");
		else
			System.out.print(current.getData() + " -> ");
		
		//No need for null check as the recursive call already first checks if the node is null
		//		if(current.getLeftNode() != null)
		traversePreOrder(current.getLeftNode());

		//		if(current.getRightNode() != null)
		traversePreOrder(current.getRightNode());

	}
	
	/**
	 * Traverse and print the node data post-order
	 * <br>
	 * left->right->root
	 * <br>
	 * used to delete the tree
	 * <br>
	 * Time Complexity: O(n)
	 */
	public void traversePostOrder() {
		if(this.root == null) {
			System.out.println("Empty Tree");
			return;
		}
		
		traversePostOrder(this.root);
	}
	
	/**
	 * Private traverse method which first goes to left node if exists, then goes to right node recursively, then prints the current root 
	 * 
	 * <br> This could be implemented inside TreeNode class well
	 * 
	 * @param current
	 */
	private void traversePostOrder(TreeNode current) {
		if(current == null)	return;
		
		//No need for null check as the recursive call already first checks if the node is null
		//		if(current.getLeftNode() != null)
		traversePostOrder(current.getLeftNode());

		//		if(current.getRightNode() != null)
		traversePostOrder(current.getRightNode());
		
		if(current == this.root)
			System.out.print(current.getData() + "* -> ");
		else
			System.out.print(current.getData() + " -> ");

	}
	
	/**
	 * Traverse and print the node data one level at time from top to bottom
	 * <br>
	 * This is same as Breadth First Search (BFS) in Graphs (trees are one kind of graphs)
	 * <br>
	 * Idea is to call a function asking it to print the given level, starting from level 1 to height of tree
	 * <br>
	 * Time Complexity: O(n^2)
	 * 
	 */
	public void traverseLevelOrder() {
		
		int height = this.height();
		
		for(int i = 1; i <= height; i++) {
			printGivenLevel(this.root, i);
		}
	}
	
	
	/**
	 * Traverse and print the node data one level at time from bottom to top
	 * <br>
	 * Idea is to call a function asking it to print the given level, starting from bottom i.e. height of tree to level 1
	 * <br>
	 * Time Complexity: O(n^2)
	 */
	public void traverseReverseLevelOrder() {
		
		int height = this.height();
		
		for(int i = height; i >= 1; i--) {
			printGivenLevel(this.root, i);
		}
	}
	
	
	/**
	 * 
	 * Function to print all nodes at a given level
	 * <br>
	 * Print nth level if a base tree is equivalent to -
	 * print (n-1)th level of its left or right child
	 * <br>
	 * When level reaches one, we print the current node
	 * 
	 * @param current
	 * @param level
	 */
	private void printGivenLevel(TreeNode current, int level) {
		
		//breaking condition
		if(current == null) return;
		
		//Single node
		if(level == 1) {
			System.out.print(current.getData()+" -> ");
		}else {
			printGivenLevel(current.getLeftNode(), level - 1);
			
			printGivenLevel(current.getRightNode(), level - 1);
		}
	}
	
	
	/**
	 * Traverse and print the node data one level at a time from top to bottom
	 * <br>
	 * This is same as Breadth First Search (BFS) in Graphs (trees are one kind of graphs)
	 * <br>
	 * Uses a queue (FIFO) to hold the children of current node
	 * <br>
	 * Time Complexity: O(n)
	 */
	public void traverseLevelOrderUsingQueue() {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(this.root);
		
		while (!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();
			
			//print current node
			System.out.print(currentNode.getData()+" -> ");
			
			//add immediate children
			if(currentNode.getLeftNode() != null)
				queue.add(currentNode.getLeftNode());
			if(currentNode.getRightNode() != null)
				queue.add(currentNode.getRightNode());
		}
	}
	
	/**
	 * Traverse and print the node data one level at time from bottom to top
	 * <br>
	 * Uses a queue (FIFO) to hold the children of current node
	 * <br>
	 * At the same time, uses a stack to hold tree elements level by level
	 * <br>
	 * Time Complexity: O(n)
	 */
	public void traverseReverseLevelOrderUsingQueueAndStack() {
		Stack<TreeNode> stack = new Stack<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(this.root);
		stack.push(this.root);
		
		while (!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();
			
			//add immediate children
			//IMP - Right subtree is visited before left subtree coz we are using a stack
			if(currentNode.getRightNode() != null) {
				queue.add(currentNode.getRightNode());
				stack.push(currentNode.getRightNode());
			}
			if(currentNode.getLeftNode() != null) {
				queue.add(currentNode.getLeftNode());
				stack.push(currentNode.getLeftNode());
			}
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop().getData()+" -> ");
		}
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