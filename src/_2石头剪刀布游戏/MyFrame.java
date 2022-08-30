package _2石头剪刀布游戏;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//@SuppressWarnings("serial")
public class MyFrame extends JFrame {
    private JButton btn1,btn2,btn3,btn4,btn5,btn6;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem1,menuItem2,menuItem3;
    private JDialog dialog_MenuItem1,dialog_MenuItem2,dialog_MenuItem3,dialog_btn1,dialog_btn2,dialog_btn3;
    private JLabel label_GameName,
            label_btn1,label_btn2,label_btn3,
            label_MenuItem1_1,label_MenuItem2_2,label_MenuItem2_1;
    private ComputerOperation cptOperation;
    ImageIcon backgroundImage;

    // 主函数创建类的实例对象
    public static void main(String[] args){
        new MyFrame();
    }

    // 构造函数
    public MyFrame(){
        this.addAndSetComponent(); // 添加组件和设置属性
        this.addListener(); // 添加监听器
    }

    // 添加组件和设置属性
    private void addAndSetComponent(){
        cptOperation = new ComputerOperation();

        btn1 = new JButton(cptOperation.getYourScissor());
        btn1.setForeground(new Color(0, 0, 128));
        btn1.setBounds(4, 102, 93, 27);
        btn1.setBackground(Color.ORANGE);

        btn2 = new JButton(cptOperation.getYourStone());
        btn2.setForeground(new Color(0, 0, 128));
        btn2.setBounds(103, 102, 93, 27);
        btn2.setVerticalAlignment(SwingConstants.TOP);
        btn2.setBackground(Color.ORANGE);

        btn3 = new JButton(cptOperation.getYourCloth());
        btn3.setForeground(new Color(0, 0, 128));
        btn3.setBounds(202, 102, 77, 27);
        btn3.setBackground(Color.ORANGE);

        // 按钮btn4和btn5作用于菜单栏中的退出游戏dialog窗口中
        btn4 = new JButton("确定");
        btn4.setBackground(new Color(255,105,180));
        btn5 = new JButton("返回");
        btn5.setBackground(new Color(0,250,154));

        // 窗口名
        this.setTitle("fingergame");

        // 窗体背景色，如果没有图片，将显示此背景色

        this.getContentPane().setBackground(new Color(138, 177, 236));
        // 对话框设置
        this.setSize(300,250);

        //窗体大小固定
        this.setResizable(false);
        this.setLocation(700, 300);
        this.getContentPane().setLayout(null);

        this.getContentPane().add(btn1);
        this.getContentPane().add(btn2);
        this.getContentPane().add(btn3);

        // 添加 游戏名 的标签
        label_GameName = new JLabel("剪刀石头布游戏");
        label_GameName.setForeground(Color.BLACK);
        label_GameName.setFont(new Font("宋体", Font.BOLD, 26));
        label_GameName.setBounds(45, 30, 200, 47);
        this.getContentPane().add(label_GameName);

        // 创建 菜单栏menuBar
        menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 39, 26);
        this.getContentPane().add(menuBar);
        menuBar.setBackground(new Color(229, 229, 11));

        // 把菜单menu 添加 到菜单栏menuBar中
        menu = new JMenu("菜单");
        menuBar.add(menu);

        // 创建 三个菜单项
        menuItem1 = new JMenuItem("游戏规则");
        menuItem1.setBackground(UIManager.getColor("MenuItem.background"));
        menu.add(menuItem1);
        menu.addSeparator();

        menuItem2 = new JMenuItem("声明");
        menuItem2.setBackground(UIManager.getColor("MenuItem.background"));
        menu.add(menuItem2);
        menu.addSeparator();

        menuItem3 = new JMenuItem("退出游戏");
        menuItem3.setBackground(UIManager.getColor("MenuItem.background"));
        menu.add(menuItem3);
    }

    // 添加监听器
    private void addListener(){
        //dialog1Menu.setResizable(false);
        menuItem1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // TODO 自动生成的方法存根
                dialog_MenuItem1 = new JDialog();
                dialog_MenuItem1.getContentPane().setLayout(null);
                label_MenuItem1_1 = new JLabel();
                label_MenuItem1_1.setText("点击三个按钮对应按钮上的操作，随后电脑随机出拳，判断胜负");
                label_MenuItem1_1.setBounds(10,0,500,65);
                dialog_MenuItem1.getContentPane().add(label_MenuItem1_1);
                dialog_MenuItem1.setTitle("游戏规则");
                dialog_MenuItem1.setSize(400, 100);
                dialog_MenuItem1.setLocation(650,360);
                dialog_MenuItem1.setVisible(true);
            }
        });
        menuItem2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // TODO 自动生成的方法存根
                dialog_MenuItem2 = new JDialog();
                dialog_MenuItem2.getContentPane().setLayout(null);
                label_MenuItem2_1 = new JLabel();
                label_MenuItem2_2 = new JLabel();
                label_MenuItem2_2.setText(cptOperation.getStatementName());
                label_MenuItem2_1.setText(cptOperation.getStatement());
                label_MenuItem2_2.setForeground(new Color(255, 0, 0));
                label_MenuItem2_1.setBounds(40, 0, 170, 65);
                label_MenuItem2_2.setBounds(160,0,80,65);
                dialog_MenuItem2.getContentPane().add(label_MenuItem2_1);
                dialog_MenuItem2.getContentPane().add(label_MenuItem2_2);
                dialog_MenuItem2.setTitle("声明");
                dialog_MenuItem2.setSize(300, 100);
                dialog_MenuItem2.setLocation(700,350);
                dialog_MenuItem2.setVisible(true);
            }
        });
        menuItem3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dialog_MenuItem3 = new JDialog();
                dialog_MenuItem3.setResizable(false);
                JLabel label_MenuItem3 = new JLabel("确定退出fingergame吗？");
                label_MenuItem3.setBounds(70, 0, 200,50);
                dialog_MenuItem3.getContentPane().setLayout(null);
                dialog_MenuItem3.setTitle("退出游戏");
                dialog_MenuItem3.getContentPane().add(label_MenuItem3);
                btn4.setBounds(50, 50, 80, 35);
                btn5.setBounds(150, 50, 80, 35);
                dialog_MenuItem3.getContentPane().add(btn4);
                dialog_MenuItem3.getContentPane().add(btn5);
                dialog_MenuItem3.setSize(290, 130);
                dialog_MenuItem3.setLocation(705,370);
                dialog_MenuItem3.setVisible(true);
                btn4.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        System.exit(0);
                    }
                });
                btn5.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        dialog_MenuItem3.dispose();
                    }
                });
            }
        });

        // 设置单击关闭的窗口
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 设置窗口显示
        this.setVisible(true);

        //创建JDialog对话框，作用是点击三个按钮出现第二窗口
        btn6 = new JButton("继续游戏");

        backgroundImage = new ImageIcon("C:\\Users\\1\\Desktop\\程序设计课程设计R19\\beijing.png");
        JLabel label_BackgroundImage = new JLabel(backgroundImage);
        label_BackgroundImage.setBounds(0,0,backgroundImage.getIconWidth(),backgroundImage.getIconHeight());

        JPanel j=(JPanel)this.getContentPane();
        j.setOpaque(false);

        getContentPane().add(label_BackgroundImage);

        btn1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                dialog_btn1 = new JDialog();
                dialog_btn1.setResizable(false);
                label_btn1 = new JLabel();
                label_btn1.setFont(new Font("黑体",Font.BOLD,18));
                dialog_btn1.getContentPane().setLayout(null);
                dialog_btn1.setLocation(750, 350);
                dialog_btn1.setSize(220, 150);
                btn6.setBounds(48, 50, 100, 35);
                btn6.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        dialog_btn1.dispose();
                    }
                });
                label_btn1.setBounds(26, 0, 200,50);
                dialog_btn1.getContentPane().add(btn6);
                dialog_btn1.getContentPane().add(label_btn1);
                dialog_btn1.setModal(true);
                try {
                    if (cptOperation.judgeWithScissor()){
                        label_btn1.setForeground(new Color(199, 0, 63));
                        label_btn1.setText(cptOperation.getComputerScissor()+" 平局");
                        dialog_btn1.getContentPane().add(label_btn1);
                    }
                    else if (cptOperation.judgeWithStone()){
                        label_btn1.setForeground(new Color(255, 0, 0));
                        label_btn1.setText(cptOperation.getComputerStone()+" 你输了");
                        dialog_btn1.getContentPane().add(label_btn1);
                    }
                    else
                    {
                        label_btn1.setForeground(new Color(0, 0, 0));
                        label_btn1.setText(cptOperation.getComputerCloth()+" 你赢了");
                        dialog_btn1.getContentPane().add(label_btn1);
                    }
                } catch (ExceptionTest e1) {


                    e1.printStackTrace();
                }
                dialog_btn1.setVisible(true);
            }
        });
        btn2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {


                dialog_btn2 = new JDialog();
                dialog_btn2.setResizable(false);
                label_btn2 = new JLabel();
                label_btn2.setFont(new Font("黑体",Font.BOLD,18));
                dialog_btn2.getContentPane().setLayout(null);
                dialog_btn2.setLocation(750, 350);
                dialog_btn2.setSize(220, 150);
                btn6.setBounds(48, 50, 100, 35);
                btn6.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        dialog_btn2.dispose();
                    }
                });
                label_btn2.setBounds(26, 0, 200,50);
                dialog_btn2.getContentPane().add(btn6);
                dialog_btn2.getContentPane().add(label_btn2);
                dialog_btn2.setModal(true);
                try {
                    if (cptOperation.judgeWithScissor())
                    {
                        label_btn2.setForeground(new Color(0, 0, 0));
                        label_btn2.setText(cptOperation.getComputerScissor()+" 你赢了");
                        dialog_btn2.getContentPane().add(label_btn2);
                    }
                    else if (cptOperation.judgeWithStone())
                    {
                        label_btn2.setForeground(new Color(0, 199, 140));
                        label_btn2.setText(cptOperation.getComputerStone()+" 平局");
                        dialog_btn2.getContentPane().add(label_btn2);
                    }
                    else
                    {
                        label_btn2.setForeground(new Color(255, 0, 0));
                        label_btn2.setText(cptOperation.getComputerCloth()+" 你输了");
                        dialog_btn2.getContentPane().add(label_btn2);
                    }
                } catch (ExceptionTest e1) {

                    e1.printStackTrace();
                }
                dialog_btn2.setVisible(true);
            }
        });
        btn3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                // TODO 自动生成的方法存根
                dialog_btn3 = new JDialog();
                dialog_btn3.setResizable(false);
                label_btn3 = new JLabel();
                label_btn3.setFont(new Font("黑体",Font.BOLD,18));
                dialog_btn3.getContentPane().setLayout(null);
                dialog_btn3.setLocation(750, 350);
                dialog_btn3.setSize(220, 150);
                btn6.setBounds(48, 50, 100, 35);
                btn6.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        dialog_btn3.dispose();
                    }
                });
                label_btn3.setBounds(26, 0, 200,50);
                dialog_btn3.getContentPane().add(btn6);
                dialog_btn3.getContentPane().add(label_btn3);
                try {
                    if (cptOperation.judgeWithScissor())
                    {
                        label_btn3.setForeground(new Color(255, 0, 0));
                        label_btn3.setText(cptOperation.getComputerScissor()+" 你输了");
                        dialog_btn3.getContentPane().add(label_btn3);
                    }
                    else if (cptOperation.judgeWithStone())
                    {
                        label_btn3.setForeground(new Color(0, 0, 0));
                        label_btn3.setText(cptOperation.getComputerStone()+" 你赢了");
                        dialog_btn3.getContentPane().add(label_btn3);
                    }
                    else
                    {
                        label_btn3.setForeground(new Color(0, 199, 140));
                        label_btn3.setText(cptOperation.getComputerCloth()+" 平局");
                        dialog_btn3.getContentPane().add(label_btn3);
                    }
                } catch (ExceptionTest e1) {

                    e1.printStackTrace();
                }
                dialog_btn3.setVisible(true);
            }
        });
    }
}
