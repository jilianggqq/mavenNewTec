package edu.gqq.leetcode;

import javax.sound.midi.MidiChannel;

/**
 * Your NumArray object will be instantiated and called as such:
 * 
 * NumArray obj = new NumArray(nums);
 * 
 * obj.update(i,val);
 * 
 * int param_2 = obj.sumRange(i,j);
 */
public class RangeSumQuery_307 {
	SegmentTreeNode root;
	public RangeSumQuery_307(int[] nums) {
		root = buildSegTree(nums, 0, nums.length - 1);
	}

	private SegmentTreeNode buildSegTree(int[] nums, int st, int ed) {
		if (st > ed) return null;
		SegmentTreeNode node = new SegmentTreeNode(st, ed);
		if (st == ed) {
			node.sum = nums[st];
			return node;
		} else {
			int mid = st + (ed - st) / 2;
			node.left = buildSegTree(nums, st, mid);
			node.right = buildSegTree(nums, mid + 1, ed);
			node.sum = node.left.sum + node.right.sum;
		}
		return node;
	}

	public void update(int i, int val) {
		doUpdate(root, i, val);
	}
	
	public void doUpdate(SegmentTreeNode node, int i, int val) {
	    if (i < node.start || i > node.end) return;
		if (i == node.start && i == node.end) {
			node.sum = val;
			return;
		}
		doUpdate(node.left, i, val);
		doUpdate(node.right, i, val);
		node.sum = node.left.sum + node.right.sum;
	}

	public int sumRange(int i, int j) {
		return doSumRange(root, i, j);
	}
	
	public int doSumRange(SegmentTreeNode node, int i, int j) {
		if (node.start == i && node.end == j) {
			return node.sum;
		} else {
			int mid = node.start + (node.end - node.start) / 2;
	        if (j <= mid) {
	            return doSumRange(node.left, i, j);
	        } else if (i >= mid + 1) {
	            return doSumRange(node.right, i, j);
	        } else {
	            return doSumRange(node.left, i, mid) + doSumRange(node.right, mid + 1, j);
	        }
		}
		
	}
}

class SegmentTreeNode {
	int start;
	int end;
	int sum;
	SegmentTreeNode left;
	SegmentTreeNode right;

	public SegmentTreeNode(int st, int ed) {
		this.start = st;
		this.end = ed;
	}
}