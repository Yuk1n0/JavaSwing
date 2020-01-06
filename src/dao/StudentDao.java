package dao;

import model.Student;
import util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDao {

    /*
     * 学生信息添加
     */
    public int add(Connection conn, Student student) throws Exception {

        String sql = "insert into t_student values(null,?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, student.getName());
        pstmt.setString(2, student.getSn());
        pstmt.setString(3, student.getSex());
        pstmt.setString(4, student.getDept());
        pstmt.setInt(5, student.getClassId());
        pstmt.setString(6, student.getAddress());
        return pstmt.executeUpdate();
    }

    /*
     * 学生信息查询
     */
    public ResultSet list(Connection conn, Student student) throws Exception {

        StringBuffer stringBuffer = new StringBuffer("select * from t_student b,t_school_class bt where b.classId=bt.id");
        if (StringUtil.isNotEmpty(student.getName())) {
            stringBuffer.append(" and b.name like '%" + student.getName() + "%'");
        }
        if (StringUtil.isNotEmpty(student.getSn())) {
            stringBuffer.append(" and b.sn like '%" + student.getSn() + "%'");
        }
        if (student.getClassId() != null && student.getClassId() != -1) {
            stringBuffer.append(" and b.classId=" + student.getClassId());
        }
        PreparedStatement pstmt = conn.prepareStatement(stringBuffer.toString());
        return pstmt.executeQuery();
    }

    /*
     * 学生信息删除
     */
    public int delete(Connection conn, String id) throws Exception {
        String sql = "delete from t_student where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        return pstmt.executeUpdate();
    }

    /*
     * 学生信息修改
     */
    public int update(Connection conn, Student student) throws Exception {

        String sql = "update t_student set name=?,sn=?,sex=?,dept=?,address=?,classId=? where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, student.getName());
        pstmt.setString(2, student.getSn());
        pstmt.setString(3, student.getSex());
        pstmt.setString(4, student.getDept());
        pstmt.setString(5, student.getAddress());
        pstmt.setInt(6, student.getClassId());
        pstmt.setInt(7, student.getId());
        return pstmt.executeUpdate();
    }

    /*
     * 指定班级下是否存在学生
     */
    public boolean existStudentByclassId(Connection conn, String classId) throws Exception {
        String sql = "select * from t_student where classId=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, classId);
        ResultSet rs = pstmt.executeQuery();
        return rs.next();
    }
}
