package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrm extends JFrame {

    private JPanel contentPane;
    private JDesktopPane table = null;

    public MainFrm() {

        setTitle("学生档案管理系统主界面");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("基本数据维护");
        mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/base.png")));
        menuBar.add(mnNewMenu);

        JMenu mnNewMenu_1 = new JMenu("班级信息管理");
        mnNewMenu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png")));
        mnNewMenu.add(mnNewMenu_1);

        JMenuItem menuItem = new JMenuItem("班级信息添加");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                SchoolClassAddInterFrm bookTypeAddInterFrm = new SchoolClassAddInterFrm();
                bookTypeAddInterFrm.setVisible(true);
                table.add(bookTypeAddInterFrm);
            }
        });
        menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
        mnNewMenu_1.add(menuItem);

        JMenuItem menuItem_1 = new JMenuItem("班级信息维护");
        menuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                SchoolClassManageInterFrm bookTypeManageInterFrm = new SchoolClassManageInterFrm();
                bookTypeManageInterFrm.setVisible(true);
                table.add(bookTypeManageInterFrm);
            }
        });
        menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
        mnNewMenu_1.add(menuItem_1);

        JMenu mnNewMenu_2 = new JMenu("学生档案管理");
        mnNewMenu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookManager.png")));
        mnNewMenu.add(mnNewMenu_2);

        JMenuItem menuItem_2 = new JMenuItem("学生档案添加");
        menuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                StudentAddInterFrm bookAddInterFrm = new StudentAddInterFrm();
                bookAddInterFrm.setVisible(true);
                table.add(bookAddInterFrm);
            }
        });

        menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
        mnNewMenu_2.add(menuItem_2);

        JMenuItem menuItem_3 = new JMenuItem("学生档案维护");
        menuItem_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                StudentManageInterFrm bookManageInterFrm = new StudentManageInterFrm();
                bookManageInterFrm.setVisible(true);
                table.add(bookManageInterFrm);
            }
        });
        menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
        mnNewMenu_2.add(menuItem_3);

        JMenuItem menuItem_4 = new JMenuItem("安全退出");
        menuItem_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "是否退出系统");
                if (result == 0) {
                    dispose();
                }
            }
        });
        menuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
        mnNewMenu.add(menuItem_4);

        JMenu menu = new JMenu("关于系统");
        menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
        menuBar.add(menu);

        JMenuItem mntmjava = new JMenuItem("关于");
        mntmjava.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                AboutInfoFrm aboutInfoFrm = new AboutInfoFrm();
                aboutInfoFrm.setVisible(true);
                table.add(aboutInfoFrm);
            }
        });
        mntmjava.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
        menu.add(mntmjava);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        table = new JDesktopPane();
        contentPane.add(table, BorderLayout.CENTER);
        // 设置JFrame最大化
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
