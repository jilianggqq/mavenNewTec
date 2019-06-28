package edu.gqq.algorithms;

/**
 * leetcode 307
 * 
 * @author gqq
 *
 */
public class RangeSumQuery {
	class SegmentTree {
		int start;
		int end;
		SegmentTree left;
		SegmentTree right;
		int sum;
	}

	SegmentTree node;
	int[] nums;

	public RangeSumQuery(int[] nums) {
		this.nums = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			this.nums[i] = nums[i];
		}
		node = initTree(nums, 0, nums.length - 1);
	}

	public void update(int i, int val) {
		if (i >= 0 && i < this.nums.length) {
			update(node, i, val);
		}
	}

	private void update(SegmentTree root, int i, int val) {
		if (root != null && i >= root.start && i <= root.end) {
			if (root.start == root.end) {
				root.sum = val;
			} else {
				int mid = root.start + (root.end - root.start) / 2;
				if (i <= mid) {
					// update left
					update(root.left, i, val);
				} else {
					// update right
					update(root.right, i, val);
				}
				root.sum = root.right.sum + root.left.sum;
			}
		}
	}

	public int sumRange(int i, int j) {
		return sumRange(i, j, node);
	}

	public int sumRange(int i, int j, SegmentTree root) {
		if (root == null || i > j)
			return 0;
		if (j < root.start || i > root.end) {
			return 0;
		}
		if (i == root.start && j == root.end)
			return root.sum;
		int mid = root.start + (root.end - root.start) / 2;
		if (j <= mid) {
			return sumRange(i, j, root.left);
		} else if (i > mid) {
			return sumRange(i, j, root.right);
		} else {
			return sumRange(i, mid, root.left) + sumRange(mid + 1, j, root.right);
		}

	}

	private SegmentTree initTree(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		SegmentTree st = new SegmentTree();
		st.start = start;
		st.end = end;
		if (start == end) {
			st.sum = nums[start];
		} else {
			int l = start + (end - start) / 2;
			st.left = initTree(nums, start, l);
			st.right = initTree(nums, l + 1, end);
			st.sum = st.left.sum + st.right.sum;
		}
		return st;
	}

	public static void main(String[] args) {

		int[] nums = { 1, 3, 5 };
		RangeSumQuery rsq = new RangeSumQuery(nums);
		System.out.println(rsq.sumRange(0, 2));
		rsq.update(1, 2);
		System.out.println(rsq.sumRange(0, 2));
		rsq.update(2, 8);
		System.out.println(rsq.sumRange(1, 2));

	}
}
