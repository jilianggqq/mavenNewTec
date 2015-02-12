package edu.gqq.encode;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.apache.commons.lang3.CharSet;

import edu.gqq.common.G;

public class EncodeTest {
	public static void main(String[] args) throws Exception {
		String string = "姬良ABC";
		byte[] bytes = string.getBytes();
		for (byte b : bytes) {
			// 因为是utf8的编码，所以应该占3+3+3个字节
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}

		G.println();
		// 当然，我们也可以把字符串转换成其它的字节流
		byte[] bytes2 = string.getBytes("gbk");
		for (byte b : bytes2) {
			// 因为是gbk的编码，所以应该占2+2+3个字节
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}

		G.println();
		byte[] bytes3 = string.getBytes("unicode");
		for (byte b : bytes3) {
			// 因为是gbk的编码，所以应该占2+2+3个字节
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}

		G.println();
		// 当我们把字节流转换成字符串的时候，必须要知道其编码，这样才能变成正规的字符串。
		// 你想，给你一些字节，说白了就是一堆01，你不知道其编码方式，或者制定了错误的编码方式，它就照着这种错误的方式开始编了。
		// 假如，我把byte2以utf8的方式给编码一下
		String newString1 = new String(bytes);
		String newString2 = new String(bytes2);
		String newString3 = new String(bytes2, "gbk");
		G.println(newString1);
		G.println(newString2);
		G.println(newString3);
	}
}
