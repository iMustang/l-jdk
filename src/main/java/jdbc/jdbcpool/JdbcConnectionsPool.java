package jdbc.jdbcpool;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

/**
 * @Title: JdbcConnectionsPool
 * @Description: 数据库连接池实现
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/17 9:32
 */
public class JdbcConnectionsPool implements DataSource{
    // 创建linkedlist集合
    private static LinkedList<Connection> connPool = new LinkedList<Connection>();
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    // 最小连接数量
    private static int jdbcConnectionInitSize;
    // 当前最大连接数量=max*jdbcConnectionInitSize
    private static int max = 1;
    // 使用静态块代码，初始化连接池，创建最小连接数量连接， 放入LinkedList集合中
    static {
        InputStream is = JdbcConnectionsPool.class.getResourceAsStream("/db.properties");
        Properties prop = new Properties();
        try {
            prop.load(is);
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            jdbcConnectionInitSize = Integer.parseInt(prop.getProperty("jdbcConnectionInitSize"));

            Class.forName(driver);

            for (int i = 0; i < jdbcConnectionInitSize; i++) {
                Connection conn = DriverManager.getConnection(url, username, password);
                System.out.println("创建了链接" + conn);
                connPool.add(conn);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 实现数据库连接的获取和新创建
     * @return 数据库连接
     * @throws SQLException
     */
    @Override
    public Connection getConnection() throws SQLException {
        // 如果集合中没有数据库连接对象了，且创建的数据库连接对象未达到最大连接数量，可再创建一组数据库连接对象以备使用
        if (connPool.size() == 0 && max <= 5) {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < jdbcConnectionInitSize; i++) {
                Connection conn = DriverManager.getConnection(url, username, password);
                System.out.println("获取到了链接" + conn);
                connPool.add(conn);
            }
            max++;
        }
        if (connPool.size() > 0) {
            // 从LinkedList集合中取出一个数据库链接对象Connection使用
            Connection conn = connPool.removeFirst();
            System.out.println("LinkedList数据库连接池大小是" + connPool.size());
            // 返回一个Connection对象，并设置Connection对象方法调用的限制，
            // 当调用connection类对象的close()方法时，会将Connection对象重新收集放入LinkedList集合中。
            return (Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader(),
                    conn.getClass().getInterfaces(), new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            if (!method.getName().equalsIgnoreCase("close")) {
                                return method.invoke(conn, args);
                            } else {
                                connPool.add(conn);
                                System.out.println(conn + "对象被释放，重新放回LinkedList集合中！");
                                System.out.println("此时LinkedList集合中有" + connPool.size() + "个数据库连接对象！");
                                return null;
                            }
                        }
                    });
        } else {
            System.out.println("连接数据库失败！");
        }
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }
}
