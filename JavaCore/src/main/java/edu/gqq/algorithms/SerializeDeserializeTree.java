package edu.gqq.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SerializeDeserializeTree {
	private static final char START = '[';
	private static final char END = ']';

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode ch1 = new TreeNode(8);
		TreeNode ch2 = new TreeNode(9);
		TreeNode ch3 = new TreeNode(11);
		root.addChild(ch1);
		root.addChild(ch2);
		root.addChild(ch3);
		TreeNode ch4 = new TreeNode(13);
		TreeNode ch5 = new TreeNode(17);
		TreeNode ch6 = new TreeNode(18);
		TreeNode ch7 = new TreeNode(20);
		TreeNode ch8 = new TreeNode(22);
		ch1.addChild(ch4);
		ch1.addChild(ch5);
		ch4.addChild(ch6);
		ch6.addChild(ch7);
		ch7.addChild(ch8);
		TreeNode ch9 = new TreeNode(23);
		TreeNode ch10 = new TreeNode(25);
		TreeNode ch11 = new TreeNode(27);
		TreeNode ch12 = new TreeNode(28);
		TreeNode ch13 = new TreeNode(32);
		TreeNode ch14 = new TreeNode(31);
		TreeNode ch15 = new TreeNode(33);
		TreeNode ch16 = new TreeNode(34);
		TreeNode ch17 = new TreeNode(29);
		ch5.addChild(ch9);
		ch3.addChild(ch10);
		ch3.addChild(ch11);
		ch10.addChild(ch12);
		ch10.addChild(ch14);
		ch12.addChild(ch13);
		ch14.addChild(ch15);
		ch14.addChild(ch16);
		ch14.addChild(ch17);
		String packed = serialize(root);
		System.out.println(packed);
		TreeNode compareTo = deSerialize(packed);
		System.out.println(root.equals(compareTo));
	}

	public static String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		return sb.toString();
	}

	/**
	 * 1. met start, change number to 0.
	 * 2. meet end. new TreeNode, then check its parent.
	 * 3. meet ), pop parent.
	 * 4. meet number, calculate.
	 * @param str
	 * @return
	 */
	public static TreeNode deSerialize(String str) {
		TreeNode root = null;
		Stack<TreeNode> stack = new Stack<>();
		int number = 0;
		for (char c : str.toCharArray()) {
			if (c == START) {
				number = 0;
			} else if (c == END) {
				TreeNode child = new TreeNode(number);
				if (!stack.isEmpty()) {
					stack.peek().children.add(child);
				} else {
					root = child;
				}
				stack.push(child);
			} else if (c == ')') {
				stack.pop();
			} else {
				number = number * 10 + (c - '0');
			}
		}
		return root;
	}

	/**
	 * Serialize a tree means use [elem], [elem], )
	 * @param root
	 * @param sb
	 */
	public static void buildString(TreeNode root, StringBuilder sb) {
		if (root == null) {
			return;
		}
		// if we don't use this, the serializaion is 5.8.13.18.20.22.))))17.23.)))9.)11.25.28.32.))31.33.)34.)29.)))27.)))
		// ))))17 is not correct.
		sb.append(START);
		sb.append(root.value);
		sb.append(END);
		for (TreeNode child : root.children) {
			buildString(child, sb);
		}
		sb.append(")");
	}
}

class TreeNode {
	int value;
	List<TreeNode> children;

	public TreeNode(int val) {
		value = val;
		children = new ArrayList<>();
	}

	public void addChild(TreeNode child) {
		this.children.add(child);
	}

	@Override
	public boolean equals(Object obj) {
		TreeNode that = (TreeNode) obj;
		if (that == null || that.value != this.value || that.children.size() != this.children.size()) {
			return false;
		}

		for (int i = 0; i < children.size(); i++) {
			if (!this.children.get(i).equals(that.children.get(i)))
				return false;
		}
		return true;
	}
}
