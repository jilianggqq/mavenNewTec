package edu.gqq.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileOperation {

	/**
	 * 不考虑多线程优化，单线程文件复制最快的方法是(文件越大该方法越有优势，一般比常用方法快30+%):
	 * 
	 * @param source
	 * @param target
	 * @throws IOException
	 */
	private static void nioTransferCopy(File source, File target) throws IOException {
		FileChannel in = null;
		FileChannel out = null;
		FileInputStream inStream = null;
		FileOutputStream outStream = null;
		try {
			inStream = new FileInputStream(source);
			outStream = new FileOutputStream(target);
			in = inStream.getChannel();
			out = outStream.getChannel();
			in.transferTo(0, in.size(), out);
			G.println("file copy ok!");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			inStream.close();
			in.close();
			outStream.close();
			out.close();
			G.println("closed normally!");

		}
	}

	/**
	 * 如果需要监测复制进度，可以用第二快的方法(留意buffer的大小，对速度有很大影响):
	 * 
	 * @param source
	 * @param target
	 * @throws IOException
	 */
	private static void nioBufferCopy(File source, File target) throws IOException {
		FileChannel in = null;
		FileChannel out = null;
		FileInputStream inStream = null;
		FileOutputStream outStream = null;
		try {
			inStream = new FileInputStream(source);
			outStream = new FileOutputStream(target);
			in = inStream.getChannel();
			out = outStream.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(4096);
			while (in.read(buffer) != -1) {
				buffer.flip();
				out.write(buffer);
				buffer.clear();
			}
			G.println("file copy ok!");
		} catch (IOException e) {
			G.println(e.getMessage());
			e.printStackTrace();
		} finally {
			inStream.close();
			in.close();
			outStream.close();
			out.close();
			G.println("closed normally!");
		}
	}

	private static void customBufferBufferedStreamCopy(File source, File target) throws IOException {
		InputStream fis = null;
		OutputStream fos = null;
		try {
			fis = new BufferedInputStream(new FileInputStream(source));
			fos = new BufferedOutputStream(new FileOutputStream(target));
			byte[] buf = new byte[4096];
			int i;
			while ((i = fis.read(buf)) != -1) {
				fos.write(buf, 0, i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fis.close();
			fos.close();
		}
	}

	private static void customBufferStreamCopy(File source, File target) throws IOException {
		InputStream fis = null;
		OutputStream fos = null;
		try {
			fis = new FileInputStream(source);
			fos = new FileOutputStream(target);
			byte[] buf = new byte[4096];
			int i;
			while ((i = fis.read(buf)) != -1) {
				fos.write(buf, 0, i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fis.close();
			fos.close();
		}
	}

	public static void main(String[] args) throws Exception {
		File fs = new File("D:\\test.txt");
		String dirpath = "D:" + File.separator + "zheteng1" + File.separator;
		File dirctory = new File(dirpath);
		if (!dirctory.exists())
			dirctory.mkdirs();

		File ft = new File(dirpath + "tt.txt");
		if (ft.exists()) {
			G.println("file exits");
			ft.delete();
			G.println("file has been deleted");
		}
		// nioTransferCopy(fs, ft);
		nioBufferCopy(fs, ft);
	}
}
