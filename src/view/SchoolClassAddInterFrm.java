package view;

import dao.SchoolClassDao;
import model.SchoolClass;
import util.DbUtil;
import util.StringUtil;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class SchoolClassAddInterFrm extends JInternalFrame {

    private JTextField classNameTxt;
    private JTextArea classDescTxt;

    private DbUtil dbUtil = new DbUtil();
    private SchoolClassDao schoolClassDao = new SchoolClassDao();

    public SchoolClassAddInterFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("添加班级信息界面");
        setBounds(100, 100, 450, 300);

        JLabel lblNewLabel = new JLabel("班级信息名称");
        JLabel lblNewLabel_1 = new JLabel("班级信息描述");

        classNameTxt = new JTextField();
        classNameTxt.setColumns(10);

        classDescTxt = new JTextArea();
        classDescTxt.setLineWrap(true);
        classDescTxt.setWrapStyleWord(true);
        JButton btnNewButton = new JButton("添加");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookTypeAddActionPerformed(e);
            }
        });
        btnNewButton.setIcon(new ImageIcon(SchoolClassAddInterFrm.class.getResource("/images/add.png")));

        JButton btnNewButton_1 = new JButton("重置");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetValueActionPerformed(e);
            }
        });
        btnNewButton_1.setIcon(new ImageIcon(SchoolClassAddInterFrm.class.getResource("/images/reset.png")));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(86)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(lblNewLabel)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(classNameTxt, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblNewLabel_1)
                                                        .addComponent(btnNewButton))
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(btnNewButton_1)
                                                        .addComponent(classDescTxt))))
                                .addContainerGap(69, GroupLayout.PREFERRED_SIZE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(56)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(classNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(29)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(classDescTxt, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnNewButton)
                                        .addComponent(btnNewButton_1))
                                .addGap(28))
        );
        getContentPane().setLayout(groupLayout);
        // 设置文本域边框
        classDescTxt.setBorder(new LineBorder(new java.awt.Color(127, 157, 185), 1, false));

    }

    /*
     * 班级信息添加事件处理
     */
    private void bookTypeAddActionPerformed(ActionEvent evt) {

        String className = this.classNameTxt.getText();
        String classDesc = this.classDescTxt.getText();
        if (StringUtil.isEmpty(className)) {
            JOptionPane.showMessageDialog(null, "班级信息名称不能为空！");
            return;
        }
        SchoolClass schoolClass = new SchoolClass(className, classDesc);
        Connection conn = null;
        try {
            conn = dbUtil.getConn();
            int n = schoolClassDao.add(conn, schoolClass);
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "班级信息添加成功！");
                resetValue();
            } else {
                JOptionPane.showMessageDialog(null, "班级信息添加失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "班级信息添加失败！");
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
     * 重置事件处理
     */
    private void resetValueActionPerformed(ActionEvent evt) {
        this.resetValue();
    }

    private void resetValue() {
        this.classNameTxt.setText("");
        this.classDescTxt.setText("");
    }
}
