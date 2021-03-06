package com.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IterativePostorder {

	Node root;

	void postOrder(Node root) {
		if (root != null) {
			// the idea is to maintain the state of the node
			// count of node = state of execution for the current node
			Map<Node, Integer> count = new HashMap<>();
			Stack<Node> stack = new Stack<>();
			stack.push(root);
			while (!stack.isEmpty()) {
				Node node = stack.peek();
				if (node == null) {
					stack.pop();
					continue;
				}
				if (!count.containsKey(node)) {
					count.put(node, 0);
				}
				// state checks
				if (count.get(node) == 0) {
					stack.push(node.left);
				} else if (count.get(node) == 1) {
					stack.push(node.right);
				} else if (count.get(node) == 2) {
					System.out.print(node.data + " ");
				}
				// node is eligible to be popped
				// count=3
				else {
					stack.pop();
				}
				// update the state of the current node
				count.put(node, count.get(node) + 1);
			}
		}
	}
	
	public static void main(String[] args) {

		IterativePostorder tree = new IterativePostorder();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("\nPostorder traversal of binary tree is -----");
		System.out.println();
		tree.postOrder(tree.root);
	}
}
