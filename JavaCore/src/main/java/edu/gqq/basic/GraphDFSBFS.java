package edu.gqq.basic;

import static java.lang.System.out;

import java.util.LinkedList;

//This class represents a directed graph using adjacency list
//representation
public class GraphDFSBFS {
	private int V; // No. of vertices

	// Array of lists for Adjacency List Representation
	private LinkedList<Integer> adj[];

	// Constructor
	public GraphDFSBFS(int v) {
		this.V = v;
		this.adj = new LinkedList[v];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	// Function to add an edge into the graph
	public void addEdge(int v, int w) {
		// Add w to v's list.
		adj[v].add(w);
	}

	// A function used by DFS
	private void DFSUtil(int v, boolean[] visited) {
		// Mark the current node as visited and print it
		visited[v] = true;
		out.println(v + " ");
		LinkedList<Integer> list = adj[v];

		// Recur for all the vertices adjacent to this vertex
		for (Integer i : list) {
			if (visited[i]) {
				continue;
			}
			DFSUtil(i, visited);
		}
	}

	// a function used by BFS
	private void BFSUtil(int v) {
		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<>();
		// Mark all the vertices as not visited(By default
		// set as false)
		boolean[] isvisited = new boolean[V];
		queue.add(v);
		isvisited[v] = true;
		while (!queue.isEmpty()) {
			// dequeue from the queue, and visit the element.
			Integer e = queue.poll();
			out.println(e);

			LinkedList<Integer> list = adj[e];
			for (Integer data : list) {
				if (!isvisited[data]) {
					isvisited[data] = true;
					queue.add(data);
				}
			}
		}
	}

	// The function to do DFS traversal. It uses recursive DFSUtil()
	public void DFS(int v) {
		// Mark all the vertices as not visited(set as
		// false by default in java)
		boolean[] visited = new boolean[V];
		// Call the recursive helper function to print DFS traversal
		DFSUtil(v, visited);
	}

	public void BFS(int v) {
		BFSUtil(v);
	}

	public static void main(String args[]) {
		GraphDFSBFS g = new GraphDFSBFS(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

		g.DFS(2);
		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 0)");
		g.BFS(0);
	}
}
