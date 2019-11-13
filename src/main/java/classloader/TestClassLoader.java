package classloader;

/**
 * title: TestClassLoader
 * description:
 */
public class TestClassLoader {
    public static void main(String[] args) {
        ClassLoader classLoader = TestClassLoader.class.getClassLoader();
        // 应用程序类加载器，加载用户类路径CLASSPATH下的类库
        System.out.println(classLoader);
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 扩展类加载器，加载\lib\ext目录下的类库
        System.out.println(classLoader.getParent());

        // 启动类加载器，加载\lib下的类库，java的核心类库
        System.out.println(classLoader.getParent().getParent());

        System.out.println("boot:"+System.getProperty("sun.boot.class.path"));
        System.out.println("ext:"+System.getProperty("sun.ext.dirs"));
        System.out.println("app:"+System.getProperty("java.class.path"));
    }
}
