package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 测试PreparedStatement的基本用法
 * 优点：效率更高，防止SQL注入
 */

public class Demo2 {
    public static void main(String[] args) {
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接(连接对象内部其实包含了Socket对象，是一个远程连接。比较耗时！)
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db?serverTimezone=UTC",
                    "root","11235813");

            String sql = "INSERT into tb_courses (course_name, course_grade) values(?,?)";
            //?占位符
            PreparedStatement ps = con.prepareCall(sql);
//            ps.setString(1, "JDBClearning");
//            ps.setFloat(2, 6.0f);

            //传参
            ps.setObject(1, "JDBC");
            ps.setObject(2, 12);

            System.out.println("插入正在学习JDBC");
            ps.execute();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
