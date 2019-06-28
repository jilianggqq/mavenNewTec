package edu.gqq.leetcode.important;

public class BSTFindKMin {
	// calculate the count of left child.
	// if count=k-1, return root.
	public int kthSmallest(TreeNode root, int k) {
		int count = getTreeCount(root.left);
		if (k - 1 == count) {
			return root.val;
		}
		// get k from left child
		if (count > k - 1) {
			return kthSmallest(root.left, k);
		} else {
			return kthSmallest(root.right, k - count - 1);
		}
	}

	/**
	 * get the node number of a tree
	 * 
	 * @param node
	 *            root
	 * @return
	 */
	private int getTreeCount(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + getTreeCount(node.left) + getTreeCount(node.right);
	}
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
