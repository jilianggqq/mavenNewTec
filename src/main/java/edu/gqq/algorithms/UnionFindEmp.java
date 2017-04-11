package edu.gqq.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionFindEmp {
	class Edge {
		int src;
		int dest;
		public Edge(int src, int dest) {
			this.src = src;
			this.dest = dest;
		}
	}

	public UnionFindEmp(List<Integer> vertices) {
		this.vertices = new ArrayList<>(vertices);		
	}

	List<Edge> edges;
	List<Integer> vertices;

	public void setEdges(List<Edge> edges) {
		this.edges = new ArrayList<>(edges);
	}
	
	public int find(int idx, int[] parents) {
		if (parents[idx] == -1) {
			return idx;
		}
		return find(parents[idx], parents);
	}

	public void union(int v1, int v2, int[] parents) {
		int setv1 = find(v1, parents);
		int setv2 = find(v2, parents);
		parents[setv1] = setv2;
	}

	public boolean isCycle() {
		int[] parents = new int[vertices.size()];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = -1;
		}
		for (Edge edge : edges) {
			int src = edge.src;
			int dest = edge.dest;
			if (find(src, parents) == find(dest, parents))
				return true;
			union(src, dest, parents);
		}
		return false;
	}

	public static void main(String[] args) {
		List<Integer> vertices = Arrays.asList(0, 1, 2, 3);
		UnionFindEmp ufe = new UnionFindEmp(vertices);
		List<Edge> edges = Arrays.asList(ufe.new Edge(0, 1), ufe.new Edge(0, 2), ufe.new Edge(0, 3), ufe.new Edge(1, 3));
		ufe.setEdges(edges);
		boolean isCycle = ufe.isCycle();
		if (isCycle) {
			System.out.println("this graph has cycle");
		} else {
			System.out.println("this graph doesn't has cycle");
		}
	}
}
