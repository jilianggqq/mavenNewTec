package edu.gqq.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingCart_Amazon {

	public static void main(String[] args) {
		List<List<String>> codeList = new ArrayList<>();
		List<String> ele1 = Arrays.asList("apple", "apple");
		List<String> ele2 = Arrays.asList("banana", "anything", "banana");
		codeList.add(ele1);
		codeList.add(ele2);
		List<String> asList = Arrays.asList("apple", "banana", "apple", "apple", "orange", "banana", "orange", "banana", "apple", "orange");
		int res = checkWinner(codeList, asList);
		System.out.println(res);
	}

	public static int checkWinner(List<List<String>> codeList, List<String> shoppingCart) {
		int m = codeList.size();
		int n = shoppingCart.size();
		return dfs(codeList, shoppingCart, m, n, 0, 0);
	}

	public static int dfs(List<List<String>> codeList, List<String> shoppingCart, int m, int n, int idx1, int idx2) {
		if (idx1 >= m) {
			return 1;
		}
		if (idx2 >= n) {
			return 0;
		}
		List<String> des = codeList.get(idx1);
		int i = 0, j = idx2;
		while (i < des.size() && j < n) {
			if (des.get(i).equals("anything") || shoppingCart.get(j).equals(des.get(i))) {
				i++;
			} else {
				i = 0;
			}
			j++;
		}
		if (i == des.size()) {
			return dfs(codeList, shoppingCart, m, n, idx1 + 1, j);
		}
		return 0;
	}
}
