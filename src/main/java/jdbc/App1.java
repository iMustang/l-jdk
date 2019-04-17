package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Title: App1
 * @Description: Statement简单连接数据库
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/17 9:47
 */
public class App1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String URL = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=GMT";
        String USER = "root";
        String PASSWORD = "root";
        // 1.加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2.获得数据库链接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        // 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from user");
        // 4.处理数据库的返回结果(使用ResultSet类)
        while (rs.next()) {
            System.out.println(rs.getString("id"));
        }

        // 5.关闭资源
        rs.close();
        st.close();
        conn.close();
    }
}
