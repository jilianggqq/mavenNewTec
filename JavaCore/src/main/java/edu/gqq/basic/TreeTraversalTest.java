package edu.gqq.basic;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeTraversalTest {
	/**
	 * Binary tree pre order traversal.
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		LinkedList<Integer> result = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				result.add(node.val);
				stack.push(node);
				node = node.left;
			} else {
				TreeNode tn = stack.pop();
				node = tn.right;
			}
		}
		return result;
	}

	/**
	 * Binary tree in order traversal.
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		LinkedList<Integer> result = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				TreeNode tn = stack.pop();
				result.add(tn.val);
				node = tn.right;
			}
		}
		return result;
	}

	/**
	 * Binary tree post order traversal.
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> result = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				result.addFirst(node.val);
				node = node.right;
			} else {
				TreeNode tn = stack.pop();
				node = tn.left;
			}
		}
		return result;
	}
}

// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
