package edu.gqq.basic;

import static org.junit.Assert.*;

import java.util.LinkedList;

import javax.lang.model.element.VariableElement;

import org.junit.Test;

public class GraphAjacentTest {

	private static final String START = "A";
	private static final String END = "E";

	public static void main(String[] args) {
		// this graph is directional
		GraphAjacent graph = new GraphAjacent();
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
		LinkedList<String> stack = new LinkedList<String>();
		LinkedList<String> visited = new LinkedList<String>();
		stack.add(START);
		System.out.println(START);
		GraphAjacentTest grftest = new GraphAjacentTest();
		// grftest.depthFirst(graph, visited);
//		grftest.dfsWithRecursion(graph, stack, visited);
	}
	
	@Test
	public void testDFSRecursion() throws Exception {
		GraphAjacent g = new GraphAjacent();
//		graph.addEdge("A", "B");
//		graph.addEdge("B", "C");
//		graph.addEdge("C", "E");
//		graph.addEdge("E", "D");
//		graph.addEdge("D", "C");
//		graph.addEdge("E", "B");
//		graph.addEdge("B", "E");
//		graph.addEdge("B", "F");
//		graph.addEdge("F", "G");
		g.addEdge("0", "1");
        g.addEdge("0", "2");
        g.addEdge("1", "2");
        g.addEdge("2", "0");
        g.addEdge("2", "3");
        g.addEdge("3", "3");
		LinkedList<String> stack = new LinkedList<String>();
		LinkedList<String> visited = new LinkedList<String>();
		stack.add("2");
		visited.add("2");
		dfsWithRecursion(g, stack, visited);
	}

	/**
	 * traditional DFS recursion traversal
	 * 
	 * @param graph
	 * @param stack
	 */
	private void dfsWithRecursion(GraphAjacent graph, LinkedList<String> stack, LinkedList<String> visited) {
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

	private void depthFirst(GraphAjacent graph, LinkedList<String> visited) {
		LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());
		// examine adjacent nodes
		for (String node : nodes) {
			if (visited.contains(node)) {
				continue;
			}
			if (node.equals(END)) {
				visited.add(node);
				printPath(visited);
				visited.removeLast();
				break;
			}
		}
		for (String node : nodes) {
			if (visited.contains(node) || node.equals(END)) {
				continue;
			}
			visited.addLast(node);
			depthFirst(graph, visited);
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