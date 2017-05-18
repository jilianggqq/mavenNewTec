package edu.gqq.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import edu.gqq.common.G;

public class HexStreamTest {
	/**
	 * 把文件内容变成16进制的，并且通过控制台打印出来。 超过10个字节换行
	 * 
	 * @throws IOException
	 */
	public static void parseFileContextToHex(String filename) throws IOException {
		FileInputStream is = new FileInputStream(filename);

		int b;
		int i = 1;
		while ((b = is.read()) != -1) {
			System.out.print(Integer.toHexString(b) + " ");
			if (i++ % 10 == 0) {
				G.println();
			}
		}
	}

	public static void main(String[] args) {
		try {
			parseFileContextToHex("d:\\test.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
