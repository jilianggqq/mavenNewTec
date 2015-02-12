package edu.gqq.lvjuan;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SymmetricNumber {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		// final String fileName = System.getenv("OUTPUT_PATH");
		String fileName = "d:\\test.txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		String res;
		String _n;
		System.out.println("������int");
		try {
			_n = in.nextLine();
		} catch (Exception e) {
			_n = null;
		}

		res = getNextSymmetricNumber(_n);
		if (res == null) {
			bw.close();
			return;
		}
		bw.write(res);
		bw.newLine();

		bw.close();
		System.out.println("����ɹ�����鿴�ļ�");
	}

	private static String getNextSymmetricNumber(String n) {
		try {
			int num = Integer.parseInt(n) + 1;
			while (!isSymNum(num++))
				;
			return (num - 1) + "";
		} catch (Exception e) {
			System.out.println("������Ϸ����ַ���");
			return null;
		}
	}

	private static boolean isSymNum(int num) {
		char[] chs = (num + "").toCharArray();
		boolean isSymNum = true;
		int len = chs.length;
		for (int i = len / 2 - 1; i >= 0; i--) {
			int j = len - i - 1;
			if (chs[i] != chs[j]) {
				isSymNum = false;
				break;
			}
		}
		return isSymNum;
	}

}
