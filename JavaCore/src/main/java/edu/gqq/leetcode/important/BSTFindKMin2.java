package edu.gqq.leetcode.important;

public class BSTFindKMin2 {
	static int number = 0;
	static int count = 0;

	public int kthSmallest(TreeNode root, int k) {
		count = k;
		search(root);
		return number;
	}

	private void search(TreeNode root) {
		if (null == root)
			return;
		search(root.left);
		if (--count == 0) {
			number = root.val;
			return;
		}
		search(root.right);
	}
}
