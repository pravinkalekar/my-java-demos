package com.ppk.recursion;

/**
 * Tower of Hanoi
 * 
 * Move n disks from Source Tower A to Target Tower C using Tower B as intermediate
 * <br> 
 * Suppose the disks are numbered from 1 to n from top to bottom
 * <br>
 * 1. Our first goal should to be move first 1..(n-1) disks to intermediate tower so that we can move the last nth disk to target tower C
 * <br>
 * 2. Once the n-1 disks are moved, all we need to do is to move the nth disk from source tower A to target tower C
 * <br>
 * 3. Now that source A is empty, intermediate B has n-1 disks, C has the nth disk, 
 * we can reuse the same algorithm to move n-1 disks from intermediate B to target C using A as intermediate this time.
 * 
 * <br>
 * It takes exponential time.<br>
 * For n discs, number of moves are (2^n)-1<br>
 * Number of moves - [1->1, 2->3, 3->7, 4->15, 5->31...]
 * 
 * 
 * @author pkalekar
 *
 */
public class TowerOfHanoiDemo {
	
	private static int numOfMoves;
	
	/**
	 * Move n disks from Tower A to Tower C using Tower B as intermediate
	 * 
	 * @param n number of disks
	 * @param a TowerFrom
	 * @param c TowerTo
	 * @param b TowerIntermediate
	 */
	public static void move(int n, String source, String target, String intermediate) {
		//breaking condition
		//when no disks to move, just return
		if(n == 0) return;
		
		//move n-1 disks from source to intermediate using target as temporary intermediate
		move(n-1, source, intermediate, target);
		
		//move nth disk from source to target
		System.out.println("Moving disk "+n+" from "+source+" to target "+ target);
		numOfMoves++;
		
		//now move remaining n-1 disks from intermediate to target using source as temporary intermediate
		move(n-1, intermediate, target, source);
		
	}

	public static void main(String[] args) {
		move(1, "A", "C", "B");
		System.out.println("For 1 disk, Number of moves (should be 1) - "+numOfMoves);
		
		numOfMoves = 0;
		move(2, "A", "C", "B");
		System.out.println("For 2 disk, Number of moves (should be 3) - "+numOfMoves);
		
		numOfMoves = 0;
		move(3, "A", "C", "B");
		System.out.println("For 3 disk, Number of moves (should be 7)- "+numOfMoves);
		
		numOfMoves = 0;
		move(5, "A", "C", "B");
		System.out.println("For 5 disk, Number of moves (should be 31)- "+numOfMoves);
	}

}
