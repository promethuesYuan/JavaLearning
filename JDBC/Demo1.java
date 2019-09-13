package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 尝试使用statement语句
 * 测试什么是SQL注入
 */

public class Demo1 {
    public static void main(String[] args) {
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接(连接对象内部其实包含了Socket对象，是一个远程连接。比较耗时！)
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db?serverTimezone=UTC",
                    "root","11235813");

            Statement stmt = con.createStatement();
            String sql = " INSERT INTO tb_courses" +
                    " (course_id,course_name,course_grade,course_info)" +
                    " VALUES(2,'Network',3,'Computer Network');";
            stmt.execute(sql);

            //SQL注入
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
