package classloader;

import lombok.AllArgsConstructor;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * title: CustomClassLoader
 * description:
 */
@AllArgsConstructor
public class CustomClassLoader extends ClassLoader {
    private String rootPath;

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 查看类是否被加载过
        Class<?> c = findLoadedClass(name);
        if (c != null) {
            return c;
        }
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    /**
     * 从自定义路径中获取指定类的字节流
     *
     * @param className 类完整路径
     * @return
     */
    private byte[] getClassData(String className) {
        String path = rootPath + className.replace(".", "/") + ".class";
        System.out.println(path);
        FileInputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new FileInputStream(path);
            out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            return out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        CustomClassLoader classLoader = new CustomClassLoader("/Users/xmustang/Data/Code/iRepo/l-jdk/target/classes/");
        Class<?> c = classLoader.loadClass("classloader.HelloWorld");
        System.out.println(c.getClassLoader());
    }
}
