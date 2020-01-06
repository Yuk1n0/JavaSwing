package util;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * 数据库工具类
 */
public class DbUtil {

    private String dbUrl = "jdbc:mysql://127.0.0.1:3306/db_student_swing?characterEncoding=utf8";
    private String dbUserName = "root";
    private String dbPassword = "123456";
    private String jdbcName = "com.mysql.jdbc.Driver";

    public static void main(String[] args) {
        DbUtil dbUtil = new DbUtil();
        try {
            dbUtil.getConn();
            System.out.println("数据库连接成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接失败!");
        }
    }

    public Connection getConn() throws Exception {
        Class.forName(jdbcName);
        Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        return conn;
    }

    public void closeConn(Connection conn) throws Exception {
        if (conn != null) {
            conn.close();
        }
    }
}
