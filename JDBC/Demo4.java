package JDBC;

import java.sql.*;

/**
 * 测试批处理Batch的基本用法
 * 批量处理时尽量使用Statement语句
 * 因为PreparedStatement语句存在预编译的问题，可能会出现问题。
 */

public class Demo4 {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接(连接对象内部其实包含了Socket对象，是一个远程连接。比较耗时！)
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db?serverTimezone=UTC",
                    "root","11235813");

            con.setAutoCommit(false);
            long start = System.currentTimeMillis();
            stmt = con.createStatement();

            for(int i=0; i<20000; i++)
                stmt.addBatch("insert into tb_courses (course_name, course_grade) values('class " + i + "', 5)");
            stmt.executeBatch();
            con.commit();
            long end = System.currentTimeMillis();
            System.out.println("插入20000条数据，耗时(ms)："+(end-start));


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            //遵循：rs -> ps -> connection 关闭;一定要将三个快分开写
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
