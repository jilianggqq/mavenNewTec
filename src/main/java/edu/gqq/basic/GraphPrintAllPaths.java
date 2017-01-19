package edu.gqq.basic;

import java.util.LinkedList;

import org.junit.Test;

public class GraphPrintAllPaths {

	private static final String START = "B";
	private static final String END = "E";

	public static void main(String[] args) {
		// this graph is directional
		GraphWithAjacent graph = new GraphWithAjacent();
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("B", "A");
		graph.addEdge("B", "D");
		graph.addEdge("B", "E"); // this is the only one-way connection
		graph.addEdge("B", "F");
		graph.addEdge("C", "A");
		graph.addEdge("C", "E");
		graph.addEdge("C", "F");
		graph.addEdge("D", "B");
		graph.addEdge("E", "C");
		graph.addEdge("E", "F");
		graph.addEdge("F", "B");
		graph.addEdge("F", "C");
		graph.addEdge("F", "E");
		LinkedList<String> visited = new LinkedList<String>();
		visited.add(START);
		GraphPrintAllPaths grftest = new GraphPrintAllPaths();
		grftest.depthFirst(graph, visited, END);
	}

	@Test
	public void testPrintAllPath1() throws Exception {
		GraphWithAjacent graph = new GraphWithAjacent();
		graph.addEdge("0", "1");
		graph.addEdge("0", "2");
		graph.addEdge("1", "2");
		graph.addEdge("2", "0");
		graph.addEdge("2", "3");
		LinkedList<String> visited = new LinkedList<>();
		visited.add("0");
		depthFirst(graph, visited, "3");
	}

	/**
	 * traditional DFS recursion traversal
	 * 
	 * @param graph
	 * @param stack
	 */
	private void dfsWithRecursion(GraphWithAjacent graph, LinkedList<String> stack, LinkedList<String> visited) {
		LinkedList<String> nodes = graph.adjacentNodes(stack.getLast());
		for (String node : nodes) {
			if (stack.contains(node) || visited.contains(node)) {
				continue;
			}
			System.out.println(node);
			stack.add(node);
			visited.add(node);
			dfsWithRecursion(graph, stack, visited);
			stack.removeLast();
		}
	}

	public void depthFirst(GraphWithAjacent graph, LinkedList<String> visited, String end) {
		LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());
		// examine adjacent nodes
		for (String node : nodes) {
			if (visited.contains(node)) {
				continue;
			}
			if (node.equals(end)) {
				visited.add(node);
				printPath(visited);
				visited.removeLast();
				break;
			}
		}
		for (String node : nodes) {
			if (visited.contains(node) || node.equals(end)) {
				continue;
			}
			visited.addLast(node);
			depthFirst(graph, visited, end);
			visited.removeLast();
		}
	}

	private void printPath(LinkedList<String> visited) {
		for (String node : visited) {
			System.out.print(node);
			System.out.print(" ");
		}
		System.out.println();
	}
}