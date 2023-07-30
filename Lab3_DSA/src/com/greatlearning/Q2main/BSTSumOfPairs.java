package com.greatlearning.Q2main;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
class Node {
	int data;
	Node left,right;
	
	public Node(int data)
	{
		this.data = data;
		left = right = null;
	}
}
public class BSTSumOfPairs {
	Node root;
	public static void main(String[] args) {
		BSTSumOfPairs bst = new BSTSumOfPairs();

		Scanner sc = new Scanner(System.in);
		bst.root = bst.insert(bst.root, 40);
		bst.root = bst.insert(bst.root, 20);
		bst.root = bst.insert(bst.root, 60);
		bst.root = bst.insert(bst.root, 10);		
		bst.root = bst.insert(bst.root, 30);
		bst.root = bst.insert(bst.root, 50);
		bst.root = bst.insert(bst.root, 70); 	
		bst.inorderTraversal(bst.root);
		System.out.print("\nEnter the SUM of pair : ");
		int sumofpair = sc.nextInt();
		bst.findSumOfGivenPair(bst.root,sumofpair);
	}

	private void findSumOfGivenPair(Node root, int sumofpair) {
		// TODO Auto-generated method stub
		Set<Integer> set = new HashSet<>();
		if(!findPairUtil(root,sumofpair,set))
		{
			System.out.println("Pair doesn't exist..........");
		}
		
	}

	private boolean findPairUtil(Node root, int sumofpair, Set<Integer> set) {
		if(root==null)
			return false;
		if(findPairUtil(root.left,sumofpair,set))
			return true;
		 
		int diff = sumofpair-root.data;
		if(set.contains(diff))
		{
			System.err.println("Match exist : ("+diff+","+root.data+")");
			return true;
		}
		else
			set.add(root.data);
		return findPairUtil(root.right,sumofpair,set);
	}

	private void inorderTraversal(Node root) {
		if(root == null)
			return;
		inorderTraversal(root.left);
		System.out.print(root.data+"-->");
		inorderTraversal(root.right);				
	}

	private Node insert(Node node, int key)
	{
		if(node==null)
		{
			node = new Node(key);
			return node;
		}
		else if(key>node.data) 
			node.right = insert(node.right,key);
		else if(key<node.data) 
			node.left = insert(node.left,key);
		
		return node;
	}
}

