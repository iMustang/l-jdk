package io;

import java.io.*;

/**
 * @Title: RandomAccessFileDemo
 * @Description:
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019-06-23 21:31
 */
public class RandomAccessFileDemo {
	public static void main(String[] args) {
		// 向文件追加内容，追加内容放在原文件末尾
		try (RandomAccessFile raf = new RandomAccessFile(new File("ProgramIOFile/io.txt"), "rw")) {
			System.out.println(raf.length());
			// 把文件记录指针定位到文件末尾
			raf.seek(raf.length());
			raf.write("追加的内容!\r\n".getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 在文件指定位置插入内容
		try {
			insert("ProgramIOFile/io.txt", 45, "新插入的内容");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void insert(String fileName, long pos, String insertContent) throws IOException, IOException {
		File tmp = File.createTempFile("tmp", null);
		tmp.deleteOnExit();
		try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
			 // 使用临时文件来保存插入点后的数据
			 FileOutputStream tmpOut = new FileOutputStream(tmp);
			 FileInputStream tmpIn = new FileInputStream(tmp)) {
			raf.seek(pos);
			byte[] bbuf = new byte[64];
			int hasRead = 0;
			while ((hasRead = raf.read(bbuf)) > 0) {
				// 将插入点后的内容写入临时文件
				tmpOut.write(bbuf, 0, hasRead);
			}
			raf.seek(pos);
			// 追加需要插入的内容
			raf.write(insertContent.getBytes());
			while ((hasRead = tmpIn.read(bbuf)) > 0) {
				// 追加临时文件中的内容
				raf.write(bbuf, 0, hasRead);
			}
		}
	}
}