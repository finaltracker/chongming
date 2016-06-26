package com.san.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

public class NewZip {
	public static void zip(String souceFileName, String destFileName) {
		File file = new File(souceFileName);
		try {
			zip(file, destFileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static  void zip(File souceFile, String destFileName) throws IOException {
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(destFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ZipOutputStream out = new ZipOutputStream(fileOut);
		zip(souceFile, out, "");
		out.close();
	}

	private static  void zip(File souceFile, ZipOutputStream out, String base)
			throws IOException {

		if (souceFile.isDirectory()) {
			File[] files = souceFile.listFiles();
			out.putNextEntry(new ZipEntry(base + "/"));
			base = base.length() == 0 ? "" : base + "/";
			for (File file : files) {
				zip(file, out, base + file.getName());
			}
		} else {
			if (base.length() > 0) {
				out.putNextEntry(new ZipEntry(base));
			} else {
				out.putNextEntry(new ZipEntry(souceFile.getName()));
			}
			System.out.println("filepath=" + souceFile.getPath());
			FileInputStream in = new FileInputStream(souceFile);

			int b;
			byte[] by = new byte[1024];
			while ((b = in.read(by)) != -1) {
				out.write(by, 0, b);
			}
			in.close();
		}
	}

	/**
	 * Test
	 */
	public static void main(String[] args) {
		NewZip.zip("E:\\Tomcat\\apache-tomcat-6.0.35\\webapps\\web\\file\\improPath\\2014122414031054624", "E://Tomcat//apache-tomcat-6.0.35//webapps//web//file//improPath//2014122414031054624.zip");
	}
}

