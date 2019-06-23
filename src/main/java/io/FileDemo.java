package io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Title: FileDemo
 * @Description:File类的使用学习
 */
public class FileDemo {
	public static void main(String[] args) throws IOException {
		/**
		 * File可以代表一个文件、一个目录
		 * File可以代表存在的文件或目录、也可以代表不存在文件或目录，用于创建
		 * File可以查看代表的文件或目录的属性（大小、读写）
		 *
		 * Java支持将斜线（/）当成与平台无关的路径分隔符。
		 */
		File file0 = new File("F:" + File.separator + "temp.txt");
		System.out.println("存在吗？" + file0.exists());
		System.out.println("是一个文件吗：" + file0.isFile());
		System.out.println("是一个文件夹吗：" + file0.isDirectory());
		System.out.println("是隐藏的文件吗：" + file0.isHidden());
		System.out.println("是绝对路径吗：" + file0.isAbsolute());

		File file1 = new File("F:/", "temp.txt");
		File file2 = new File(".");
		System.out.println("当前路径是：" + file2.getAbsolutePath());
		File file3 = new File("/temp.txt");
		System.out.println(file3.getAbsolutePath());
		File file4 = new File("F:/temp.txt");
		System.out.println("创建成功了吗？" + file4.createNewFile());
		File destFile = new File("F:/abc.txt");
		System.out.println("重命名成功吗？" + file4.renameTo(destFile));
		File dir = new File("F:/a");
		System.out.println("创建单级文件夹成功吗？：" + dir.mkdir());
		dir = new File("F:/b/c");
		System.out.println("创建多级文件夹成功吗？：" + dir.mkdirs());
		File file5 = new File("F:/a.txt");
		System.out.println("删除成功吗？ " + file5.delete());
		file5.deleteOnExit();

//		获取文件基本信息
		File file6 = new File("F:/a/b/c/d/temp.txt");
		System.out.println("文件名：" + file6.getName());
		System.out.println("获取绝对路径：" + file6.getPath());
		System.out.println("getAbsolutePath获取绝对路径：" + file6.getAbsolutePath());
		System.out.println("获取文件的的大小(字节为单位)：" + file6.length());
		System.out.println("获取文件的父路径：" + file6.getParent());
		// 使用毫秒值转换成Date对象
		long lastModified = file6.lastModified();
		Date date = new Date(lastModified);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		System.out.println("获取最后一次的修改时间：" + dateFormat.format(date));

		File[] roots = File.listRoots(); // 列出所有的根目录
		for (File file : roots) {
			System.out.println(file);
		}
		File file = new File("F:/");
		String[] fileNames = file.list();
		for (String fileName : fileNames) {
			System.out.println(fileName);
		}
		// 将当前路径下的所有文件与子文件夹都使用File对象描述，然后把这些File对象存储到File数组
		File[] files = file.listFiles();
		for (File fileItem : files) {
			System.out.println("文件名：" + fileItem.getName());
		}
		//自定义文件名过滤器
		class MyFileFilter implements FilenameFilter {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");
			}
		}
	}
}
