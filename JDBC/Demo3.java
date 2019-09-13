package JDBC;

import com.mysql.cj.protocol.Resultset;
import com.sun.org.apache.regexp.internal.RE;

import java.sql.*;

/**
 * 测试ResultSet的基本用法
 */

public class Demo3 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接(连接对象内部其实包含了Socket对象，是一个远程连接。比较耗时！)
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db?serverTimezone=UTC",
                    "root","11235813");

            String sql = "select course_id, course_name, course_grade from tb_courses where course_id >= ?";
            ps = con.prepareCall(sql);
            ps.setObject(1, 2);
            rs =  ps.executeQuery();

            while (rs.next()){
                System.out.println(rs.getInt(1)+"---"+ rs.getString(2)+
                        "---"+rs.getFloat(3));
            }
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
            if(ps != null) {
                try {
                    ps.close();
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
