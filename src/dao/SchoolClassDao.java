package dao;

import model.SchoolClass;
import util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SchoolClassDao {

    public int add(Connection conn, SchoolClass schoolClass) throws Exception {

        String sql = "insert into t_school_class values(null,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, schoolClass.getClassName());
        System.out.println(schoolClass.getClassName());
        pstmt.setString(2, schoolClass.getCalssDesc());
        return pstmt.executeUpdate();
    }

    /*
     * 查询班级集合
     */
    public ResultSet list(Connection conn, SchoolClass schoolClass) throws Exception {

        StringBuffer stringBuffer = new StringBuffer("select * from t_school_class");
        if (StringUtil.isNotEmpty(schoolClass.getClassName())) {
            stringBuffer.append(" and className like '%" + schoolClass.getClassName() + "%'");
        }
        PreparedStatement pstmt = conn.prepareStatement(stringBuffer.toString().replaceFirst("and", "where"));
        return pstmt.executeQuery();
    }

    /*
     * 删除班级
     */
    public int delete(Connection conn, String id) throws Exception {

        String sql = "delete from t_school_class where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        return pstmt.executeUpdate();
    }

    /*
     * 更新班级
     */
    public int update(Connection conn, SchoolClass schoolClass) throws Exception {

        String sql = "update t_school_class set className=?,classDesc=? where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, schoolClass.getClassName());
        pstmt.setString(2, schoolClass.getCalssDesc());
        pstmt.setInt(3, schoolClass.getId());
        return pstmt.executeUpdate();
    }
}
