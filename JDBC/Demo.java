package JDBC;

import java.sql.*;

/**
 * 创建连接demo
 * 并测试连接用时
 */

public class Demo {
    public static void main(String[] args) {
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            long start = System.currentTimeMillis();
            //建立连接(连接对象内部其实包含了Socket对象，是一个远程连接。比较耗时！)
            //真正开发中，为了提高效率，都会使用连接池来管理连接对象。
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db?serverTimezone=UTC",
                    "root","11235813");
            long end = System.currentTimeMillis();
            System.out.println(con);
            System.out.println("建立连接耗时"+(end-start)+"ms");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
