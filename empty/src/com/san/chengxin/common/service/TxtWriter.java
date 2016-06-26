package com.san.chengxin.common.service;

import java.io.BufferedOutputStream;
import java.io.IOException;

/**
 * 生成TXT文件工具类
 * 
 * @author yangyj
 *
 */
public class TxtWriter {
	private BufferedOutputStream os;

	private String[] header;
	private String[][] body;

	public void write() throws IOException {
		if (header == null && body == null)
			throw new IllegalArgumentException("Hasn't set any data!");

		if (header != null) {
			StringBuffer sb = new StringBuffer();
			int i = 0;
			for (; i < header.length; i++) {
				if (i == 0)
					sb.append(header[i]);
				else
					sb.append(",").append(header[i]);
			}
			sb.append("\r\n");
			os.write(sb.toString().getBytes());
		}

		if (body != null) {
			int i = 1;
			for (; i < body.length; i++) {
				StringBuffer row = new StringBuffer();
				int j = 0;
				for (; j < body[i].length; j++) {
					if (j == 0)
						row.append(body[i][j]);
					else
						row.append(",").append(body[i][j]);
				}
				row.append("\r\n");
				os.write(row.toString().getBytes());
			}
		}
	}

	/**
	 * @return Returns the body.
	 */
	public String[][] getBody() {
		return body;
	}

	/**
	 * @param body The body to set.
	 */
	public void setBody(String[][] body) {
		this.body = body;
	}

	/**
	 * @return Returns the header.
	 */
	public String[] getHeader() {
		return header;
	}

	/**
	 * @param header The header to set.
	 */
	public void setHeader(String[] header) {
		this.header = header;
	}

	/**
	 * @return Returns the os.
	 */
	public BufferedOutputStream getOs() {
		return os;
	}

	/**
	 * @param os The os to set.
	 */
	public void setOs(BufferedOutputStream os) {
		this.os = os;
	}
}
