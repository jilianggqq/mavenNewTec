package edu.gqq.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
        return pathNum(0,0,m,n);
    }
    
    public int pathNum(int i, int j, int m, int n) {
        if(i>=m || j>=n) {
            return 0;
        }
        if(i==m-1 && j==n-1) {
            return 1;
        }
        
        return pathNum(i+1, j, m, n) + pathNum(i, j+1, m, n);
    }
    
    @Test
	public void testUP() throws Exception {
		int uniquePaths = uniquePaths(23, 12);
		assertEquals(193536720, uniquePaths);
	}
}
