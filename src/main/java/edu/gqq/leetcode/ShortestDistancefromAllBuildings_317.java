package edu.gqq.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class ShortestDistancefromAllBuildings_317 {
	public static void main(String[] args) {
		ShortestDistancefromAllBuildings_317 s = new ShortestDistancefromAllBuildings_317();
		int[][] grid = { { 1, 0, 2, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 } };
		s.shortestDistance(grid);
	}

	int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

	public int shortestDistance(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[][] dist = new int[m][n];
		// Initialize building list and accessibility matrix `grid`
		List<Tuple> buildings = new ArrayList<>();
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j) {
				if (grid[i][j] == 1)
					buildings.add(new Tuple(i, j, 0));
				grid[i][j] = -grid[i][j];
			}
		// BFS from every building
		for (int k = 0; k < buildings.size(); ++k) {
			System.out.println("loop with " + buildings.get(k));
			bfs(buildings.get(k), k, dist, grid, m, n);
		}
		// Find the minimum distance
		int ans = -1;
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				if (grid[i][j] == buildings.size() && (ans < 0 || dist[i][j] < ans))
					ans = dist[i][j];
		return ans;
	}

	public void bfs(Tuple root, int k, int[][] dist, int[][] grid, int m, int n) {
		Queue<Tuple> q = new ArrayDeque<>();
		q.add(root);
		while (!q.isEmpty()) {
			Tuple b = q.poll();
			System.out.println("\n" + b);
			dist[b.y][b.x] += b.dist;
			System.out.println(Arrays.deepToString(dist));
			System.out.println(Arrays.deepToString(grid));
			for (int i = 0; i < 4; ++i) {
				int x = b.x + dx[i], y = b.y + dy[i];
				if (y >= 0 && x >= 0 && y < m && x < n && grid[y][x] == k) {
					grid[y][x] = k + 1;
					Tuple tobeadded = new Tuple(y, x, b.dist + 1);
					q.add(tobeadded);
					System.out.println("tobeadded : " + tobeadded);
				}
			}
			System.out.println(Arrays.deepToString(grid));
		}
	}
}

class Tuple {
	public int y;
	public int x;
	public int dist;

	public Tuple(int y, int x, int dist) {
		this.y = y;
		this.x = x;
		this.dist = dist;
	}

	@Override
	public String toString() {
		return "[" + this.y + " " + this.x + "]" + " dist:" + this.dist;
	}
}
