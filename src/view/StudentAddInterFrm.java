package view;

import dao.SchoolClassDao;
import dao.StudentDao;
import model.SchoolClass;
import model.Student;
import util.DbUtil;
import util.StringUtil;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

public class StudentAddInterFrm extends JInternalFrame {

    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField studentTxt;
    private JTextField snTxt;
    private JTextField deptTxt;
    private JComboBox schoolClassJcb;
    private JTextArea addressTxt;
    private JRadioButton manJrb;
    private JRadioButton femaleJrb;

    private DbUtil dbUtil = new DbUtil();
    private SchoolClassDao schoolClassDao = new SchoolClassDao();
    private StudentDao studentDao = new StudentDao();

    public StudentAddInterFrm() {

        setClosable(true);
        setIconifiable(true);
        setTitle("添加学生信息");
        setBounds(100, 100, 450, 467);

        JLabel label = new JLabel("学生姓名");

        studentTxt = new JTextField();
        studentTxt.setColumns(10);

        JLabel label_1 = new JLabel("学生学号");

        snTxt = new JTextField();
        snTxt.setColumns(10);

        JLabel label_2 = new JLabel("学生性别");

        manJrb = new JRadioButton("男");
        buttonGroup.add(manJrb);
        manJrb.setSelected(true);

        femaleJrb = new JRadioButton("女");
        buttonGroup.add(femaleJrb);

        JLabel label_3 = new JLabel("所在院系");

        deptTxt = new JTextField();
        deptTxt.setColumns(10);

        JLabel label_4 = new JLabel("家庭住址");

        addressTxt = new JTextArea();

        JLabel label_5 = new JLabel("所在班级");

        schoolClassJcb = new JComboBox();

        JButton button = new JButton("添加");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookAddActionPerformed(e);
            }
        });
        button.setIcon(new ImageIcon(StudentAddInterFrm.class.getResource("/images/add.png")));

        JButton button_1 = new JButton("重置");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetValueActionPerformed(e);
            }
        });
        button_1.setIcon(new ImageIcon(StudentAddInterFrm.class.getResource("/images/reset.png")));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(42)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(button)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(button_1)
                                                .addGap(232))
                                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                .addComponent(label_5)
                                                .addGroup(groupLayout.createSequentialGroup()
                                                        .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                                                .addComponent(label_4)
                                                                .addComponent(label_2)
                                                                .addComponent(label))
                                                        .addPreferredGap(ComponentPlacement.RELATED)
                                                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                                .addGroup(groupLayout.createSequentialGroup()
                                                                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                                                                                .addComponent(studentTxt, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(groupLayout.createSequentialGroup()
                                                                                        .addComponent(manJrb)
                                                                                        .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                        .addComponent(femaleJrb))
                                                                                .addComponent(schoolClassJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addGap(35)
                                                                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                                                                                .addGroup(groupLayout.createSequentialGroup()
                                                                                        .addComponent(label_1)
                                                                                        .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                        .addComponent(snTxt, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(groupLayout.createSequentialGroup()
                                                                                        .addComponent(label_3)
                                                                                        .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                        .addComponent(deptTxt))))
                                                                .addComponent(addressTxt))
                                                        .addContainerGap(44, Short.MAX_VALUE)))))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(42)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label)
                                        .addComponent(studentTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_1)
                                        .addComponent(snTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(29)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label_2)
                                        .addComponent(manJrb)
                                        .addComponent(femaleJrb)
                                        .addComponent(label_3)
                                        .addComponent(deptTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(33)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label_5)
                                        .addComponent(schoolClassJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(30)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(label_4)
                                        .addComponent(addressTxt, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(button)
                                        .addComponent(button_1))
                                .addGap(42))
        );
        getContentPane().setLayout(groupLayout);
        // 设置文本域边框
        addressTxt.setBorder(new LineBorder(new java.awt.Color(127, 157, 185), 1, false));
        fillBookType();
    }

    /*
     * 重置事件处理
     */
    private void resetValueActionPerformed(ActionEvent e) {
        this.resetValue();
    }

    /*
     * 学生添加事件处理
     */
    private void bookAddActionPerformed(ActionEvent evt) {

        String name = this.studentTxt.getText();
        String sn = this.snTxt.getText();
        String dept = this.deptTxt.getText();
        String address = this.addressTxt.getText();

        if (StringUtil.isEmpty(name)) {
            JOptionPane.showMessageDialog(null, "学生姓名不能为空！");
            return;
        }

        if (StringUtil.isEmpty(sn)) {
            JOptionPane.showMessageDialog(null, "学生学号不能为空！");
            return;
        }

        if (StringUtil.isEmpty(dept)) {
            JOptionPane.showMessageDialog(null, "学生学院不能为空！");
            return;
        }

        String sex = "";
        if (manJrb.isSelected()) {
            sex = "男";
        } else if (femaleJrb.isSelected()) {
            sex = "女";
        }

        SchoolClass schoolClass = (SchoolClass) schoolClassJcb.getSelectedItem();
        int classId = schoolClass.getId();
        Student student = new Student(name, sn, sex, dept, classId, address);

        Connection conn = null;
        try {
            conn = dbUtil.getConn();
            int addNum = studentDao.add(conn, student);
            if (addNum == 1) {
                JOptionPane.showMessageDialog(null, "学生添加成功！");
                resetValue();
            } else {
                JOptionPane.showMessageDialog(null, "学生添加失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "学生添加失败！");
        } finally {
            try {
                dbUtil.closeConn(conn);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /*
     * 重置表单
     */
    private void resetValue() {

        this.studentTxt.setText("");
        this.snTxt.setText("");
        this.deptTxt.setText("");
        this.manJrb.setSelected(true);
        this.addressTxt.setText("");
        if (this.schoolClassJcb.getItemCount() > 0) {
            this.schoolClassJcb.setSelectedIndex(0);
        }
    }

    /*
     * 初始化学生类别下拉框
     */
    private void fillBookType() {

        Connection conn = null;
        SchoolClass bookType = null;
        try {
            conn = dbUtil.getConn();
            ResultSet rs = schoolClassDao.list(conn, new SchoolClass());
            while (rs.next()) {
                bookType = new SchoolClass();
                bookType.setId(rs.getInt("id"));
                bookType.setClassName(rs.getString("className"));
                this.schoolClassJcb.addItem(bookType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
