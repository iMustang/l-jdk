package io.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Title: PathDemo
 */
public class PathDemo {
	public static void main(String[] args) {
		String originalPath =
				"/projects/a-project/../another-project";

		Path path1 = Paths.get(originalPath);
		System.out.println("path1 = " + path1);

		Path path2 = path1.normalize();
		System.out.println("path2 = " + path2);
	}
}
